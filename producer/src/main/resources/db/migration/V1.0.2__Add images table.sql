CREATE SEQUENCE images_id_seq;
CREATE TABLE images (
    id bigint not null DEFAULT NEXTVAL('images_id_seq'),
    title varchar(255) not NULL,
    url varchar(255) not NULL,
    food_id bigint DEFAULT NULL,
    primary key (id),
    CONSTRAINT fk_image_food
      FOREIGN KEY (food_id)
      REFERENCES foods (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);
ALTER SEQUENCE images_id_seq OWNED BY images.id;