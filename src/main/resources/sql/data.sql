
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
 --INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user01', 'qwe123.', '김민수', now(), now());
 --INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user02', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '이지은', now(), now());
 --INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user03', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '박서준', now(), now());
 --INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user04', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '최유리', now(), now());
 --INSERT INTO member (mid, mpwd, mname, create_date, update_date) VALUES ('user05', '$2a$10$69bMrChodVYxOcvM/cUo7evsho3hw6YBJT9yepHudwBlIvi7KlV0.', '정우성', now(), now());

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

 --INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('첫 번째 게시글', '내용입니다1', null, 1, now(), now());
 --INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('두 번째 게시글', '내용입니다2', 'https://placehold.co/100', 2, now(), now());
 --INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('세 번째 게시글', '내용입니다3', null, 3, now(), now());
 --INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('네 번째 게시글', '내용입니다4', 'https://placehold.co/100', 4, now(), now());
 --INSERT INTO board (btitle, bcontent, bfile, mno, create_date, update_date) VALUES ('다섯 번째 게시글', '내용입니다5', null, 5, now(), now());

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

INSERT INTO car (efficiency, mileage, month, accident, change_user, price) VALUES
                                                                               (11.5, 15000, 14, 0, 0, 4250),
                                                                               (8.2, 5000, 4, 0, 0, 6800),
                                                                               (7.5, 120, 2, 0, 0, 8400),
                                                                               (10.2, 28000, 26, 0, 0, 3850),
                                                                               (9.8, 18000, 16, 0, 0, 4900),
                                                                               (6.2, 800, 1, 0, 0, 11500),
                                                                               (7.9, 3200, 3, 0, 0, 7200),
                                                                               (8.8, 12000, 10, 0, 0, 5800),
                                                                               (9.0, 24000, 22, 1, 1, 4100),
                                                                               (6.8, 4500, 5, 0, 0, 9200),
                                                                               (12.8, 42000, 38, 1, 1, 2950),
                                                                               (13.2, 88000, 74, 2, 2, 1650),
                                                                               (12.0, 33000, 28, 1, 1, 3100),
                                                                               (12.5, 22000, 24, 0, 1, 3600),
                                                                               (11.8, 31000, 29, 1, 0, 3350),
                                                                               (13.5, 55000, 52, 2, 2, 2100),
                                                                               (12.2, 48000, 42, 0, 1, 2800),
                                                                               (13.0, 61000, 58, 1, 2, 1980),
                                                                               (11.9, 29000, 25, 0, 1, 3450),
                                                                               (12.7, 41000, 36, 1, 1, 2900),
                                                                               (16.2, 125000, 82, 3, 2, 980),
                                                                               (15.0, 154000, 108, 4, 3, 650),
                                                                               (14.0, 72000, 62, 2, 1, 1950),
                                                                               (15.5, 185000, 122, 4, 3, 480),
                                                                               (13.8, 64000, 65, 2, 2, 1780),
                                                                               (14.2, 162000, 118, 3, 3, 580),
                                                                               (15.8, 142000, 95, 4, 3, 540),
                                                                               (16.5, 98000, 70, 1, 2, 1350),
                                                                               (17.2, 115000, 80, 2, 2, 1180),
                                                                               (19.0, 52000, 45, 0, 1, 2200),
                                                                               (14.5, 210000, 135, 5, 4, 320),
                                                                               (18.5, 245000, 158, 6, 5, 180),
                                                                               (10.1, 255000, 160, 4, 4, 150),
                                                                               (13.9, 198000, 128, 5, 4, 390),
                                                                               (15.2, 220000, 144, 3, 5, 280),
                                                                               (11.0, 230000, 150, 4, 3, 210),
                                                                               (14.1, 260000, 155, 5, 4, 160),
                                                                               (12.5, 205000, 130, 3, 3, 420),
                                                                               (13.4, 215000, 140, 4, 5, 290),
                                                                               (16.0, 240000, 152, 6, 4, 190),
                                                                               (10.8, 2500, 2, 0, 0, 5400),
                                                                               (14.8, 4100, 3, 0, 0, 3800),
                                                                               (12.1, 1500, 1, 0, 0, 4600),
                                                                               (15.1, 6200, 4, 0, 0, 3150),
                                                                               (8.5, 900, 1, 0, 0, 7900),
                                                                               (13.3, 3300, 2, 0, 0, 3500),
                                                                               (11.2, 5100, 4, 0, 0, 4200),
                                                                               (16.0, 1800, 1, 0, 0, 2600),
                                                                               (9.5, 2800, 3, 0, 0, 6200),
                                                                               (12.6, 4600, 4, 0, 0, 3300),
                                                                               (11.3, 16200, 15, 0, 0, 4180),
                                                                               (8.4, 4800, 4, 0, 0, 6950),
                                                                               (7.4, 350, 3, 0, 0, 8250),
                                                                               (10.0, 29500, 27, 1, 0, 3720),
                                                                               (9.6, 19100, 17, 0, 0, 4810),
                                                                               (6.4, 950, 2, 0, 0, 11200),
                                                                               (8.1, 2900, 3, 0, 0, 7350),
                                                                               (8.6, 12800, 11, 0, 0, 5650),
                                                                               (9.2, 23100, 21, 1, 0, 4190),
                                                                               (6.6, 4900, 6, 0, 0, 8950),
                                                                               (12.5, 44500, 40, 1, 2, 2820),
                                                                               (13.5, 84000, 71, 2, 1, 1720),
                                                                               (11.8, 34800, 30, 1, 1, 3020),
                                                                               (12.3, 23400, 25, 0, 1, 3510),
                                                                               (12.0, 29800, 28, 1, 1, 3420),
                                                                               (13.2, 57500, 54, 2, 2, 2020),
                                                                               (12.4, 46200, 41, 1, 1, 2880),
                                                                               (12.8, 63400, 60, 2, 2, 1910),
                                                                               (12.1, 28200, 24, 0, 0, 3530),
                                                                               (12.9, 39500, 35, 1, 1, 2990),
                                                                               (16.0, 129000, 85, 3, 3, 940),
                                                                               (14.8, 159000, 112, 4, 3, 610),
                                                                               (14.2, 70500, 60, 2, 1, 1990),
                                                                               (15.3, 189000, 125, 5, 4, 450),
                                                                               (14.0, 62500, 63, 2, 2, 1820),
                                                                               (14.5, 158000, 115, 3, 2, 610),
                                                                               (15.6, 146000, 98, 4, 3, 510),
                                                                               (16.7, 95000, 68, 1, 1, 1390),
                                                                               (17.0, 118000, 82, 2, 3, 1140),
                                                                               (18.8, 54500, 47, 0, 1, 2130),
                                                                               (14.7, 205000, 132, 4, 4, 340),
                                                                               (18.2, 249000, 161, 6, 4, 160),
                                                                               (10.3, 251000, 158, 4, 5, 170),
                                                                               (13.7, 202000, 130, 5, 4, 370),
                                                                               (15.4, 215000, 141, 3, 4, 300),
                                                                               (11.2, 234000, 153, 5, 3, 190),
                                                                               (13.9, 264000, 158, 5, 5, 140),
                                                                               (12.7, 201000, 127, 3, 2, 440),
                                                                               (13.2, 219000, 143, 4, 4, 270),
                                                                               (16.3, 237000, 150, 6, 4, 205),
                                                                               (10.6, 2800, 3, 0, 0, 5250),
                                                                               (15.0, 3900, 3, 0, 0, 3910),
                                                                               (11.9, 1700, 1, 0, 0, 4480),
                                                                               (15.3, 6000, 4, 0, 0, 3220),
                                                                               (8.7, 800, 1, 0, 0, 8050),
                                                                               (13.1, 3500, 2, 0, 0, 3410),
                                                                               (11.4, 4900, 4, 0, 0, 4320),
                                                                               (15.8, 2000, 2, 0, 0, 2520),
                                                                               (9.3, 3000, 3, 0, 0, 6080),
                                                                               (12.8, 4400, 4, 0, 0, 3410);