DROP TABLE IF EXISTS test;
CREATE TABLE test (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  intcol    INT,
  stringcol VARCHAR(100),
  doublecol DOUBLE
);
INSERT INTO test (intcol, stringcol, doublecol) VALUES (393939, 'testString', 3.9);