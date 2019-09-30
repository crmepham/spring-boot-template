create table user (
	id bigint(10) unsigned not null auto_increment,
	username varchar(50) not null,
	password varchar(200) not null,
	account_non_expired tinyint(1) default 1,
	account_non_locked tinyint(1) default 1,
	credentials_non_expired tinyint(1) default 1,
	enabled tinyint(1) default 0,
	created datetime default now(),
	last_updated datetime default now(),
	visible tinyint(1) default 1,
	primary key (id),
	unique(username)
) engine=InnoDB default charset=utf8;

CREATE INDEX user_username ON `user` (username);
CREATE INDEX user_password ON `user` (password);

create table role (
    id bigint(10) unsigned not null auto_increment,
    name varchar(25) not null,
    created datetime default now(),
    last_updated datetime default now(),
    primary key (id),
    unique(name)
) engine=InnoDB default charset=utf8;

CREATE INDEX role_name ON `role` (name);

create table privilege (
    id bigint(10) unsigned not null auto_increment,
    name varchar(25) not null,
    created datetime default now(),
    last_updated datetime default now(),
    primary key (id),
    unique(name)
) engine=InnoDB default charset=utf8;

CREATE INDEX privilege_name ON `privilege` (name);

create table user_role (
	id bigint(10) unsigned not null auto_increment,
	user_id bigint(10) unsigned not null,
	role_id bigint(10) unsigned not null,
	primary key (id),
	unique(user_id, role_id)
) engine=InnoDB default charset=utf8;

CREATE INDEX user_role ON `user_role` (user_id, role_id);

create table role_privilege (
	id bigint(10) unsigned not null auto_increment,
	role_id bigint(10) unsigned not null,
	privilege_id bigint(10) unsigned not null,
	primary key (id),
	unique(role_id, privilege_id)
) engine=InnoDB default charset=utf8;

CREATE INDEX role_privilege ON `role_privilege` (role_id, privilege_id);

insert into user (username,password,enabled,visible) values ('admin','$2a$10$tsNJ8nCUFQKkUamQJiYvUeN0Gi.FgGh.SnSKk02rv9hSXBERmMQYm',1,1);
insert into role (name) values ('ROLE_ADMIN'), ('ROLE_USER');
insert into privilege (name) values ('PRIVILEGE_READ'), ('PRIVILEGE_WRITE');

set @userId = (select id from user where username = 'admin');
set @roleId = (select id from role where name = 'ROLE_ADMIN');
set @privilegeReadId = (select id from privilege where name = 'PRIVILEGE_READ');
set @privilegeWriteId = (select id from privilege where name = 'PRIVILEGE_WRITE');
insert into role_privilege (role_id,privilege_id) values (@roleId,@privilegeReadId), (@roleId,@privilegeWriteId);
insert into user_role (user_id, role_id) values (@userId, @roleId);