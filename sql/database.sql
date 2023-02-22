CREATE TABLE pf_test
(
    id           CHAR(32) NOT NULL PRIMARY KEY,
    create_time  DATETIME,
    age          INTEGER,
    birthday     DATE,
    name         VARCHAR2(255) COMMENT '名字',
    home_address VARCHAR2(255),
    event_status VARCHAR2(64),
    is_marry     BIT(1)
);
CREATE TABLE pf_user
(
    id         CHAR(32) NOT NULL PRIMARY KEY,
    created_dt DATETIME COMMENT '创建时间',
    name       VARCHAR2(255) COMMENT '名称'
);
