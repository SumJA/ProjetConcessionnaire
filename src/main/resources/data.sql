-- -----------------------------------------------------
-- Data for table `voitures`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `voitures`;

INSERT INTO `voitures`.`role` (`id`, `nom`) VALUES (1, 'admin');
INSERT INTO `voitures`.`role` (`id`, `nom`) VALUES (2, 'magasinier');
INSERT INTO `voitures`.`role` (`id`, `nom`) VALUES (3, 'commercial');

COMMIT;


-- -----------------------------------------------------
-- Data for table `voitures`.`status`
-- -----------------------------------------------------
START TRANSACTION;
USE `voitures`;

INSERT INTO `voitures`.`status` (`id`, `nom`) VALUES (1, 'commande livre');
INSERT INTO `voitures`.`status` (`id`, `nom`) VALUES (2, 'commande recue');
INSERT INTO `voitures`.`status` (`id`, `nom`) VALUES (3, 'commande annulee');
INSERT INTO `voitures`.`status` (`id`, `nom`) VALUES (4, 'devis valide');
INSERT INTO `voitures`.`status` (`id`, `nom`) VALUES (5, 'devis annule');
INSERT INTO `voitures`.`status` (`id`, `nom`) VALUES (6, 'devis en cours');

COMMIT;