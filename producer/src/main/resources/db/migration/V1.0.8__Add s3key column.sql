ALTER TABLE images
ADD COLUMN s3key varchar(255) not NULL unique;