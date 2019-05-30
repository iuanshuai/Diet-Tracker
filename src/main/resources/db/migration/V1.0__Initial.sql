CREATE SEQUENCE users_id_seq;
create table users (
    Id bigint not null DEFAULT NEXTVAL('users_id_seq'),
    email varchar(255) not NULL,
    last_name varchar(255) not NULL,
    first_name varchar(255) not NULL,
    primary key (Id)
);
ALTER  SEQUENCE users_id_seq OWNED BY users.id;