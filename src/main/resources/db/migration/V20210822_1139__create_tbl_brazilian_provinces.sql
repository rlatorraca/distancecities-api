CREATE TABLE tbl_province_br (
        id     serial NOT NULL,
        name   varchar(60),
        abbreviation  varchar(2),
        ibge   integer,
        country   integer,
        phonecode    json,
        /* Keys */
        CONSTRAINT tbl_province
            PRIMARY KEY (id)
);
