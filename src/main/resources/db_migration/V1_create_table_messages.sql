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

