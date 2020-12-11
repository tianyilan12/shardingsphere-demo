
-- ----------------------------
-- Table structure for encrypt_user
-- ----------------------------
DROP TABLE IF EXISTS `encrypt_user`;
CREATE TABLE `encrypt_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) DEFAULT NULL,
  `user_name_plain` varchar(200) DEFAULT NULL,
  `pwd` varchar(200) DEFAULT NULL,
  `assisted_query_pwd` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
