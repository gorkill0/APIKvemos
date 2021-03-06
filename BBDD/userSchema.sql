-- MySQL Script generated by MySQL Workbench
-- Tue Oct 13 14:28:19 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kvemos
-- -----------------------------------------------------
CREATE USER 'administrador' IDENTIFIED BY 'admin';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `kvemos`.* TO 'administrador';
CREATE USER 'registro' IDENTIFIED BY 'reg';

GRANT INSERT ON TABLE `kvemos`.`registrado` TO 'registro';
CREATE USER 'usuario' IDENTIFIED BY 'usuario';

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE `kvemos`.`puntuar` TO 'usuario';
GRANT UPDATE, SELECT, INSERT, DELETE ON TABLE `kvemos`.`guardar` TO 'usuario';
GRANT SELECT ON TABLE `kvemos`.`genero` TO 'usuario';
GRANT SELECT ON TABLE `kvemos`.`plataforma` TO 'usuario';
GRANT SELECT ON TABLE `kvemos`.`producto_audiovisual` TO 'usuario';
GRANT SELECT ON TABLE `kvemos`.`pelicula` TO 'usuario';
GRANT SELECT ON TABLE `kvemos`.`oferta` TO 'usuario';
GRANT SELECT ON TABLE `kvemos`.`documental` TO 'usuario';
GRANT SELECT ON TABLE `kvemos`.`serie` TO 'usuario';
GRANT SELECT, UPDATE ON TABLE `kvemos`.`usuario` TO 'usuario';
GRANT SELECT, UPDATE ON TABLE `kvemos`.`registrado` TO 'usuario';
GRANT SELECT ON TABLE `kvemos`.`pais` TO 'usuario';
CREATE USER 'superkvemos' IDENTIFIED BY 'kvemos';

GRANT ALL ON kvemos.* TO 'superkvemos';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
