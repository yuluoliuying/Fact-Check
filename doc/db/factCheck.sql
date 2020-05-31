drop table if exists `role`;
drop table if exists `user_tag`;
drop table if exists `result_state`;
drop table if exists `result`;
drop table if exists `message_state`;
drop table if exists `message_process`;
drop table if exists `message_log`;
drop table if exists `message`;
drop table if exists `user`;
drop table if exists `tag`;



create table `user`
(
    uid       integer auto_increment,
    username  varchar(100) unique not null,
    password  varchar(100)        not null,
    role_name varchar(100)        null,
    primary key (uid)
);

insert into `user`(username, password, role_name)
values ('zzytql', '123456', '管理员'),
       ('ckftcl', '123456', '管理员');

create table `tag`
(
    tid      integer auto_increment,
    tag_name varchar(100) unique not null,
    primary key (tid)
);

insert into `tag`(tag_name)
values ('科学'),
       ('生活'),
       ('政策'),
       ('海外'),
       ('国内');

create table `user_tag`
(
    username varchar(100),
    tag_name varchar(100),
    primary key (username, tag_name),
    foreign key (username) references `user` (username) on delete cascade,
    foreign key (tag_name) references `tag` (tag_name) on delete cascade
);

create table `message`
(
    mid          integer auto_increment,
    message_name varchar(100) not null,
    username     varchar(100) null,
    description  text   not null,
    position     varchar(100) null,
    tag_name     varchar(100) null,
    upload_time  timestamp    not null,
    primary key (mid),
    foreign key (username) references `user` (username) on delete cascade
);

create table `message_state`
(
    mid    integer,
    status integer,
    primary key (mid),
    foreign key (mid) references `message` (mid) on delete cascade
);

create table `message_process`
(
    process_num integer auto_increment,
    mid         integer      not null,
    type        integer      not null,
    state       integer      not null,
    username    varchar(100) null,
    content     text,
    primary key (process_num),
    foreign key (mid) references `message` (mid) on delete cascade,
    foreign key (username) references `user` (username) on delete cascade
);

create table `message_log`
(
    lid         integer auto_increment,
    username    varchar(100) null,
    content     text         not null,
    upload_time timestamp    not null,
    primary key (lid),
    foreign key (username) references `user` (username) on delete cascade
);

create table `result`
(
    rid          integer auto_increment,
    mid          integer,
    username     varchar(100) null,
    result_name  varchar(100) not null,
    cover        varchar(100) not null,
    description  text   not null,
    position     varchar(100) null,
    tag_name     varchar(100) not null,
    update_time  timestamp    not null,
    release_time timestamp    not null,
    primary key (rid),
    foreign key (mid) references `message` (mid) on delete cascade,
    foreign key (username) references `user` (username) on delete cascade
);

create table `result_state`(
    rid integer,
    state integer not null ,
    primary key (rid),
    foreign key (rid) references `result`(rid) on delete cascade
)
