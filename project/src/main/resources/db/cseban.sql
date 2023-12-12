/*
 Navicat Premium Data Transfer

 Source Server         : database_system_homework
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : localhost:3306
 Source Schema         : cseban

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 11/12/2023 22:44:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for absent_request
-- ----------------------------
DROP TABLE IF EXISTS `absent_request`;
CREATE TABLE `absent_request`  (
  `request_id` int(11) NOT NULL,
  `starttime` datetime(0) NULL DEFAULT NULL,
  `endtime` datetime(0) NULL DEFAULT NULL,
  `course_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`request_id`) USING BTREE,
  CONSTRAINT `FK_Inheritance_1` FOREIGN KEY (`request_id`) REFERENCES `request` (`request_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '请假请求' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of absent_request
-- ----------------------------
INSERT INTO `absent_request` VALUES (1, NULL, NULL, NULL);
INSERT INTO `absent_request` VALUES (6, NULL, NULL, '数学');
INSERT INTO `absent_request` VALUES (7, '2023-12-11 00:00:00', '2023-12-11 00:00:00', '数学');
INSERT INTO `absent_request` VALUES (8, '2023-12-11 21:25:40', '2023-12-11 22:20:00', '数学');
INSERT INTO `absent_request` VALUES (9, '2023-12-11 21:25:40', '2023-12-11 22:20:00', '数学');
INSERT INTO `absent_request` VALUES (10, '2023-12-11 21:25:40', '2023-12-11 22:20:00', '数学');
INSERT INTO `absent_request` VALUES (11, '2023-12-11 21:25:40', '2023-12-11 22:20:00', '数学');
INSERT INTO `absent_request` VALUES (12, '2023-12-11 21:25:40', '2023-12-11 22:20:00', '数学');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专业，学院' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '计算机');

-- ----------------------------
-- Table structure for instructor
-- ----------------------------
DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor`  (
  `teacher_id` int(11) NOT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE,
  INDEX `FK_Relationship_8`(`dept_id`) USING BTREE,
  CONSTRAINT `FK_Inheritance_3` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of instructor
-- ----------------------------
INSERT INTO `instructor` VALUES (1111, 1);
INSERT INTO `instructor` VALUES (1113, 1);

-- ----------------------------
-- Table structure for leave_request
-- ----------------------------
DROP TABLE IF EXISTS `leave_request`;
CREATE TABLE `leave_request`  (
  `request_id` int(11) NOT NULL,
  `leaveTime` date NULL DEFAULT NULL,
  `returnTime` date NULL DEFAULT NULL,
  `destination` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`request_id`) USING BTREE,
  CONSTRAINT `FK_Inheritance_2` FOREIGN KEY (`request_id`) REFERENCES `request` (`request_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '离校请求' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leave_request
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NULL DEFAULT NULL,
  `notice_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE,
  INDEX `FK_Relationship_3`(`teacher_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, 1111, '我是高珺');
INSERT INTO `notice` VALUES (2, 1111, '我还是高珺');
INSERT INTO `notice` VALUES (3, 1113, '我是达尔汗');

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request`  (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NULL DEFAULT NULL,
  `student_id` int(11) NULL DEFAULT NULL,
  `information` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_agree` tinyint(1) NULL DEFAULT NULL,
  `refuse_information` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`request_id`) USING BTREE,
  INDEX `FK_Relationship_11`(`student_id`) USING BTREE,
  INDEX `FK_Relationship_9`(`teacher_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '请假请求' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of request
-- ----------------------------
INSERT INTO `request` VALUES (1, 1111, 34, '请假第一次', 0, NULL, 1);
INSERT INTO `request` VALUES (3, 1111, 34, '我要请假', 0, NULL, NULL);
INSERT INTO `request` VALUES (4, 1111, 34, '我要请假', 0, NULL, NULL);
INSERT INTO `request` VALUES (5, 1111, 34, '我要请假', 0, NULL, NULL);
INSERT INTO `request` VALUES (6, 1111, 34, '我要请假', 0, NULL, NULL);
INSERT INTO `request` VALUES (7, 1111, 34, '我要请假', 0, NULL, NULL);
INSERT INTO `request` VALUES (8, 1111, 34, '我要请假', 0, NULL, NULL);
INSERT INTO `request` VALUES (9, 1111, 34, '我要请假', 0, NULL, 1);
INSERT INTO `request` VALUES (10, 1111, 34, '我要请假', 0, NULL, 1);
INSERT INTO `request` VALUES (11, 1111, 34, '我要请假', -1, NULL, 1);
INSERT INTO `request` VALUES (12, 1111, 34, '我要请假', -1, NULL, 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NULL DEFAULT NULL,
  `student_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_class` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_grade` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `FK_Relationship_1`(`dept_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (34, 1, '甘雨', '04', '2021');

-- ----------------------------
-- Table structure for student_look_notice
-- ----------------------------
DROP TABLE IF EXISTS `student_look_notice`;
CREATE TABLE `student_look_notice`  (
  `notice_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `is_read` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`, `student_id`) USING BTREE,
  INDEX `FK_Relationship_6`(`student_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`notice_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_look_notice
-- ----------------------------
INSERT INTO `student_look_notice` VALUES (2, 34, 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NULL DEFAULT NULL,
  `teacher_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE,
  INDEX `FK_Relationship_2`(`dept_id`) USING BTREE,
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1114 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教工类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1111, 1, '高珺');
INSERT INTO `teacher` VALUES (1112, 1, '韩波');
INSERT INTO `teacher` VALUES (1113, 1, '达尔罕');

SET FOREIGN_KEY_CHECKS = 1;
