-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 09-Maio-2023 às 17:22
-- Versão do servidor: 8.0.31
-- versão do PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dbuniversidade`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbaluno`
--

DROP TABLE IF EXISTS `tbaluno`;
CREATE TABLE IF NOT EXISTS `tbaluno` (
  `rgm` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `municipio` varchar(255) NOT NULL,
  `celular` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `dtanascimento` varchar(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`rgm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbaluno`
--

INSERT INTO `tbaluno` (`rgm`, `nome`, `cpf`, `endereco`, `uf`, `municipio`, `celular`, `dtanascimento`, `email`) VALUES
(123, 'Fp', '494.991.919-84', 'ewfewfwe', 'AP', 'efwwfwe', '(15)919949849', '04/01/2000', 'fe@2322');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcurso`
--

DROP TABLE IF EXISTS `tbcurso`;
CREATE TABLE IF NOT EXISTS `tbcurso` (
  `rgm` int NOT NULL,
  `curso` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `campus` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `periodo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`rgm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbcurso`
--

INSERT INTO `tbcurso` (`rgm`, `curso`, `campus`, `periodo`) VALUES
(123, 'Direito', 'Unicid - Carrao', 'Noturno');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbnota`
--

DROP TABLE IF EXISTS `tbnota`;
CREATE TABLE IF NOT EXISTS `tbnota` (
  `rgm` int NOT NULL,
  `semestre` varchar(10) NOT NULL,
  `disciplina` varchar(255) NOT NULL,
  `falta` int NOT NULL,
  `nota` varchar(3) NOT NULL,
  `rgmSemestreDisciplina` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`rgmSemestreDisciplina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbnota`
--

INSERT INTO `tbnota` (`rgm`, `semestre`, `disciplina`, `falta`, `nota`, `rgmSemestreDisciplina`) VALUES
(123, '1.2022', 'Direito Civil', 3, '3,0', '1231.2022Direito Civil'),
(123, '1.2022', 'Direito Trabalhista', 7, '3,5', '1231.2022Direito Trabalhista'),
(123, '1.2023', 'Direito Civil', 3, '8,0', '1231.2023Direito Civil'),
(123, '2.2022', 'Direito Civil', 3, '3,0', '1232.2022Direito Civil'),
(123, '2.2023', 'Direito Civil', 3, '7,5', '1232.2023Direito Civil');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
