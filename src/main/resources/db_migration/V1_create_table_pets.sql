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

