create table body (
     id serial primary key,
     name varchar(255)
 );

create table engine (
    id serial primary key,
    name varchar(255)
);

create table gearbox (
    id serial primary key,
    name varchar(255)
);

create table automobile (
    id serial primary key,
    name varchar(255),
    id_body int references body(id),
    id_engine int references engine(id),
    id_gearbox int references gearbox(id)
);

insert into body (name) values ('Седан');
insert into body (name) values ('Купе');
insert into body (name) values ('Универсал');
insert into body (name) values ('Хэтчбек');
insert into body (name) values ('Внедорожник');
insert into body (name) values ('Пикап');

insert into engine(name) values ('оппозитный');
insert into engine(name) values ('V-образный');
insert into engine(name) values ('W12');
insert into engine(name) values ('Рядный');
insert into engine(name) values ('Роторный');
insert into engine(name) values ('Карбюратор');

insert into gearbox (name) values ('Механическая коробка');
insert into gearbox (name) values ('Автоматическая коробка');
insert into gearbox (name) values ('Роботизированная ');
insert into gearbox (name) values ('Вариативная');
insert into gearbox (name) values ('Безвальная ');
insert into gearbox (name) values ('Несинхронизированная ');

insert into automobile (name, id_body, id_engine, id_gearbox)
VALUES ('VESTA', 1, 4, 1),
       ('AUDI R8', 2, 5, 2),
       ('VW', 3, 2, 4),
       ('Astra', 4, 4, 3),
       ('Cruzak', 5, 2, 1);

select a.name Марка,
       b.name Кузов,
       e.name Двигатель,
       g.name Коробка
from automobile a
    left join body b on b.id = a.id_body
    left join engine e on a.id_engine = e.id
    left join gearbox g on a.id_gearbox = g.id;

select b.name from body b full join automobile a on b.id = a.id_body where a.id is null;
select e.name from engine e full join automobile a on e.id = a.id_engine where a.id is null;
select g.name from gearbox g full join automobile a on g.id = a.id_gearbox where a.id is null;

-- select b.name from body b left join automobile a on b.id = a.id_body where a.id is null;
-- select e.name from engine e left join automobile a on e.id = a.id_engine where a.id is null;
-- select g.name from gearbox g left join automobile a on g.id = a.id_gearbox where a.id is null;



