
-- ----------------------------
-- Table structure for health_level
-- ----------------------------
DROP TABLE IF EXISTS `health_level`;
CREATE TABLE `health_level` (
  `level_id` bigint(20) NOT NULL,
  `level_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for health_record
-- ----------------------------
DROP TABLE IF EXISTS `health_record`;
CREATE TABLE `health_record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `level_id` bigint(20) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for health_task
-- ----------------------------
DROP TABLE IF EXISTS `health_task`;
CREATE TABLE `health_task` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `record_id` bigint(20) NOT NULL,
  `task_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
