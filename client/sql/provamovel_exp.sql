-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 06, 2015 at 08:04 
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `provamovel`
--
CREATE DATABASE IF NOT EXISTS `provamovel` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `provamovel`;

-- --------------------------------------------------------

--
-- Table structure for table `tb_question`
--

DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE IF NOT EXISTS `tb_question` (
  `id` int(11) NOT NULL,
  `test` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tb_question_option`
--

DROP TABLE IF EXISTS `tb_question_option`;
CREATE TABLE IF NOT EXISTS `tb_question_option` (
  `id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `question` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tb_test`
--

DROP TABLE IF EXISTS `tb_test`;
CREATE TABLE IF NOT EXISTS `tb_test` (
  `id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `authorEmail` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE IF NOT EXISTS `tb_user` (
  `email` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `hash` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user_answer_item`
--

DROP TABLE IF EXISTS `tb_user_answer_item`;
CREATE TABLE IF NOT EXISTS `tb_user_answer_item` (
  `id` int(11) NOT NULL,
  `answer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user_test_answer`
--

DROP TABLE IF EXISTS `tb_user_test_answer`;
CREATE TABLE IF NOT EXISTS `tb_user_test_answer` (
  `id` int(11) NOT NULL,
  `userEmail` varchar(250) NOT NULL,
  `test` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_question`
--
ALTER TABLE `tb_question`
 ADD PRIMARY KEY (`id`), ADD KEY `test` (`test`);

--
-- Indexes for table `tb_question_option`
--
ALTER TABLE `tb_question_option`
 ADD PRIMARY KEY (`id`), ADD KEY `question` (`question`);

--
-- Indexes for table `tb_test`
--
ALTER TABLE `tb_test`
 ADD PRIMARY KEY (`id`), ADD KEY `authorEmail` (`authorEmail`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
 ADD PRIMARY KEY (`email`);

--
-- Indexes for table `tb_user_answer_item`
--
ALTER TABLE `tb_user_answer_item`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_user_test_answer`
--
ALTER TABLE `tb_user_test_answer`
 ADD PRIMARY KEY (`id`), ADD KEY `userEmail` (`userEmail`), ADD KEY `test` (`test`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_question`
--
ALTER TABLE `tb_question`
ADD CONSTRAINT `tb_question_ibfk_1` FOREIGN KEY (`test`) REFERENCES `tb_test` (`id`);

--
-- Constraints for table `tb_question_option`
--
ALTER TABLE `tb_question_option`
ADD CONSTRAINT `tb_question_option_ibfk_1` FOREIGN KEY (`question`) REFERENCES `tb_question` (`id`);

--
-- Constraints for table `tb_test`
--
ALTER TABLE `tb_test`
ADD CONSTRAINT `tb_test_ibfk_1` FOREIGN KEY (`authorEmail`) REFERENCES `tb_user` (`email`);

--
-- Constraints for table `tb_user_answer_item`
--
ALTER TABLE `tb_user_answer_item`
ADD CONSTRAINT `tb_user_answer_item_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tb_user_test_answer` (`id`);

--
-- Constraints for table `tb_user_test_answer`
--
ALTER TABLE `tb_user_test_answer`
ADD CONSTRAINT `tb_user_test_answer_ibfk_1` FOREIGN KEY (`userEmail`) REFERENCES `tb_user` (`email`),
ADD CONSTRAINT `tb_user_test_answer_ibfk_2` FOREIGN KEY (`test`) REFERENCES `tb_test` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
