/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : yuncang

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 21/02/2023 10:31:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wallet_detail
-- ----------------------------
DROP TABLE IF EXISTS `wallet_detail`;
CREATE TABLE `wallet_detail`  (
  `wallet_detail_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '钱包金额变动明细主键id',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `wallet_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '钱包id',
  `amount_change` decimal(10, 2) NOT NULL COMMENT '金额变动',
  `remaining_amount` decimal(10, 2) NOT NULL COMMENT '剩余金额',
  `description` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '金额变动描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`wallet_detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallet_detail
-- ----------------------------
INSERT INTO `wallet_detail` VALUES ('499431470415347712', '999', '499424847579971584', 10.00, 888.88, '退款', '2023-02-20 21:23:14');
INSERT INTO `wallet_detail` VALUES ('499432007210762240', '999', '499424847579971584', -100.00, 788.88, '购物', '2023-02-20 21:25:22');
INSERT INTO `wallet_detail` VALUES ('499459530791452672', '999', '499424847579971584', -100.00, 688.88, '消费', '2023-02-20 23:14:44');
INSERT INTO `wallet_detail` VALUES ('499460072775221248', '999', '499424847579971584', -88.88, 600.00, '消费', '2023-02-20 23:16:53');
INSERT INTO `wallet_detail` VALUES ('499460366632353792', '999', '499424847579971584', -0.88, 599.12, '消费', '2023-02-20 23:18:03');
INSERT INTO `wallet_detail` VALUES ('499609967700082688', '999', '499424847579971584', -8.88, 590.24, '消费', '2023-02-21 09:12:31');
INSERT INTO `wallet_detail` VALUES ('499612560354574336', '999', '499424847579971584', -8.88, 581.36, '消费', '2023-02-21 09:22:49');
INSERT INTO `wallet_detail` VALUES ('499613325290766336', '999', '499424847579971584', -8.88, 572.48, '消费', '2023-02-21 09:25:51');
INSERT INTO `wallet_detail` VALUES ('499613421130612736', '999', '499424847579971584', -8.88, 563.60, '消费', '2023-02-21 09:26:14');
INSERT INTO `wallet_detail` VALUES ('499613529364627456', '999', '499424847579971584', 8.88, 572.48, '退款', '2023-02-21 09:26:40');
INSERT INTO `wallet_detail` VALUES ('499614141863034880', '999', '499424847579971584', 20.00, 592.48, '退款', '2023-02-21 09:29:06');
INSERT INTO `wallet_detail` VALUES ('499614591567921152', '999', '499424847579971584', -100.00, 492.48, '消费', '2023-02-21 09:30:53');
INSERT INTO `wallet_detail` VALUES ('499627666836684800', '888', '499424729942327296', -88.80, 800.08, '消费', '2023-02-21 10:22:50');
INSERT INTO `wallet_detail` VALUES ('499627863440490496', '888', '499424729942327296', 88.80, 888.88, '退款', '2023-02-21 10:23:37');
INSERT INTO `wallet_detail` VALUES ('499628837605343232', '888', '499424729942327296', 1.00, 889.88, '退款', '2023-02-21 10:27:30');
INSERT INTO `wallet_detail` VALUES ('499628877082132480', '888', '499424729942327296', -1.00, 888.88, '消费', '2023-02-21 10:27:39');

SET FOREIGN_KEY_CHECKS = 1;
