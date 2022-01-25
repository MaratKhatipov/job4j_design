create table type (
    id serial primary key,
    name varchar(255)
);

    create table product (
    id serial primary key,
    name varchar(255),
    typ_id int references type(id),
    expired_date date,
    price float
);

insert into type (name) values ('СЫР');
insert into type (name) values ('мороженое');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('Мясная продукция');
insert into type (name) values ('Крупы');
insert into type (name) values ('Мин. Вода');
insert into type (name) values ('Шоколад');

insert into product (name, typ_id, expired_date, price) values ('Моцарелла', 1, '01.01.2022', 950);
insert into product (name, typ_id, expired_date, price) values ('Голландский', 1, '01.01.2022', 450);
insert into product (name, typ_id, expired_date, price) values ('Пармезан', 1, '01.10.2022', 1450);
insert into product (name, typ_id, expired_date, price) values ('Пошехонский', 1, '23.01.2022', 390);

insert into product (name, typ_id, expired_date, price) values ('Магнат', 2, '13.01.2022', 120);
insert into product (name, typ_id, expired_date, price) values ('Пломбир', 2, '13.02.2022', 120);
insert into product (name, typ_id, expired_date, price) values ('Земляника', 2, '23.01.2022', 120);
insert into product (name, typ_id, expired_date, price) values ('Сникерс', 2, '21.03.2022', 120);
insert into product (name, typ_id, expired_date, price) values ('мороженое БОН пари', 2, '13.01.2022', 75);
insert into product (name, typ_id, expired_date, price) values ('мороженое Ваниль', 2, '13.02.2022', 52);
insert into product (name, typ_id, expired_date, price) values ('мороженое Айсбери', 2, '23.01.2022', 198);
insert into product (name, typ_id, expired_date, price) values ('МагнатШоколад', 2, '13.12.2021', 180);
insert into product (name, typ_id, expired_date, price) values ('Шоколадная крошка', 2, '19.03.2022', 35);
insert into product (name, typ_id, expired_date, price) values ('Земляника с изюмом', 2, '03.03.2022', 86);
insert into product (name, typ_id, expired_date, price) values ('Сникерс с грецким орехом', 2, '16.03.2021', 15);


insert into product(name, typ_id, expired_date, price) values ('Домик в деревне', 3, '22.01.2022', 60);
insert into product(name, typ_id, expired_date, price) values ('Простоквашино', 3, '21.01.2022', 50);
insert into product(name, typ_id, expired_date, price) values ('Село зелёное', 3, '26.01.2022', 40);
insert into product(name, typ_id, expired_date, price) values ('ГОСТовское', 3, '27.01.2022', 70);

insert into product(name, typ_id, expired_date, price) values ('Докторская', 4, '28.12.2021', 96);
insert into product(name, typ_id, expired_date, price) values ('Русская', 4, '28.01.2022', 487);
insert into product(name, typ_id, expired_date, price) values ('Молочная', 4, '28.02.2022', 526);
insert into product(name, typ_id, expired_date, price) values ('Мясо замороженое', 4, '28.02.2022', 526);

insert into product(name, typ_id, expired_date, price) values ('Гречка', 5, '28.02.2023', 87);
insert into product(name, typ_id, expired_date, price) values ('Рис басмати', 5, '12.10.2023', 120);

insert into product(name, typ_id, expired_date, price) values ('Обуховская 13', 6, '28.02.2024', 69);
insert into product(name, typ_id, expired_date, price) values ('Есентуки 17', 6, '01.01.2024', 80);

insert into product(name, typ_id, expired_date, price) values ('Бабаевский', 7, '28.02.2026', 180);
insert into product(name, typ_id, expired_date, price) values ('Альпен Гольд', 7, '15.06.2022', 120);
insert into product(name, typ_id, expired_date, price) values ('Российский', 7, '24.01.2022', 80);


/**1. Написать запрос получение всех продуктов с типом "СЫР"*/
select p.name product
from product p join type t on p.typ_id = t.id
where t.name = 'СЫР';

/**
2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"*/
select name from product where name like '%мороженое%';

select * from product;

/**
  3. Написать запрос, который выводит все продукты, срок годности которых уже истек
 */
select * from product
where expired_date < current_date;

-- 4. Написать запрос, который выводит самый дорогой продукт.
select name, price from product p where price = (select max(price) from product);


/**
5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
В виде имя_типа, количество
 */
select t.name, count(p.name)from type t
    join product p on t.id = p.typ_id
group by t.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name from product p
    join type t on p.typ_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

/**
  7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
  Под количеством подразумевается количество продуктов определенного типа.
  Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла",
  которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.
 */

select t.name from type t
join product p on t.id = p.typ_id
group by t.name
having count(p.name) < 10;

--8. Вывести все продукты и их тип.
select p.name, t.name from product p join type t on p.typ_id = t.id;