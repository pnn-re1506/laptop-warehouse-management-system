-- MySQL Script for Computer Inventory Management System
-- With separate import and export prices
-- English version

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database will be selected by the client (DBeaver/JDBC)
--

-- --------------------------------------------------------

--
-- Table structure for table `Account`
--

CREATE TABLE `Account` (
  `fullName` varchar(50) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Sample data for table `Account`
--

INSERT INTO `Account` (`fullName`, `userName`, `password`, `role`, `status`, `email`) VALUES
('Admin', 'admin', '$2a$12$Y87zSnx.tpFvieylSeXuo.agjb7swi3UVnoo6KVMY9xP5STj4zJhm', 'Admin', 1, 'phucnhanpht@gmail.com');


-- --------------------------------------------------------

--
-- Table structure for table `ImportDetail`
--

CREATE TABLE `ImportDetail` (
  `importId` varchar(50) NOT NULL,
  `productId` varchar(50) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `importPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ExportDetail`
--

CREATE TABLE `ExportDetail` (
  `exportId` varchar(50) NOT NULL,
  `productId` varchar(50) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `exportPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Computer`
--

CREATE TABLE `Computer` (
  `productId` varchar(50) NOT NULL,
  `productName` varchar(100) DEFAULT NULL,
  `quantity` int(11) NOT NULL DEFAULT 0,
  `cpuName` varchar(50) NOT NULL DEFAULT '0',
  `ram` varchar(50) NOT NULL DEFAULT '0',
  `graphicsCard` varchar(50) DEFAULT NULL,
  `importPrice` double NOT NULL DEFAULT 0,
  `exportPrice` double NOT NULL DEFAULT 0,
  `mainBoard` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `storage` varchar(50) DEFAULT NULL,
  `screenSize` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Table structure for table `Supplier`
--

CREATE TABLE `Supplier` (
  `supplierId` varchar(50) NOT NULL,
  `supplierName` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Sample data for table `Supplier`
--

INSERT INTO `Supplier` (`supplierId`, `supplierName`, `phone`, `address`) VALUES
('ANPHAT', 'An Phat Automation Co., Ltd', '02835109735', '86/21 Phan Tay Ho, P. 7, Phu Nhuan Dist, Ho Chi Minh City'),
('CODO', 'Co Do Trading Service Co., Ltd', '02838115345', '622/16/5 Cong Hoa, Ward 13, Tan Binh Dist, Ho Chi Minh City'),
('FPT', 'FPT Digital Retail JSC', '02873023456', '261 - 263 Khanh Hoi, Ward 2, District 4, Ho Chi Minh City');


-- --------------------------------------------------------

--
-- Table structure for table `Import`
--

CREATE TABLE `Import` (
  `importId` varchar(50) NOT NULL,
  `createdDate` timestamp NULL DEFAULT NULL,
  `createdBy` varchar(50) DEFAULT NULL,
  `supplierId` varchar(50) DEFAULT NULL,
  `totalAmount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Export`
--

CREATE TABLE `Export` (
  `exportId` varchar(50) NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `createdBy` varchar(50) NOT NULL,
  `totalAmount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Account`
--
ALTER TABLE `Account`
  ADD PRIMARY KEY (`userName`) USING BTREE;

--
-- Indexes for table `ImportDetail`
--
ALTER TABLE `ImportDetail`
  ADD PRIMARY KEY (`importId`,`productId`),
  ADD KEY `FK_ImportDetail_Computer` (`productId`);

--
-- Indexes for table `ExportDetail`
--
ALTER TABLE `ExportDetail`
  ADD PRIMARY KEY (`exportId`,`productId`),
  ADD KEY `FK_ExportDetail_Computer` (`productId`);

--
-- Indexes for table `Computer`
--
ALTER TABLE `Computer`
  ADD PRIMARY KEY (`productId`);

--
-- Indexes for table `Supplier`
--
ALTER TABLE `Supplier`
  ADD PRIMARY KEY (`supplierId`);

--
-- Indexes for table `Import`
--
ALTER TABLE `Import`
  ADD PRIMARY KEY (`importId`),
  ADD KEY `FK_Import_Supplier` (`supplierId`),
  ADD KEY `FK_Import_Account` (`createdBy`);

--
-- Indexes for table `Export`
--
ALTER TABLE `Export`
  ADD PRIMARY KEY (`exportId`),
  ADD KEY `FK_Export_Account` (`createdBy`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ImportDetail`
--
ALTER TABLE `ImportDetail`
  ADD CONSTRAINT `FK_ImportDetail_Computer` FOREIGN KEY (`productId`) REFERENCES `Computer` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ImportDetail_Import` FOREIGN KEY (`importId`) REFERENCES `Import` (`importId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ExportDetail`
--
ALTER TABLE `ExportDetail`
  ADD CONSTRAINT `FK_ExportDetail_Computer` FOREIGN KEY (`productId`) REFERENCES `Computer` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ExportDetail_Export` FOREIGN KEY (`exportId`) REFERENCES `Export` (`exportId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Import`
--
ALTER TABLE `Import`
  ADD CONSTRAINT `FK_Import_Account` FOREIGN KEY (`createdBy`) REFERENCES `Account` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Import_Supplier` FOREIGN KEY (`supplierId`) REFERENCES `Supplier` (`supplierId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Export`
--
ALTER TABLE `Export`
  ADD CONSTRAINT `FK_Export_Account` FOREIGN KEY (`createdBy`) REFERENCES `Account` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
