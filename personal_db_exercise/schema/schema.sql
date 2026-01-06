CREATE DATABASE employee_manage;

USE employee_manage;

CREATE TABLE department(
	dept_id int PRIMARY KEY,
	dept_name varchar(30) NOT NULL
);

CREATE TABLE employee(
	emp_id int PRIMARY KEY AUTO_INCREMENT,
	emp_name varchar(30) NOT NULL,
	gender int NOT NULL,
	birthday date NOT NULL,
	dept_id int NOT NULL,
	
	FOREIGN KEY(dept_id) REFERENCES department(dept_id)
);

INSERT INTO department(dept_id, dept_name)VALUES
	(1, "営業部"),
	(2, "経理部"),
	(3, "総務部");

INSERT INTO employee(emp_name, gender, birthday, dept_id)VALUES
	("中部太郎", 1, "1990-10-20", 1),
	("田中二郎", 1, "1978-12-15", 2),
	("愛知花子", 2, "1988-05-15", 2);
