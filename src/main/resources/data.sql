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




