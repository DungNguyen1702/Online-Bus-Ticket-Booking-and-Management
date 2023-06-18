CREATE DATABASE PBL3
GO

USE PBL3
GO

create table City(
	CityID nvarchar(30),
	ParkingName nvarchar(100),
	CityName nvarchar(21),
	ParkingAddress nvarchar(100),
	CONSTRAINT PK_City Primary key (CityID)
)
GO

create table RouteWay(
	RouteID INT IDENTITY(1,1),
	CityIDStart nvarchar(30),
	CityIDEnd nvarchar(30),
	Distance nvarchar(30),
	Duration Time,
	BusID nvarchar(20),
	BasePrice nvarchar(20),
	CONSTRAINT PK_RouteWay Primary key (RouteID)
)
GO

create table TripInDay(
	TripID INT IDENTITY(1,1),
	TimeStart Time,
	TimeEnd time,
	RouteID int,
	DateStart date,
	DateEnd date,
	CONSTRAINT PK_Trip Primary key (TripID)
)
GO

create table Ticket(
	TicketID int IDENTITY(1,1),	
	BillID INT,
	SeatNumber nvarchar(20),
	KindOfTicket nvarchar(20),
	Price nvarchar(20),
	TripID INT,
	CONSTRAINT PK_Ticket Primary key (TicketID)
)
GO

create table InfoCustomer(
	InfoID INT IDENTITY(1,1),
	RealName nvarchar(100),
	PhoneNumber varchar(10),
	HomeAddress nvarchar(30),
	Email nvarchar(30),
	CONSTRAINT PK_Info Primary key (InfoID)
)

create table Customer(
	CustomerID INT IDENTITY(1,1),
	UserName nvarchar(20),
	UserPassWord nvarchar(20),
	RealName nvarchar(100),
	CitizenID nvarchar(12),
	DateOfBirth Date,
	PhoneNumber varchar(10),
	Email nvarchar(30),
	Sex nvarchar(10),
	CONSTRAINT PK_Customer Primary key (CustomerID)
)

create table Bill(
	BillID INT IDENTITY(1,1),
	CustomerID INT,
	PaymentMethod nvarchar(20),
	Status1 nvarchar(20),
	KindOfBook nvarchar(20),
	BookDate DATE,
	InfoID INT,
	TotalPrice nvarchar(20),
	CONSTRAINT PK_Bill Primary key (BillID)
)
GO

create table Bus(
	BusID nvarchar(20),
	NumberOfSeat INT,
	KindOfBus nvarchar(30),
	CONSTRAINT PK_Bus Primary key (BusID)
)
GO

-- tao FOREIGN KEY 

ALTER TABLE Bill
	ADD CONSTRAINT FK_CustomerID FOREIGN KEY ( CustomerID ) REFERENCES Customer ( CustomerID )
		ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE Bill
	ADD CONSTRAINT FK_InfoID FOREIGN KEY ( InfoID ) REFERENCES InfoCustomer ( InfoID )
		ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE Ticket
	ADD CONSTRAINT FK_BillID FOREIGN KEY ( BillID ) REFERENCES Bill ( BillID ) 
	ON DELETE CASCADE ON UPDATE CASCADE	
GO

ALTER TABLE Ticket
	ADD CONSTRAINT FK_TripID FOREIGN KEY (TripID) REFERENCES TripInDay ( TripID )
	ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE TripInDay
	ADD CONSTRAINT FK_RouteID FOREIGN KEY ( RouteID ) REFERENCES Routeway ( RouteID ) 
	ON DELETE CASCADE ON UPDATE CASCADE	
GO

ALTER TABLE RouteWay
	ADD CONSTRAINT FK_CityIDStart FOREIGN KEY ( CityIDStart ) REFERENCES City ( CityID ) 
	ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE RouteWay
	ADD CONSTRAINT FK_CityIDEnd FOREIGN KEY ( CityIDEnd ) REFERENCES City ( CityID) 
GO

ALTER TABLE RouteWay
	ADD CONSTRAINT FK_BusID FOREIGN KEY ( BusID ) REFERENCES Bus ( BusID) 
	ON DELETE CASCADE ON UPDATE CASCADE
GO
