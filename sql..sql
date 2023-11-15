CREATE DATABASE `nongguindb`;
USE  `nongguindb`;
CREATE TABLE IF NOT EXISTS `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) NOT NULL,
  `userEmail` varchar(50) NOT NULL unique,
  `userPass` varchar(50) NOT NULL,
  `userPhone` varchar(30) NOT NULL,
  `userGender` varchar(10) NOT NULL,
  `userAddress` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS `courts`(
	`courtId` INT NOT NULL AUTO_INCREMENT,
    `courtName` VARCHAR(30) NOT NULL,
    `courtAddress` VARCHAR(100) NOT NULL,
    `courtTel` VARCHAR(50) NOT NULL,
    `courtDes` VARCHAR(100) NOT NULL,
    `courtCmatchsapacity` INT NOT NULL,
    PRIMARY KEY(`courtId`)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `matchs`(
	`matchId` int NOT NULL AUTO_INCREMENT,
    `matchDate` TIMESTAMP NOT NULL,
    `matchApplicantCnt` int DEFAULT 0,
    `matchLevel` VARCHAR(10) NOT NULL,
    `matchGender` VARCHAR(10) NOT NULL,
    `courtId` int NOT NULL,
    PRIMARY KEY(`matchId`),
    CONSTRAINT FOREIGN KEY (`courtId`) REFERENCES courts(`courtId`)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `payment`(
	`paymentId` INT NOT NULL AUTO_INCREMENT,
    `paymentAmount` INT NOT NULL,
	`paymentDate` TIMESTAMP DEFAULT (current_date),
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

CREATE TABLE IF NOT EXISTS `friend`(
	`friendId` INT NOT NULL AUTO_INCREMENT,
    `friendToUser` INT NOT NULL,
    `friendFromUser` INT NOT NULL,
    `friendIsFriend` BOOLEAN NOT NULL,
    PRIMARY KEY (`friendId`),
    CONSTRAINT FOREIGN KEY(`friendToUser`) REFERENCES users(`userId`)
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `nongguindb`.`users` (`userName`, `userEmail`, `userPass`, `userPhone`, `userGender`, `userAddress`)
						VALUES ('김중광', 'card0923@naver.com', '1234', '01011111111', 'm', '경기도 화성'),
							   ('김소광', 'card0924@naver.com', '1234', '01011111112', 'm', '태양계 화성'),
							   ('김대광', 'card0925@naver.com', '1234', '01011111112', 'm', '안드로메다');
						
INSERT INTO `nongguindb`.`courts` (`courtName`, `courtAddress`, `courtTel`, `courtDes`, `courtCapacity`) 
						VALUES ('삼성리틀썬더스 & 체대가자 강남점', '서울 강남구 선릉로 305 B2, B3호 ', '02-578-5550', '안녕하세요 ^_^\n\n삼성리틀썬더스 강남점 입니다 .\n\n많은 관심 부탁드립니다 :)', '10'),
							   ('유고걸', '서울 강남구 학동로56길 37 로웰빌딩 지하 1층', '1644-0659', '당신의 상상이 현실이 되는 공간, 유고걸입니다.  ', '12'),
							   ('인아우트', '서울 마포구 와우산로13길 6 지하1,2층 ', '070-4272-9044', '당신의 현실이 상상이 되는 공간, 인아우트입니다.  ', '10');
INSERT INTO `nongguindb`.`matchs` (`matchDate`, `matchApplicantCnt`, `matchLevel`, `matchGender`, `courtId`) 
								VALUES ('2023-11-15 09:00:00', '0', '1', 'both', '1'),
										('2023-11-15 12:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-15 15:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-15 18:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-16 09:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-16 12:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-16 15:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-16 18:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-17 09:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-17 12:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-17 15:00:00', '0', '1', 'both', '1'),
                                        ('2023-11-17 18:00:00', '0', '1', 'both', '1');
                                        
INSERT INTO `nongguindb`.`payment` (`paymentAmount`, `paymentDate`, `userId`, `matchId`) 
							VALUES ('10000', '2023-11-14 12:00:00', '1', '1'),
								   ('10000', '2023-11-14 12:10:00', '2', '1'),
                                   ('10000', '2023-11-14 12:20:00', '3', '1');
INSERT INTO `nongguindb`.`match_user` (`matchId`, `userId`)
							VALUES ('1', '1'),
                                   ('1', '2'),
                                   ('1', '3');
                                   
INSERT INTO `nongguindb`.`friend` (`friendToUser`, `friendFromUser`, `friendIsFriend`) 
							VALUES ('1', '2', true),
								   ('2', '1', false),
                                   ('2', '3', true),
                                   ('3', '2', true);


