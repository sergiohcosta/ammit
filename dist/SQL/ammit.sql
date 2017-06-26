-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 26-Jun-2017 às 22:06
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
CREATE DATABASE IF NOT EXISTS `ammit` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ammit`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `casoteste`
--

DROP TABLE IF EXISTS `casoteste`;
CREATE TABLE `casoteste` (
  `id` int(11) NOT NULL,
  `ammit_seed` varchar(100) DEFAULT NULL,
  `ammit_qtde` int(11) DEFAULT NULL,
  `entrada` text,
  `saida` text,
  `codigofonte` longblob,
  `codigofonte_linguagem` varchar(10) DEFAULT NULL,
  `questao` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `conteudo` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `questao`
--

DROP TABLE IF EXISTS `questao`;
CREATE TABLE `questao` (
  `id` int(11) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `enunciado` text,
  `professor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Extraindo dados da tabela `questao`
--

INSERT INTO `questao` (`id`, `titulo`, `enunciado`, `professor`) VALUES
(1, 'Questão de teste 1 do professor 1', 'Esta questão foi cadastrada pelo Administrador para o Professor 1 com a finalidade de validar esse fluxo.', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `resposta`
--

DROP TABLE IF EXISTS `resposta`;
CREATE TABLE `resposta` (
  `id` int(11) NOT NULL,
  `aluno` int(11) NOT NULL,
  `questao` int(11) NOT NULL,
  `codfonte` longblob,
  `estado` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` blob NOT NULL,
  `salt` blob NOT NULL,
  `perfil` varchar(10) NOT NULL,
  `situacao` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `pwd`, `salt`, `perfil`, `situacao`) VALUES
(1, 'Administrador', 'admin', 0xf017bfcfc829dc305fcf808bd7568d20db8997bb, 0x745569d7660df30c, 'Admin', 1),
(2, 'Professor de Testes 1', 'prof1@prof1.com', 0x640dae1b22656ac15ef80b5bdbfc1a4ece877035, 0x5500562150d3a907, 'Professor', 1),
(3, 'Aluno de Testes 1', 'aluno1@aluno1.com', 0xfac95dd550705c39ff56c37e14e94e7b4d9bcc56, 0xaf6b98eca847e02e, 'Aluno', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `casoteste`
--
ALTER TABLE `casoteste`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_casoteste_questao1_idx` (`questao`);

--
-- Indexes for table `questao`
--
ALTER TABLE `questao`
  ADD PRIMARY KEY (`id`,`professor`),
  ADD KEY `fk_questao_usuario_idx` (`professor`);

--
-- Indexes for table `resposta`
--
ALTER TABLE `resposta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_resposta_aluno` (`aluno`),
  ADD KEY `fk_resposta_questao` (`questao`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `casoteste`
--
ALTER TABLE `casoteste`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `questao`
--
ALTER TABLE `questao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `resposta`
--
ALTER TABLE `resposta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `casoteste`
--
ALTER TABLE `casoteste`
  ADD CONSTRAINT `fk_casoteste_questao1` FOREIGN KEY (`questao`) REFERENCES `questao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `questao`
--
ALTER TABLE `questao`
  ADD CONSTRAINT `fk_questao_usuario` FOREIGN KEY (`professor`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `resposta`
--
ALTER TABLE `resposta`
  ADD CONSTRAINT `fk_resposta_aluno` FOREIGN KEY (`aluno`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_resposta_questao` FOREIGN KEY (`questao`) REFERENCES `questao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
