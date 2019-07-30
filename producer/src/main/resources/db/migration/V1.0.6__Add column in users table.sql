ALTER TABLE users
ADD COLUMN enabled boolean not NULL,
ADD COLUMN locked boolean not NULL,
ADD COLUMN expired boolean not NULL;