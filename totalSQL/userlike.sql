DROP TABLE IF EXISTS USERLIKE

CREATE TABLE USERLIKE(
    likeno INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	boardno INT NOT NULL,
	uid VARCHAR(30) NOT NULL
);