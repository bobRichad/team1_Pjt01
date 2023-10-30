CREATE TABLE Member(
    id number primary key,
    name VARCHAR2(12) unique,
    addr VARCHAR2(50) not null,
    nation VARCHAR2(12) not null,
    email VARCHAR2(30) not null,
    age number
);
--이름 중복자 현실에 많이 존재, email에 중복불가 거는것도 좋을 듯
--javalink아이디로 진행 요망
CREATE SEQUENCE mem_seq 
    start with 0
    increment by 1
    minvalue 0
;

SELECT * from member;

