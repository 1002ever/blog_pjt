CREATE TABLE hashtag(
tagNo INT AUTO_INCREMENT PRIMARY KEY,
tagname VARCHAR(20),
COUNT int
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
introNo int REFERENCES introduction (introNo), 
tagNo int REFERENCES hashtag (tagNo)
);


INSERT INTO hashtag(tagname) VALUES('지원동기');
INSERT INTO hashtag(tagname) VALUES('입사 후 포부');
INSERT INTO hashtag(tagname) VALUES('갈등');
INSERT INTO hashtag(tagname) VALUES('팀워크');
INSERT INTO hashtag(tagname) VALUES('성취');
INSERT INTO hashtag(tagname) VALUES('실패');
INSERT INTO hashtag(tagname) VALUES('도전');
INSERT INTO hashtag(tagname) VALUES('성공');
INSERT INTO hashtag(tagname) VALUES('성격');
INSERT INTO hashtag(tagname) VALUES('장점');
INSERT INTO hashtag(tagname) VALUES('단점');
INSERT INTO hashtag(tagname) VALUES('가치관');
INSERT INTO hashtag(tagname) VALUES('성장과정');
INSERT INTO hashtag(tagname) VALUES('혁신');
INSERT INTO hashtag(tagname) VALUES('문제해결');
INSERT INTO hashtag(tagname) VALUES('정직');
tagginginterestfieldinterestfield