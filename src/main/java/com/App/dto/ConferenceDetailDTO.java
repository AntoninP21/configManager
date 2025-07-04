@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceDetailDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private List<TalkSummaryDTO> talks;
}