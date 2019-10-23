-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 23 oct. 2019 à 17:07
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanque_v4`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `nom`, `prenom`, `login`, `password`) VALUES
(12, 'GG', 'nabila', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`id`, `adresse`, `nom`) VALUES
(15, 'anfa', 'proxibanque');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `code` bigint(20) NOT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `code_postale` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `code_conseiller` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`code`, `adresse`, `code_postale`, `email`, `nom`, `prenom`, `ville`, `code_conseiller`) VALUES
(17, 'lol', '20220', 'chaij.abrak@gmail.com', 'Baaziz', 'Chaimaa', 'casablanca', NULL),
(21, 'lol', '20220', 'chaij.ba@gmail.com', 'Baaziz', 'Chaimaa', 'casablanca', NULL),
(28, 'lol', '20220', 'cha@gmail.com', 'Baaziz', 'Chaim', 'casablanca', 10);

-- --------------------------------------------------------

--
-- Structure de la table `compte_agence`
--

CREATE TABLE `compte_agence` (
  `num_compte` int(11) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `id_agence` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte_agence`
--

INSERT INTO `compte_agence` (`num_compte`, `date_creation`, `solde`, `id_agence`) VALUES
(0, NULL, 20, 15);

-- --------------------------------------------------------

--
-- Structure de la table `compte_courant`
--

CREATE TABLE `compte_courant` (
  `num_compte` int(11) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `decouvert` double NOT NULL,
  `code_client` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte_courant`
--

INSERT INTO `compte_courant` (`num_compte`, `date_creation`, `solde`, `decouvert`, `code_client`) VALUES
(18, '2019-10-23 13:42:55', 1600, 1000, 17),
(22, '2019-10-23 13:52:59', 20220, 1000, 21),
(29, '2019-10-23 14:04:33', 2000, 1000, 28);

-- --------------------------------------------------------

--
-- Structure de la table `compte_epargne`
--

CREATE TABLE `compte_epargne` (
  `num_compte` int(11) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `taux_remuneration` double NOT NULL,
  `code_client` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte_epargne`
--

INSERT INTO `compte_epargne` (`num_compte`, `date_creation`, `solde`, `taux_remuneration`, `code_client`) VALUES
(19, '2019-10-23 13:42:55', 20300, 0.03, 17),
(23, '2019-10-23 13:52:59', 20220, 0.03, 21),
(30, '2019-10-23 14:04:33', 20220, 0.03, 28);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `code_gerant` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `conseiller`
--

INSERT INTO `conseiller` (`id`, `nom`, `prenom`, `login`, `password`, `code_gerant`) VALUES
(10, 'bb', 'chaimaa', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `gerant`
--

CREATE TABLE `gerant` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_agence` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `gerant`
--

INSERT INTO `gerant` (`id`, `nom`, `prenom`, `login`, `password`, `id_agence`) VALUES
(0, 'BAAZIZ', 'chaimaa', NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(37),
(37),
(37),
(37),
(37),
(37),
(37);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `dtype` varchar(31) NOT NULL,
  `numero` bigint(20) NOT NULL,
  `date_op` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `code_cpt` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`dtype`, `numero`, `date_op`, `montant`, `code_cpt`) VALUES
('R', 20, '2019-10-23 13:50:21', 100, 18),
('R', 24, '2019-10-23 13:55:39', 100, 18),
('R', 25, '2019-10-23 13:57:51', 100, 18),
('R', 26, '2019-10-23 13:59:44', 100, 18),
('V', 27, '2019-10-23 13:59:45', 100, 19);

-- --------------------------------------------------------

--
-- Structure de la table `parametrage`
--

CREATE TABLE `parametrage` (
  `id` bigint(20) NOT NULL,
  `commission` double NOT NULL,
  `graphe` varchar(255) DEFAULT NULL,
  `nombre_max_client` int(11) NOT NULL,
  `nombre_max_conseiller` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `parametrage`
--

INSERT INTO `parametrage` (`id`, `commission`, `graphe`, `nombre_max_client`, `nombre_max_conseiller`) VALUES
(0, 0.2, '0', 5, 5);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `permissions` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `employe_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `permissions`, `roles`, `username`, `employe_id`) VALUES
(9, 1, '$2a$10$qqu/t5qfQRrh4xunxKvTbOb6EUs6Z8li.C/R63BrsCnUFDVPLHvkK', '', 'CONSEILLER', 'chaimaa', 10),
(11, 1, '$2a$10$rjO6pLoN5.TOuEULveF79ebNVLctoWwa5QuOS.HtmHF7ztE78p87C', '', 'Moderateur', 'nabila', 12),
(13, 1, '$2a$10$G6aYX.hJGjgmrJoyr.tYdeB/joSwfFU.uWjbWEWdKOPKHU2VkGhBu', '', 'GERANT', 'fatiz', 14);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UKbfgjs3fem0hmjhvih80158x29` (`email`),
  ADD KEY `FKqdoh19y3yb6anpi45kk96n4kh` (`code_conseiller`);

--
-- Index pour la table `compte_agence`
--
ALTER TABLE `compte_agence`
  ADD PRIMARY KEY (`num_compte`),
  ADD KEY `FK8v7flcvt3hc0cjvsw1bfsu0ei` (`id_agence`);

--
-- Index pour la table `compte_courant`
--
ALTER TABLE `compte_courant`
  ADD PRIMARY KEY (`num_compte`),
  ADD KEY `FK69ai9u2odhpcvgebjfg3lgug6` (`code_client`);

--
-- Index pour la table `compte_epargne`
--
ALTER TABLE `compte_epargne`
  ADD PRIMARY KEY (`num_compte`),
  ADD KEY `FKd7dsjoh55u1x2hoe2xynvhl43` (`code_client`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcb6sy4kbr0pbqny47vbh2l228` (`code_gerant`);

--
-- Index pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4vbpv546e9oikhpxkx7xaonjs` (`id_agence`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`numero`);

--
-- Index pour la table `parametrage`
--
ALTER TABLE `parametrage`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKqdoh19y3yb6anpi45kk96n4kh` FOREIGN KEY (`code_conseiller`) REFERENCES `conseiller` (`id`);

--
-- Contraintes pour la table `compte_agence`
--
ALTER TABLE `compte_agence`
  ADD CONSTRAINT `FK8v7flcvt3hc0cjvsw1bfsu0ei` FOREIGN KEY (`id_agence`) REFERENCES `agence` (`id`);

--
-- Contraintes pour la table `compte_courant`
--
ALTER TABLE `compte_courant`
  ADD CONSTRAINT `FK69ai9u2odhpcvgebjfg3lgug6` FOREIGN KEY (`code_client`) REFERENCES `client` (`code`);

--
-- Contraintes pour la table `compte_epargne`
--
ALTER TABLE `compte_epargne`
  ADD CONSTRAINT `FKd7dsjoh55u1x2hoe2xynvhl43` FOREIGN KEY (`code_client`) REFERENCES `client` (`code`);

--
-- Contraintes pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD CONSTRAINT `FKcb6sy4kbr0pbqny47vbh2l228` FOREIGN KEY (`code_gerant`) REFERENCES `gerant` (`id`);

--
-- Contraintes pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD CONSTRAINT `FK4vbpv546e9oikhpxkx7xaonjs` FOREIGN KEY (`id_agence`) REFERENCES `agence` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
