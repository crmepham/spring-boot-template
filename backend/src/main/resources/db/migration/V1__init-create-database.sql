create table user (
	id bigint(10) unsigned not null auto_increment,
	username varchar(50) not null,
	password varchar(200) not null,
	account_non_expired bit default 1,
	account_non_locked bit default 1,
	credentials_non_expired bit default 1,
	enabled bit default 0,
	created datetime default now(),
	last_updated datetime default now(),
	visible bit default 1,
	primary key (id),
	unique(username)
) engine=innodb default charset=utf8;

create index user_username on `user` (username);
create index user_password on `user` (password);

create table role (
    id bigint(10) unsigned not null auto_increment,
    name varchar(25) not null,
    created datetime default now(),
    last_updated datetime default now(),
    primary key (id),
    unique(name)
) engine=innodb default charset=utf8;

create index role_name on `role` (name);

create table privilege (
    id bigint(10) unsigned not null auto_increment,
    name varchar(25) not null,
    created datetime default now(),
    last_updated datetime default now(),
    primary key (id),
    unique(name)
) engine=innodb default charset=utf8;

create index privilege_name on `privilege` (name);

create table user_role (
	id bigint(10) unsigned not null auto_increment,
	user_id bigint(10) unsigned not null,
	role_id bigint(10) unsigned not null,
	primary key (id),
	unique(user_id, role_id)
) engine=innodb default charset=utf8;

create index user_role on `user_role` (user_id, role_id);

create table role_privilege (
	id bigint(10) unsigned not null auto_increment,
	role_id bigint(10) unsigned not null,
	privilege_id bigint(10) unsigned not null,
	primary key (id),
	unique(role_id, privilege_id)
) engine=innodb default charset=utf8;

create index role_privilege on `role_privilege` (role_id, privilege_id);

insert into user (username,password,enabled,visible) values ('admin','$2a$10$dPqlSyivpW5PDEVmViV4/.ErSpJ4bkmCLaB7yc2fB0c.cqzm4OtI2',1,1);
insert into role (name) values ('role_admin'), ('role_user');
insert into privilege (name) values ('privilege_read'), ('privilege_write');

set @userid = (select id from user where username = 'admin');
set @roleid = (select id from role where name = 'role_admin');
set @privilegereadid = (select id from privilege where name = 'privilege_read');
set @privilegewriteid = (select id from privilege where name = 'privilege_write');
insert into role_privilege (role_id,privilege_id) values (@roleid,@privilegereadid), (@roleid,@privilegewriteid);
insert into user_role (user_id, role_id) values (@userid, @roleid);