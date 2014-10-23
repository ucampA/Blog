DROP TABLE blog;
DROP TABLE member CASCADE CONSTRAINT;

CREATE TABLE member (
	userid	varchar(20) primary key,
	userpw	varchar(20) not null,
	name	varchar(20) not null,
	phone	varchar(13) not null,
	blogname varchar(30) not null,
	type char(1),
	constraint member_type_ck check(type in ('A', 'U'))
);

CREATE TABLE blog (
	no number(5) primary key,
	title varchar(50) not null,
	content varchar(500) not null,
	writeday date not null,
	readcount number(4) not null,
	userid	varchar(20),
	constraint blog_userid_fk foreign key(userid) references member(userid)
);

CREATE SEQUENCE seq_blog_no INCREMENT BY 1 START WITH 1;

