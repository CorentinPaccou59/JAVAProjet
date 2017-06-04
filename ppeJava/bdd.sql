-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:8889
-- Généré le :  Lun 27 Mars 2017 à 15:18
-- Version du serveur :  5.6.35
-- Version de PHP :  7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `ppeJava`
--

-- --------------------------------------------------------

--
-- Structure de la table `Commande`
--

CREATE TABLE `Commande` (
  `idCommande` int(11) NOT NULL,
  `quantiteCommande` int(11) NOT NULL,
  `conditionnementCommande` varchar(200) NOT NULL,
  `dateConditionnementCommande` date NOT NULL,
  `dateEnvoiCommande` date NOT NULL,
  `idProduit` varchar(11) NOT NULL,
  `idDistributeur` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Commande`
--

INSERT INTO `Commande` (`idCommande`, `quantiteCommande`, `conditionnementCommande`, `dateConditionnementCommande`, `dateEnvoiCommande`, `idProduit`, `idDistributeur`) VALUES
(1, 1, 'de tout', '2017-03-27', '2017-03-30', '01', 'd1');

-- --------------------------------------------------------

--
-- Structure de la table `Distributeur`
--

CREATE TABLE `Distributeur` (
  `idDistributeur` varchar(40) NOT NULL,
  `nomDistributeur` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Distributeur`
--

INSERT INTO `Distributeur` (`idDistributeur`, `nomDistributeur`) VALUES
('d1', 'Distributeur1');

-- --------------------------------------------------------

--
-- Structure de la table `Produit`
--

CREATE TABLE `Produit` (
  `idProduit` varchar(11) NOT NULL,
  `varieteProduit` varchar(500) NOT NULL,
  `typeProduit` varchar(500) NOT NULL,
  `calibreProduit` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Produit`
--

INSERT INTO `Produit` (`idProduit`, `varieteProduit`, `typeProduit`, `calibreProduit`) VALUES
('01', 'Française', 'noix', 10),
('02', 'Espagnol', 'noix', 20),
('03', 'Allemande', 'noix', 30),
('04', 'Anglaise', 'noix', 40),
('05', 'Congolaise', 'noix', 50);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Commande`
--
ALTER TABLE `Commande`
  ADD PRIMARY KEY (`idCommande`),
  ADD UNIQUE KEY `idDistributeur` (`idDistributeur`),
  ADD KEY `idProduit` (`idProduit`),
  ADD KEY `idProduit_2` (`idProduit`);

--
-- Index pour la table `Distributeur`
--
ALTER TABLE `Distributeur`
  ADD PRIMARY KEY (`idDistributeur`);

--
-- Index pour la table `Produit`
--
ALTER TABLE `Produit`
  ADD PRIMARY KEY (`idProduit`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Commande`
--
ALTER TABLE `Commande`
  MODIFY `idCommande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Commande`
--
ALTER TABLE `Commande`
  ADD CONSTRAINT `versDistributeur` FOREIGN KEY (`idDistributeur`) REFERENCES `Distributeur` (`idDistributeur`),
  ADD CONSTRAINT `versProduit` FOREIGN KEY (`idProduit`) REFERENCES `Produit` (`idProduit`);
