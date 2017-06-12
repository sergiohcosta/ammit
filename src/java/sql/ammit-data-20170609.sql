-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 10-Jun-2017 às 01:19
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ammit`
--

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `pwd`, `salt`, `perfil`, `situacao`) VALUES
(1, '11111', '11111@11111.111', 0xfd41a37641e230b313bf385b7423bcce685210a1, 0xbfa61420d11eea09000000000000000000000000, 'Professor', 1),
(2, 'prof1', 'prof1@prof1.com', 0x76cd4c4a29ee1fc9d50a2e7379b435cb8e969660, 0xdb4b0faaef12f2df000000000000000000000000, 'Professor', 1),
(3, 'prof2', 'prof2@prof2.com', 0x8af16d7355c4700ea6fb76380e13b5548a155e60, 0x699eea321347e2d2, 'Professor', 1),
(4, 'prof3@prof3.com', 'prof3@prof3.com', 0xbc6fc4dcd8ea80de038286b298b8e8e184904712, 0xc45a49865ef40a81, 'Professor', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


--
-- Extraindo dados da tabela `questao`
--

INSERT INTO `questao` (`id`, `titulo`, `enunciado`, `professor`) VALUES
(1, 'titulo 1', 'enunciado 1', 2),
(2, 'titulo 2', 'enunciado 2', 3),
(3, 'titulo 2', 'enunciado 2', 3),
(4, 'titulo 2', 'enunciado 2', 3),
(5, 'titulo 2', 'enunciado 2', 3),
(6, 'titulo 2', 'enunciado 2', 3),
(7, 'titulo 2', 'enunciado 2', 3),
(8, 'qqqqqqqqqq', 'wwwwwwwww', 2),
(9, 'qqqqqqqqqq', 'wwwwwwwww', 2),
(10, 'qqqqqqqqqq', 'wwwwwwwww', 2),
(11, '3324225', '123512344', 1),
(12, '3324225', '123512344', 1),
(13, '3324225', '123512344', 1),
(14, '23123134', '4534131234', 2),
(15, 'adasdsad', 'saasasda', 1),
(16, 'drgdfdfgdfggf', 'sdfasfdadfasfd', 4);

