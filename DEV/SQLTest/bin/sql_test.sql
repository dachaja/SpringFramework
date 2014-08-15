create table users(
	id varchar2(8) primary key,
	password varchar2(8),
	name varchar2(20),
	role varchar2(5)
);

insert into users values('test','test','AJ','Admin');
insert into users values('aaa','aaa','조아현','User');

create table board(
	seq number(5) primary key,
	title varchar2(200),
	writer varchar2(20),
	content varchar2(2000),
	regdate date default sysdate,
	cnt number(5) default 0
);

insert into board (seq, title, writer, content) values(1,'test','test','test.');

select * from users;
select * from board;