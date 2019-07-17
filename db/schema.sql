drop table account;
drop table person;

create table Person(
	id serial primary key,
	Username varchar not null,
	Password varchar not null,
	Authority integer not null,
	Accountnum integer not null,
	verified boolean not null
	);

create table Account(
	id serial primary key,
	balance int not null,
	accountnumber int not null references Person(id)
	);
	
insert into Person(Username,Password,Authority,Accountnum,verified) values('emp',123,2,0,true);
insert into Person(Username,Password,Authority,Accountnum,verified) values('adm',123,3,0,true);