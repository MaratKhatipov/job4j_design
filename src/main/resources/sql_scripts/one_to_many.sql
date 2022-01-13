create table country(
	id serial primary key,
	name_country varchar(255)
);

create table cities(
	id serial primary key,
	name_cities varchar(255),
	country_id int references country(id)
);

insert into country(name_country) values('Russia');

insert into cities(name_cities, country_id) values('Yekaterinburg', 1);
insert into cities(name_cities, country_id) values('Bryansk', 1);

select* from cities;
SELECT * FROM country WHERE id in(SELECT id FROM cities); 