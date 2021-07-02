CREATE DATABASE IF NOT EXISTS Todo;

USE Todo;

CREATE TABLE IF NOT EXISTS todolist(
taskId int auto_increment,
taskDescription varchar(1000) not null,
taskProgress varchar(30) not null,
primary key(taskId)
);