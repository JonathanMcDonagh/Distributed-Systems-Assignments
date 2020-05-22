-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 18, 2020 at 01:02 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test_create_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
CREATE TABLE IF NOT EXISTS `data` (
  `ppsn` varchar(10) NOT NULL,
  `fname` varchar(65) NOT NULL,
  `lname` varchar(65) NOT NULL,
  `email` varchar(65) NOT NULL,
  `dob` varchar(8) NOT NULL,
  `address` varchar(65) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `salary` varchar(6) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`ppsn`, `fname`, `lname`, `email`, `dob`, `address`, `gender`, `salary`) VALUES
('1122343A', 'Jonathan', 'McDonagh', 'jonathan@gmail.com', '20/04/98', 'Railway Square, Waterford', 'Male', '40000'),
('2233454B', 'Lauren', 'Scally', 'Lauren@gmail.com', '04/05/97', 'Railway Square, Waterford', 'Female', '40000'),
('3344565C', 'Joe', 'Bloggs', 'Joe@gmail.com', '01/01/01', 'Waterford City', 'Male', '100000');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
