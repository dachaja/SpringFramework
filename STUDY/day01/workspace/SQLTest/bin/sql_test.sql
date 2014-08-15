create table users(
	id varchar2(8) primary key,
	password varchar2(8),
	name varchar2(20),
	role varchar2(5)
);

insert into users values('test','test','AJ','Admin');
insert into users values('aaa','aaa','ȫ�浿','User');

create table board(
	seq number(5) primary key,
	title varchar2(200),
	writer varchar2(20),
	content varchar2(2000),
	regdate date default sysdate,
	cnt number(5) default 0
);

insert into board (seq, title, writer, content) values(1,'�����λ�','ȫ�浿','�� ��Ź�帳�ϴ�.');

select * from users;
select * from board;