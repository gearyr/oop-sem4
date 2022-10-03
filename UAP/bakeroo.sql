-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2022 at 02:57 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bakeroo`
--

-- --------------------------------------------------------

--
-- Table structure for table `cup_cake`
--

CREATE TABLE `cup_cake` (
  `PastryID` varchar(5) NOT NULL,
  `PastryName` varchar(50) NOT NULL,
  `PastryType` varchar(20) NOT NULL,
  `PastryPrice` int(11) NOT NULL,
  `ToppingName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cup_cake`
--

INSERT INTO `cup_cake` (`PastryID`, `PastryName`, `PastryType`, `PastryPrice`, `ToppingName`) VALUES
('CC001', 'Cotton Candy Pudding', 'Cup Cake', 25000, 'Cotton Candy'),
('CC002', 'Chocolate Selfcare Bear', 'Cup Cake', 35000, 'Bear Frosting'),
('CC003', 'Orange Fruit Dove', 'Cup Cake', 30000, 'Orange Blossom'),
('CC004', 'Paku Paku Green Bean', 'Cup Cake', 28000, 'Red Bean Paste'),
('CC005', 'Dia Tropical', 'Cup Cake', 50000, 'Mango Sorbe');

-- --------------------------------------------------------

--
-- Table structure for table `roll_cake`
--

CREATE TABLE `roll_cake` (
  `PastryID` varchar(5) NOT NULL,
  `PastryName` varchar(50) NOT NULL,
  `PastryType` varchar(20) NOT NULL,
  `PastryPrice` int(11) NOT NULL,
  `FillingName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roll_cake`
--

INSERT INTO `roll_cake` (`PastryID`, `PastryName`, `PastryType`, `PastryPrice`, `FillingName`) VALUES
('RC001', 'Peanut Butter Coal', 'Roll Cake', 65000, 'Butter Cognac'),
('RC002', 'Berry Pinwheel', 'Roll Cake', 55000, 'Strawberry Pie'),
('RC003', 'Mocha Yule Log', 'Roll Cake', 80000, 'Mocha Marzipan'),
('RC004', 'Twirl Roly Poly', 'Roll Cake', 35000, 'Cinnamon Twirl'),
('RC005', 'Budapest Roll', 'Roll Cake', 100000, 'Hazelnut Meringue');

-- --------------------------------------------------------

--
-- Table structure for table `transacttion`
--

CREATE TABLE `transaction` (
  `TransactionID` varchar(6) NOT NULL,
  `PastryID` varchar(5) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cup_cake`
--
ALTER TABLE `cup_cake`
  ADD PRIMARY KEY (`PastryID`);

--
-- Indexes for table `roll_cake`
--
ALTER TABLE `roll_cake`
  ADD PRIMARY KEY (`PastryID`);

--
-- Indexes for table `transacttion`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`TransactionID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
