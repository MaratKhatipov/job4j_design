/**
    users - role = many-to-one +
    role - rules = many-to-many +
    item - users = many-to-one
    item - comments = one-to-many
    item - attachs = one-to-many
    item - category = many-to-one
    item - state = many-to-one
 */
create table role(
                     id serial primary key,
                     role_name varchar(255)
);

create table rules(
                      id serial primary key,
                      rules_name text
);

create table role_rules(
                           id serial primary key,
                           role_id int references role(id),
                           rules_id int references rules(id));

create table users(
                      id serial primary key,
                      name_users varchar(255),
                      role_id int references role(id)
);

create table category(
                         id serial primary key,
                         name_category text
);

create table state(
                      id serial primary key,
                      name_state text
);

create table item(
                     id serial primary key,
                     name_item varchar(255),
                     id_users int references users(id),
                     id_category int references category(id),
                     id_state int references state(id)
);

create table attaches(
                         id serial primary key,
                         name_attaches varchar(255),
                         id_item int references item(id)
);

create table comments(
                         id serial primary key,
                         name_comments text,
                         id_item int references item(id)
);