DROP TABLE tagging;
DROP TABLE hashtag;
DROP TABLE introduction;


CREATE TABLE hashtag(
tagNo INT AUTO_INCREMENT PRIMARY KEY,
tagname VARCHAR(20),
cnt int
);

CREATE TABLE introduction(
introNo INT AUTO_INCREMENT PRIMARY KEY,
uid VARCHAR(10),
company VARCHAR(10),
startdate DATE,
enddate DATE,
subjectNo INT,
subject VARCHAR(20),
contents TEXT(20000),
limitlength int
);

CREATE TABLE tagging(
taggingNo int PRIMARY KEY AUTO_INCREMENT,
introNo int REFERENCES introduction (introNo), 
tagNo int REFERENCES hashtag (tagNo)
);

INSERT INTO hashtag(tagname,cnt) VALUES('지원동기',1);
INSERT INTO hashtag(tagname,cnt) VALUES('입사 후 포부',1);
INSERT INTO hashtag(tagname,cnt) VALUES('갈등',1);
INSERT INTO hashtag(tagname,cnt) VALUES('팀워크',1);
INSERT INTO hashtag(tagname,cnt) VALUES('성취',1);
INSERT INTO hashtag(tagname,cnt) VALUES('실패',1);
INSERT INTO hashtag(tagname,cnt) VALUES('도전',1);
INSERT INTO hashtag(tagname,cnt) VALUES('성공',1);
INSERT INTO hashtag(tagname,cnt) VALUES('성격',1);
INSERT INTO hashtag(tagname,cnt) VALUES('장점',1);
INSERT INTO hashtag(tagname,cnt) VALUES('단점',1);
INSERT INTO hashtag(tagname,cnt) VALUES('가치관',1);
INSERT INTO hashtag(tagname,cnt) VALUES('성장과정',1);
INSERT INTO hashtag(tagname,cnt) VALUES('혁신',1);
INSERT INTO hashtag(tagname,cnt) VALUES('문제해결',1);
INSERT INTO hashtag(tagname,cnt) VALUES('정직',1);

