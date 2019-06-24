ALTER TABLE users
ADD COLUMN password varchar(255) not NULL unique;