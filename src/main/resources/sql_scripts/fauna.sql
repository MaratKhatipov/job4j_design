create table fauna (
                       id serial primary key,
                       name text,
                       avg_age int,
                       discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('fish', 300, '01.04.0345');
insert into fauna(name, avg_age, discovery_date) values ('bat', 3000, '09.10.1467');
insert into fauna(name, avg_age, discovery_date) values ('bear', 10000, '20.12.0003');
insert into fauna(name, avg_age, discovery_date) values ('lion', 7000, null);
insert into fauna(name, avg_age, discovery_date) values ('human', 30000, null);
insert into fauna(name, avg_age, discovery_date) values ('tiger', 11000, null);

select *from fauna where name like '%fish%';
select *from fauna where avg_age > 10000 and avg_age < 21000;
select *from fauna where discovery_date is null;
select *from fauna where discovery_date < '01.01.1950';