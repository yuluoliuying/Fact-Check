drop table if exists `role`;
drop table if exists `user_tag`;
drop table if exists `result`;
drop table if exists `message_state`;
drop table if exists `message_process`;
drop table if exists `message_log`;
drop table if exists `message`;
drop table if exists `user`;
drop table if exists `tag`;



create table `user`
(
    uid      integer auto_increment,
    username varchar(100) unique not null,
    password varchar(100)        not null,
    primary key (uid)
);

insert into `user`(username, password)
values ('zzytql', '123456'),
       ('ckftcl', '123456');

create table `role`
(
    rid      integer auto_increment,
    roleName varchar(100) not null,
    uid      integer      not null,
    primary key (rid),
    foreign key (uid) references `user` (uid) on delete cascade
);

create table `tag`
(
    tid     integer auto_increment,
    tagName varchar(100) unique not null,
    primary key (tid)
);

create table `user_tag`
(
    uid integer,
    tid integer,
    primary key (uid, tid),
    foreign key (uid) references `user` (uid) on delete cascade,
    foreign key (tid) references `tag` (tid) on delete cascade
);

create table `message`
(
    mid         integer auto_increment,
    messageName varchar(100) not null,
    description mediumtext   not null,
    position    varchar(100) null,
    tagName     varchar(100) null,
    uploadTime  timestamp    not null,
    primary key (mid)
);

create table `message_state`
(
    mid    integer,
    status integer,
    time   timestamp not null,
    primary key (mid, status),
    foreign key (mid) references `message` (mid) on delete cascade
);

create table `message_process`
(
    processNum integer auto_increment,
    mid        integer      not null,
    type       integer      not null,
    state      integer      not null,
    username   varchar(100) not null,
    content    text,
    primary key (processNum),
    foreign key (mid) references `message` (mid) on delete cascade,
    foreign key (username) references `user` (username) on delete cascade
);

create table `message_log`
(
    lid        integer auto_increment,
    username   varchar(100) not null,
    content    text         not null,
    uploadTime timestamp    not null,
    primary key (lid),
    foreign key (username) references `user` (username) on delete cascade
);

create table `result`
(
    rid         integer auto_increment,
    state       integer      not null,
    resultName  varchar(100) not null,
    description mediumtext   not null,
    position    varchar(100) null,
    tagName     varchar(100) not null,
    updateTime  timestamp    not null,
    releaseTime timestamp    not null,
    primary key (rid)
)
