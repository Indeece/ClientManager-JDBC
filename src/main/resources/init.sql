CREATE TABLE Customer (
    id           BIGINT           AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(50)      NOT NULL,
    email        VARCHAR(50)      UNIQUE NOT NULL,
    phone        VARCHAR(20),
    created      TIMESTAMP        DEFAULT CURRENT_TIMESTAMP
)