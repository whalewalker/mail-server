create database if not exists server;

create user if not exists 'whale'@'localhost' identified by '#Whale123';
grant all privileges on server.* 'whale'@'localhost';
flush privileges