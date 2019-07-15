drop table Person;
drop table Account;


select * from Person where username = 'Frank'
select * from person
select * from Account
select * from Account where accountnumber = 1
select * from person where username = 'br' and password = '123'
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
	
	
	insert into Person(Username,Password,Authority,Accountnum,verified) values('emp',123,2,50000,true);
	insert into Account(balance,accountnumber) values(200,2);
	update account set balance = 250 where accountnumber = 1	
	update person set verified = true where username = 'emp'
		
	update person set accountnum = 5000 where username = 'emp'
select max(id) from account		
	
	
	
	
	
	
	create table movies(
	id serial primary key,
	title text not null,
	year integer not null check (year > 1950),
	director integer references directors(id)
	);
	

	
insert into directors(name) values ('steven Spielberg');
insert into movies(title,year,director) values('Jurassic park', 1993,1);