DROP TABLE IF EXISTS `findmycity`.`category`;
CREATE TABLE  `findmycity`.`category` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESC` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`comments`;
CREATE TABLE  `findmycity`.`comments` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ENTITY_ID` int(10) unsigned NOT NULL,
  `ENTITY_TYPE_ID` int(10) unsigned NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `COMMENT` varchar(2000) NOT NULL,
  `RATINGS` int(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`)
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
  CONSTRAINT `FK_delivery_1` FOREIGN KEY (`RESTAURENT_ID`) REFERENCES `restaurent` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`entity_type`;
CREATE TABLE  `findmycity`.`entity_type` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_item`;
CREATE TABLE  `findmycity`.`menu_item` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_item_add_on`;
CREATE TABLE  `findmycity`.`menu_item_add_on` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_item_add_on_mapping`;
CREATE TABLE  `findmycity`.`menu_item_add_on_mapping` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MENU_ITEM_ADD_ON_ID` int(10) unsigned NOT NULL,
  `MENU_ITEM_MAPPING_ID` int(10) unsigned NOT NULL,
  `PRICE` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_menu_item_add_on_mapping_1` (`MENU_ITEM_ADD_ON_ID`),
  KEY `FK_menu_item_add_on_mapping_2` (`MENU_ITEM_MAPPING_ID`),
  CONSTRAINT `FK_menu_item_add_on_mapping_2` FOREIGN KEY (`MENU_ITEM_MAPPING_ID`) REFERENCES `menu_item_mapping` (`ID`),
  CONSTRAINT `FK_menu_item_add_on_mapping_1` FOREIGN KEY (`MENU_ITEM_ADD_ON_ID`) REFERENCES `menu_item_add_on` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_item_mapping`;
CREATE TABLE  `findmycity`.`menu_item_mapping` (
  `MENU_ITEM_ID` int(10) unsigned NOT NULL,
  `RESTAURENT_MENU_ID` int(10) unsigned NOT NULL,
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PRICE` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_menu_item_mapping_1` (`MENU_ITEM_ID`),
  KEY `FK_menu_item_mapping_2` (`RESTAURENT_MENU_ID`),
  CONSTRAINT `FK_menu_item_mapping_2` FOREIGN KEY (`RESTAURENT_MENU_ID`) REFERENCES `restaurent_menu` (`ID`),
  CONSTRAINT `FK_menu_item_mapping_1` FOREIGN KEY (`MENU_ITEM_ID`) REFERENCES `menu_item` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_serving_time`;
CREATE TABLE  `findmycity`.`menu_serving_time` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`menu_type`;
CREATE TABLE  `findmycity`.`menu_type` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `MENU_SERVING_TIME_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_menu_type_1` (`MENU_SERVING_TIME_ID`),
  CONSTRAINT `FK_menu_type_1` FOREIGN KEY (`MENU_SERVING_TIME_ID`) REFERENCES `menu_serving_time` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

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
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CODE` varchar(10) NOT NULL,
  `NAME` varchar(10) NOT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `PHOTO_ID` int(10) unsigned DEFAULT NULL,
  `IS_ACTIVE` varchar(1) DEFAULT NULL,
  `DELIVERY_FLAG` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_restaurent_photo` (`PHOTO_ID`),
  CONSTRAINT `FK_restaurent_photo` FOREIGN KEY (`PHOTO_ID`) REFERENCES `photo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`restaurent_category`;
CREATE TABLE  `findmycity`.`restaurent_category` (
  `RESTAURENT_ID` int(10) unsigned NOT NULL,
  `CATEGORY_ID` int(10) unsigned NOT NULL,
  KEY `FK_restaurent_category_1` (`RESTAURENT_ID`),
  KEY `FK_restaurent_category_2` (`CATEGORY_ID`),
  CONSTRAINT `FK_restaurent_category_1` FOREIGN KEY (`RESTAURENT_ID`) REFERENCES `restaurent` (`ID`),
  CONSTRAINT `FK_restaurent_category_2` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `findmycity`.`restaurent_menu`;
CREATE TABLE  `findmycity`.`restaurent_menu` (
  `RESTAURENT_ID` int(10) unsigned NOT NULL,
  `MENU_TYPE_ID` int(10) unsigned NOT NULL,
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_restaurent_menu_1` (`RESTAURENT_ID`),
  KEY `FK_restaurent_menu_2` (`MENU_TYPE_ID`),
  CONSTRAINT `FK_restaurent_menu_1` FOREIGN KEY (`RESTAURENT_ID`) REFERENCES `restaurent` (`ID`),
  CONSTRAINT `FK_restaurent_menu_2` FOREIGN KEY (`MENU_TYPE_ID`) REFERENCES `menu_type` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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