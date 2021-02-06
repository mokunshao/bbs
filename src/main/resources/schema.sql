DROP DATABASE IF EXISTS ssm;
CREATE DATABASE ssm CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ssm;
CREATE TABLE Todo
(
    `id`      INT          NOT NULL AUTO_INCREMENT,
    `content`   VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `ssm`.`Topic` (
`id` INT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(45) NOT NULL,
`content` VARCHAR(1000) NOT NULL,
`userId` INT NOT NULL,
PRIMARY KEY (`id`));


CREATE TABLE `ssm`.`User` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(45) NOT NULL,
`password` VARCHAR(45) NOT NULL,
`role` ENUM('admin', 'normal', 'guest') NOT NULL,
PRIMARY KEY (`id`));


CREATE TABLE `ssm`.`TopicComment` (
`id` INT NOT NULL AUTO_INCREMENT,
`content` VARCHAR(200) NOT NULL,
`userId` INT NOT NULL,
`topicId` INT NOT NULL,
PRIMARY KEY (`id`));
