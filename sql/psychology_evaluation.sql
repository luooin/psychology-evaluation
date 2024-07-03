/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : psychology_evaluation

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 03/07/2024 23:25:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/1713406015779.jpg');
INSERT INTO `config` VALUES (2, 'picture2', 'upload/1713405999433.jpg');
INSERT INTO `config` VALUES (3, 'picture3', 'upload/1713405980903.jpg');

-- ----------------------------
-- Table structure for exampaper
-- ----------------------------
DROP TABLE IF EXISTS `exampaper`;
CREATE TABLE `exampaper`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试卷名称',
  `time` int(0) NOT NULL COMMENT '心理测试时长(分钟)',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '试卷状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1673753357466 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试卷表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exampaper
-- ----------------------------
INSERT INTO `exampaper` VALUES (1, '2023-01-15 10:56:39', '压力测试', 60, 1);
INSERT INTO `exampaper` VALUES (1673753357465, '2023-01-15 11:29:16', '心理健康测试', 60, 1);

-- ----------------------------
-- Table structure for examquestion
-- ----------------------------
DROP TABLE IF EXISTS `examquestion`;
CREATE TABLE `examquestion`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `paperid` bigint(0) NOT NULL COMMENT '所属试卷id（外键）',
  `papername` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试卷名称',
  `questionname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试题名称',
  `options` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '选项，json字符串',
  `score` bigint(0) NULL DEFAULT 0 COMMENT '分值',
  `answer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '答案解析',
  `type` bigint(0) NULL DEFAULT 0 COMMENT '试题类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空）',
  `sequence` bigint(0) NULL DEFAULT 100 COMMENT '试题排序，值越大排越前面',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1673753468005 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examquestion
-- ----------------------------
INSERT INTO `examquestion` VALUES (1673753403851, '2023-01-15 11:30:02', 1673753357465, '心理健康测试', '输入试题内容', '[{\"text\":\"A.11\",\"code\":\"A\"},{\"text\":\"B.22\",\"code\":\"B\"},{\"text\":\"C.33\",\"code\":\"C\"},{\"text\":\"D.44\",\"code\":\"D\"}]', 10, 'A', '输入答案分析内容', 0, 1);
INSERT INTO `examquestion` VALUES (1673753444569, '2023-01-15 11:30:44', 1673753357465, '心理健康测试', '试题', '[{\"text\":\"A.kl\",\"code\":\"A\"},{\"text\":\"B.dgag\",\"code\":\"B\"},{\"text\":\"C.srer\",\"code\":\"C\"},{\"text\":\"D.fhfhsfdh\",\"code\":\"D\"}]', 10, 'A,B', '分析', 1, 2);
INSERT INTO `examquestion` VALUES (1673753468004, '2023-01-15 11:31:07', 1673753357465, '心理健康测试', '试题3', '[{\"text\":\"A.对\",\"code\":\"A\"},{\"text\":\"B.错\",\"code\":\"B\"}]', 10, 'A', '分析2', 2, 3);

-- ----------------------------
-- Table structure for examrecord
-- ----------------------------
DROP TABLE IF EXISTS `examrecord`;
CREATE TABLE `examrecord`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `userid` bigint(0) NOT NULL COMMENT '用户id',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `paperid` bigint(0) NOT NULL COMMENT '试卷id（外键）',
  `papername` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试卷名称',
  `questionid` bigint(0) NOT NULL COMMENT '试题id（外键）',
  `questionname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试题名称',
  `options` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '选项，json字符串',
  `score` bigint(0) NULL DEFAULT 0 COMMENT '分值',
  `answer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '答案解析',
  `myscore` bigint(0) NOT NULL DEFAULT 0 COMMENT '试题得分',
  `myanswer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考生答案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1673753677756 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '心理测试记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examrecord
-- ----------------------------
INSERT INTO `examrecord` VALUES (1673753660862, '2023-01-15 11:34:20', 1673753561857, '王强', 1, '十万个为什么', 1, '下面动物不属于昆虫的是（）。', '[{\"text\":\"A.苍蝇\",\"code\":\"A\",\"checked\":false},{\"text\":\"B.蜜蜂\",\"code\":\"B\",\"checked\":false},{\"text\":\"C.蜂鸟\",\"code\":\"C\",\"checked\":true}]', 20, 'C', '蜂鸟', 20, 'C');
INSERT INTO `examrecord` VALUES (1673753664302, '2023-01-15 11:34:23', 1673753561857, '王强', 1, '十万个为什么', 2, '油着火后可以用水扑灭。', '[{\"text\":\"A.对\",\"code\":\"A\",\"checked\":true},{\"text\":\"B.错\",\"code\":\"B\",\"checked\":false}]', 20, 'B', '油着火后不可以用水扑灭', 0, 'A');
INSERT INTO `examrecord` VALUES (1673753674442, '2023-01-15 11:34:34', 1673753561857, '王强', 1, '十万个为什么', 3, '地球是个球体，中间是（ ）。', '[]', 30, '赤道', '赤道', 30, '赤道');
INSERT INTO `examrecord` VALUES (1673753677755, '2023-01-15 11:34:36', 1673753561857, '王强', 1, '十万个为什么', 4, '下面动物中会流汗的有（ ）。', '[{\"text\":\"A.马\",\"code\":\"A\",\"checked\":false},{\"text\":\"B.猫\",\"code\":\"B\",\"checked\":true},{\"text\":\"C.狗\",\"code\":\"C\",\"checked\":true}]', 30, 'A,B', '狗不会流汗', 0, 'B,C');
INSERT INTO `examrecord` VALUES (1720020121736, '2024-07-03 23:22:01', 1713496878482, '苏大苗', 1673753357465, '心理健康测试', 1673753403851, '输入试题内容', '[{\"text\":\"A.11\",\"code\":\"A\",\"checked\":false},{\"text\":\"B.22\",\"code\":\"B\",\"checked\":true},{\"text\":\"C.33\",\"code\":\"C\",\"checked\":false},{\"text\":\"D.44\",\"code\":\"D\",\"checked\":false}]', 10, 'A', '输入答案分析内容', 0, 'B');
INSERT INTO `examrecord` VALUES (1720020125025, '2024-07-03 23:22:04', 1713496878482, '苏大苗', 1673753357465, '心理健康测试', 1673753444569, '试题', '[{\"text\":\"A.kl\",\"code\":\"A\",\"checked\":false},{\"text\":\"B.dgag\",\"code\":\"B\",\"checked\":true},{\"text\":\"C.srer\",\"code\":\"C\",\"checked\":false},{\"text\":\"D.fhfhsfdh\",\"code\":\"D\",\"checked\":false}]', 10, 'A,B', '分析', 0, 'B');
INSERT INTO `examrecord` VALUES (1720020126839, '2024-07-03 23:22:06', 1713496878482, '苏大苗', 1673753357465, '心理健康测试', 1673753468004, '试题3', '[{\"text\":\"A.对\",\"code\":\"A\",\"checked\":true},{\"text\":\"B.错\",\"code\":\"B\",\"checked\":false}]', 10, 'A', '分析2', 10, 'A');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `picture` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (136, '2023-01-15 10:56:39', '离开是一种痛苦，是一种勇气，但同样也是一个考验，是一个新的开端', '无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。', 'upload/news_picture6.jpg', '<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够确定自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在成功时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>');
INSERT INTO `news` VALUES (137, '2023-01-15 10:56:39', 'Leave未必是一种痛苦', '无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。', 'upload/news_picture7.jpg', '<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够确定自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在成功时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>');
INSERT INTO `news` VALUES (138, '2023-01-15 10:56:39', '坚持才会成功', '回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。', 'upload/news_picture8.jpg', '<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度赞赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `userid` bigint(0) NOT NULL COMMENT '用户id',
  `refid` bigint(0) NULL DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `picture` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1673753649163 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storeup
-- ----------------------------
INSERT INTO `storeup` VALUES (1673753649162, '2023-01-15 11:34:08', 1673753561857, 1673753126990, 'xinlizhishi', '心理健康知识', 'upload/1673753109916.jpeg', '1', NULL, NULL);
INSERT INTO `storeup` VALUES (1720020043805, '2024-07-03 23:20:42', 1713496878482, 1673753126990, 'xinlizhishi', '心理健康知识', 'upload/1673753109916.jpeg', '1', NULL, NULL);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(0) NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '新增时间',
  `expiratedtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (13, 1713496878482, 'student1', 'xuesheng', '学生', 'dsgsq5oal52fses7mqamlowkgyxvvlxf', '2024-07-03 23:19:48', '2024-07-04 00:23:06');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '123456', '管理员', '2023-01-15 10:56:39');

-- ----------------------------
-- Table structure for xinlidangan
-- ----------------------------
DROP TABLE IF EXISTS `xinlidangan`;
CREATE TABLE `xinlidangan`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `xuehao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `shoujihaoma` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `xinlidengji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '心理等级',
  `xinlipinggu` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '心理评估',
  `dengjishijian` datetime(0) NULL DEFAULT NULL COMMENT '登记时间',
  `beizhu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '心理档案' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xinlidangan
-- ----------------------------

-- ----------------------------
-- Table structure for xinlilaoshi
-- ----------------------------
DROP TABLE IF EXISTS `xinlilaoshi`;
CREATE TABLE `xinlilaoshi`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `laoshizhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '老师账号',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `laoshixingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '老师姓名',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `shanzhanglingyu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '擅长领域',
  `lianxidianhua` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `gerenjianjie` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '个人简介',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `laoshizhanghao`(`laoshizhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1713502797244 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '心理老师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xinlilaoshi
-- ----------------------------
INSERT INTO `xinlilaoshi` VALUES (1713502641650, '2024-04-19 12:57:21', '003', '123456', '张老师', 'upload/1719992837614.jpeg', '女', '情感', '13333333333', '<p>xxxxxxxxxxxxxxxxxxx</p>');
INSERT INTO `xinlilaoshi` VALUES (1713502721905, '2024-04-19 12:58:41', '002', '123456', '吴老师', 'upload/1713502701784.webp', '男', '心理', '12222222222', '<p>xxxxxxxxxxxxxxxxxxx</p>');
INSERT INTO `xinlilaoshi` VALUES (1713502797243, '2024-04-19 12:59:57', '001', '123456', '谢老师', 'upload/1719995520957.jpeg', '女', '情感', '11111111111', '<p>xxxxxxxxxxxxxxxxxxx</p>');

-- ----------------------------
-- Table structure for xinlipinggu
-- ----------------------------
DROP TABLE IF EXISTS `xinlipinggu`;
CREATE TABLE `xinlipinggu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `xuehao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `ceshimingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '测试名称',
  `ceshichengji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '测试成绩',
  `xinlipinggu` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '心理评估',
  `pinggujieguo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评估结果',
  `pinggushijian` datetime(0) NULL DEFAULT NULL COMMENT '评估时间',
  `laoshizhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师账号',
  `laoshixingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师姓名',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `userid` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '心理评估' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xinlipinggu
-- ----------------------------

-- ----------------------------
-- Table structure for xinlitishi
-- ----------------------------
DROP TABLE IF EXISTS `xinlitishi`;
CREATE TABLE `xinlitishi`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `xuehao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `pinggujieguo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评估结果',
  `tishineirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提示内容',
  `tishishijian` datetime(0) NULL DEFAULT NULL COMMENT '提示时间',
  `laoshizhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师账号',
  `laoshixingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师姓名',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `userid` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '心理提示' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xinlitishi
-- ----------------------------

-- ----------------------------
-- Table structure for xinlizhishi
-- ----------------------------
DROP TABLE IF EXISTS `xinlizhishi`;
CREATE TABLE `xinlizhishi`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `fengmian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '封面',
  `zhishineirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '知识内容',
  `fabushijian` date NULL DEFAULT NULL COMMENT '发布时间',
  `laiyuan` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `userid` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1673753126991 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '心理知识' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xinlizhishi
-- ----------------------------
INSERT INTO `xinlizhishi` VALUES (31, '2023-01-15 10:56:39', '心灵驿站', 'upload/xinlizhishi_fengmian3.jpg', '<p>罗森塔尔效应是一种社会心理效应，指对一个人传递积极的期望，就会使他进步得更快，发展得更好。反之，向一个人传递消极的期望则会使人自暴自弃，放弃努力。</p>', '2023-01-14', '网络', 1);
INSERT INTO `xinlizhishi` VALUES (1673753126990, '2023-01-15 11:25:26', '心理健康知识', 'upload/1673753109916.jpeg', '<p>输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息输入知识内容详情信息</p>', '2023-01-15', '心理网', 1);

-- ----------------------------
-- Table structure for xinlizixun
-- ----------------------------
DROP TABLE IF EXISTS `xinlizixun`;
CREATE TABLE `xinlizixun`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `laoshizhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师账号',
  `laoshixingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师姓名',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `zixunneirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '咨询内容',
  `zixunshijian` datetime(0) NULL DEFAULT NULL COMMENT '咨询时间',
  `xuehao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `shoujihaoma` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `shhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  `userid` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1714196659889 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '心理咨询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xinlizixun
-- ----------------------------
INSERT INTO `xinlizixun` VALUES (1713590708428, '2024-04-20 13:25:08', '003', '张老师', 'upload/1713502563804.webp', '<p>老师好</p>', '2024-04-20 05:24:54', '240101', '苏大苗', '12345678900', '好的', 1713496878482);
INSERT INTO `xinlizixun` VALUES (1714026797573, '2024-04-25 14:33:17', '003', '张老师', 'upload/1713502563804.webp', '<p>1111</p>', '2024-04-25 06:33:09', '240101', '苏大苗', '12345678900', '', 1713496878482);
INSERT INTO `xinlizixun` VALUES (1714026910818, '2024-04-25 14:35:09', '001', '谢老师', 'upload/1713502772830.webp', '<p>1111</p>', '2024-04-25 06:35:03', '240101', '苏大苗', '12345678900', '', 1713496878482);
INSERT INTO `xinlizixun` VALUES (1714196659888, '2024-04-27 13:44:19', '003', '张老师', 'upload/1713502563804.webp', '<p>1111</p>', '2024-04-27 05:44:10', '240101', '苏大苗', '12345678900', '', 1713496878482);
INSERT INTO `xinlizixun` VALUES (1720019351063, '2024-07-03 23:09:10', '001', '谢老师', 'upload/1719995520957.jpeg', '<p>我心情不好</p>', '2024-07-03 23:09:03', 'student1', '苏大苗', '12345678900', '', 1713496878482);
INSERT INTO `xinlizixun` VALUES (1720019416661, '2024-07-03 23:10:15', '003', '张老师', 'upload/1719992837614.jpeg', '<p>我</p>', '2024-07-03 23:10:11', 'student1', '苏大苗', '12345678900', '', 1713496878482);

-- ----------------------------
-- Table structure for xuesheng
-- ----------------------------
DROP TABLE IF EXISTS `xuesheng`;
CREATE TABLE `xuesheng`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `xuehao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `xueshengxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `shoujihaoma` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `youxiang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `xuehao`(`xuehao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1713502069549 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xuesheng
-- ----------------------------
INSERT INTO `xuesheng` VALUES (1713496878482, '2024-04-19 11:21:18', 'student1', '123456', '苏大苗', 'upload/1714133387458.jpg', '男', '18', '12345678900', '12345678900@qq.com');
INSERT INTO `xuesheng` VALUES (1713501946825, '2024-04-19 12:45:46', 'student2', '123456', '胡图图', 'upload/1713501884613.jpg', '男', '18', '14785236900', '14785236900@qq.com');
INSERT INTO `xuesheng` VALUES (1713502069548, '2024-04-19 12:47:49', 'student3', '123456', '一二三', 'upload/1720016252518.jpeg', '女', '19', '14725836900', '14725836900@qq.com');

-- ----------------------------
-- Table structure for zaixianyuyue
-- ----------------------------
DROP TABLE IF EXISTS `zaixianyuyue`;
CREATE TABLE `zaixianyuyue`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `laoshizhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师账号',
  `laoshixingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师姓名',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '头像',
  `yuyuedidian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预约地点',
  `yuyueshijian` datetime(0) NOT NULL COMMENT '预约时间',
  `yuyueneirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '预约内容',
  `xuehao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `shoujihaoma` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '审核回复',
  `userid` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1713590826115 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '在线预约' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zaixianyuyue
-- ----------------------------
INSERT INTO `zaixianyuyue` VALUES (1713590826114, '2024-04-20 13:27:05', '003', '张老师', 'upload/1713502563804.webp', '211', '2024-01-01 05:26:26', '<p>心理辅导</p>', '240101', '苏大苗', '12345678900', '待审核', '', 1713496878482);
INSERT INTO `zaixianyuyue` VALUES (1720019384284, '2024-07-03 23:09:43', '001', '谢老师', 'upload/1719995520957.jpeg', 'e教', '2024-07-03 23:00:14', '<p>我想说话</p>', 'student1', '苏大苗', '12345678900', '待审核', '', 1713496878482);
INSERT INTO `zaixianyuyue` VALUES (1720019571876, '2024-07-03 23:12:51', '003', '张老师', 'upload/1719992837614.jpeg', 'a', '2024-07-03 23:12:42', '', 'student1', '苏大苗', '12345678900', '待审核', '', 1713496878482);

SET FOREIGN_KEY_CHECKS = 1;
