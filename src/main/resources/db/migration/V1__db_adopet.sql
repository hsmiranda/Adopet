create sequence tbl_messages_seq increment by 50;

alter sequence tbl_messages_seq owner to postgres;

create table tbl_messages
(
    int_id         integer not null primary key,
    txt_message    varchar(500),
    txt_name_tutor varchar(255),
    txt_name_pet   varchar(255),
    txt_phone      varchar(255)
);

alter table tbl_messages owner to postgres;

create sequence tbl_pet_seq increment by 50;

alter sequence tbl_pet_seq owner to postgres;

create table tbl_pet
(
    id              integer not null primary key,
    txt_specie      smallint constraint tbl_pet_txt_specie_check check ((txt_specie >= 0) AND (txt_specie <= 1)),
    txt_city        varchar(255),
    txt_name        varchar(255),
    txt_personality varchar(255),
    txt_size        varchar(255)
);

alter table tbl_pet owner to postgres;

create sequence tbl_tutor_seq increment by 50;

alter sequence tbl_tutor_seq owner to postgres;

create table tbl_tutor
(
    id           integer not null primary key,
    txt_about    varchar(255),
    txt_city     varchar(255),
    txt_email    varchar(255) not null,
    txt_password varchar(255) not null,
    txt_phone    varchar(255),
    txt_user     varchar(255) not null
);

alter table tbl_tutor owner to postgres;