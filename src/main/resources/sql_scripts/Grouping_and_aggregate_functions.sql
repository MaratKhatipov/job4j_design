create table devices (
                         id serial primary key,
                         name varchar(255),
                         price float
);

create table people (
                        id serial primary key,
                        name varchar(255)
);

create table devices_people (
                                id serial primary key,
                                device_id int references devices(id),
                                people_id int references people(id)
);

insert into devices(name, price)
values ('Монитор', 17199), ('Колонки', 16895), ('Сабвуфер', 13450),
       ('Клавиатура', 2690),('Мышь', 4590),('Коврик', 21855),
       ('Наушники', 650),('Чехол', 390),('Флешка', 218);

insert into people(name) values ('Аня'), ('Ваня'), ('Боря');

insert into devices_people(device_id, people_id) VALUES (1, 1), (2, 1);
insert into devices_people(device_id, people_id) VALUES (3, 2), (4, 2), (5, 2), (6, 2);
insert into devices_people(device_id, people_id) VALUES (7, 3), (8, 3), (9, 3);

select avg(price) from devices;

select p.name, d.price
from devices_people as dp
         join people p on dp.people_id = p.id
         join devices d on d.id = dp.device_id;

select p.name, avg(price)
from devices_people as dp
         join people p on dp.people_id = p.id
         join devices d on d.id = dp.device_id
group by p.name;

select p.name, avg(price)
from devices_people as dp
         join people p on dp.people_id = p.id
         join devices d on d.id = dp.device_id
group by p.name
having avg(price) > 5000;



select p.name, d.name, d.price
from devices_people as dp
         join people p on dp.people_id = p.id
         join devices d on d.id = dp.device_id where p.name like 'А%';

select p.name, d.name, d.price
from devices_people as dp
         join people p on dp.people_id = p.id
         join devices d on d.id = dp.device_id where p.name like 'В%';

select p.name, d.name, d.price
from devices_people as dp
         join people p on dp.people_id = p.id
         join devices d on d.id = dp.device_id where p.name like 'Б%';

/**
2. Заполнить таблицы данными.+

3. Используя агрегатные функции вывести среднюю цену устройств.+

4. Используя группировку вывести для каждого человека среднюю цену его устройств+.

5. Дополнить запрос п.4. условием, что средняя стоимость устройств должна быть больше 5000.

6. Залить скрипт в репозиторий.

7. Перевести ответственного на Петра Арсентьева.
 */
