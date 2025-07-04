INSERT INTO speaker (id, first_name, last_name, bio) VALUES
(1, 'James', 'Gosling', 'Le père de Java.'),
(2, 'Gavin', 'King', 'Créateur de Hibernate.');

INSERT INTO conference (id, name, start_date, end_date, location) VALUES
(10, 'Devoxx France 2024', '2024-04-17', '2024-04-19', 'Paris'),
(11, 'Spring I/O 2024', '2024-05-30', '2024-05-31', 'Barcelone');

INSERT INTO talk (id, title, description, start_time, conference_id, speaker_id) VALUES
(100, 'Introduction to Project Loom', 'Découvrez les virtual threads en Java.', '2024-04-17T10:00:00', 10, NULL),
(101, 'Deep Dive into Spring Boot 3', 'Nouveautés et bonnes pratiques.', '2024-05-30T11:00:00', 11, 2);
