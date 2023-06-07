-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 15, 2021 lúc 08:30 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ql_covid`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dang_nhap`
--

CREATE TABLE `dang_nhap` (
  `username` varchar(40) NOT NULL,
  `password` varchar(50) NOT NULL,
  `QLNhanKhau` char(1) NOT NULL,
  `QLKhaiBao` char(1) NOT NULL,
  `QLSucKhoe` char(1) NOT NULL,
  `QLTestCovid` char(1) NOT NULL,
  `QLTiemVaccine` char(1) NOT NULL,
  `QLCachly` char(1) NOT NULL,
  `ThongKeCovid` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `dang_nhap`
--

INSERT INTO `dang_nhap` (`username`, `password`, `QLNhanKhau`, `QLKhaiBao`, `QLSucKhoe`, `QLTestCovid`, `QLTiemVaccine`, `QLCachly`, `ThongKeCovid`) VALUES
('lam', '123', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y'),
('viet', '321', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ql_cach_ly`
--

CREATE TABLE `ql_cach_ly` (
  `HoTen` varchar(255) NOT NULL,
  `Id` varchar(255) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `MucDoCachLy` varchar(20) NOT NULL,
  `DiaChiCachLy` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ql_cach_ly`
--

INSERT INTO `ql_cach_ly` (`HoTen`, `Id`, `NgayBatDau`, `MucDoCachLy`, `DiaChiCachLy`) VALUES
('Đức Lâm', '000', '2010-02-05', 'F2', 'www'),
('Đức Lâm', '000', '2222-02-02', 'F1', 'Hanoi'),
('Đức Lâm', '000', '2222-02-03', 'F3', 'kaa'),
('Đức Lâm', '000', '2222-02-09', 'F3', 'Ha Noi'),
('Đức Việt', '111', '2021-02-07', 'F1', 'Hoang Mai'),
('Viet Do', '333', '2020-01-02', 'F2', 'Hanoiiiii'),
('Viet Do', '333', '2021-01-22', 'F2', 'Namms');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ql_khai_bao`
--

CREATE TABLE `ql_khai_bao` (
  `MaKhaiBao` int(11) NOT NULL,
  `HoTen` varchar(255) NOT NULL,
  `Id` varchar(255) NOT NULL,
  `TiepXucVoiNguoiBenh` varchar(255) NOT NULL,
  `DiVeTuVungDich` varchar(255) NOT NULL,
  `TiepXucVoiNguoiTuVungDich` varchar(255) NOT NULL,
  `NgayKhaiBao` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ql_khai_bao`
--

INSERT INTO `ql_khai_bao` (`MaKhaiBao`, `HoTen`, `Id`, `TiepXucVoiNguoiBenh`, `DiVeTuVungDich`, `TiepXucVoiNguoiTuVungDich`, `NgayKhaiBao`) VALUES
(2, 'Đức Việt', '111', 'Có', 'Có', 'Có', '2021-02-02'),
(4, 'Viet Do', '333', 'Có', 'Không', 'Có', '2020-02-02'),
(6, 'Đức Lâm', '000', 'Không', 'Không', 'Không', '2022-02-02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ql_nhan_khau`
--

CREATE TABLE `ql_nhan_khau` (
  `HoTen` varchar(255) NOT NULL,
  `Id` varchar(255) NOT NULL,
  `GioiTinh` varchar(255) NOT NULL,
  `NgaySinh` date NOT NULL,
  `SoDienThoai` varchar(255) DEFAULT NULL,
  `SoTheBHYT` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `QuocTich` varchar(255) NOT NULL,
  `ThuongTruTamTru` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ql_nhan_khau`
--

INSERT INTO `ql_nhan_khau` (`HoTen`, `Id`, `GioiTinh`, `NgaySinh`, `SoDienThoai`, `SoTheBHYT`, `Email`, `QuocTich`, `ThuongTruTamTru`) VALUES
('ABC', '2222', 'Nữ', '2001-02-02', '', 'SV333', 'sss2@as', 'VN', 'HaiPhong'),
('Viet Do', '333', 'Khác', '2020-03-02', '33333', 'SV221', 'vietdu@gmail', 'VN', 'QN'),
('XYZ', '444', 'Nam', '2010-02-02', '', 'SV221', '', 'VN', 'Hanoi'),
('Đức Lâm', '000', 'Nam', '2001-02-08', '0020222222', 'SV111', 'aa@bb', 'VN', 'Mê Linh, Hà Nội'),
('Đức Việt', '111', 'Nữ', '2001-04-30', '099292', 'SV222', 'ducviet@gmail', 'VN', 'Hoàng Mai');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ql_suc_khoe`
--

CREATE TABLE `ql_suc_khoe` (
  `MaKhaiBao` int(11) NOT NULL,
  `HoTen` varchar(255) NOT NULL,
  `Id` varchar(255) NOT NULL,
  `Ho` varchar(32) NOT NULL,
  `Sot` varchar(32) NOT NULL,
  `KhoTho` varchar(32) NOT NULL,
  `DauNguoi` varchar(32) NOT NULL,
  `MatViGiac` varchar(32) NOT NULL,
  `BuonNon` varchar(32) NOT NULL,
  `TrieuChungKhac` varchar(1024) DEFAULT NULL,
  `NgayXuatHien` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ql_suc_khoe`
--

INSERT INTO `ql_suc_khoe` (`MaKhaiBao`, `HoTen`, `Id`, `Ho`, `Sot`, `KhoTho`, `DauNguoi`, `MatViGiac`, `BuonNon`, `TrieuChungKhac`, `NgayXuatHien`) VALUES
(4, 'Đức Việt', '111', 'Có', 'Có', 'Có', 'Có', 'Có', 'Có', 'ABX', '2020-01-01'),
(6, 'Đức Lâm', '000', 'Không', 'Không', 'Không', 'Không', 'Không', 'Không', '', '2020-02-02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ql_test_covid`
--

CREATE TABLE `ql_test_covid` (
  `HoTen` varchar(255) NOT NULL,
  `Id` varchar(255) NOT NULL,
  `MaCode` varchar(255) NOT NULL,
  `KetQua` varchar(255) NOT NULL,
  `LoaiTest` varchar(255) NOT NULL,
  `NgayTest` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ql_test_covid`
--

INSERT INTO `ql_test_covid` (`HoTen`, `Id`, `MaCode`, `KetQua`, `LoaiTest`, `NgayTest`) VALUES
('Viet Do', '333', '2', 'Dương tính', 'PCR', '2222-02-02'),
('Viet Do', '333', '2222', 'Dương tính', 'Test nhanh', '2222-02-02'),
('Viet Do', '333', '2w', 'Âm tính', 'PCR', '2222-02-02'),
('Đức Việt', '111', 'idiot', 'Dương tính', 'PCR', '2021-02-02'),
('Đức Lâm', '000', 'm1', 'Âm tính', 'PCR', '2020-01-01'),
('Đức Việt', '111', 'q2', 'Âm tính', 'Test nhanh', '2222-02-02'),
('Đức Lâm', '000', 't1', 'Dương tính', 'PCR', '2022-02-02'),
('Đức Việt', '111', 't12', 'Âm tính', 'PCR', '2222-02-02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ql_tiem_vaccine`
--

CREATE TABLE `ql_tiem_vaccine` (
  `HoTen` varchar(255) NOT NULL,
  `Id` varchar(255) NOT NULL,
  `LanTiem` int(11) NOT NULL,
  `LoaiVaccine` varchar(255) NOT NULL,
  `LoVaccine` varchar(255) DEFAULT NULL,
  `NgayTiem` date NOT NULL DEFAULT current_timestamp(),
  `DonViTiemChung` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ql_tiem_vaccine`
--

INSERT INTO `ql_tiem_vaccine` (`HoTen`, `Id`, `LanTiem`, `LoaiVaccine`, `LoVaccine`, `NgayTiem`, `DonViTiemChung`) VALUES
('Đức Lâm', '000', 1, 'AstraZeneca', '', '2021-02-03', 'MeLinh'),
('Đức Việt', '111', 1, 'Sputnik V', '', '2020-03-02', 'Hanoi'),
('Viet Do', '333', 1, 'Moderna', 'a', '2020-02-02', '1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dang_nhap`
--
ALTER TABLE `dang_nhap`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `ql_cach_ly`
--
ALTER TABLE `ql_cach_ly`
  ADD PRIMARY KEY (`Id`,`NgayBatDau`),
  ADD KEY `FK_cach_ly` (`Id`,`HoTen`) USING BTREE;

--
-- Chỉ mục cho bảng `ql_khai_bao`
--
ALTER TABLE `ql_khai_bao`
  ADD PRIMARY KEY (`MaKhaiBao`),
  ADD KEY `FK_khai_bao` (`Id`,`HoTen`);

--
-- Chỉ mục cho bảng `ql_nhan_khau`
--
ALTER TABLE `ql_nhan_khau`
  ADD PRIMARY KEY (`HoTen`,`Id`),
  ADD UNIQUE KEY `PrimaryKey` (`Id`);

--
-- Chỉ mục cho bảng `ql_suc_khoe`
--
ALTER TABLE `ql_suc_khoe`
  ADD PRIMARY KEY (`MaKhaiBao`),
  ADD KEY `FK_suc_khoe` (`Id`,`HoTen`);

--
-- Chỉ mục cho bảng `ql_test_covid`
--
ALTER TABLE `ql_test_covid`
  ADD PRIMARY KEY (`MaCode`),
  ADD KEY `FK_test_covid` (`Id`,`HoTen`);

--
-- Chỉ mục cho bảng `ql_tiem_vaccine`
--
ALTER TABLE `ql_tiem_vaccine`
  ADD PRIMARY KEY (`Id`,`LanTiem`),
  ADD KEY `FK_tiem_vaccine` (`Id`,`HoTen`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ql_khai_bao`
--
ALTER TABLE `ql_khai_bao`
  MODIFY `MaKhaiBao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `ql_suc_khoe`
--
ALTER TABLE `ql_suc_khoe`
  MODIFY `MaKhaiBao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ql_cach_ly`
--
ALTER TABLE `ql_cach_ly`
  ADD CONSTRAINT `FK_cach_ly` FOREIGN KEY (`Id`,`HoTen`) REFERENCES `ql_nhan_khau` (`Id`, `HoTen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ql_khai_bao`
--
ALTER TABLE `ql_khai_bao`
  ADD CONSTRAINT `FK_khai_bao` FOREIGN KEY (`Id`,`HoTen`) REFERENCES `ql_nhan_khau` (`Id`, `HoTen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ql_suc_khoe`
--
ALTER TABLE `ql_suc_khoe`
  ADD CONSTRAINT `FK_suc_khoe` FOREIGN KEY (`Id`,`HoTen`) REFERENCES `ql_nhan_khau` (`Id`, `HoTen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ql_test_covid`
--
ALTER TABLE `ql_test_covid`
  ADD CONSTRAINT `FK_test_covid` FOREIGN KEY (`Id`,`HoTen`) REFERENCES `ql_nhan_khau` (`Id`, `HoTen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ql_tiem_vaccine`
--
ALTER TABLE `ql_tiem_vaccine`
  ADD CONSTRAINT `FK_tiem_vaccine` FOREIGN KEY (`Id`,`HoTen`) REFERENCES `ql_nhan_khau` (`Id`, `HoTen`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
