create table avgGrade (
id serial primary key,
student_name varchar(255),
course_number int,
subject text,
passed bool
);
select* from avgGrade

insert into avgGrade(student_name, course_number, subject, passed) values ('Fedya', 1, 'math', false );
select* from avgGrade

update avgGrade set course_number = 2;
select* from avgGrade

update avgGrade set subject = 'Java';
select* from avgGrade

update avgGrade set student_name = 'Kolya';
select* from avgGrade

update avgGrade set passed = true;
select* from avgGrade

delete from avgGrade;
select* from avgGrade