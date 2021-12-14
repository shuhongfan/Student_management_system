/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : sms

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 14/12/2021 11:09:30
*/
CREATE DATABASE sms;
USE sms;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `classNO` bigint(20) NOT NULL AUTO_INCREMENT,
  `facultyNO` bigint(20) NULL DEFAULT NULL,
  `classSize` int(11) NULL DEFAULT NULL,
  `year` date NULL DEFAULT NULL,
  `counsellorNO` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`classNO`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 756 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 14, 60, '2021-09-01', 18);
INSERT INTO `class` VALUES (2, 14, 56, '2021-09-01', 18);
INSERT INTO `class` VALUES (322, 3, 34545, '2021-12-04', 17);
INSERT INTO `class` VALUES (755, 4, 63, '2021-04-01', 24);

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `classRoomNO` bigint(20) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NULL DEFAULT NULL,
  `isMultimedia` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `locationNo` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`classRoomNO`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1011 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (101, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (102, 40, 0, 1, 33);
INSERT INTO `classroom` VALUES (103, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (104, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (105, 120, 1, 0, 1);
INSERT INTO `classroom` VALUES (201, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (202, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (203, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (204, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (301, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (302, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (303, 60, 1, 0, 1);
INSERT INTO `classroom` VALUES (1010, 66, 1, 1, 32);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseID` bigint(20) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hour` int(11) NULL DEFAULT NULL,
  `credit` double NULL DEFAULT NULL,
  PRIMARY KEY (`courseID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '高级语言程序设计（Java）', 64, 3.5);
INSERT INTO `course` VALUES (2, 'JavaScript高级开发', 48, 2.5);
INSERT INTO `course` VALUES (3, 'JSP程序设计', 56, 3);
INSERT INTO `course` VALUES (4, 'VC++程序设计', 56, 3.5);
INSERT INTO `course` VALUES (5, 'Python程序设计', 40, 2);
INSERT INTO `course` VALUES (6, '计算机网络', 48, 3.5);
INSERT INTO `course` VALUES (7, 'IOS程序设计', 36, 2);
INSERT INTO `course` VALUES (8, '中国近现代史纲要', 32, 2);
INSERT INTO `course` VALUES (9, '数据库原理与技术', 60, 3.5);
INSERT INTO `course` VALUES (10, '心理健康教育', 40, 2);
INSERT INTO `course` VALUES (11, '思想道德修养与法律基础	', 40, 3);
INSERT INTO `course` VALUES (12, '毛泽东思想和中国特色社会主义理论体系概论	', 40, 4);
INSERT INTO `course` VALUES (13, '形势与政策	', 40, 1);
INSERT INTO `course` VALUES (14, '基础应用英语Ⅰ	', 40, 3.5);
INSERT INTO `course` VALUES (15, '基础应用英语Ⅱ	', 40, 3.5);
INSERT INTO `course` VALUES (16, '大学生职业发展与就业指导	', 20, 2);
INSERT INTO `course` VALUES (17, '体育Ⅰ	', 48, 2);
INSERT INTO `course` VALUES (18, '体育Ⅱ	', 48, 2);
INSERT INTO `course` VALUES (19, '高等数学(二)	', 48, 3.5);
INSERT INTO `course` VALUES (20, '军训与国防教育	', 60, 5);
INSERT INTO `course` VALUES (21, '操作系统（Linux）	', 60, 3);
INSERT INTO `course` VALUES (22, 'css+div网站标准化重构	', 54, 3);
INSERT INTO `course` VALUES (23, 'css+div网站标准化重构	', 54, 3);
INSERT INTO `course` VALUES (24, 'PHP程序设计	', 54, 3);
INSERT INTO `course` VALUES (25, '大型动态商业网站开发与运营实训	', 54, 3);
INSERT INTO `course` VALUES (26, '网页设计与网站建设	', 54, 3.5);
INSERT INTO `course` VALUES (27, '网页视觉设计	', 54, 3);
INSERT INTO `course` VALUES (28, '网站前端设计综合实训	', 30, 4);
INSERT INTO `course` VALUES (29, '数据库技术应用MySQL	', 54, 3);
INSERT INTO `course` VALUES (30, 'Javascript网站动态特效设计	', 54, 3);
INSERT INTO `course` VALUES (31, '用户体验设计	', 40, 3);
INSERT INTO `course` VALUES (32, 'Bootstrap UI框架技术	', 40, 3);
INSERT INTO `course` VALUES (33, 'VueJS框架开发	', 54, 4);
INSERT INTO `course` VALUES (34, '平面设计	', 40, 3);
INSERT INTO `course` VALUES (35, 'PHP网站内容管理系统应用与开发	', 40, 2);
INSERT INTO `course` VALUES (36, 'HTML 5	', 40, 2);
INSERT INTO `course` VALUES (37, '图像处理技术	', 40, 3);
INSERT INTO `course` VALUES (38, '图像处理课程设计	', 40, 3);
INSERT INTO `course` VALUES (39, '毕业设计	', 60, 20);
INSERT INTO `course` VALUES (40, 'Web前端框架技术	', 40, 3);
INSERT INTO `course` VALUES (41, 'Windows网络服务器搭建与维护	', 40, 3);
INSERT INTO `course` VALUES (55, '安卓开发', 50, 5);

-- ----------------------------
-- Table structure for curriculum
-- ----------------------------
DROP TABLE IF EXISTS `curriculum`;
CREATE TABLE `curriculum`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `courseNO` bigint(20) NULL DEFAULT NULL,
  `classNO` bigint(20) NULL DEFAULT NULL,
  `teacherID` bigint(20) NULL DEFAULT NULL,
  `schoolYear` int(11) NULL DEFAULT NULL,
  `term` int(11) NULL DEFAULT NULL,
  `startWeek` int(11) NULL DEFAULT NULL,
  `endWeek` int(11) NULL DEFAULT NULL,
  `weekday` int(11) NULL DEFAULT NULL,
  `section` int(11) NULL DEFAULT NULL,
  `locationNo` bigint(20) NULL DEFAULT NULL,
  `classRoomNO` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20210104 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of curriculum
-- ----------------------------
INSERT INTO `curriculum` VALUES (1, 1, 1, 13, 2021, 0, 1, 18, 1, 3, 1, 101);
INSERT INTO `curriculum` VALUES (2, 2, 1, 14, 2021, 0, 1, 18, 2, 5, 2, 202);
INSERT INTO `curriculum` VALUES (3, 3, 2, 15, 2021, 1, 1, 18, 4, 7, 1, 101);
INSERT INTO `curriculum` VALUES (4, 4, 1, 16, 2021, 0, 1, 18, 5, 6, 1, 301);
INSERT INTO `curriculum` VALUES (5, 5, 2, 17, 2021, 0, 1, 18, 2, 1, 1, 204);
INSERT INTO `curriculum` VALUES (11, 2, 1, 14, 2021, 0, 1, 18, 2, 6, 2, 202);
INSERT INTO `curriculum` VALUES (12, 3, 2, 15, 2021, 1, 1, 18, 4, 8, 1, 101);
INSERT INTO `curriculum` VALUES (13, 4, 1, 16, 2021, 0, 1, 18, 5, 5, 1, 301);
INSERT INTO `curriculum` VALUES (14, 5, 2, 17, 2021, 0, 1, 18, 2, 2, 1, 204);
INSERT INTO `curriculum` VALUES (15, 1, 1, 13, 2021, 0, 1, 18, 1, 4, 1, 101);
INSERT INTO `curriculum` VALUES (16, 2, 1, 14, 2018, 0, 1, 18, 2, 6, 2, 202);
INSERT INTO `curriculum` VALUES (17, 3, 2, 15, 2019, 0, 1, 18, 4, 8, 1, 101);
INSERT INTO `curriculum` VALUES (18, 4, 1, 16, 2033, 0, 1, 18, 5, 5, 1, 301);
INSERT INTO `curriculum` VALUES (19, 5, 2, 17, 2021, 0, 1, 18, 2, 2, 1, 204);
INSERT INTO `curriculum` VALUES (20, 1, 1, 13, 2020, 0, 1, 18, 1, 4, 1, 101);
INSERT INTO `curriculum` VALUES (100, 3, 1, 13, 2021, 0, 1, 18, 3, 5, 1, 101);
INSERT INTO `curriculum` VALUES (101, 3, 1, 13, 2021, 0, 1, 18, 3, 6, 1, 101);
INSERT INTO `curriculum` VALUES (102, 30, 1, 21, 2021, 0, 1, 20, 4, 1, 7, 203);
INSERT INTO `curriculum` VALUES (111, 7, 1, 17, 2021, 1, 5, 20, 1, 1, 2, 101);
INSERT INTO `curriculum` VALUES (112, 7, 1, 17, 2021, 1, 5, 20, 1, 2, 2, 101);
INSERT INTO `curriculum` VALUES (200, 6, 322, 18, 2021, 0, 1, 18, 1, 7, 1, 201);
INSERT INTO `curriculum` VALUES (5060, 40, 1, 12, 2021, 0, 5, 18, 6, 5, 22, 301);
INSERT INTO `curriculum` VALUES (20210103, 10, 1, 18, 2021, 0, 5, 18, 5, 3, 1, 302);

-- ----------------------------
-- Table structure for faculty
-- ----------------------------
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty`  (
  `facultyNO` bigint(20) NOT NULL AUTO_INCREMENT,
  `facultyName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`facultyNO`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of faculty
-- ----------------------------
INSERT INTO `faculty` VALUES (1, '外国语学院');
INSERT INTO `faculty` VALUES (2, '政治与法律学院');
INSERT INTO `faculty` VALUES (3, '马克思主义学院');
INSERT INTO `faculty` VALUES (4, '美术与设计学院');
INSERT INTO `faculty` VALUES (5, '经济与管理学院');
INSERT INTO `faculty` VALUES (6, '音乐学院');
INSERT INTO `faculty` VALUES (7, '教育与心理学院');
INSERT INTO `faculty` VALUES (8, '国际教育学院');
INSERT INTO `faculty` VALUES (9, '数学与统计学院');
INSERT INTO `faculty` VALUES (10, '物理与电子信息工程学院');
INSERT INTO `faculty` VALUES (11, '生命科学技术学院');
INSERT INTO `faculty` VALUES (12, '农学院');
INSERT INTO `faculty` VALUES (13, '机械工程学院');
INSERT INTO `faculty` VALUES (14, '计算机与信息科学学院');
INSERT INTO `faculty` VALUES (15, '土木工程学院');
INSERT INTO `faculty` VALUES (16, '建筑学院');
INSERT INTO `faculty` VALUES (100, '神学院');

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location`  (
  `locationNo` bigint(20) NOT NULL AUTO_INCREMENT,
  `locationName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`locationNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES (1, '教1楼');
INSERT INTO `location` VALUES (2, '教2楼');
INSERT INTO `location` VALUES (4, '教4楼');
INSERT INTO `location` VALUES (6, '计科楼');
INSERT INTO `location` VALUES (7, '经法楼');
INSERT INTO `location` VALUES (8, '体育馆');
INSERT INTO `location` VALUES (22, '凌峰楼');
INSERT INTO `location` VALUES (32, '德育楼');
INSERT INTO `location` VALUES (33, '计科楼');
INSERT INTO `location` VALUES (34, '明德楼');
INSERT INTO `location` VALUES (55, '旅游学院');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `facultyNO` bigint(20) NULL DEFAULT NULL,
  `classNO` bigint(20) NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`studentID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1913013 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (191301, '王林1', '2010-12-31', 14, 1, '湖北省武汉市', '1343888888', '提前修完“数据结构“4334', 0);
INSERT INTO `student` VALUES (191302, '程明    ', '1996-02-01', 14, 2, '湖北省武汉市', '13437777777', '班长', 1);
INSERT INTO `student` VALUES (191303, '王燕    ', '1994-10-06', 14, 2, '湖北省武汉市', '13437777777', '三好生', 0);
INSERT INTO `student` VALUES (191304, '韦严平  ', '1995-08-26', 5, 1, '湖北省武汉市', '13437777777', 'C++语言不及格，待补考', 1);
INSERT INTO `student` VALUES (191306, '李方方  ', '1995-11-20', 14, 2, '湖北省武汉市', '13437777777', 'C++语言不及格，待补考', 1);
INSERT INTO `student` VALUES (191307, '李明    ', '1995-05-01', 14, 1, '湖北省武汉市', '13437777777', '三好生', 1);
INSERT INTO `student` VALUES (191308, '林一帆  ', '1994-08-05', 14, 2, '湖北省武汉市', '13437777777', '准备转专业学习', 1);
INSERT INTO `student` VALUES (191309, '张强民  ', '1994-08-11', 14, 1, '湖北省武汉市', '13437777777', '准备转专业学习', 1);
INSERT INTO `student` VALUES (191310, '张蔚    ', '1996-07-22', 14, 2, '湖北省武汉市', '13437777777', NULL, 0);
INSERT INTO `student` VALUES (191311, '赵琳    ', '1995-03-18', 14, 1, '湖北省武汉市', '13437777777', NULL, 0);
INSERT INTO `student` VALUES (191313, '严红    ', '1994-08-11', 14, 2, '湖北省宜昌市', '13437777777', NULL, 0);
INSERT INTO `student` VALUES (191314, '张思思  ', '1995-01-30', 14, 2, '湖北省武汉市', '13437777777', NULL, 0);
INSERT INTO `student` VALUES (221301, '王敏    ', '1994-06-10', 14, 1, '湖北省武汉市', '13437777777', NULL, 1);
INSERT INTO `student` VALUES (221302, '王林    ', '1994-01-29', 14, 2, '湖北省武汉市', '13437777777', NULL, 1);
INSERT INTO `student` VALUES (221303, '王玉民  ', '1995-03-26', 14, 1, '湖北省武汉市', '13437777777', NULL, 1);
INSERT INTO `student` VALUES (221304, '马琳琳  ', '1995-02-10', 14, 1, '湖北省武汉市', '13437777777', NULL, 0);
INSERT INTO `student` VALUES (221306, '李计    ', '1995-09-20', 14, 2, '湖北省武汉市', '13437777777', NULL, 1);
INSERT INTO `student` VALUES (221310, '李红庆  ', '1994-05-01', 14, 2, '湖北省孝感市', '13437777777', NULL, 1);
INSERT INTO `student` VALUES (221316, '孙祥欣  ', '1994-03-19', 14, 1, '湖北省武汉市', '13437777777', NULL, 1);
INSERT INTO `student` VALUES (221318, '孙研    ', '1995-10-09', 14, 1, '湖北省武汉市', '13437777777', NULL, 1);
INSERT INTO `student` VALUES (221320, '吴薇32华  ', '1995-03-22', 6, 1, '湖北省武汉市32', '13437773223', '3232', 0);
INSERT INTO `student` VALUES (221321, '刘燕敏  ', '1994-11-12', 14, 1, '湖北省武汉市', '13437777777', NULL, 0);
INSERT INTO `student` VALUES (221341, '罗林琳  ', '1995-01-30', 14, 1, '湖北省武汉市', '13437777777', NULL, 0);
INSERT INTO `student` VALUES (221343, '王五1', '2021-12-01', 4, 2, '北京', '1343444444', '3232fgregre', 0);
INSERT INTO `student` VALUES (1913012, '哇哈哈', '2021-12-03', 100, 1, '武汉职业技术学院', '1343333333', '武汉职业技术学院结业', 0);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacherID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `facultyNO` bigint(20) NULL DEFAULT NULL,
  `speciality` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacherID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (12, '舒洪凡', 100, '神学', '教室');
INSERT INTO `teacher` VALUES (13, '郑艳君', 14, '计算机java', '讲师');
INSERT INTO `teacher` VALUES (14, '黄兰英呃42342', 2, '法律', '无');
INSERT INTO `teacher` VALUES (15, '夏建勋', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (16, '陈国志', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (17, '张学敏', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (18, '熊曾刚', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (19, '焦家林', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (20, '李兵园432', 3, '计算机32423', '讲师3232');
INSERT INTO `teacher` VALUES (21, '梁其洋', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (22, '阚远亮', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (23, '余雷', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (24, '李纪平', 14, '计算机', '讲师');
INSERT INTO `teacher` VALUES (25, '王五', 3, '毛泽东', '教授');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(11) NOT NULL,
  `disabled` int(11) NULL DEFAULT 0,
  `contrastStudentID` int(11) NULL DEFAULT NULL,
  `contrastTeacherID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'tom', 'tom', 0, 0, 191301, NULL);
INSERT INTO `user` VALUES (4, 'shf', 'shf', 2, 0, NULL, NULL);
INSERT INTO `user` VALUES (5, 'zhangsan', 'zhangsan', 2, 0, NULL, NULL);
INSERT INTO `user` VALUES (8, 'abc', 'abc', 0, 0, 191302, NULL);
INSERT INTO `user` VALUES (9, 'lisi', 'lisi', 0, 0, 191303, NULL);
INSERT INTO `user` VALUES (11, 'class', 'class', 1, 0, NULL, 13);
INSERT INTO `user` VALUES (12, 'zhangsan3333333', '123456', 1, 1, NULL, 13);
INSERT INTO `user` VALUES (13, 'superbaby1', 'superbaby1', 0, 0, 191304, NULL);
INSERT INTO `user` VALUES (14, 'superbaby2', 'superbaby2', 0, 0, 191306, NULL);
INSERT INTO `user` VALUES (15, 'zhangsan', 'zhangsan', 1, 0, NULL, 14);
INSERT INTO `user` VALUES (18, 'zhangsan232', 'zhangsan232', 0, 0, 191307, NULL);
INSERT INTO `user` VALUES (19, 'zhangsan', '32', 0, 0, 191308, NULL);
INSERT INTO `user` VALUES (21, 'hahah', 'hahah', 0, 0, 191309, NULL);
INSERT INTO `user` VALUES (24, 'zhangsan324', '12345', 0, 0, 191310, NULL);
INSERT INTO `user` VALUES (25, 'jcbb', 'jcbb', 2, 0, NULL, NULL);
INSERT INTO `user` VALUES (26, 'xuesheng1', 'xs11', 0, 1, 191301, NULL);
INSERT INTO `user` VALUES (27, 'xue1', 'xue1', 0, 0, 191301, NULL);
INSERT INTO `user` VALUES (28, 'laosi1', 'laosi1', 1, 0, NULL, 12);

SET FOREIGN_KEY_CHECKS = 1;
