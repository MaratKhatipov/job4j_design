insert into role(role_name) values ('loader');
insert into rules(rules_name) values ('unloading');
insert into role_rules(role_id, rules_id) VALUES (1, 1);
insert into users(name_users, role_id) VALUES ('Fedya', 1);
insert into category(name_category) values ('SOME category');
insert into state(name_state) values ('some state');
insert into item(name_item, id_users, id_category, id_state) VALUES ('SOME ITEM', 1, 1, 1);
insert into attaches(name_attaches, id_item) VALUES ('Zayavka.pdf', 1);
insert into comments(name_comments, id_item) VALUES ('Hello World', 1);