/**
  0.2. PrepareStatement [#379307]
  1. Создадим таблицу
 */
create table cities(
    id serial primary key,
    name text,
    population int
);