insert into roles (id, name)
values (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

insert into users (id, username, password, email)
values
(1, 'user', '{noop}user', 'user@gmail.com'),
(2, 'admin', '{noop}admin', 'admin@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1), (2, 2);
