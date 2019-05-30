CREATE SEQUENCE foods_id_seq;
create table foods (
    Id bigint not null DEFAULT NEXTVAL('foods_id_seq'),
    food_name varchar(255) not NULL,
    food_calorie integer not NULL,
    food_type varchar(255) not NULL,
    primary key (Id)
);
ALTER  SEQUENCE foods_id_seq OWNED BY foods.id;