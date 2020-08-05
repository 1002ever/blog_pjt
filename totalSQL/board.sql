CREATE TABLE board(

boardNo INT PRIMARY KEY AUTO_INCREMENT,
uid VARCHAR(20) NOT NULL,
subject varchar(100) NOT NULL,
content TEXT(20000),
likes INT DEFAULT 0,
interest VARCHAR(100) NULL,
picture VARCHAR(100) NULL,
date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP 
);

INSERT INTO board(uid,subject,content,interest) 
VALUES('ssafy','본인의 성장과정을 간략히 작성해주시기 바랍니다',
'[개발자의 미래를 꿈꾸며] 처음 학과~~','it'
)