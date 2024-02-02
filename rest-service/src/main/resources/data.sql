insert into cities (name)
values ('Yaroslavl'), ('Moscow');

insert into streets (name, city_id)
values ('Trufanova', 1), ('Margolina', 1), ('Arbat', 2), ('Pushkina', 2);

insert into houses (number, street_id)
values ('3', 1), ('7', 1), ('12', 2), ('5', 2), ('15', 3);

insert into apartments (area, house_id)
values (33, 1), (80.5, 1), (120.3, 2), (56.8, 3), (76.7, 4);