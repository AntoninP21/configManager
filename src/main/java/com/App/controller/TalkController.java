@RestController
@RequestMapping("/api/talks")
@RequiredArgsConstructor
public class TalkController {

    private final TalkRepository talkRepository;
    private final ConferenceRepository conferenceRepository;
    private final SpeakerRepository speakerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Talk> getTalk(@PathVariable Long id) {
        return talkRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/conference/{conferenceId}")
    public ResponseEntity<Talk> createTalk(@PathVariable Long conferenceId, @RequestBody Talk talk) {
        return conferenceRepository.findById(conferenceId)
                .map(conference -> {
                    talk.setConference(conference);
                    return ResponseEntity.ok(talkRepository.save(talk));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{talkId}/assign-speaker/{speakerId}")
    public ResponseEntity<Talk> assignSpeaker(@PathVariable Long talkId, @PathVariable Long speakerId) {
        Optional<Talk> talkOpt = talkRepository.findById(talkId);
        Optional<Speaker> speakerOpt = speakerRepository.findById(speakerId);

        if (talkOpt.isPresent() && speakerOpt.isPresent()) {
            Talk talk = talkOpt.get();
            talk.setSpeaker(speakerOpt.get());
            return ResponseEntity.ok(talkRepository.save(talk));
        }
        return ResponseEntity.notFound().build();
    }
}
