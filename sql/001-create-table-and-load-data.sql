DROP TABLE IF EXISTS history;

CREATE TABLE history (
  id int unsigned AUTO_INCREMENT,
  years VARCHAR(20) NOT NULL,
  area VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO history (years,area) VALUES ("2017年","東京");
INSERT INTO history (years,area) VALUES ("2018年","埼玉");
