# 1 데이터베이스 생성
drop database if exists boardservice7;
create database boardservice7;
use boardservice7;

# 2 테이블 생성
create table board(
	bno int auto_increment ,
    constraint primary key(bno),
    bcontent longtext not null,
    bwriter varchar(30) not  null,
    bdate datetime default now()
);

INSERT INTO board (bcontent, bwriter) VALUES ('안녕하세요, 첫 번째 게시물입니다.', 'user01');
INSERT INTO board (bcontent, bwriter) VALUES ('두 번째 테스트 글을 올립니다.', 'user02');
INSERT INTO board (bcontent, bwriter) VALUES ('세 번째 게시물 내용입니다.', 'user03');
INSERT INTO board (bcontent, bwriter) VALUES ('네 번째 게시물, 잘 작동하나요?', 'user04');
INSERT INTO board (bcontent, bwriter) VALUES ('다섯 번째 글입니다. 반갑습니다.', 'user05');
INSERT INTO board (bcontent, bwriter) VALUES ('여섯 번째 샘플 데이터입니다.', 'user06');
INSERT INTO board (bcontent, bwriter) VALUES ('일곱 번째 게시글입니다.', 'user07');
INSERT INTO board (bcontent, bwriter) VALUES ('여덟 번째 데이터 입력 중입니다.', 'user08');
INSERT INTO board (bcontent, bwriter) VALUES ('아홉 번째 게시글입니다.', 'user09');
INSERT INTO board (bcontent, bwriter) VALUES ('열 번째 마지막 데이터입니다.', 'user10');

# 3 테이블 샘플 데이터