-- Queries for Stock Project

DROP TABLE STOCK;

CREATE TABLE STOCK (SYMBOL VARCHAR(3) PRIMARY KEY, NAME VARCHAR(20), COMPANYNAME VARCHAR(20), DESCRIPTION VARCHAR(20), QTY INT, CURRENTMKTPRICE DOUBLE);

insert into stock (SYMBOL, NAME, COMPANYNAME, DESCRIPTION , QTY, CURRENTMKTPRICE) VALUES ('SY1', 'NAME1', 'COMP1', 'DESC1', 50, 564.36);
insert into stock (SYMBOL, NAME, COMPANYNAME, DESCRIPTION , QTY, CURRENTMKTPRICE) VALUES ('SY2', 'NAME2', 'COMP2', 'DESC2', 100, 864.36);

