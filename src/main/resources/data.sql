-- STUDENTS
INSERT INTO `diplomation-demo`.`student` (`f_number`, `name`) VALUES ('12345', 'Simon');
INSERT INTO `diplomation-demo`.`student` (`f_number`, `name`) VALUES ('111111', 'Pesho');
INSERT INTO `diplomation-demo`.`student` (`f_number`, `name`) VALUES ('222222', 'Ceco');

-- TUTORS
INSERT INTO `diplomation-demo`.`uni_tutor` (`name`, `position_type`) VALUES ('Pashovski', '1');
INSERT INTO `diplomation-demo`.`uni_tutor` (`name`, `position_type`) VALUES ('Lilova', '0');
INSERT INTO `diplomation-demo`.`uni_tutor` (`name`, `position_type`) VALUES ('Viktorov', '2');

-- APPLICATIONS
INSERT INTO `diplomation-demo`.`application` (`aims`, `problems`, `status`, `technologies`, `topic`, `student_id`, `uni_tutor_id`)
VALUES ('Solve world hunger', 'World hunger', '1', 'SQL, Java', 'Taking ozempic instead of eating', '1', '1');
INSERT INTO `diplomation-demo`.`application` (`aims`, `problems`, `status`, `technologies`, `topic`, `student_id`, `uni_tutor_id`)
VALUES ('Achieving world piece', 'Greedy wars', '1', 'Automation', 'Automation as a peace maker', '2', '2');
INSERT INTO `diplomation-demo`.`application` (`aims`, `problems`, `status`, `technologies`, `topic`, `student_id`, `uni_tutor_id`)
VALUES ('Creating wealth for pensioners', 'Low pensions', '0', 'Robots', 'Robots generating wealth for your grandma', '3', '3');
INSERT INTO `diplomation-demo`.`application` (`aims`, `problems`, `status`, `technologies`, `topic`, `student_id`, `uni_tutor_id`)
VALUES ('Finding the perfect technology for making sandwiches', 'No problem, just sandwich', '2', 'Cheap labour', 'What a sandwich shop helps to achieve', '3', '3');

-- THESES
INSERT INTO `diplomation-demo`.`thesis` (`date_of_submission`, `text`, `title`, `application_id`)
VALUES ('2025-01-01', 'Though ozempic created a bunch of problems, it suppressed the hunger of the high class. Let us make it available to yhe public and see what happens! I bet it will solve world hunger.', 'Solving World hunger with pills', '1');
INSERT INTO `diplomation-demo`.`thesis` (`date_of_submission`, `text`, `title`, `application_id`)
VALUES ('2024-03-25', 'Since AI is becoming more intelligent every day, soon enough it will become sentient, start ruling instead of humans. If that proves true, there would no longer be greedy people starting wars. Instead, AI, if programmed ethically, would strive towards creating long-term solutions for us and therefore eliminating the need and hunger for war.', 'Automating peace', '2');
INSERT INTO `diplomation-demo`.`thesis` (`date_of_submission`, `text`, `title`, `application_id`)
VALUES ('2025-01-02', 'Robots are the key to wealth. If every pensioner gets a robot that works and generates money, they will be provided for financially and would actually get to enjoy retirement.', 'Robots for grandma', '3');

-- RECENSIONS
INSERT INTO `diplomation-demo`.`recension` (`conclusion`, `date_of_submission`, `is_passed`, `text`, `reviewer_id`, `thesis_id`) VALUES ('yuh', '2025-01-02', TRUE, 'yes', '2', '1');
INSERT INTO `diplomation-demo`.`recension` (`conclusion`, `date_of_submission`, `is_passed`, `text`, `reviewer_id`, `thesis_id`) VALUES ('nah', '2023-04-01', FALSE, 'no', '1', '2');
