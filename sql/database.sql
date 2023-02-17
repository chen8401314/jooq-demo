CREATE TABLE test (
  id char(32) NOT NULL PRIMARY KEY,
  create_time DATETIME,
  age INTEGER,
  birthday DATE,
  name VARCHAR(255),
  sex VARCHAR(10),
  department VARCHAR(100),
  home_address VARCHAR(255),
  event_status VARCHAR(64),
  is_marry BIT(1)
);
