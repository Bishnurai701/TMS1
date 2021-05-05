-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3309
-- Generation Time: Jul 04, 2020 at 10:47 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tms`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_address`
--

CREATE TABLE `tbl_address` (
  `Address_id` int(10) NOT NULL,
  `AddressType_id` int(10) DEFAULT NULL,
  `Address_MunicipalityName` varchar(225) DEFAULT NULL,
  `Municipality_id` int(10) DEFAULT NULL,
  `StreetName` varchar(225) DEFAULT NULL,
  `WardNo` int(100) DEFAULT NULL,
  `Country_id` int(10) DEFAULT NULL,
  `State_id` int(10) DEFAULT NULL,
  `District_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `CityName` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_address`
--

INSERT INTO `tbl_address` (`Address_id`, `AddressType_id`, `Address_MunicipalityName`, `Municipality_id`, `StreetName`, `WardNo`, `Country_id`, `State_id`, `District_id`, `Registration_id`, `CityName`) VALUES
(1, 1, 'Mapya Dudhkoshi', 1, 'Khali', 2, 1, 1, 1, 9, 'Sallery'),
(12, 2, 'Kathmandu', 4, 'Kapan', 10, 1, 3, 8, 9, 'Kathmandu'),
(13, 1, 'Mapya Dudhkoshi', 1, 'Khali Danda', 2, 1, 1, 1, 10, 'Sallery'),
(14, 2, 'Kathmandu', 4, 'Kapan Chowk', 10, 1, 3, 8, 10, 'Kathmandu'),
(15, 1, 'Mapya Dudhkoshi', 1, 'Kapan', 11, 1, 1, 1, 15, 'Kathmandu');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_addresstype`
--

CREATE TABLE `tbl_addresstype` (
  `AddressType_id` int(10) NOT NULL,
  `AddressTypeName` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_addresstype`
--

INSERT INTO `tbl_addresstype` (`AddressType_id`, `AddressTypeName`) VALUES
(1, 'Permanent Address'),
(2, 'Temporary Address');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_attendance`
--

CREATE TABLE `tbl_attendance` (
  `Attendance_id` int(10) NOT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `AttendDate` datetime DEFAULT NULL,
  `Check_IN` time DEFAULT NULL,
  `Check_OUT` time DEFAULT NULL,
  `TotalPresentDate` datetime DEFAULT NULL,
  `TotalAbsentDate` datetime DEFAULT NULL,
  `User_id` int(10) DEFAULT NULL,
  `Comment` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_attendance`
--

INSERT INTO `tbl_attendance` (`Attendance_id`, `Registration_id`, `AttendDate`, `Check_IN`, `Check_OUT`, `TotalPresentDate`, `TotalAbsentDate`, `User_id`, `Comment`) VALUES
(1, 9, '2020-07-07 00:00:00', '10:00:00', '04:00:00', '2020-07-07 00:00:00', '2020-07-07 00:00:00', NULL, 'ok');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_board`
--

CREATE TABLE `tbl_board` (
  `Board_id` int(10) NOT NULL,
  `BoardName` varchar(225) DEFAULT NULL,
  `School_id` int(10) DEFAULT NULL,
  `HighSchool` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_board`
--

INSERT INTO `tbl_board` (`Board_id`, `BoardName`, `School_id`, `HighSchool`, `Registration_id`) VALUES
(1, 'SEE Board', NULL, NULL, NULL),
(3, 'HSEB Board', NULL, NULL, NULL),
(4, 'SLC Board', NULL, NULL, NULL),
(5, 'HMG Board', NULL, NULL, NULL),
(6, 'Not Applicable', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_contact`
--

CREATE TABLE `tbl_contact` (
  `Contact_id` int(10) NOT NULL,
  `Email` varchar(225) DEFAULT NULL,
  `MobileNo` varchar(100) DEFAULT NULL,
  `LandLine` varchar(100) DEFAULT NULL,
  `Person_id` int(10) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_contact`
--

INSERT INTO `tbl_contact` (`Contact_id`, `Email`, `MobileNo`, `LandLine`, `Person_id`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Registration_id`) VALUES
(1, 'rajvison@gmail.com', '9869162217', '9988888', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'rajvison@gmail.com', '9869162217', '99888880', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'rajvison@gmail.com', '9869162217', '9', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_country`
--

CREATE TABLE `tbl_country` (
  `Country_id` int(10) NOT NULL,
  `CountryName` varchar(225) DEFAULT NULL,
  `CountryCode` int(12) DEFAULT NULL,
  `CreatedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_country`
--

INSERT INTO `tbl_country` (`Country_id`, `CountryName`, `CountryCode`, `CreatedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`) VALUES
(1, 'Nepal', 977, NULL, NULL, NULL, NULL),
(2, 'China', 86, NULL, NULL, NULL, NULL),
(3, 'India', 91, NULL, NULL, NULL, NULL),
(4, 'Bhutan', 975, NULL, NULL, NULL, NULL),
(5, 'Bangaladesh', 880, NULL, NULL, NULL, NULL),
(6, 'Afganistan', 93, NULL, NULL, NULL, NULL),
(7, 'Maldives', 960, NULL, NULL, NULL, NULL),
(8, 'Pakistan', 92, NULL, NULL, NULL, NULL),
(9, 'Srilangka', 94, NULL, NULL, NULL, NULL),
(10, 'Japan', 81, NULL, NULL, NULL, NULL),
(11, 'South Korea', 82, NULL, NULL, NULL, NULL),
(12, 'North Korea', 850, NULL, NULL, NULL, NULL),
(13, 'Hong Kong', 852, NULL, NULL, NULL, NULL),
(14, 'Rasia', 7, NULL, NULL, NULL, NULL),
(15, 'Singapore', 65, NULL, NULL, NULL, NULL),
(16, 'Taiwan', 886, NULL, NULL, NULL, NULL),
(18, 'USA', 1, NULL, NULL, NULL, NULL),
(19, 'UK', 2, NULL, NULL, NULL, NULL),
(20, 'France', 3, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_department`
--

CREATE TABLE `tbl_department` (
  `Department_id` int(10) NOT NULL,
  `DepartmentName` varchar(225) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_department`
--

INSERT INTO `tbl_department` (`Department_id`, `DepartmentName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`) VALUES
(1, 'Cash Department', NULL, NULL, NULL, NULL),
(2, 'Management Department', NULL, NULL, NULL, NULL),
(3, 'Account Department', NULL, NULL, NULL, NULL),
(4, 'Marketing Department', NULL, NULL, NULL, NULL),
(5, 'Loan Department', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_district`
--

CREATE TABLE `tbl_district` (
  `District_id` int(10) NOT NULL,
  `DistrictName` varchar(225) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_district`
--

INSERT INTO `tbl_district` (`District_id`, `DistrictName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Registration_id`) VALUES
(1, 'Solukhumbu', NULL, NULL, NULL, NULL, NULL),
(2, 'Okhaldhunga', NULL, NULL, NULL, NULL, NULL),
(3, 'Udayapur', NULL, NULL, NULL, NULL, NULL),
(4, 'Khotang', NULL, NULL, NULL, NULL, NULL),
(5, 'Bhojpur', NULL, NULL, NULL, NULL, NULL),
(6, 'Sangkhuwasabha', NULL, NULL, NULL, NULL, NULL),
(8, 'Kathmandu', NULL, NULL, NULL, NULL, NULL),
(9, 'Lalitpur', NULL, NULL, NULL, NULL, NULL),
(10, 'Bhaktapur', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_faculty`
--

CREATE TABLE `tbl_faculty` (
  `Faculty_id` int(10) NOT NULL,
  `FacultyName` varchar(225) DEFAULT NULL,
  `Bachelor_id` int(10) DEFAULT NULL,
  `Master_id` int(10) DEFAULT NULL,
  `HighSchool_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_faculty`
--

INSERT INTO `tbl_faculty` (`Faculty_id`, `FacultyName`, `Bachelor_id`, `Master_id`, `HighSchool_id`, `Registration_id`) VALUES
(1, 'Management', NULL, NULL, NULL, NULL),
(2, 'Computer Science', NULL, NULL, NULL, NULL),
(3, 'Education', NULL, NULL, NULL, NULL),
(4, 'Humanities', NULL, NULL, NULL, NULL),
(5, 'Hotel Management', NULL, NULL, NULL, NULL),
(6, 'BBS', NULL, NULL, NULL, NULL),
(7, 'BBA', NULL, NULL, NULL, NULL),
(8, 'B.Ed', NULL, NULL, NULL, NULL),
(9, 'BA', NULL, NULL, NULL, NULL),
(10, 'BCA', NULL, NULL, NULL, NULL),
(11, 'Bsc IT', NULL, NULL, NULL, NULL),
(12, 'Bsc CSIT', NULL, NULL, NULL, NULL),
(13, 'BIT', NULL, NULL, NULL, NULL),
(14, 'MBS', NULL, NULL, NULL, NULL),
(15, 'MCA', NULL, NULL, NULL, NULL),
(16, 'MIT', NULL, NULL, NULL, NULL),
(17, 'Msc. IT', NULL, NULL, NULL, NULL),
(18, 'MBA', NULL, NULL, NULL, NULL),
(19, 'MA', NULL, NULL, NULL, NULL),
(20, 'Msc CSIT', NULL, NULL, NULL, NULL),
(21, 'Not Applicable', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_leave`
--

CREATE TABLE `tbl_leave` (
  `Leave_id` int(10) NOT NULL,
  `LeaveDateCheck_IN` datetime DEFAULT NULL,
  `LeaveDateCheck_OUT` datetime DEFAULT NULL,
  `Total_LeaveHours` datetime DEFAULT NULL,
  `LeaveDeductionRate` float DEFAULT NULL,
  `Net_LeaveAmount` float DEFAULT NULL,
  `LeaveReson` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_level`
--

CREATE TABLE `tbl_level` (
  `level_id` int(10) NOT NULL,
  `LevelName` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_level`
--

INSERT INTO `tbl_level` (`level_id`, `LevelName`) VALUES
(1, 'School'),
(2, 'High School'),
(3, 'Bachelor'),
(4, 'Master');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_municipality`
--

CREATE TABLE `tbl_municipality` (
  `Municipality_id` int(10) NOT NULL,
  `MunicipalityName` varchar(225) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_municipality`
--

INSERT INTO `tbl_municipality` (`Municipality_id`, `MunicipalityName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Registration_id`) VALUES
(1, 'Rural Municipality', NULL, NULL, NULL, NULL, NULL),
(2, 'Municipality', NULL, NULL, NULL, NULL, NULL),
(3, 'Sub Metropolitant  City', NULL, NULL, NULL, NULL, NULL),
(4, 'Metropolitant  City', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_officehours`
--

CREATE TABLE `tbl_officehours` (
  `OfficeHours_id` int(10) NOT NULL,
  `OfficeHours` time DEFAULT NULL,
  `StartTime` time DEFAULT NULL,
  `EndTime` time DEFAULT NULL,
  `Weekend` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_officehours`
--

INSERT INTO `tbl_officehours` (`OfficeHours_id`, `OfficeHours`, `StartTime`, `EndTime`, `Weekend`) VALUES
(1, '08:00:00', '09:00:00', '05:00:00', '05:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_overtime`
--

CREATE TABLE `tbl_overtime` (
  `OverTime_id` int(10) NOT NULL,
  `OverTimeCheck_IN` time DEFAULT NULL,
  `OverTimeCheck_OUT` time DEFAULT NULL,
  `TotalOvetTime` datetime DEFAULT NULL,
  `PayRateHours` float DEFAULT NULL,
  `Net_OverTimeAmount` float DEFAULT NULL,
  `OverTimeFor` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_post`
--

CREATE TABLE `tbl_post` (
  `Post_id` int(10) NOT NULL,
  `PostName` varchar(225) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_post`
--

INSERT INTO `tbl_post` (`Post_id`, `PostName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`) VALUES
(1, 'CEO', NULL, NULL, NULL, NULL),
(2, 'Managing Director', NULL, NULL, NULL, NULL),
(3, 'Branch Manager', NULL, NULL, NULL, NULL),
(4, 'Hub Manager', NULL, NULL, NULL, NULL),
(5, 'Head of Accountant ', NULL, NULL, NULL, NULL),
(6, 'Accountant', NULL, NULL, NULL, NULL),
(7, 'Marketing Manager', NULL, NULL, NULL, NULL),
(8, 'Finance Manager', NULL, NULL, NULL, NULL),
(9, 'President', NULL, NULL, NULL, NULL),
(10, 'Vice President', NULL, NULL, NULL, NULL),
(11, 'Cashier', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_qrandthump`
--

CREATE TABLE `tbl_qrandthump` (
  `QRAndThump_id` int(10) NOT NULL,
  `QRCode` varchar(225) DEFAULT NULL,
  `Thump` varchar(225) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `CreatedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_qrandthump`
--

INSERT INTO `tbl_qrandthump` (`QRAndThump_id`, `QRCode`, `Thump`, `Registration_id`, `CreatedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`) VALUES
(1, '1', '1', 1, 'Bishnu', 'Bishnu rai', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(2, '1', '1', 1, 'Bishnu', 'Bishnu rai', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_qualification`
--

CREATE TABLE `tbl_qualification` (
  `Qualification_id` int(10) NOT NULL,
  `Level_id` int(10) DEFAULT NULL,
  `InstituteName` varchar(225) DEFAULT NULL,
  `PercentOrGPA` varchar(20) DEFAULT NULL,
  `PassedYear` date DEFAULT NULL,
  `Address` varchar(225) DEFAULT NULL,
  `Board_id` int(10) DEFAULT NULL,
  `Faculty_id` int(10) DEFAULT NULL,
  `University_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `FileName` varchar(225) DEFAULT NULL,
  `FilePath` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_qualification`
--

INSERT INTO `tbl_qualification` (`Qualification_id`, `Level_id`, `InstituteName`, `PercentOrGPA`, `PassedYear`, `Address`, `Board_id`, `Faculty_id`, `University_id`, `Registration_id`, `FileName`, `FilePath`) VALUES
(2, 2, 'Grammer Higher Secondary School', '55%', '2020-06-06', 'Koteswor,Kathmandu,Nepal', 3, 1, 6, 9, NULL, ''),
(3, 3, 'Lord Budhdha Educational Foundation', '70%', '2020-06-17', 'Maitidevi,kathmandu,nepal', 6, 10, 5, 9, NULL, ''),
(4, 1, 'Shree Mahendrodaya Higher Secondary School', '62%', '2015-01-11', 'Okhre- 4, dadagau, Khotang ', 4, 21, 6, 10, NULL, ''),
(5, 2, 'Bright Future College', '48%', '2020-11-30', 'Satdobato- 14, Lalitpur', 3, 1, 6, 10, NULL, ''),
(6, 1, 'Himalayan Secondary School', '55%', '2020-06-01', 'Mapya Dydhkoshi ', 5, 21, 6, 12, NULL, ''),
(7, 1, 'Khumjung Secondary School', '63.63%', '2020-06-06', 'Khmjung,Solukhumbu,Nepal', 4, 21, 6, 9, NULL, ''),
(8, 1, 'Khumjung Secondary School', '55%', '2020-06-08', 'Khmjung,Solukhumbu,Nepal', 1, 21, 6, 15, NULL, ''),
(16, 1, 'Khumjung Secondary School', '63.63%', '2020-06-12', 'Khmjung,Solukhumbu,Nepal', 4, 2, 6, 9, 'Book1.xlsx', 'G:\\Project\\TMS\\web\\File\\Book1.xlsx');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_register`
--

CREATE TABLE `tbl_register` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `email` varchar(225) NOT NULL,
  `sex` varchar(200) DEFAULT NULL,
  `country` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_register`
--

INSERT INTO `tbl_register` (`id`, `name`, `password`, `email`, `sex`, `country`) VALUES
(1, 'Bishnu Rai', 'pokhara.com', 'rajvison@gmail.com', 'male', 'Other'),
(2, 'Pabitra Rai', 'pabitra.com', 'pabitra@gmail.com', 'female', 'Nepal'),
(3, 'Bishnu', 'pokhara.com', 'bishnu@gmail.com', 'male', 'Nepal'),
(13, 'Bishnu Rai', 'pokhara.com', 'rajvison@gmail.com', 'male', 'Nepal');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_registration`
--

CREATE TABLE `tbl_registration` (
  `Registration_id` int(10) NOT NULL,
  `RegistrationDate` datetime DEFAULT NULL,
  `FirstName` varchar(225) DEFAULT NULL,
  `MiddleName` varchar(225) DEFAULT NULL,
  `LastName` varchar(225) DEFAULT NULL,
  `MothersName` varchar(225) DEFAULT NULL,
  `FathersName` varchar(225) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `Email` varchar(225) DEFAULT NULL,
  `MobileNo` varchar(100) DEFAULT NULL,
  `LandLine` varchar(100) DEFAULT NULL,
  `PersonalIDNumber` int(11) DEFAULT NULL,
  `Section_id` int(10) DEFAULT NULL,
  `Post_id` int(10) DEFAULT NULL,
  `Department_id` int(10) DEFAULT NULL,
  `PhotoName` varchar(100) DEFAULT NULL,
  `PhotoPath` varchar(100) DEFAULT NULL,
  `Salary_id` int(10) DEFAULT NULL,
  `User_id` int(10) DEFAULT NULL,
  `QRAndThump_id` int(10) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_registration`
--

INSERT INTO `tbl_registration` (`Registration_id`, `RegistrationDate`, `FirstName`, `MiddleName`, `LastName`, `MothersName`, `FathersName`, `DOB`, `Gender`, `Email`, `MobileNo`, `LandLine`, `PersonalIDNumber`, `Section_id`, `Post_id`, `Department_id`, `PhotoName`, `PhotoPath`, `Salary_id`, `User_id`, `QRAndThump_id`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`) VALUES
(9, '2020-06-05 00:00:00', 'Bishnu', 'Khaling', 'Rai', 'Dorjee Maya Rai', 'Dhane Rai', '2020-06-05 00:00:00', 'Male', 'rajvison@gmail.com', '9869162217', NULL, 2, 1, 1, 2, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, '2020-06-06 00:00:00', 'Pabitra', 'Khaling', 'Rai', 'Dorjee Maya Rai', 'Dhane Rai', '2020-06-05 00:00:00', 'Female', 'pabitra@gmail.com', '9877', NULL, 4, 1, 2, 1, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, '2020-06-05 00:00:00', 'Nawa', 'Khaling', 'Rai', 'Dorjee Maya Rai', 'Dhane Rai', '2020-06-06 00:00:00', 'Male', 'nawa@gmail.com', '9876', NULL, 6, 2, 2, 2, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, '2020-06-07 00:00:00', 'Kiran', '', 'Rai', 'mangali', 'dhane', '2020-06-08 00:00:00', 'Male', 'kiran@gmail.com', '987544', '987544', 7, 2, 2, 1, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(15, '2020-06-19 00:00:00', 'sony', 'Khaling', 'Rai', 'tika rai', 'tika rai', '2020-06-07 00:00:00', 'Female', 'sony@gmail.com', '98741', '98741', 8, 2, 2, 1, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(28, '2020-06-01 00:00:00', 'Bishnu', 'Khaling', 'Rai', 'Dorjee Maya Rai', 'Dhane Rai', '2020-06-01 00:00:00', 'Male', 'c@gmail.com', '9874612', '4', 12, 1, 1, 1, 'bishnu.jpg', 'G:\\Project\\TMS\\web\\image\\bishnu.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(29, '2020-05-31 00:00:00', 'Bishnu', 'Khaling', 'Rai', 'Dorjee Maya Rai', 'Dhane Rai', '2020-06-01 00:00:00', 'Male', 'e@gmail.com', '98777', '99888880', 13, 1, 1, 1, 'bishnurai.jpg', 'G:\\Project\\TMS\\web\\image\\bishnurai.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_section`
--

CREATE TABLE `tbl_section` (
  `Section_id` int(10) NOT NULL,
  `SectionName` varchar(225) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Person_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_section`
--

INSERT INTO `tbl_section` (`Section_id`, `SectionName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Person_id`) VALUES
(1, 'Account Section', NULL, NULL, NULL, NULL, NULL),
(2, 'Marketing Section', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_state`
--

CREATE TABLE `tbl_state` (
  `State_id` int(10) NOT NULL,
  `StateName` varchar(225) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_state`
--

INSERT INTO `tbl_state` (`State_id`, `StateName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Registration_id`) VALUES
(1, 'Kirant State', NULL, NULL, NULL, NULL, NULL),
(2, 'Magarat State', NULL, NULL, NULL, NULL, NULL),
(3, '3 No. Newa State', NULL, NULL, NULL, NULL, NULL),
(4, '4 No. State', NULL, NULL, NULL, NULL, NULL),
(5, '5 No. State', NULL, NULL, NULL, NULL, NULL),
(6, '6 No. State', NULL, NULL, NULL, NULL, NULL),
(7, '7 No. State', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_street`
--

CREATE TABLE `tbl_street` (
  `Street_id` int(10) NOT NULL,
  `StreetName` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_street`
--

INSERT INTO `tbl_street` (`Street_id`, `StreetName`) VALUES
(1, 'Kapan Chowk'),
(8, 'Hurcom'),
(9, 'Bodu'),
(10, 'Khyaldel'),
(11, 'Suksale');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_university`
--

CREATE TABLE `tbl_university` (
  `University_id` int(10) NOT NULL,
  `UniversityName` varchar(225) DEFAULT NULL,
  `Bachelor_id` int(10) DEFAULT NULL,
  `Master_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_university`
--

INSERT INTO `tbl_university` (`University_id`, `UniversityName`, `Bachelor_id`, `Master_id`, `Registration_id`) VALUES
(1, 'Tribhuwan University', NULL, NULL, NULL),
(2, 'Pokhara University', NULL, NULL, NULL),
(3, 'Purba Angchal University', NULL, NULL, NULL),
(4, 'Kathmandu University', NULL, NULL, NULL),
(5, 'Open University', NULL, NULL, NULL),
(6, 'Not Applicable', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `User_id` int(10) NOT NULL,
  `UserLoginName` varchar(225) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `UserGroup_id` int(10) DEFAULT NULL,
  `QRAndThump_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `CreatedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `UserName` varchar(225) DEFAULT NULL,
  `UserRoll_id` int(10) DEFAULT NULL,
  `Status` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`User_id`, `UserLoginName`, `Password`, `UserGroup_id`, `QRAndThump_id`, `Registration_id`, `CreatedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `UserName`, `UserRoll_id`, `Status`) VALUES
(6, 'bishnu701', 'admin123', 13, NULL, NULL, NULL, NULL, NULL, NULL, 'Bishnu Khaling Rai', 10, 1),
(20, 'nawa', 'nawa', 1, NULL, NULL, NULL, NULL, NULL, NULL, 'Nawa Rai', 11, 1),
(22, 'kiranrai', 'kiran', 18, NULL, NULL, NULL, NULL, NULL, NULL, 'Kiran Rai', 1, 1),
(36, 'pabitra', 'admin123', 4, NULL, NULL, NULL, NULL, NULL, NULL, 'Pabitra Rai', 1, 1),
(53, 'bishnu', 'admin123', 13, NULL, NULL, NULL, NULL, NULL, NULL, 'Bishnu  Rai', 10, 1),
(56, 'sunita', 'sunita12', 8, NULL, NULL, NULL, NULL, NULL, NULL, 'Sunita Rai', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_userauthentication`
--

CREATE TABLE `tbl_userauthentication` (
  `UserAuthentication_id` int(10) NOT NULL,
  `NewCreate` tinyint(1) DEFAULT NULL,
  `ForUpdate` tinyint(1) DEFAULT NULL,
  `ForDelete` tinyint(1) DEFAULT NULL,
  `CreatedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `UserAuthenticationName` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_userauthentication`
--

INSERT INTO `tbl_userauthentication` (`UserAuthentication_id`, `NewCreate`, `ForUpdate`, `ForDelete`, `CreatedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `UserAuthenticationName`) VALUES
(1, 1, 1, 1, 'Bishnu', 'Bishnu', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL),
(2, 1, 1, 1, 'Bishnu', 'Bishnu', '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL),
(3, 1, 1, 1, 'Bishnu Rai', 'Bishnu Rai', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Full Authenticate');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_usergroup`
--

CREATE TABLE `tbl_usergroup` (
  `UserGroup_id` int(10) NOT NULL,
  `UserGroupName` varchar(225) DEFAULT NULL,
  `CreatedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_usergroup`
--

INSERT INTO `tbl_usergroup` (`UserGroup_id`, `UserGroupName`, `CreatedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`) VALUES
(1, 'Section Manager', 'bishnu', 'bishnu', '2020-04-04 00:00:00', '2020-04-04 00:00:00'),
(4, 'Accountant', NULL, NULL, NULL, NULL),
(8, 'Receptionist', NULL, NULL, NULL, NULL),
(9, 'Marketing Manager', NULL, NULL, NULL, NULL),
(10, 'Managing Director', NULL, NULL, NULL, NULL),
(13, 'Database Administrator', NULL, NULL, NULL, NULL),
(18, 'Manager', NULL, NULL, NULL, NULL),
(19, 'Delux Section', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_userroll`
--

CREATE TABLE `tbl_userroll` (
  `UserRoll_id` int(10) NOT NULL,
  `UserRollName` varchar(225) DEFAULT NULL,
  `CreatedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_userroll`
--

INSERT INTO `tbl_userroll` (`UserRoll_id`, `UserRollName`, `CreatedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`) VALUES
(1, 'Super Admin', 'Bishnu', 'Bishnu', '2020-04-04 00:00:00', '2020-04-04 00:00:00'),
(10, 'Admin', NULL, NULL, NULL, NULL),
(11, 'User', NULL, NULL, NULL, NULL),
(14, 'Views', NULL, NULL, NULL, NULL),
(16, 'Normal User', NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_address`
--
ALTER TABLE `tbl_address`
  ADD PRIMARY KEY (`Address_id`),
  ADD KEY `AddressType_id` (`AddressType_id`),
  ADD KEY `Registration_id` (`Registration_id`),
  ADD KEY `Country_id` (`Country_id`),
  ADD KEY `State_id` (`State_id`),
  ADD KEY `District_id` (`District_id`),
  ADD KEY `Municipality_id` (`Municipality_id`);

--
-- Indexes for table `tbl_addresstype`
--
ALTER TABLE `tbl_addresstype`
  ADD PRIMARY KEY (`AddressType_id`);

--
-- Indexes for table `tbl_attendance`
--
ALTER TABLE `tbl_attendance`
  ADD PRIMARY KEY (`Attendance_id`),
  ADD KEY `Registration_id` (`Registration_id`),
  ADD KEY `User_id` (`User_id`);

--
-- Indexes for table `tbl_board`
--
ALTER TABLE `tbl_board`
  ADD PRIMARY KEY (`Board_id`);

--
-- Indexes for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  ADD PRIMARY KEY (`Contact_id`),
  ADD KEY `Registration_id` (`Registration_id`);

--
-- Indexes for table `tbl_country`
--
ALTER TABLE `tbl_country`
  ADD PRIMARY KEY (`Country_id`);

--
-- Indexes for table `tbl_department`
--
ALTER TABLE `tbl_department`
  ADD PRIMARY KEY (`Department_id`);

--
-- Indexes for table `tbl_district`
--
ALTER TABLE `tbl_district`
  ADD PRIMARY KEY (`District_id`);

--
-- Indexes for table `tbl_faculty`
--
ALTER TABLE `tbl_faculty`
  ADD PRIMARY KEY (`Faculty_id`);

--
-- Indexes for table `tbl_leave`
--
ALTER TABLE `tbl_leave`
  ADD PRIMARY KEY (`Leave_id`);

--
-- Indexes for table `tbl_level`
--
ALTER TABLE `tbl_level`
  ADD PRIMARY KEY (`level_id`);

--
-- Indexes for table `tbl_municipality`
--
ALTER TABLE `tbl_municipality`
  ADD PRIMARY KEY (`Municipality_id`);

--
-- Indexes for table `tbl_officehours`
--
ALTER TABLE `tbl_officehours`
  ADD PRIMARY KEY (`OfficeHours_id`);

--
-- Indexes for table `tbl_overtime`
--
ALTER TABLE `tbl_overtime`
  ADD PRIMARY KEY (`OverTime_id`);

--
-- Indexes for table `tbl_post`
--
ALTER TABLE `tbl_post`
  ADD PRIMARY KEY (`Post_id`);

--
-- Indexes for table `tbl_qrandthump`
--
ALTER TABLE `tbl_qrandthump`
  ADD PRIMARY KEY (`QRAndThump_id`);

--
-- Indexes for table `tbl_qualification`
--
ALTER TABLE `tbl_qualification`
  ADD PRIMARY KEY (`Qualification_id`),
  ADD KEY `Level_id` (`Level_id`),
  ADD KEY `Board_id` (`Board_id`),
  ADD KEY `Faculty_id` (`Faculty_id`),
  ADD KEY `University_id` (`University_id`),
  ADD KEY `Registration_id` (`Registration_id`);

--
-- Indexes for table `tbl_register`
--
ALTER TABLE `tbl_register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_registration`
--
ALTER TABLE `tbl_registration`
  ADD PRIMARY KEY (`Registration_id`),
  ADD KEY `Post_id` (`Post_id`),
  ADD KEY `Section_id` (`Section_id`),
  ADD KEY `User_id` (`User_id`),
  ADD KEY `Department_id` (`Department_id`);

--
-- Indexes for table `tbl_section`
--
ALTER TABLE `tbl_section`
  ADD PRIMARY KEY (`Section_id`);

--
-- Indexes for table `tbl_state`
--
ALTER TABLE `tbl_state`
  ADD PRIMARY KEY (`State_id`);

--
-- Indexes for table `tbl_street`
--
ALTER TABLE `tbl_street`
  ADD PRIMARY KEY (`Street_id`);

--
-- Indexes for table `tbl_university`
--
ALTER TABLE `tbl_university`
  ADD PRIMARY KEY (`University_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`User_id`),
  ADD KEY `UserGroup_id` (`UserGroup_id`),
  ADD KEY `QRAndThump_id` (`QRAndThump_id`),
  ADD KEY `UserRoll_id` (`UserRoll_id`);

--
-- Indexes for table `tbl_userauthentication`
--
ALTER TABLE `tbl_userauthentication`
  ADD PRIMARY KEY (`UserAuthentication_id`);

--
-- Indexes for table `tbl_usergroup`
--
ALTER TABLE `tbl_usergroup`
  ADD PRIMARY KEY (`UserGroup_id`);

--
-- Indexes for table `tbl_userroll`
--
ALTER TABLE `tbl_userroll`
  ADD PRIMARY KEY (`UserRoll_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_address`
--
ALTER TABLE `tbl_address`
  MODIFY `Address_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tbl_addresstype`
--
ALTER TABLE `tbl_addresstype`
  MODIFY `AddressType_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_attendance`
--
ALTER TABLE `tbl_attendance`
  MODIFY `Attendance_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_board`
--
ALTER TABLE `tbl_board`
  MODIFY `Board_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  MODIFY `Contact_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_country`
--
ALTER TABLE `tbl_country`
  MODIFY `Country_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tbl_department`
--
ALTER TABLE `tbl_department`
  MODIFY `Department_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_district`
--
ALTER TABLE `tbl_district`
  MODIFY `District_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbl_faculty`
--
ALTER TABLE `tbl_faculty`
  MODIFY `Faculty_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tbl_leave`
--
ALTER TABLE `tbl_leave`
  MODIFY `Leave_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_level`
--
ALTER TABLE `tbl_level`
  MODIFY `level_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_municipality`
--
ALTER TABLE `tbl_municipality`
  MODIFY `Municipality_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_officehours`
--
ALTER TABLE `tbl_officehours`
  MODIFY `OfficeHours_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_overtime`
--
ALTER TABLE `tbl_overtime`
  MODIFY `OverTime_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_post`
--
ALTER TABLE `tbl_post`
  MODIFY `Post_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbl_qrandthump`
--
ALTER TABLE `tbl_qrandthump`
  MODIFY `QRAndThump_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_qualification`
--
ALTER TABLE `tbl_qualification`
  MODIFY `Qualification_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_register`
--
ALTER TABLE `tbl_register`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tbl_registration`
--
ALTER TABLE `tbl_registration`
  MODIFY `Registration_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `tbl_section`
--
ALTER TABLE `tbl_section`
  MODIFY `Section_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_state`
--
ALTER TABLE `tbl_state`
  MODIFY `State_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_street`
--
ALTER TABLE `tbl_street`
  MODIFY `Street_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tbl_university`
--
ALTER TABLE `tbl_university`
  MODIFY `University_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `User_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `tbl_userauthentication`
--
ALTER TABLE `tbl_userauthentication`
  MODIFY `UserAuthentication_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_usergroup`
--
ALTER TABLE `tbl_usergroup`
  MODIFY `UserGroup_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tbl_userroll`
--
ALTER TABLE `tbl_userroll`
  MODIFY `UserRoll_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_address`
--
ALTER TABLE `tbl_address`
  ADD CONSTRAINT `tbl_address_ibfk_1` FOREIGN KEY (`AddressType_id`) REFERENCES `tbl_addresstype` (`AddressType_id`),
  ADD CONSTRAINT `tbl_address_ibfk_2` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`),
  ADD CONSTRAINT `tbl_address_ibfk_3` FOREIGN KEY (`Country_id`) REFERENCES `tbl_country` (`Country_id`),
  ADD CONSTRAINT `tbl_address_ibfk_4` FOREIGN KEY (`State_id`) REFERENCES `tbl_state` (`State_id`),
  ADD CONSTRAINT `tbl_address_ibfk_5` FOREIGN KEY (`District_id`) REFERENCES `tbl_district` (`District_id`),
  ADD CONSTRAINT `tbl_address_ibfk_6` FOREIGN KEY (`Municipality_id`) REFERENCES `tbl_municipality` (`Municipality_id`);

--
-- Constraints for table `tbl_attendance`
--
ALTER TABLE `tbl_attendance`
  ADD CONSTRAINT `tbl_attendance_ibfk_1` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`),
  ADD CONSTRAINT `tbl_attendance_ibfk_2` FOREIGN KEY (`User_id`) REFERENCES `tbl_user` (`User_id`);

--
-- Constraints for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  ADD CONSTRAINT `tbl_contact_ibfk_1` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`);

--
-- Constraints for table `tbl_qualification`
--
ALTER TABLE `tbl_qualification`
  ADD CONSTRAINT `tbl_qualification_ibfk_1` FOREIGN KEY (`Level_id`) REFERENCES `tbl_level` (`level_id`),
  ADD CONSTRAINT `tbl_qualification_ibfk_2` FOREIGN KEY (`Board_id`) REFERENCES `tbl_board` (`Board_id`),
  ADD CONSTRAINT `tbl_qualification_ibfk_3` FOREIGN KEY (`Faculty_id`) REFERENCES `tbl_faculty` (`Faculty_id`),
  ADD CONSTRAINT `tbl_qualification_ibfk_4` FOREIGN KEY (`University_id`) REFERENCES `tbl_university` (`University_id`),
  ADD CONSTRAINT `tbl_qualification_ibfk_5` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`);

--
-- Constraints for table `tbl_registration`
--
ALTER TABLE `tbl_registration`
  ADD CONSTRAINT `tbl_registration_ibfk_11` FOREIGN KEY (`Department_id`) REFERENCES `tbl_department` (`Department_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_3` FOREIGN KEY (`Post_id`) REFERENCES `tbl_post` (`Post_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_4` FOREIGN KEY (`Section_id`) REFERENCES `tbl_section` (`Section_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_5` FOREIGN KEY (`User_id`) REFERENCES `tbl_user` (`User_id`);

--
-- Constraints for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD CONSTRAINT `tbl_user_ibfk_1` FOREIGN KEY (`UserGroup_id`) REFERENCES `tbl_usergroup` (`UserGroup_id`),
  ADD CONSTRAINT `tbl_user_ibfk_2` FOREIGN KEY (`QRAndThump_id`) REFERENCES `tbl_qrandthump` (`QRAndThump_id`),
  ADD CONSTRAINT `tbl_user_ibfk_3` FOREIGN KEY (`UserRoll_id`) REFERENCES `tbl_userroll` (`UserRoll_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
