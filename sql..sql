CREATE DATABASE `nongguindb`;

CREATE TABLE IF NOT EXISTS `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) NOT NULL,
  `userEmail` varchar(50) NOT NULL,
  `userPass` varchar(50) NOT NULL,
  `userPhone` varchar(30) NOT NULL,
  `userGender` varchar(10) NOT NULL,
  `userAddress` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `matchs`(
	`matchId` int NOT NULL AUTO_INCREMENT,
    `matchDate` DATE NOT NULL,
    `matchApplicantCnt` int DEFAULT 0,
    `matchLevel` VARCHAR(10) NOT NULL,
    `matchGender` VARCHAR(10) NOT NULL,
    `operationHourId` int NOT NULL,
    `courtId` int NOT NULL,
    PRIMARY KEY(`matchId`),
    CONSTRAINT FOREIGN KEY (`operationHourId`) REFERENCES operationHour(`operationHourId`),
    CONSTRAINT FOREIGN KEY (`courtId`) REFERENCES courts(`courtId`)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `operationHour`(
	`operationHourId` INT NOT NULL AUTO_INCREMENT,
    `operationHourStart` TIME NOT NULL,
    PRIMARY KEY(`operationHourId`)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `courts`(
	`courtId` INT NOT NULL AUTO_INCREMENT,
    `courtName` VARCHAR(30) NOT NULL,
    `courtAddress` VARCHAR(100) NOT NULL,
    `courtTel` VARCHAR(50) NOT NULL,
    `courtDes` VARCHAR(100) NOT NULL,
    `courtCapacity` INT NOT NULL,
    PRIMARY KEY(`courtId`)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `payment`(
	`paymentId` INT NOT NULL AUTO_INCREMENT,
    `paymentAmount` INT NOT NULL,
	`paymentDate` DATE DEFAULT (current_date),
    `userId` INT NOT NULL,
    `matchId` INT NOT NULL,
    PRIMARY KEY(`paymentId`),
    CONSTRAINT FOREIGN KEY(`userId`) REFERENCES users(`userId`),
    CONSTRAINT FOREIGN KEY(`matchId`) REFERENCES matchs(`matchId`)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `match_user`(
	`matchId` INT NOT NULL,
    `userId` INT NOT NULL,
    PRIMARY KEY(`matchId`,`userId`)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;