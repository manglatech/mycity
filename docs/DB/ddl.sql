CREATE DATABASE `findmycity` /*!40100 DEFAULT CHARACTER SET latin1 */;
DROP TABLE IF EXISTS `findmycity`.`category`;
CREATE TABLE  `findmycity`.`category` (
  `CATEGORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESC` varchar(45) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`delivery`;
CREATE TABLE  `findmycity`.`delivery` (
  `RESTAURENT_ID` int(10) unsigned NOT NULL,
  `MIN_TIME` int(10) unsigned DEFAULT NULL,
  `MAX_TIME` int(10) unsigned DEFAULT NULL,
  `MIN_AMOUNT` int(10) unsigned DEFAULT NULL,
  `MAX_AMOUNT` int(10) unsigned DEFAULT NULL,
  `CHARGE` int(10) unsigned DEFAULT NULL,
  `TO_TIME` varchar(4) DEFAULT NULL,
  `FROM_TIME` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`RESTAURENT_ID`),
  CONSTRAINT `FK_delivery_1` FOREIGN KEY (`RESTAURENT_ID`) REFERENCES `restaurent` (`RESTAURENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`ingredients`;
CREATE TABLE  `findmycity`.`ingredients` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_category`;
CREATE TABLE  `findmycity`.`menu_category` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_item`;
CREATE TABLE  `findmycity`.`menu_item` (
  `RESTAURENT_ID` int(10) unsigned NOT NULL,
  `MENU_ITEM_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ITEM_NAME` varchar(45) NOT NULL,
  `ITEM_DESC` varchar(255) DEFAULT NULL,
  `MENU_CATEGORY_ID` int(10) unsigned DEFAULT NULL,
  `PRICE` int(10) unsigned NOT NULL,
  PRIMARY KEY (`MENU_ITEM_ID`) USING BTREE,
  KEY `FK_menu_item_1` (`MENU_CATEGORY_ID`),
  KEY `FK_menu_item_2` (`RESTAURENT_ID`),
  CONSTRAINT `FK_menu_item_1` FOREIGN KEY (`MENU_CATEGORY_ID`) REFERENCES `menu_category` (`ID`),
  CONSTRAINT `FK_menu_item_2` FOREIGN KEY (`RESTAURENT_ID`) REFERENCES `restaurent` (`RESTAURENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_item_ingredients`;
CREATE TABLE  `findmycity`.`menu_item_ingredients` (
  `INGREDIENT_ID` int(10) unsigned NOT NULL,
  `MENU_ITEM_ID` int(10) unsigned NOT NULL,
  KEY `FK_menu_item_ingredients_2` (`INGREDIENT_ID`),
  KEY `FK_menu_item_ingredients_1` (`MENU_ITEM_ID`),
  CONSTRAINT `FK_menu_item_ingredients_1` FOREIGN KEY (`MENU_ITEM_ID`) REFERENCES `menu_item` (`MENU_ITEM_ID`),
  CONSTRAINT `FK_menu_item_ingredients_2` FOREIGN KEY (`INGREDIENT_ID`) REFERENCES `ingredients` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`photo`;
CREATE TABLE  `findmycity`.`photo` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(26) DEFAULT NULL,
  `DESC` varchar(100) DEFAULT NULL,
  `LOCATION` varchar(256) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`restaurent`;
CREATE TABLE  `findmycity`.`restaurent` (
  `RESTAURENT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CODE` varchar(10) NOT NULL,
  `NAME` varchar(10) NOT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `PHOTO_ID` int(10) unsigned DEFAULT NULL,
  `IS_ACTIVE` varchar(1) DEFAULT NULL,
  `DELIVERY_FLAG` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`RESTAURENT_ID`) USING BTREE,
  KEY `FK_restaurent_photo` (`PHOTO_ID`),
  CONSTRAINT `FK_restaurent_photo` FOREIGN KEY (`PHOTO_ID`) REFERENCES `photo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`restaurent_category`;
CREATE TABLE  `findmycity`.`restaurent_category` (
  `RESTAURENT_ID` int(10) unsigned NOT NULL,
  `CATEGORY_ID` int(10) unsigned NOT NULL,
  KEY `FK_restaurent_category_1` (`CATEGORY_ID`),
  KEY `FK_restaurent_category_2` (`RESTAURENT_ID`),
  CONSTRAINT `FK_restaurent_category_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`),
  CONSTRAINT `FK_restaurent_category_2` FOREIGN KEY (`RESTAURENT_ID`) REFERENCES `restaurent` (`RESTAURENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`role`;
CREATE TABLE  `findmycity`.`role` (
  `role_name` varchar(26) NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`user`;
CREATE TABLE  `findmycity`.`user` (
  `emailAddress` varchar(256) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` varchar(1) NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`user_role`;
CREATE TABLE  `findmycity`.`user_role` (
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  KEY `Index_2` (`user_id`) USING BTREE,
  KEY `Index_1` (`role_id`) USING BTREE,
  CONSTRAINT `FK_user_role_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_user_role_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;