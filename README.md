# EASETRAIN-WEBSITE
this is easetrain website

Password : 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

[ERD]

1. Refer ERD for Database utility use



![Untitled Diagram drawio (26)](https://github.com/Hazrulidham28/EASETRAIN-WEBSITE/assets/96154175/39dca8df-4e34-4473-a44c-c7cc34800001)

CREATING TABLE IN MYSQL

1. CREATE TABLE ADMIN(
email VARCHAR(40) PRIMARY KEY,
pass varchar(20) NOT NULL,
username varchar(40) NOT NULL,
address varchar (100) NOT NULL,
phoneNo varchar(12) NOT NULL

);

2. 
CREATE TABLE CUSTOMER(
IcNum VARCHAR(40) PRIMARY KEY, 
username varchar(20) NOT NULL,
email varchar(40) NOT NULL,
PhoneNO varchar (12) NOT NULL,
pass varchar(20) NOT NULL,
walletbalance double, 
profilepic varchar(100)

);
3.
CREATE TABLE TRAIN(TrNo varchar(20) PRIMARY KEY,date varchar(15) not null,FromStn varchar(20) not null,ToStn varchar(20) not null,depTime varchar(20) not null,arrTime varchar(20) not null,duration varchar(20) not null,type varchar(20) not null,fare double not null);

4.Create table for reserve
 CREATE TABLE RESERVE(transId varchar(30) PRIMARY KEY,IcNum varchar(40) REFERENCES customer(IcNum),TrNo varchar(20) REFERENCES train,date varchar(20),fromStn varchar(20),toStn varchar(20),seat varchar(10),amount double,DepTime varchar(20),ArrTime varchar(20),duration varchar(20),type varchar(20));

INSERT VALUE INTO TABLE

1.INSERT INTO admin VALUES('adminDemo@gmail.com','admin123','admin1','Tapah Perak','0123456789');

2.INSERT INTO customer VALUES('000000-00-0000','customer1','cust@gmail.com','0123456789','customer1',50.00,'https://drive.google.com/uc?export=view&id=15U6MiCsN2LLipUjcOmvo4BWET61Cbr7H');
3.insert into TRAIN values('TRxxx','01-01-2001','Kuala Lumpur','Tapah','12:45 PM','17:00 PM','4hrs 15min','PLATINUM',94.00);

