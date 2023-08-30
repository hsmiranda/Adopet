create sequence tbl_abrigo_id_seq increment by 50;
alter sequence tbl_abrigo_id_seq owner to postgres;

create table tbl_abrigo
(
    pk_long_id      bigint not null primary key,
    txt_name        varchar(500) not null,
    txt_city        varchar(255) not null,
    txt_phone       varchar(255)
);

create sequence tbl_pet_seq increment by 50;

alter sequence tbl_pet_seq owner to postgres;

CREATE TYPE enum_specie AS ENUM ('Dog', 'Cat');

create table tbl_pet
(
    pk_long_id      bigint not null primary key,
    enum_specie     enum_specie,
    txt_city        varchar(255) not null,
    txt_name        varchar(255) not null,
    int_age         integer not null,
    txt_personality varchar(255) not null,
    txt_size        varchar(255) not null,
    fk_abrigo_id    bigint not null,
    foreign key (fk_abrigo_id) references tbl_abrigo (pk_long_id)
);

alter table tbl_pet owner to postgres;

create sequence tbl_tutor_seq increment by 50;

alter sequence tbl_tutor_seq owner to postgres;

create table tbl_tutor
(
    id           bigint not null primary key,
    txt_about    varchar(255),
    txt_city     varchar(255),
    txt_email    varchar(255) not null,
    txt_password varchar(255) not null,
    txt_phone    varchar(255),
    txt_username varchar(255) not null
);

alter table tbl_tutor owner to postgres;


