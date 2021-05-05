-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3309
-- Generation Time: Jun 08, 2020 at 07:34 AM
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
-- Table structure for table `tbl_bachelor`
--

CREATE TABLE `tbl_bachelor` (
  `Bachelor_id` int(10) NOT NULL,
  `InstitudeName` varchar(225) DEFAULT NULL,
  `PassedYear` datetime DEFAULT NULL,
  `PercentORGPA` int(10) DEFAULT NULL,
  `BachelorAddress` varchar(225) DEFAULT NULL,
  `Faculty_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `University_id` int(10) DEFAULT NULL,
  `FileName` varchar(225) DEFAULT NULL,
  `FilePath` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(3, 'HSEB Board', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_contact`
--

CREATE TABLE `tbl_contact` (
  `Contact_id` int(10) NOT NULL,
  `Email` varchar(225) DEFAULT NULL,
  `MobileNo` int(12) DEFAULT NULL,
  `LandLine` int(12) DEFAULT NULL,
  `Person_id` int(10) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_country`
--

CREATE TABLE `tbl_country` (
  `Country_id` int(10) NOT NULL,
  `CountryName` varchar(225) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `PermanentAddress_id` int(10) DEFAULT NULL,
  `TemporaryAddress_id` int(10) DEFAULT NULL,
  `CreatedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `CountryCode` int(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_country`
--

INSERT INTO `tbl_country` (`Country_id`, `CountryName`, `Registration_id`, `PermanentAddress_id`, `TemporaryAddress_id`, `CreatedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `CountryCode`) VALUES
(1, 'Nepal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 977),
(2, 'China', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 86),
(3, 'India', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 91),
(4, 'Bhutan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 975),
(5, 'Bangaladesh', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 880),
(6, 'Afganistan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 93),
(7, 'Maldives', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 960),
(8, 'Pakistan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 92),
(9, 'Srilangka', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 94),
(10, 'Japan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 81),
(11, 'South Korea', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 82),
(12, 'North Korea', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 850),
(13, 'Hong Kong', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 852),
(14, 'Rasia', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7),
(15, 'Singapore', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 65),
(16, 'Taiwan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 886);

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
  `ModifiedDate` datetime DEFAULT NULL,
  `Person_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_department`
--

INSERT INTO `tbl_department` (`Department_id`, `DepartmentName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Person_id`, `Registration_id`) VALUES
(1, 'Cash Department', NULL, NULL, NULL, NULL, NULL, NULL);

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
  `Registration_id` int(10) DEFAULT NULL,
  `TemporaryAddress_id` int(10) DEFAULT NULL,
  `PermanentAddress_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_district`
--

INSERT INTO `tbl_district` (`District_id`, `DistrictName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Registration_id`, `TemporaryAddress_id`, `PermanentAddress_id`) VALUES
(1, 'Solukhumbu', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Okhaldhunga', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Udayapur', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'Khotang', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'Bhojpur', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'Sangkhuwasabha', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
(13, 'BIT', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_highschool`
--

CREATE TABLE `tbl_highschool` (
  `HighSchool_id` int(10) NOT NULL,
  `HighSchoolName` varchar(225) DEFAULT NULL,
  `PassedYear` datetime DEFAULT NULL,
  `PercentORGPA` int(10) DEFAULT NULL,
  `HighSchoolAddress` varchar(225) DEFAULT NULL,
  `Faculty_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `FileName` varchar(225) DEFAULT NULL,
  `FilePath` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_master`
--

CREATE TABLE `tbl_master` (
  `Master_id` int(10) NOT NULL,
  `InstitudeName` varchar(225) DEFAULT NULL,
  `PassedYear` datetime DEFAULT NULL,
  `PercentORGPA` int(10) DEFAULT NULL,
  `MasterAddress` varchar(225) DEFAULT NULL,
  `Faculty_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `University_id` int(10) DEFAULT NULL,
  `FileName` varchar(225) DEFAULT NULL,
  `FilePath` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `Registration_id` int(10) DEFAULT NULL,
  `TemporaryAddress_id` int(10) DEFAULT NULL,
  `PermanentAddress_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_municipality`
--

INSERT INTO `tbl_municipality` (`Municipality_id`, `MunicipalityName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Registration_id`, `TemporaryAddress_id`, `PermanentAddress_id`) VALUES
(1, 'Rural Municipality', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Municipality', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Sub Metropolitant  City', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'Metropolitant  City', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_permanentaddress`
--

CREATE TABLE `tbl_permanentaddress` (
  `PermanentAddress_id` int(10) NOT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `MunicipalityName` varchar(225) DEFAULT NULL,
  `StreetName` varchar(225) DEFAULT NULL,
  `WardNo` int(10) DEFAULT NULL,
  `State_id` int(10) DEFAULT NULL,
  `District_id` int(10) DEFAULT NULL,
  `Municipality_id` int(10) DEFAULT NULL,
  `Salary_id` int(10) DEFAULT NULL,
  `Person_id` int(10) DEFAULT NULL,
  `Country_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_person`
--

CREATE TABLE `tbl_person` (
  `Person_id` int(10) NOT NULL,
  `Post_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `Salary_id` int(10) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `FirstName` varchar(225) DEFAULT NULL,
  `MiddleName` varchar(225) DEFAULT NULL,
  `LastName` varchar(225) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `Gender` varchar(225) DEFAULT NULL,
  `PersonalIDNumber` int(12) DEFAULT NULL,
  `Section_id` int(10) DEFAULT NULL,
  `Department_id` int(10) DEFAULT NULL,
  `PermanentAddress_id` int(10) DEFAULT NULL,
  `TemporaryAddress_id` int(10) DEFAULT NULL,
  `PhotoName` varchar(225) DEFAULT NULL,
  `PhotoPath` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_post`
--

CREATE TABLE `tbl_post` (
  `Post_id` int(10) NOT NULL,
  `PostName` varchar(225) DEFAULT NULL,
  `Person_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_post`
--

INSERT INTO `tbl_post` (`Post_id`, `PostName`, `Person_id`, `Registration_id`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`) VALUES
(1, 'CEO', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Managing Director', NULL, NULL, NULL, NULL, NULL, NULL);

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
  `Person_id` int(10) DEFAULT NULL,
  `Post_id` int(10) DEFAULT NULL,
  `Section_id` int(10) DEFAULT NULL,
  `Salary_id` int(10) DEFAULT NULL,
  `User_id` int(10) DEFAULT NULL,
  `QRAndThump_id` int(10) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `RegistrationDate` datetime DEFAULT NULL,
  `PermanentAddress_id` int(10) DEFAULT NULL,
  `TemporaryAddress_id` int(10) DEFAULT NULL,
  `Department_id` int(10) DEFAULT NULL,
  `District_id` int(10) DEFAULT NULL,
  `Country_id` int(10) DEFAULT NULL,
  `State_id` int(10) DEFAULT NULL,
  `Municipality_id` int(10) DEFAULT NULL,
  `Contact_id` int(10) DEFAULT NULL,
  `Faculty_id` int(10) DEFAULT NULL,
  `University_id` int(10) DEFAULT NULL,
  `Board_id` int(10) DEFAULT NULL,
  `School_id` int(10) DEFAULT NULL,
  `HighSchool_id` int(10) DEFAULT NULL,
  `Bachelor_id` int(10) DEFAULT NULL,
  `Master_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_school`
--

CREATE TABLE `tbl_school` (
  `School_id` int(10) NOT NULL,
  `SchoolName` varchar(225) DEFAULT NULL,
  `PassedYear` datetime DEFAULT NULL,
  `PercentORGPA` int(10) DEFAULT NULL,
  `SchoolAddress` varchar(225) DEFAULT NULL,
  `Board_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `FileName` varchar(225) DEFAULT NULL,
  `FilePath` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_section`
--

CREATE TABLE `tbl_section` (
  `Section_id` int(10) NOT NULL,
  `SectionName` varchar(225) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `CreratedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Person_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_section`
--

INSERT INTO `tbl_section` (`Section_id`, `SectionName`, `Registration_id`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Person_id`) VALUES
(1, 'Account Section', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Marketing Section', NULL, NULL, NULL, NULL, NULL, NULL);

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
  `Registration_id` int(10) DEFAULT NULL,
  `PermanentAddress_id` int(10) DEFAULT NULL,
  `TemporaryAddress_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_state`
--

INSERT INTO `tbl_state` (`State_id`, `StateName`, `CreratedBy`, `ModifiedBy`, `CreatedDate`, `ModifiedDate`, `Registration_id`, `PermanentAddress_id`, `TemporaryAddress_id`) VALUES
(1, 'Kirant State', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Magarat State', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, '3 No. Newa State', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, '4 No. State', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, '5 No. State', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, '6 No. State', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, '7 No. State', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
-- Table structure for table `tbl_temporaryaddress`
--

CREATE TABLE `tbl_temporaryaddress` (
  `TemporaryAddress_id` int(10) NOT NULL,
  `MunicipalityName` varchar(225) DEFAULT NULL,
  `StreetName` varchar(225) DEFAULT NULL,
  `WardNo` int(10) DEFAULT NULL,
  `State_id` int(10) DEFAULT NULL,
  `District_id` int(10) DEFAULT NULL,
  `Municipality_id` int(10) DEFAULT NULL,
  `Registration_id` int(10) DEFAULT NULL,
  `Salary_id` int(10) DEFAULT NULL,
  `Person_id` int(10) DEFAULT NULL,
  `CreatedBy` varchar(225) DEFAULT NULL,
  `ModifiedBy` varchar(225) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Country_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(5, 'Open University', NULL, NULL, NULL);

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
(6, 'bishnu701', 'po', 13, NULL, NULL, NULL, NULL, NULL, NULL, 'Bishnu Khaling Rai', 10, 1),
(20, 'nawa', 'nawa', 1, NULL, NULL, NULL, NULL, NULL, NULL, 'Nawa Rai', 11, 1),
(22, 'kiranrai', 'kiran', 18, NULL, NULL, NULL, NULL, NULL, NULL, 'Kiran Rai', 1, 1),
(36, 'pabitra', 'po', 4, NULL, NULL, NULL, NULL, NULL, NULL, 'Pabitra Rai', 1, 1),
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
-- Indexes for table `tbl_bachelor`
--
ALTER TABLE `tbl_bachelor`
  ADD PRIMARY KEY (`Bachelor_id`),
  ADD KEY `Registration_id` (`Registration_id`);

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
-- Indexes for table `tbl_highschool`
--
ALTER TABLE `tbl_highschool`
  ADD PRIMARY KEY (`HighSchool_id`),
  ADD KEY `Registration_id` (`Registration_id`);

--
-- Indexes for table `tbl_master`
--
ALTER TABLE `tbl_master`
  ADD PRIMARY KEY (`Master_id`),
  ADD KEY `Registration_id` (`Registration_id`);

--
-- Indexes for table `tbl_municipality`
--
ALTER TABLE `tbl_municipality`
  ADD PRIMARY KEY (`Municipality_id`);

--
-- Indexes for table `tbl_permanentaddress`
--
ALTER TABLE `tbl_permanentaddress`
  ADD PRIMARY KEY (`PermanentAddress_id`);

--
-- Indexes for table `tbl_person`
--
ALTER TABLE `tbl_person`
  ADD PRIMARY KEY (`Person_id`),
  ADD KEY `TemporaryAddress_id` (`TemporaryAddress_id`),
  ADD KEY `Registration_id` (`Registration_id`),
  ADD KEY `PermanentAddress_id` (`PermanentAddress_id`);

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
-- Indexes for table `tbl_register`
--
ALTER TABLE `tbl_register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_registration`
--
ALTER TABLE `tbl_registration`
  ADD PRIMARY KEY (`Registration_id`),
  ADD KEY `Person_id` (`Person_id`),
  ADD KEY `Post_id` (`Post_id`),
  ADD KEY `Section_id` (`Section_id`),
  ADD KEY `User_id` (`User_id`),
  ADD KEY `District_id` (`District_id`),
  ADD KEY `State_id` (`State_id`),
  ADD KEY `Municipality_id` (`Municipality_id`),
  ADD KEY `Country_id` (`Country_id`),
  ADD KEY `Department_id` (`Department_id`),
  ADD KEY `Faculty_id` (`Faculty_id`),
  ADD KEY `University_id` (`University_id`),
  ADD KEY `Board_id` (`Board_id`);

--
-- Indexes for table `tbl_school`
--
ALTER TABLE `tbl_school`
  ADD PRIMARY KEY (`School_id`),
  ADD KEY `Registration_id` (`Registration_id`);

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
-- Indexes for table `tbl_temporaryaddress`
--
ALTER TABLE `tbl_temporaryaddress`
  ADD PRIMARY KEY (`TemporaryAddress_id`),
  ADD KEY `District_id` (`District_id`),
  ADD KEY `Country_id` (`Country_id`),
  ADD KEY `State_id` (`State_id`),
  ADD KEY `Municipality_id` (`Municipality_id`),
  ADD KEY `Registration_id` (`Registration_id`);

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
-- AUTO_INCREMENT for table `tbl_bachelor`
--
ALTER TABLE `tbl_bachelor`
  MODIFY `Bachelor_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_board`
--
ALTER TABLE `tbl_board`
  MODIFY `Board_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  MODIFY `Contact_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_country`
--
ALTER TABLE `tbl_country`
  MODIFY `Country_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tbl_department`
--
ALTER TABLE `tbl_department`
  MODIFY `Department_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_district`
--
ALTER TABLE `tbl_district`
  MODIFY `District_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_faculty`
--
ALTER TABLE `tbl_faculty`
  MODIFY `Faculty_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tbl_highschool`
--
ALTER TABLE `tbl_highschool`
  MODIFY `HighSchool_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_master`
--
ALTER TABLE `tbl_master`
  MODIFY `Master_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_municipality`
--
ALTER TABLE `tbl_municipality`
  MODIFY `Municipality_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_person`
--
ALTER TABLE `tbl_person`
  MODIFY `Person_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_post`
--
ALTER TABLE `tbl_post`
  MODIFY `Post_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_qrandthump`
--
ALTER TABLE `tbl_qrandthump`
  MODIFY `QRAndThump_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_register`
--
ALTER TABLE `tbl_register`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tbl_registration`
--
ALTER TABLE `tbl_registration`
  MODIFY `Registration_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_school`
--
ALTER TABLE `tbl_school`
  MODIFY `School_id` int(10) NOT NULL AUTO_INCREMENT;

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
-- AUTO_INCREMENT for table `tbl_temporaryaddress`
--
ALTER TABLE `tbl_temporaryaddress`
  MODIFY `TemporaryAddress_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_university`
--
ALTER TABLE `tbl_university`
  MODIFY `University_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
-- Constraints for table `tbl_bachelor`
--
ALTER TABLE `tbl_bachelor`
  ADD CONSTRAINT `tbl_bachelor_ibfk_1` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`);

--
-- Constraints for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  ADD CONSTRAINT `tbl_contact_ibfk_1` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`);

--
-- Constraints for table `tbl_highschool`
--
ALTER TABLE `tbl_highschool`
  ADD CONSTRAINT `tbl_highschool_ibfk_1` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`);

--
-- Constraints for table `tbl_master`
--
ALTER TABLE `tbl_master`
  ADD CONSTRAINT `tbl_master_ibfk_1` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`);

--
-- Constraints for table `tbl_person`
--
ALTER TABLE `tbl_person`
  ADD CONSTRAINT `tbl_person_ibfk_2` FOREIGN KEY (`TemporaryAddress_id`) REFERENCES `tbl_temporaryaddress` (`TemporaryAddress_id`),
  ADD CONSTRAINT `tbl_person_ibfk_3` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`),
  ADD CONSTRAINT `tbl_person_ibfk_4` FOREIGN KEY (`PermanentAddress_id`) REFERENCES `tbl_permanentaddress` (`PermanentAddress_id`);

--
-- Constraints for table `tbl_registration`
--
ALTER TABLE `tbl_registration`
  ADD CONSTRAINT `tbl_registration_ibfk_11` FOREIGN KEY (`Department_id`) REFERENCES `tbl_department` (`Department_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_12` FOREIGN KEY (`Faculty_id`) REFERENCES `tbl_faculty` (`Faculty_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_13` FOREIGN KEY (`University_id`) REFERENCES `tbl_university` (`University_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_14` FOREIGN KEY (`Board_id`) REFERENCES `tbl_board` (`Board_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_3` FOREIGN KEY (`Post_id`) REFERENCES `tbl_post` (`Post_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_4` FOREIGN KEY (`Section_id`) REFERENCES `tbl_section` (`Section_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_5` FOREIGN KEY (`User_id`) REFERENCES `tbl_user` (`User_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_6` FOREIGN KEY (`District_id`) REFERENCES `tbl_district` (`District_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_7` FOREIGN KEY (`Country_id`) REFERENCES `tbl_country` (`Country_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_8` FOREIGN KEY (`State_id`) REFERENCES `tbl_state` (`State_id`),
  ADD CONSTRAINT `tbl_registration_ibfk_9` FOREIGN KEY (`Municipality_id`) REFERENCES `tbl_municipality` (`Municipality_id`);

--
-- Constraints for table `tbl_school`
--
ALTER TABLE `tbl_school`
  ADD CONSTRAINT `tbl_school_ibfk_1` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`);

--
-- Constraints for table `tbl_temporaryaddress`
--
ALTER TABLE `tbl_temporaryaddress`
  ADD CONSTRAINT `tbl_temporaryaddress_ibfk_1` FOREIGN KEY (`District_id`) REFERENCES `tbl_district` (`District_id`),
  ADD CONSTRAINT `tbl_temporaryaddress_ibfk_2` FOREIGN KEY (`Country_id`) REFERENCES `tbl_country` (`Country_id`),
  ADD CONSTRAINT `tbl_temporaryaddress_ibfk_3` FOREIGN KEY (`State_id`) REFERENCES `tbl_state` (`State_id`),
  ADD CONSTRAINT `tbl_temporaryaddress_ibfk_4` FOREIGN KEY (`Municipality_id`) REFERENCES `tbl_municipality` (`Municipality_id`),
  ADD CONSTRAINT `tbl_temporaryaddress_ibfk_5` FOREIGN KEY (`Registration_id`) REFERENCES `tbl_registration` (`Registration_id`);

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
