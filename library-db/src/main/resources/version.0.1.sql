create table book(
book_Id varchar(25)  primary key,
author varchar(50) not null,
price varchar(5),
available int(4),
title varchar(64) not null,
due_Date date,
return_Date date,
created_At date,
updated_At date,
member_id char(35),
is_Deleted boolean
);
CREATE TABLE member(
member_id char(35) primary key ,
name varchar (25) not NULL ,
email_id varchar (45) unique ,
contact_no varchar(13) unique ,
expiry_Date DATE ,
member_Type varchar(10)
)

create TABLE user_limit(
member_id char (35) primary KEY ,
total_book int(1)
)