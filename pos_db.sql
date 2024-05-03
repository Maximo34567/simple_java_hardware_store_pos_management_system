-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2023 at 04:18 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `billing_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_name` varchar(250) NOT NULL,
  `product_price` double NOT NULL,
  `billing_qty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`billing_id`, `product_id`, `product_name`, `product_price`, `billing_qty`) VALUES
(27, NULL, 'Paint Varnish', 8678.25, 87);

-- --------------------------------------------------------

--
-- Table structure for table `clerk`
--

CREATE TABLE `clerk` (
  `clerk_id` int(11) NOT NULL,
  `clerk_name` varchar(250) NOT NULL,
  `clerk_username` varchar(250) NOT NULL,
  `clerk_password` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clerk`
--

INSERT INTO `clerk` (`clerk_id`, `clerk_name`, `clerk_username`, `clerk_password`) VALUES
(1, 'Mark Angelo Fulledo', 'user', '4f8996da763b7a969b128ee307569eaf3a635486ddab211d512c85b9df8fb');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(250) NOT NULL,
  `product_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_price`) VALUES
(1, 'Paint Varnish', 99.75),
(2, 'Hammer', 15.99),
(3, 'Screwdriver Set', 12.49),
(4, 'Power Drill', 89.99),
(5, 'Pliers', 8.75),
(6, 'Tape Measure', 7.99),
(7, 'Adjustable Wrench', 14.25),
(8, 'Saw', 24.99),
(9, 'Paintbrush Set', 10.49),
(10, 'Safety Gloves', 5.99),
(11, 'Cordless Screwdriver', 39.99),
(12, 'Nails (1 lb)', 2.49),
(13, 'Screws (1 lb)', 3.99),
(14, 'Caulk Gun', 8.99),
(15, 'Paint Roller', 6.49),
(16, 'Level', 11.75),
(17, 'Duct Tape', 3.49),
(18, 'Flashlight', 9.99),
(19, 'Bucket', 4.25),
(20, 'Plunger', 7.99),
(21, 'Extension Cord', 12.49),
(22, 'Work Gloves', 6.75),
(23, 'Hacksaw', 13.99),
(24, 'Stud Finder', 17.49),
(25, 'Ladder', 59.99),
(26, 'Safety Goggles', 4.99),
(27, 'Utility Knife', 5.75),
(28, 'Drill Bits Set', 18.99),
(29, 'Hinge Set', 6.99),
(30, 'Socket Wrench Set', 29.75),
(31, 'Cordless Drill', 79.99),
(32, 'Paint Tray Set', 8.49),
(33, 'Sanding Block', 4.25),
(34, 'Sledgehammer', 27.49),
(35, 'Wire Cutters', 9.99),
(36, 'Wood Glue', 5.49),
(37, 'Lawn Mower', 149.99),
(38, 'Step Ladder', 34.99),
(39, 'Paint Drop Cloth', 12.75),
(40, 'Screw Assortment', 7.49),
(41, 'Staple Gun', 22.99),
(42, 'Garden Hose', 19.99),
(43, 'Spray Paint (Can)', 5.99),
(44, 'Broom', 11.25),
(45, 'Chainsaw', 89.75),
(46, 'Dust Mask', 3.49),
(47, 'Outdoor Extension Cord', 16.49),
(48, 'Crowbar', 14.99),
(49, 'Plastic Tarp', 6.25),
(50, 'Wood Screws (1 lb)', 4.99),
(51, 'Jigsaw', 38.99),
(52, 'Laser Level', 29.49),
(53, 'Wheelbarrow', 49.99),
(54, 'Cordless Leaf Blower', 69.99),
(55, 'Pruning Shears', 9.25),
(56, 'Cement Mix', 42.75),
(57, 'Toolbox Set', 26.49);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`billing_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `clerk`
--
ALTER TABLE `clerk`
  ADD PRIMARY KEY (`clerk_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billing`
--
ALTER TABLE `billing`
  MODIFY `billing_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `clerk`
--
ALTER TABLE `clerk`
  MODIFY `clerk_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billing`
--
ALTER TABLE `billing`
  ADD CONSTRAINT `billing_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
