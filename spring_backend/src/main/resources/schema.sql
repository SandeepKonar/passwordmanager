CREATE DATABASE IF NOT EXISTS password_manager;
USE password_manager;

CREATE TABLE IF NOT EXISTS USER_DETAILS (
	user_id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(25),
    credential VARCHAR(25),
    PRIMARY KEY(user_id)
);

CREATE TABLE IF NOT EXISTS APP_PASSWORDS (
	user_id INT,
    app_id INT NOT NULL AUTO_INCREMENT,
    app_name varchar(50),
    credential varchar(25),
    create_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    metadata_flag bool,
    app_status varchar(10),
    PRIMARY KEY(app_id),
    FOREIGN KEY(user_id) REFERENCES USER_DETAILS(user_id) on DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS PASSWORD_METADATA (
	app_id INT,
    field_name VARCHAR(25) NOT NULL,
    field_value VARCHAR(25),
    create_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_hashed bool,
    PRIMARY KEY (app_id, field_name),
    FOREIGN KEY(app_id) REFERENCES APP_PASSWORDS(app_id) on DELETE CASCADE
);