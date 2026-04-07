
-- data08 todo sample insert --
-- INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('자바공부', 'Chapter 4: 제어문 익히기', false, NOW(), NOW());
-- INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('자바공부', 'Chapter 3: 연산자 복습', true, NOW(), NOW());
-- INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('프로젝트', 'Todo 리스트 DB 연동 실습', false, NOW(), NOW());
-- INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('개념정리', 'JVM 메모리 구조(Stack vs Heap)', false, NOW(), NOW());
-- INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('독서', '객체지향의 사실과 오해 1장', true, NOW(), NOW());
-- INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('알고리즘', '백준 1000번: A+B 해결', true, NOW(), NOW());
-- INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('환경설정', 'IntelliJ 플러그인 설치 및 최적화', false, NOW(), NOW());
-- -INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('면접대비', 'Java8 람다와 스트림 API 정리', false, NOW(), NOW());
-- -INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('버그수정', 'DB Connection Leak 문제 해결', true, NOW(), NOW());
-- INSERT INTO todo (title, content, done, create_date, update_date) VALUES ('자바공부', 'Chapter 5: 배열과 다차원 배열', false, NOW(), NOW());
-- insert into article_Entity(title,content)values ("제목1" , "내용1");

-- ---------------- day11 todo sample insert ----------------
-- insert into category (cname, create_date, update_date) values ('공부', now(), now());
-- insert into category (cname, create_date, update_date) values ('운동', now(), now());
-- insert into category (cname, create_date, update_date) values ('업무', now(), now());
-- insert into category (cname, create_date, update_date) values ('취미', now(), now());
-- insert into category (cname, create_date, update_date) values ('생활', now(), now());

-- insert into todo (title, content, done, cno, create_date, update_date) values('자바 공부', 'JPA 기본 개념 정리', false, 1, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('Spring Boot 실습', 'REST API 만들기', false, 1, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('React 공부', 'useState와 props 이해하기', false, 1, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('데이터베이스 공부', 'JOIN과 INDEX 복습', false, 1, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('알고리즘 문제풀이', '백준 문제 5개 풀기', false, 1, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('헬스장 가기', '하체 운동', false, 2, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('러닝', '5km 달리기', false, 2, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('스트레칭', '아침 스트레칭 20분', true, 2, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('수영', '자유형 연습', false, 2, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('요가', '유연성 운동', false, 2, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('프로젝트 기획', '서비스 기능 목록 정리', false, 3, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('회의 준비', '자료 PPT 작성', false, 3, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('코드 리뷰', '팀원 PR 검토', false, 3, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('API 설계', 'ERD 및 엔드포인트 설계', false, 3, now(), now());
-- insert into todo (title, content, done, cno, create_date, update_date) values('배포 준비', 'Docker 이미지 빌드', false,


-- ----------------  Springweb user sample insert ----------------
 INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user01', 'qwe123.', '김민수', now(), now());
 INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user02', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '이지은', now(), now());
 INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user03', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '박서준', now(), now());
 INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user04', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '최유리', now(), now());
 INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user05', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '정우성', now(), now());

-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user06', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '강하늘', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user07', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '한지민', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user08', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '신세경', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user09', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '김수현', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user10', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '이종석', now(), now());

-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user11', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '박보검', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user12', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '송혜교', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user13', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '김태리', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user14', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '전지현', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user15', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '유재석', now(), now());

-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user16', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '강호동', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user17', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '이광수', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user18', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '하정우', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user19', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '공유', now(), now());
-- INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user20', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '수지', now(), now());



-- ---------------- Board sample insert ----------------

 INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('첫 번째 게시글', '내용입니다1', null, 1, now(), now());
 INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('두 번째 게시글', '내용입니다2', 'https://placehold.co/100', 2, now(), now());
 INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('세 번째 게시글', '내용입니다3', null, 3, now(), now());
 INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('네 번째 게시글', '내용입니다4', 'https://placehold.co/100', 4, now(), now());
 INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('다섯 번째 게시글', '내용입니다5', null, 5, now(), now());

-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('여섯 번째 게시글', '내용입니다6', 'https://placehold.co/100', 1, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('일곱 번째 게시글', '내용입니다7', null, 2, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('여덟 번째 게시글', '내용입니다8', 'https://placehold.co/100', 3, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('아홉 번째 게시글', '내용입니다9', null, 4, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열 번째 게시글', '내용입니다10', 'https://placehold.co/100', 5, now(), now());

-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열한 번째 게시글', '내용입니다11', null, 1, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열두 번째 게시글', '내용입니다12', 'https://placehold.co/100', 2, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열세 번째 게시글', '내용입니다13', null, 3, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열네 번째 게시글', '내용입니다14', 'https://placehold.co/100', 4, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열다섯 번째 게시글', '내용입니다15', null, 5, now(), now());

-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열여섯 번째 게시글', '내용입니다16', 'https://placehold.co/100', 1, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열일곱 번째 게시글', '내용입니다17', null, 2, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열여덟 번째 게시글', '내용입니다18', 'https://placehold.co/100', 3, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('열아홉 번째 게시글', '내용입니다19', null, 4, now(), now());
-- INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('스무 번째 게시글', '내용입니다20', 'https://placehold.co/100', 5, now(), now());



-------------------practice sample insert-------------------

