create database if not exists cars;

use cars;

drop table if exists cars;

create table models(
	id int(10) not null,
	make varchar(20) not null,
	primary key(id)
);
