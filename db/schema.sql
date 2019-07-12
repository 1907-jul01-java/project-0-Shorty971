drop table users;
drop table directors;

create table Person(
	id serial primary key,
	Username varchar not null,
	Password varchar not null,
	Authority integer not null,
	AccountNumber integer not null,
	verified boolean not null
	);

create table movies(
	id serial primary key,
	title text not null,
	year integer not null check (year > 1950),
	director integer references directors(id)
	);
	
	
insert into directors(name) values ('steven Spielberg');
insert into movies(title,year,director) values('Jurassic park', 1993,1);