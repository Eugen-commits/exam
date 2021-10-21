create sequence if not exists school_seq
    start 1;

create table if not exists school
(
    school_id      bigint not null default nextval('order_seq' :: regclass),
    student_id bigint not null,
    teacher_id bigint not null,
    school_name text not null,
    status int,
    constraint order_pk primary key (school_id)
    );

comment on table orders is 'Школа';
comment on column orders.school_id is 'Идентификатор школы';
comment on column orders.student_id is 'Идентификатор студента';
comment on column orders.teacher_id is 'Идентификатор учителя';
comment on column orders.status is 'Имя школы';

