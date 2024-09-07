CREATE DATABASE ql_quancaphe;
GO

USE ql_quancaphe;
GO

-- Tạo bảng Khách hàng
CREATE TABLE KhachHang (
    id_kh INT IDENTITY(1,1) PRIMARY KEY,
    ten_kh NVARCHAR(255) NOT NULL,
    sodt_kh NVARCHAR(20) NOT NULL,
    ngaysinh_kh DATE,
    diachi_kh NVARCHAR(255)
);

-- Tạo bảng Nhân viên
CREATE TABLE NhanVien (
    id_nv INT IDENTITY(1,1) PRIMARY KEY,
    ten_nv NVARCHAR(255) NOT NULL,
    gioitinh_nv INT,
    sodt_nv NVARCHAR(20) NOT NULL,
    ngaybatdaulamviec_nv DATE,
    luong_nv DECIMAL(10,2) NOT NULL,
    email NVARCHAR(255) NOT NULL,
	usernv NVARCHAR(50) NOT NULL,
    passwordnv NVARCHAR(50) NOT NULL
);

-- Tạo bảng Đơn hàng
CREATE TABLE DonHang (
    id_dh INT IDENTITY(1,1) PRIMARY KEY,
    id_kh INT,
    id_nv INT,
    ngayDatHang DATETIME DEFAULT CURRENT_TIMESTAMP,
    ngayThanhToan DATETIME,
    soTienDaThanhToan DECIMAL(10,2),
    tongTien DECIMAL(10,2) NOT NULL,
    giamGia DECIMAL(10,2),
    FOREIGN KEY (id_kh) REFERENCES KhachHang(id_kh),
    FOREIGN KEY (id_nv) REFERENCES NhanVien(id_nv)
);

-- Tạo bảng Danh mục sản phẩm
CREATE TABLE DanhMucSanPham (
    id_danhmuc INT IDENTITY(1,1) PRIMARY KEY,
    ten_danhmuc NVARCHAR(50) NOT NULL
);

-- Tạo bảng Sản phẩm
CREATE TABLE SanPham (
    id_sp INT IDENTITY(1,1) PRIMARY KEY,
    ten_sp NVARCHAR(255) NOT NULL,
    id_danhmuc INT,
    gia_sp DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_danhmuc) REFERENCES DanhMucSanPham(id_danhmuc)
);

-- Tạo bảng Chi tiết đơn hàng
CREATE TABLE ChiTietDonHang (
    id_ctdh INT IDENTITY(1,1) PRIMARY KEY,
    id_dh INT,
    id_sp INT,
    soluong INT NOT NULL,
    thanhTien DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_dh) REFERENCES DonHang(id_dh),
    FOREIGN KEY (id_sp) REFERENCES SanPham(id_sp)
);

-- Tạo bảng Thanh toán
CREATE TABLE ThanhToan (
    id_tt INT IDENTITY(1,1) PRIMARY KEY,
    id_dh INT,
    ngaythanhtoan DATETIME DEFAULT CURRENT_TIMESTAMP,
    sotienthanhtoan DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_dh) REFERENCES DonHang(id_dh)
);

-- Tạo bảng Người dùng
CREATE TABLE NguoiDung (
    id_nguoidung INT IDENTITY(1,1) PRIMARY KEY,
    tendangnhap NVARCHAR(50) NOT NULL,
    matkhau NVARCHAR(50) NOT NULL,
    vaitro NVARCHAR(50) DEFAULT N'Nhân viên bán hàng' NOT NULL
);

-- Thêm dữ liệu vào bảng Khách hàng
INSERT INTO KhachHang (ten_kh, sodt_kh, ngaysinh_kh, diachi_kh)
VALUES 
(N'Nguyễn Văn A', '0912345678', '1990-01-01', N'123 Đường Lê Đại Thành, Quận 1, TP.HCM'),
(N'Trần Văn Danh','0912548721','1999-03-21',N'Số 115 Lê Trọng Tấn, Quận Tân Phú, TP.HCM'),
(N'Tống Thế Vĩ','0923656612','2000-12-21',N'Số 18 Tân Thới Nhất 17, Quận Bình Tân, TP.HCM'),
(N'Hồ Ngọc Nữ','0966363678','2001-01-31',N'Số 15 Trần Tấn, Quận Tân Phú, TP.HCM'),
(N'Trần Thị B', '0987654321', '1985-05-10', N'456 Đường Lý Thánh Tông, Quận 2, TP.HCM');

INSERT INTO NhanVien (ten_nv, gioitinh_nv, sodt_nv, ngaybatdaulamviec_nv, luong_nv, email, usernv, passwordnv)
VALUES 
(N'Nguyễn Phan Mai Lan', 1, '0966239196', '2003-04-12', 8000000, 'mailan1204@gmail.com', 'mailan', 'mailan1204'),
(N'Trần Trung Nhân', 0, '0703576846', '2002-01-21', 7500000, 'trungnhan2101@gmail.com', 'trungnhan', 'trungnhan2101'),
(N'Nguyễn Huỳnh Minh Học', 0, '0838338637', '2001-03-27', 7600000, 'minhhoc2703@gmail.com', 'minhhoc', 'minhhoc2703'),
(N'Phan Ngọc Trâm', 1, '0966393947', '2004-10-30', 7000000, 'ngoctram3010@gmail.com', 'ngoctram', 'ngoctram3010');


-- Thêm dữ liệu vào bảng Danh mục sản phẩm
INSERT INTO DanhMucSanPham (ten_danhmuc)
VALUES 
(N'Cà phê'),
(N'Sinh Tố'),
(N'Nước ép'),
(N'Trà sữa');

-- Thêm dữ liệu vào bảng Sản phẩm
INSERT INTO SanPham (ten_sp, id_danhmuc, gia_sp)
VALUES 
--cafe
(N'Cà phê đen', 1, 25000),
(N'Cà phê sữa',1,30000),
(N'Bạc xỉu',1,33000),
(N'Capuchino nóng',1,45000),
(N'Capuchino đá',1,45000),
--sinhto
(N'Sinh tố bơ',2,35000),
(N'Sinh tố mãng cầu',2,40000),
(N'Sinh tố sầu riêng',2,40000),
(N'Sinh tố cà rốt',2,35000),
(N'Sinh tố dâu',2,35000),
--nuocep
(N'Nước ép thơm',3,35000),
(N'Nước ép táo',3,35000),
(N'Nước ép xoài',3,35000),
(N'Nước ép mận',3,35000),
(N'Nước ép cà rốt',3,35000),
(N'Nước ép bưởi',3,35000),
(N'Nước ép dưa hấu',3,35000),
--trasua
(N'Trà sữa trân châu', 4, 30000),
(N'Sữa trân châu đường đen', 4, 35000),
(N'Trà mãng cầu', 4, 36000),
(N'Trà đào', 4, 30000),
(N'Trà trái cây tươi', 4, 35000),
(N'Trà sữa phô mai tươi', 4, 30000);

-- Thêm dữ liệu vào bảng Đơn hàng
INSERT INTO DonHang (id_kh, id_nv, ngayDatHang, ngayThanhToan, soTienDaThanhToan, tongTien, giamGia)
VALUES 
(1, 1, '2024-05-01 10:30:00', NULL, 0, 55000, 5000),
(2, 2, '2024-05-01 11:00:00', NULL, 0, 30000, 0),
(3, 3, '2024-05-02 12:00:00', NULL, 0, 40000, 0),
(4, 4, '2024-05-03 09:00:00', NULL, 0, 65000, 5000),
(3, 1, '2024-05-03 10:00:00', NULL, 0, 45000, 0),
(5, 2, '2024-05-03 11:00:00', NULL, 0, 80000, 10000);

-- Thêm dữ liệu vào bảng Chi tiết đơn hàng
INSERT INTO ChiTietDonHang (id_dh, id_sp, soluong, thanhTien)
VALUES 
(1, 1, 2, 50000), 
(1, 2, 1, 30000),
(2, 3, 2, 70000),
(3, 4, 1, 40000),
(4, 5, 2, 60000),
(4, 6, 1, 35000),
(5, 1, 3, 75000),
(5, 19, 2, 70000);

-- Thêm dữ liệu vào bảng Thanh toán
INSERT INTO ThanhToan (id_dh, sotienthanhtoan)
VALUES 
(1, 50000),
(2, 30000),
(3, 40000),
(4, 65000),
(5, 45000);

-- Thêm dữ liệu vào bảng Người dùng
INSERT INTO NguoiDung (tendangnhap, matkhau, vaitro)
VALUES 
(N'admin', N'admin123', N'Quản trị hệ thống');

SELECT 
    sp.ten_sp, 
    ctdh.soluong, 
    kh.id_kh, 
    tt.ngaythanhtoan, 
    ctdh.thanhTien
FROM 
    ChiTietDonHang ctdh
JOIN 
    SanPham sp ON ctdh.id_sp = sp.id_sp
JOIN 
    DonHang dh ON ctdh.id_dh = dh.id_dh
JOIN 
    ThanhToan tt ON dh.id_dh = tt.id_dh
JOIN 
    KhachHang kh ON dh.id_kh = kh.id_kh;

SELECT *FROM KhachHang
SELECT *FROM NhanVien
SELECT *FROM DonHang
SELECT *FROM DanhMucSanPham
SELECT *FROM SanPham
SELECT *FROM ChiTietDonHang
SELECT *FROM ThanhToan
SELECT *FROM NguoiDung
