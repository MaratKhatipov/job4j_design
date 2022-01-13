 create table book_publishers(
     id serial primary key,
     name_publishers varchar(255)
 );
 
create table autors (
     id serial primary key,
     name_autor varchar(255),
	 book_name varchar(255)
 );
 
 create table publishers_autor(
     id serial primary key,
     autor_id int references autors(id),
     publishers_id int references book_publishers(id)
 );
 
 insert into autors(name_autor, book_name) values('Cay Horstmann', 'Core Java');
 insert into autors(name_autor, book_name) values('Cay Horstmann', 'Big Java');
 insert into autors(name_autor, book_name) values('Cay Horstmann', 'Java SE 8 for the Really Impatient');
 insert into autors(name_autor, book_name) values('Herbert Schildt', 'Java: The Complete Reference, 12th Edition');
 insert into autors(name_autor, book_name) values('Herbert Schildt', 'Java Programming Cookbook');
 insert into autors(name_autor, book_name) values('Bruce Eckel', 'Thinking in Java');
 insert into autors(name_autor, book_name) values('Joshua Bloch', 'Effective Java: Programming Language Guide');

 insert into book_publishers(name_publishers) values('Piter');
 insert into book_publishers(name_publishers) values('Вильямс');
 
 insert into publishers_autor(autor_id, publishers_id) values (1, 1);
 insert into publishers_autor(autor_id, publishers_id) values (2, 1);
 insert into publishers_autor(autor_id, publishers_id) values (3, 1);
 insert into publishers_autor(autor_id, publishers_id) values (4, 1);
 insert into publishers_autor(autor_id, publishers_id) values (5, 1);
 insert into publishers_autor(autor_id, publishers_id) values (6, 2);
 insert into publishers_autor(autor_id, publishers_id) values (7, 2);

 select* from book_publishers;
 select* from autors;
 select* from publishers_autor;
 