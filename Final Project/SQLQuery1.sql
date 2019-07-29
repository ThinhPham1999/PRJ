Use PRJ311_DE130111

Create table Product_DE130111(
	sProduct_ID char(5) primary key,
	sProduct_Name nvarchar(30),
	sUnit nvarchar(30),
	sPrice int
)


Insert into Product_DE130111 values('P0001', 'Samsung Galaxy 10', 'Set', 12000000)
Insert into Product_DE130111 values('P0002', 'IPhone 12X', 'Item', 24000000 )  

Select * from Product_DE130111