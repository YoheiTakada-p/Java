CREATE DATABASE ogy DEFAULT CHARACTER SET utf8;
USE ogy;
CREATE TABLE t_user (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(10) NOT NULL UNIQUE,
	login_id varchar(10) NOT NULL UNIQUE,
	login_password varchar(10) NOT NULL,
	user_comment varchar(10),
	create_date date,
	update_date date
	);

CREATE TABLE t_post (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	sentence varchar(30) NOT NULL,
	user_id int NOT NULL,
	title_id int NOT NULL,
	create_date date
	);

CREATE TABLE t_like (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id int NOT NULL,
	post_id int NOT NULL
	);

CREATE TABLE t_title (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title varchar(24) NOT NULL,
	create_date date
	);
