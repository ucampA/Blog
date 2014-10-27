DROP TABLE reple;
DROP TABLE blog;
DROP TABLE post CASCADE CONSTRAINT;
DROP TABLE member CASCADE CONSTRAINT;
DROP SEQUENCE seq_blog_no;

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
	userid	varchar(20) primary key,
	blogname varchar(30) not null,
	openState varchar(1),
	constraint blog_userid_fk foreign key(userid) references member(userid),
	constraint blog_openstate_ck check(openState in ('O', 'C'))
);

CREATE TABLE post (
	no number(5) primary key,
	title varchar(50) not null,
	content varchar(500) not null,
	writeday date not null,
	readcount number(4) not null,
	userid	varchar(20),
	openState varchar(1),
	constraint post_userid_fk foreign key(userid) references member(userid),
	constraint post_openstate_ck check(openState in ('O', 'C'))
);

CREATE TABLE reple (
	rno number(5) primary key,
	content varchar(500) not null,
	writeday date not null,
	userid	varchar(20),
	pno number(5)
);

CREATE SEQUENCE seq_reple_no INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE seq_blog_no INCREMENT BY 1 START WITH 1;

CREATE OR REPLACE trigger insertBlogInfo 
after
	insert on member
	for each row
BEGIN
	insert into blog values(:new.userid, :new.blogname, 'O');	
END;
/
commit;

CREATE OR REPLACE trigger deletePostAndPost 
after
	delete on member
	for each row
BEGIN
	delete from post where userid = :old.userid;
	delete from blog where userid = :old.userid;
END;
/

insert into member values('admin', 'admin', 'admin', '010-1111-1111', 'noBlog', 'A');

commit;

