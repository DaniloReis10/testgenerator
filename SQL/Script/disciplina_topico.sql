SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `testgenerator`.`Disciplina` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DisciplinaNome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `testgenerator`.`Topico` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DisciplinaId` INT(11) NOT NULL,
  `TopicoNome` VARCHAR(255) NULL DEFAULT NULL,
  `CargaHoraria` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `DisciplinaTopicoPK_idx` (`DisciplinaId` ASC),
  CONSTRAINT `DisciplinaTopicoPK`
    FOREIGN KEY (`DisciplinaId`)
    REFERENCES `testgenerator`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
