--1. Создать таблицы и заполнить их начальными данными
create table departments (
    id serial primary key,
    name varchar(255)
);

create table employers (
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

insert into departments(name) values('Marketing');
insert into departments(name) values('Operations');
insert into departments(name) values('Finance');
insert into departments(name) values('Sales');
insert into departments(name) values('Cleaning');


insert into employers(name, departments_id) values('Tom', 1);
insert into employers(name, departments_id) values('Jerry', 1);
insert into employers(name) values('John');
insert into employers(name, departments_id) values('Samanta', 2);
insert into employers(name) values('Donald');
insert into employers(name, departments_id) values('Anastasiya', 3);
insert into employers(name) values('Alex');
insert into employers(name, departments_id) values('Tony', 4);

--2. Выполнить запросы с left, rigth, full, cross соединениями
select * from employers e left join departments d on d.id = e.departments_id;

select * from employers e right join  departments d on d.id = e.departments_id;

select * from departments d full join employers e on d.id=e.departments_id;

select * from departments cross join employers;

--3. Используя left join найти департаменты, у которых нет работников
select d.name from departments d
    left join employers e on d.id = e.departments_id
where departments_id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат
-- (порядок вывода колонок в эти запросах также должен быть идентичный).
select * from departments d
    left join employers e on d.id=e.departments_id
where e.departments_id is not null;

select *
from departments d
         right join employers e on d.id=e.departments_id
where e.departments_id is not null;

/**
  5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
  Используя cross join составить все возможные разнополые пары
 */
CREATE table teens (
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens (name, gender) VALUES ('Vladimir', 'male');
insert into teens (name, gender) VALUES ('Vlada', 'female');
insert into teens (name, gender) VALUES ('Petya', 'male');
insert into teens (name, gender) VALUES ('Zlata', 'female');
insert into teens (name, gender) VALUES ('Olga', 'female');
insert into teens (name, gender) VALUES ('Yaroslav', 'male');
insert into teens (name, gender) VALUES ('Conan Barbarian', 'male');
insert into teens (name, gender) VALUES ('Janna', 'female');

update teens set gender = 'm' where name = 'Vladimir';
update teens set gender = 'm' where name = 'Petya';
update teens set gender = 'm' where name = 'Yaroslav';
update teens set gender = 'm' where name = 'Conan Barbarian';

select * from teens;

select m.name "Мужское имя", m.gender "Мужской пол",
       f.name "Женское имя", f.gender "Женской пол"
from teens m cross join teens f
where m.gender = 'm' and f.gender = 'female';

