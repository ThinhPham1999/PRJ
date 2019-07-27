Use FuSM

Create table Student(
	sCode char(5) primary key,
	sName nvarchar(30),
	sDoB date,
	sGender int default(1) check(sGender>=1 and sGender<=2)
)


Insert into Student values('S0001', 'Lam', CONVERT(datetime, '2010-08-27', 120), 1)
Insert into Student values('S0002', 'Nam', CONVERT(datetime, '1999-05-27', 120), 1) 
Insert into Student values('S0003', 'Minh', CONVERT(datetime, '1999-02-03', 120), 2) 
Insert into Student values('S0004', 'Khoa', CONVERT(datetime, '1999-09-10', 120), 1)  

Select * from Student