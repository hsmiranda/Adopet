create sequence seq_pk_tb_abrigo increment by 50;
alter sequence seq_pk_tb_abrigo owner to postgres;

create table tbl_abrigo
(
    pk_long_abrigo_id      bigint not null primary key,
    txt_name               varchar(255) not null,
    txt_city               varchar(255) not null,
    txt_phone              varchar(255)
);

create sequence seq_pk_tbl_pet increment by 50;
alter sequence seq_pk_tbl_pet owner to postgres;

create type enum_specie as enum ('DOG', 'CAT');
alter type enum_specie owner to postgres;

create table tbl_pet
(
    pk_long_pet_id  bigint not null primary key,
    enum_specie     enum_specie,
    txt_city        varchar(255) not null,
    txt_name        varchar(255) not null,
    int_age         integer not null,
    txt_personality varchar(255) not null,
    txt_size        varchar(255) not null,
    fk_abrigo_id    bigint not null,
    bl_adotado      boolean default true,
    txt_url_photo   varchar(255) not null,
    foreign key (fk_abrigo_id) references tbl_abrigo (pk_long_abrigo_id)
);

alter table tbl_pet owner to postgres;

create sequence seq_pk_tbl_tutor increment by 50;
alter sequence seq_pk_tbl_tutor owner to postgres;

create table tbl_tutor
(
    pk_long_tutor_id    bigint not null primary key,
    txt_about           varchar(255),
    txt_city            varchar(255),
    txt_email           varchar(255) not null,
    txt_password        varchar(255) not null,
    txt_phone           varchar(255),
    txt_username        varchar(255) not null
);

alter table tbl_tutor owner to postgres;


create table tbl_adocao
(
    pk_long_adocao_id       bigint not null primary key,
    fk_long_tutor_id        bigint not null,
    fk_long_pet_id          bigint not null,
    dt_adocao_data          date not null,
    foreign key (fk_long_tutor_id) references tbl_tutor (pk_long_tutor_id),
    foreign key (fk_long_pet_id) references tbl_pet (pk_long_pet_id)
);

alter table tbl_adocao owner to postgres;

create sequence seq_tbl_adocao_pk increment by 50;
alter sequence seq_tbl_adocao_pk owner to postgres;