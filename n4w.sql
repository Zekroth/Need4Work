-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Creato il: Apr 24, 2020 alle 08:45
-- Versione del server: 8.0.18
-- Versione PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `n4w`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `asta`
--

DROP TABLE IF EXISTS `asta`;
CREATE TABLE IF NOT EXISTS `asta` (
  `id_asta` int(11) NOT NULL AUTO_INCREMENT,
  `email_utente` varchar(300) NOT NULL,
  `data_inizio` datetime NOT NULL,
  `data_fine` datetime NOT NULL,
  `email_vincitore` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `prezzo_partenza` decimal(6,2) NOT NULL,
  `prezzo_chiusura` decimal(6,2) DEFAULT NULL,
  `titolo` varchar(100) NOT NULL,
  `commento` varchar(500) NOT NULL,
  `professione_richiesta` int(11) NOT NULL,
  PRIMARY KEY (`id_asta`),
  KEY `email_utente` (`email_utente`),
  KEY `email_vincitore` (`email_vincitore`),
  KEY `professione_richiesta` (`professione_richiesta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `asta`
--

INSERT INTO `asta` (`id_asta`, `email_utente`, `data_inizio`, `data_fine`, `email_vincitore`, `prezzo_partenza`, `prezzo_chiusura`, `titolo`, `commento`, `professione_richiesta`) VALUES
(1, 'edoardo.barchiesi@hotmail.it', '2020-04-24 00:00:00', '2020-04-24 00:00:00', NULL, '500.15', NULL, 'Creazione sito web', 'Ho bisogno di un programmatore che mi crei un sito web', 3),
(2, 'edoardo.barchiesi@hotmail.it', '2020-04-24 00:00:00', '2020-04-24 00:00:00', NULL, '500.16', NULL, 'Creazione sito web', 'Ho bisogno di un programmatore che mi crei un sito web', 3),
(3, 'edoardo.barchiesi@hotmail.it', '2020-04-24 00:00:00', '2020-04-25 00:00:00', NULL, '500.16', NULL, 'Creazione sito web', 'Ho bisogno di un programmatore che mi crei un sito web', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `lavoro`
--

DROP TABLE IF EXISTS `lavoro`;
CREATE TABLE IF NOT EXISTS `lavoro` (
  `id_lavoro` int(11) NOT NULL AUTO_INCREMENT,
  `id_asta` int(11) NOT NULL,
  `id_recensione` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_lavoro`),
  KEY `id_asta` (`id_asta`),
  KEY `id_recensione` (`id_recensione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `offerta`
--

DROP TABLE IF EXISTS `offerta`;
CREATE TABLE IF NOT EXISTS `offerta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_utente` varchar(300) NOT NULL,
  `id_asta` int(11) NOT NULL,
  `prezzo` decimal(6,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `email_utente` (`email_utente`),
  KEY `id_asta` (`id_asta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `professione`
--

DROP TABLE IF EXISTS `professione`;
CREATE TABLE IF NOT EXISTS `professione` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipologia` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `professione`
--

INSERT INTO `professione` (`id`, `tipologia`) VALUES
(1, 'Elettricista'),
(2, 'Idraulico'),
(3, 'Scimmia Programmatrice'),
(4, 'Gabriel');

-- --------------------------------------------------------

--
-- Struttura della tabella `professionista`
--

DROP TABLE IF EXISTS `professionista`;
CREATE TABLE IF NOT EXISTS `professionista` (
  `email_utente` varchar(300) NOT NULL,
  `id_professione` int(11) NOT NULL,
  PRIMARY KEY (`email_utente`,`id_professione`),
  UNIQUE KEY `id_professione` (`id_professione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `professionista`
--

INSERT INTO `professionista` (`email_utente`, `id_professione`) VALUES
('edoardo.barchiesi@hotmail.it', 2),
('edoardo.barchiesi@hotmail.it', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `recensione`
--

DROP TABLE IF EXISTS `recensione`;
CREATE TABLE IF NOT EXISTS `recensione` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commento` varchar(500) NOT NULL,
  `voto` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

DROP TABLE IF EXISTS `utente`;
CREATE TABLE IF NOT EXISTS `utente` (
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `data_nascita` date NOT NULL,
  `via` varchar(300) NOT NULL,
  `cap` int(5) NOT NULL,
  `paese` varchar(100) NOT NULL,
  `provincia` varchar(2) NOT NULL,
  `email` varchar(300) NOT NULL,
  `cellulare` varchar(10) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`nome`, `cognome`, `data_nascita`, `via`, `cap`, `paese`, `provincia`, `email`, `cellulare`, `password`) VALUES
('Edoardo', 'Barchiesi', '1998-12-14', 'via franchi maggi 4, Rozzano', 20089, 'Italia', 'MI', 'edoardo.barchiesi@hotmail.it', '3474295393', 'Edogaming98');

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `asta`
--
ALTER TABLE `asta`
  ADD CONSTRAINT `asta_ibfk_1` FOREIGN KEY (`email_utente`) REFERENCES `utente` (`email`) ON UPDATE CASCADE,
  ADD CONSTRAINT `asta_ibfk_2` FOREIGN KEY (`email_vincitore`) REFERENCES `utente` (`email`) ON UPDATE CASCADE,
  ADD CONSTRAINT `asta_ibfk_3` FOREIGN KEY (`professione_richiesta`) REFERENCES `professione` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Limiti per la tabella `lavoro`
--
ALTER TABLE `lavoro`
  ADD CONSTRAINT `lavoro_ibfk_1` FOREIGN KEY (`id_asta`) REFERENCES `asta` (`id_asta`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `lavoro_ibfk_2` FOREIGN KEY (`id_recensione`) REFERENCES `recensione` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limiti per la tabella `offerta`
--
ALTER TABLE `offerta`
  ADD CONSTRAINT `offerta_ibfk_1` FOREIGN KEY (`id_asta`) REFERENCES `asta` (`id_asta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `offerta_ibfk_2` FOREIGN KEY (`email_utente`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `professionista`
--
ALTER TABLE `professionista`
  ADD CONSTRAINT `professionista_ibfk_1` FOREIGN KEY (`email_utente`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `professionista_ibfk_2` FOREIGN KEY (`id_professione`) REFERENCES `professione` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
