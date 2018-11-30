-- create database and table with table
CREATE DATABASE guestbook;
CREATE TABLE IF NOT EXISTS guestbook (content TEXT, name VARCHAR(16), date_time TIMESTAMP);

-- create entry
INSERT INTO guestbook VALUES ('tresc posta', 'imie', '2001-09-28 01:00');

-- read all entries 
SELECT * FROM guestbook;
