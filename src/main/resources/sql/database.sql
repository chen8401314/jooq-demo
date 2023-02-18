CREATE TABLE pf_test_t
(
    id           CHAR(32) NOT NULL PRIMARY KEY,
    create_time  DATETIME,
    age          INTEGER,
    birthday     DATE,
    name         VARCHAR2(255),
    home_address VARCHAR2(255),
    event_status VARCHAR2(64),
    is_marry     BIT(1)
);
CREATE TABLE pf_user_t
(
    id        CHAR(32) NOT NULL PRIMARY KEY,
    created_dt DATETIME,
    name      VARCHAR2(255)
);
