use PBL3
go

-- Insert Customer
insert into dbo.Customer (UserName, UserPassWord, RealName, CitizenID, DateOfBirth, PhoneNumber, Email, Sex )
values
	('dung1702', 'dung123', N'Nguyễn Văn Dũng', '192143444', '2003-02-17' , '0905116391', 'vandung17022003@gmal.com',N'Nam'),
	('tin', '123', N'Phạm Duy Tin', '192143444', '2003-08-04' , '0965582649', 'phamtin4822003@gmal.com',N'Nam'),
	('hung123', 'hung123', N'Ngô Hồ Minh Hưng', '192143444', '2003-08-04' , '0965582649', 'hungngocute123@gmal.com',N'Nam')
GO

-- Insert Bus
insert into dbo.bus
values
	('bus001',17,N'1 tầng'),
	('bus002',34,N'2 tầng'),
	('bus003',20,N'Giường nằm')
GO

-- Insert City
insert into dbo.City
values
('City001',N'Bến xe Châu Đốc',					N'An Giang',				N'QL91, Vĩnh Mỹ, Châu Đốc, Châu Phú B'),
('City002',N'Bến Xe Khách Vũng Tàu',			N'Bà Rịa - Vũng Tàu',		N'Nam Kỳ Khởi Nghĩa, Phường Thắng Tam, Vũng Tàu, Bà Rịa - Vũng Tàu'),
('City003',N'Bến xe Bạc Liêu',					N'Bạc Liêu',				N'522 Trần Phú, Phường 7, Bạc Liêu'),
('City004',N'Bến Xe Khách Bắc Ninh',			N'Bắc Ninh',				N'53J6+8QV, ĐT295B, P.Tiền An, Bắc Ninh'),
('City005',N'Tô Châu Bến Tre',					N'Bến Tre',					N'1B2 Đoàn Hoàng Minh, P. Phú Khương, Bến Tre'),
('City006',N'Bến xe Bến Cát',					N'Bình Dương',				N'12 H6, Thới Hoà, Bến Cát, Bình Dương'),
('City007',N'Bến xe khách Quy Nhơn',			N'Bình Định',				N'Võ Liệu, Ghềnh Ráng, Quy Nhơn, Bình Định'),
('City008',N'Bến Xe Bắc Phan Thiết',			N'Bình Thuận',				N'1 Từ Văn Tư, Phú Trinh, Hàm Thuận Bắc, Bình Thuận'),
('City009',N'Bến Xe Khách Cà Mau',				N'Cà Mau',					N'Phường 6, Tp. Cà Mau, Cà Mau'),
('City010',N'Bến Xe Khách Cần Thơ',				N'Cần Thơ',					N'36 Đ. Nguyễn Văn Linh, Khu dân cư 91B, Ninh Kiều, Cần Thơ'),
('City011',N'Bến Xe Trung Tâm TP Đà Nẵng',		N'Đà Nẵng',					N'97 Cao Sơn Pháo, Hoà Minh, Cẩm Lệ, Đà Nẵng'),
('City012',N'Bến xe Phía bắc Tp.Buôn Ma Thuột',	N'Đắk Lắk',					N'71 Nguyễn Chí Thanh, Tân An, Thành phố Buôn Ma Thuột, Đắk Lắk'),
('City013',N'Bến Xe Gia Nghĩa Đăk Nông',		N'Đắk Nông',				N'XMG2+Q6Q, Phường Nghĩa Phú, Gia Nghĩa, Đắk Nông'),
('City014',N'Bến xe Cao Lãnh',					N'Đồng Tháp',				N'1 Lý Thường Kiệt, Phường 2, TP. Cao Lãnh, Đồng Tháp'),
('City015',N'Bến xe Đồng Nai',					N'Đồng Nai',				N'Bình Đa, Tp. Biên Hòa, Đồng Nai'),
('City016',N'Bến Xe Đức Long Gia Lai',			N'Gia Lai',					N'43 Lý Nam Đế, P.Trà Bá, Thành phố Pleiku, Gia Lai'),
('City017',N'Bến Xe Giáp Bát',					N'Hà Nội',					N'Km6 Giải Phóng, Hoàng Mai,  Hà Nội'),
('City018',N'Bến Xe Hà Tĩnh',					N'Hà Nội',					N'13 Võ Liêm Sơn, Bắc Hà, Tp. Hà Tĩnh, Hà Tĩnh'),
('City019',N'Bến Xe Khách Hải Dương',			N'Hải Dương',				N'1 Hồng Quang, P. Bình Hàn, Hải Dương'),
('City020',N'Bến xe khách Vĩnh Niệm',			N'Hải Phòng',				N'Vĩnh Niệm, Lê Chân, Hải Phòng'),
('City021',N'Bến xe Vị Thanh',					N'Hậu Giang',				N'QL61C, ĐIỂM 6, Vị Thuỷ, Hậu Giang'),
('City022',N'Bến Xe An Sương',					N'Thành phố Hồ Chí Minh',	N'QL22, Bà Điểm, Hóc Môn, Thành phố Hồ Chí Minh'),
('City023',N'Bến xe Ninh Hòa',					N'Khánh Hòa',				N'Đường Lê Duẩn, Cam Lộc, Tp. Cam Ranh, Khánh Hòa'),
('City024',N'Bến xe Hà Tiên',					N'Kiên Giang',				N'Hẻm 51, Tô Châu, Hà Tiên, Kiên Giang'),
('City025',N'Bến xe Đà Lạt',					N'Lâm Đồng',				N'1 Đường Tô Hiến Thành, Phường 3, Thành phố Đà Lạt, Lâm Đồng'),
('City026',N'Bến Xe Long An Quốc Lộ 1A',		N'Long An',					N' Phường 2, Tp. Tân An, Long An'),
('City027',N'Bến xe Nam Định',					N'Nam Định',				N'Lộc Hoà, Tp. Nam Định, Nam Định'),
('City028',N'Bến xe Bắc Vinh',					N'Nghệ An',					N'Thăng Long, Nghi Kim, Thành phố Vinh, Nghệ An'),
('City029',N'Bến Xe Tỉnh Ninh Thuận',			N'Ninh Thuận',				N'52 QL1A, Đài Sơn, Phan Rang-Tháp Chàm, Ninh Thuận'),
('City030',N'Bến xe liên tỉnh Phú Yên',			N'Phú Yên',					N'227 Nguyễn Tất Thành, Phường 8, Tuy Hòa, Phú Yên'),
('City031',N'Bến xe khách Quảng Nam',			N'Quảng Nam',				N'QL1A, Phường Tân Thạnh, Tp. Tam Kỳ, Quảng Nam'),
('City032',N'Bến xe Quảng Ngãi',				N'Quảng Ngãi',				N'Nghĩa Chánh Nam, Tp. Quảng Ngãi, Quảng Ngãi'),
('City033',N'Bến Xe Khách Móng Cái',			N'Quảng Ninh',				N'Đường Hùng Vương - Phường Ka Long, Móng Cái,Quảng Ninh '),
('City034',N'Bến Xe Khách Đông Hà',				N'Quảng Trị',				N'425 Lê Duẩn, Đông Lễ, Đông Hà, Quảng Trị'),
('City035',N'Bến xe Sóc Trăng',					N'Sóc Trăng',				N'Lê Văn Tám, Phường 3, Tp. Sóc Trăng, Sóc Trăng'),
('City036',N'Bến Xe Khách-Tân Biên',			N'Tây Ninh',				N'GXXX+QWC, QL22B, Tân Biên, Tây Ninh'),
('City037',N'Bến Xe Phía Bắc Thanh Hóa',		N'Thanh Hoá',				N'1a Nguyễn Chí Thanh, P. Nam Ngạn, Thành phố Thanh Hóa, Thanh Hoá'),
('City038',N'Bến Xe Phía Nam',					N'Thừa Thiên Huế',			N'97 An Dương Vương, An Đông, Thành phố Huế, Thừa Thiên Huế'),
('City039',N'Bến Xe Khách Trà Vinh',			N'Trà Vinh',				N'559 QL54, Phường 9, Trà Vinh')
GO

-- Insert RouteWay
insert into dbo.RouteWay (CityIDStart, CityIDEnd, Distance, Duration, BusID, BasePrice)
values
('City001','City009','231','07:00:00','bus002','200000'),
('City001','City010','125','03:00:00','bus003','120000'),
('City001','City022','237','06:00:00','bus001','210000'),

('City002','City010','254','06:00:00','bus002','285000'),
('City002','City022','110','03:00:00','bus001','130000'),

('City003','City022','125','07:00:00','bus003','190000'),

('City004','City017','40','01:00:00','bus001','50000'),

('City005','City022','86','03:00:00','bus002','120000'),

('City006','City009','335','09:00:00','bus003','300000'),
('City006','City024','350','09:00:00','bus001','300000'),
('City006','City035','260','07:00:00','bus002','300000'),

('City007','City022','705','14:00:00','bus001','280000'),
('City007','City030','94','02:00:00','bus002','100000'),

('City008','City022','220','05:00:00','bus003','160000'),

('City009','City001','295','07:00:00','bus001','200000'),
('City009','City006','370','09:00:00','bus001','300000'),
('City009','City010','170','04:00:00','bus002','160000'),
('City009','City022','297','07:00:00','bus003','230000'),

('City010','City001','123','03:00:00','bus001','120000'),
('City010','City002','254','06:00:00','bus003','285000'),
('City010','City009','170','04:00:00','bus002','160000'),
('City010','City022','160','04:00:00','bus003','165000'),
('City010','City024','125','03:00:00','bus002','145000'),
('City010','City025','464','11:00:00','bus001','430000'),
('City010','City039','79','02:00:00','bus001','80000'),

('City011','City007','500','11:00:00','bus002','270000'),
('City011','City013','756','15:00:00','bus003','320000'),
('City011','City022','980','20:00:00','bus001','395000'),
('City011','City023','610','10:00:00','bus001','290000'),
('City011','City025','850','16:00:00','bus002','360000'),
('City011','City031','150','02:00:00','bus002','110000'),

('City012','City022','325','08:00:00','bus003','255000'),

('City013','City011','678','15:00:00','bus001','320000'),

('City014','City022','150','03:00:00','bus002','130000'),

('City015','City002','90','02:00:00','bus002','80000'),
('City015','City008','160','04:00:00','bus001','150000'),
('City015','City022','40','01:00:00','bus003','50000'),

('City016','City022','40','01:00:00','bus002','50000'),


('City017','City011','745','18:00:00','bus001','400000'),
('City017','City019','76','01:00:00','bus002','100000'),
('City017','City027','78','02:00:00','bus003','100000'),

('City018','City034','247','05:00:00','bus003','240000'),
('City018','City037','193','04:00:00','bus001','200000'),

('City019','City017','80','01:00:00','bus002','80000'),
('City019','City020','50','01:00:00','bus002','40000'),

('City020','City027','90','02:00:00','bus001','100000'),
('City020','City033','191','03:00:00','bus002','200000'),

('City021','City022','220','05:00:00','bus003','275000'),

('City022','City002','122','03:00:00','bus001','180000'),
('City022','City003','280','07:00:00','bus002','190000'),
('City022','City007','710','14:00:00','bus002','280000'),
('City022','City008','220','05:00:00','bus003','160000'),
('City022','City009','347','08:00:00','bus001','230000'),
('City022','City010','160','08:00:00','bus002','230000'),
('City022','City012','345','08:00:00','bus001','255000'),
('City022','City023','443','09:00:00','bus003','275000'),
('City022','City025','305','08:00:00','bus002','300000'),
('City022','City029','346','07:00:00','bus001','190000'),
('City022','City031','990','20:00:00','bus002','395000'),
('City022','City038','1050','22:00:00','bus001','400000'),
('City022','City036','144','03:00:00','bus002','125000'),

('City023','City011','550','10:00:00','bus003','270000'),
('City023','City025','140','04:00:00','bus003','165000'),
('City023','City022','443','09:00:00','bus002','275000'),

('City024','City010','125','03:00:00','bus003','145000'),
('City024','City022','235','05:00:00','bus002','190000'),
('City024','City006','300','08:00:00','bus001','250000'),

('City025','City010','464','11:00:00','bus002','430000'),
('City025','City011','700','14:00:00','bus003','340000'),
('City025','City022','305','08:00:00','bus001','305000'),
('City025','City023','140','04:00:00','bus001','165000'),
('City025','City038','900','18:00:00','bus002','410000'),

('City026','City003','218','05:00:00','bus002','170000'),

('City027','City017','90','02:00:00','bus003','100000'),

('City028','City004','318','06:00:00','bus002','500000'),


('City029','City022','346','7:00:00','bus001','190000'),

('City030','City022','590','11:00:00','bus002','255000'),

('City031','City013','630','13:00:00','bus003','480000'),

('City032','City014','507','11:00:00','bus001','330000'),
('City032','City022','850','17:00:00','bus002','330000'),

('City033','City020','187','03:00:00','bus003','125000'),

('City034','City038','72','02:00:00','bus002','100000'),

('City035','City006','260','06:00:00','bus001','215000'),
('City035','City022','230','05:00:00','bus002','175000'),
('City035','City021','230','02:00:00','bus003','175000'),

('City036','City022','125','02:00:00','bus001','110000'),
('City036','City026','143','03:00:00','bus002','130000'),

('City037','City018','193','4:00:00','bus002','150000'),

('City038','City016','457','09:00:00','bus003','300000'),
('City038','City022','1050','18:00:00','bus001','400000'),
('City038','City025','1050','18:00:00','bus002','410000'),
('City038','City028','372','07:00:00','bus003','250000'),

('City039','City022','135','4:00:00','bus001','130000'),

('City039','City005','50','01:00:00','bus002','50000'),
('City039','City015','163','04:00:00','bus002','150000')

---------------------- 4 cái dưới Tất cả đều không cần Insert ID vào vì ID tự tăng, IDTrip sẽ bắt đầu từ số 1 nên phần Ticket có thể chọn số 1
---------------------- phần NumberSeat trong ticket thì bắt đầu bằng chữ G01, G02, ...............

-- Insert Customer

-- Insert Info 

-- Insert Bill

-- Insert Ticket

