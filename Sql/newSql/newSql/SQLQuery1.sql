Create Database FULib
Go
Use FULib
Go
CREATE TABLE Users (
	UserID char(5) Primary key,
	FullName nvarchar (30) NOT NULL ,
	Email varchar (30) NULL Check(Email  like '[a-z]%@[a-z]%.[a-z]%'),
	Password varchar(10) not null,
	Status char(2) default('BT') check(status in ('BT','LT','KT','SP')),
	UserRight int default(1) check(userRight>=1 and userRight<=3))
Go
Insert into Users(UserID,FullName,Email,password) values('U0001','Minh','a@b.c','1234')
Insert into Users(UserID,FullName,Email,password) values('U0002','Nam','a@b.c','1234')
Go
Create Table Books(
	BookID varchar(12) primary key,
	Title nvarchar(150) not null,
	Author nvarchar(30) not null,
	Category nvarchar(20),
	Keyword nvarchar(100) not null)
Go
Insert into Books(BookID, Title,Author,Category,Keyword) values('B0001',N'L?p trình Java',N'Ngô Trung Vi?t','L?p trình','Java')	
Insert into Books(BookID, Title,Author,Category,Keyword) values('B0002',N'L?p trình Python',N'Nguy?n Thành Th?y','L?p trình','Python')	
Insert into Books(BookID, Title,Author,Category,Keyword) values('B0003',N'Machine Learning',N'Michael William','Computer Science','Machine')	
Go
Create Table LogLibs(
	UserID char(5) foreign key references Users(UserID),
	BookID varchar(12),
	NgayDat datetime default(getDate()),
	NgayMuon datetime, NgayPtra datetime, NgayTra datetime,
	MaNV char(5) foreign key references Users(UserID),
	LogID int identity(1,1) primary key,
	check(NgayMuon>NgayDat), check(NgayTra>NgayMuon))
Go
Create procedure MuonSach
@bid varchar(12), @mbd char(5), @id int output
As
Begin
  Begin tran
	Insert into LogLibs(userID,bookid) values(@mbd,@bid)
	Set @id=@@identity
  commit tran	
End	