CREATE TABLE tbl_country (
     id serial primary key,
     iso varchar(2) NOT NULL,
     name varchar(80) NOT NULL,
     nicename varchar(80) NOT NULL,
     iso3 varchar(3)  NULL,
     numcode int NULL,
     phonecode integer NOT NULL

--    CONSTRAINT country_pkey
--       PRIMARY KEY (id)
);