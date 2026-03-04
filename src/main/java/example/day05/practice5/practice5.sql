drop database if exists practice5;
create database practice5;
use practice5;

create table book(
	bno int primary key auto_increment,
    bname varchar(255),
    bwriter varchar(255),
    publisher varchar(255)
);
insert into book(bname , bwriter , publisher) values('개미' , '유재석' , '비상'); 
insert into book(bname , bwriter , publisher) values('사피엔스' , '강호동' , '금성'); 
insert into book(bname , bwriter , publisher) values('총균쇠' , '신동엽' , '바다'); 
select * from book;

