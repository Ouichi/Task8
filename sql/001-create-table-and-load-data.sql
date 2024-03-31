DROP TABLE IF EXISTS movies;

CREATE TABLE History (
  id int unsigned AUTO_INCREMENT,
  years VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO History (years) VALUES ("2017年");
INSERT INTO History (years) VALUES ("2018年");
