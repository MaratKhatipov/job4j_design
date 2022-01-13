create table wife(
	id serial primary key, 
	wife_name varchar(255)
);

create table husband(
	id serial primary key,
	husband_name varchar(255)
);

create table wife_husband(
	id serial primary key,
	wife_id int references wife(id) unique,
	husband_id int references husband(id) unique
);