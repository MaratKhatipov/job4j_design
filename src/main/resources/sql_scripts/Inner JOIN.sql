/**
Задание:

1. Придумать две таблицы и связь между ними

2. Написать 3 запроса с inner join с использованием альясов

3. Загрузить скрипт в репозиторий

4. Перевести ответственного на Петра Арсентьева
 */

 create table company (
     id serial primary key,
     name text,
     description text,
     address varchar(255),
     postcode int
 );

create table warehouse (
    id serial primary key,
    name varchar(255),
    address varchar(255),
    company_id int references company(id)
);

insert into company (name, description, address, postcode) VALUES ('Computer', 'sale of computers', 'Lenina 1', 111222);

insert into company (name, description, address, postcode) VALUES ('Product', 'sale of product', 'Mira 32', 222333);

insert into company (name, description, address, postcode) VALUES ('Spare parts', 'sale of Spare parts', 'Petrova 3', 333444);

insert into warehouse (name, address, company_id) VALUES ('Склад №1', 'Lenina 1', 1);
insert into warehouse (name, address, company_id) VALUES ('Скалд №2', 'Malysheva 2', 1);
insert into warehouse (name, address, company_id) VALUES ('Склад №3', 'Lenina 120', 1);

insert into warehouse (name, address, company_id) VALUES ('Пятёрочка Логистик', '32-km', 2);
insert into warehouse (name, address, company_id) VALUES ('Городской склад', 'Shvarca 1', 2);

insert into warehouse (name, address, company_id) VALUES ('Личный склад дяди Вани', 'Roschinskaya 125', 3);

select * from company;
select * from warehouse;

select* from warehouse join company c on warehouse.company_id = c.id;

select w.name, w.address, c.name, c.description, c.address from warehouse as w join company as c on w.company_id = c.id;

select c.name, w.name, c.address, w.address, c.description  from warehouse as w join company as c on w.company_id = c.id;

select c.name as "Название компании",
       w.name as "Название склада",
       c.address as "Адрес компании",
       w.address as "Адрес склада",
       c.description  as Описание
from warehouse as w join company as c on w.company_id = c.id;

select c.name as "Название компании",
       w.name as "Название склада",
       c.address as "Адрес компании",
       w.address as "Адрес склада",
       c.description  as Описание
from warehouse as w join company as c on w.company_id = c.id
where c.name like 'C%';

select c.name as "Название компании",
       w.name as "Название склада",
       c.address as "Адрес компании",
       w.address as "Адрес склада",
       c.description  as Описание
from warehouse as w join company as c on w.company_id = c.id
where w.address like '%a%' ;

select c.name as "Название компании",
       w.name as "Название склада",
       c.address as "Адрес компании",
       w.address as "Адрес склада",
       c.description  as Описание
from warehouse as w join company as c on w.company_id = c.id order by w.address desc ;
