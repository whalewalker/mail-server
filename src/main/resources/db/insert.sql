SET FOREIGN_KEY_CHECKS = 0;

truncate table mail;
truncate table user;

INSERT INTO user(first_name, last_name, user_name, password)
VALUES ('John', 'snow', 'snow@gmail.com', 'snow123'),
       ('Kabiru', 'dansu', 'dansu@gmail.com', 'kabiru234'),
        ('fatai', 'wale', 'fatai@gmail.com', 'wale123');

SET FOREIGN_KEY_CHECKS = 1;
