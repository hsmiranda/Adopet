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

