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

 Date: 21/02/2023 10:31:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
  `wallet_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '钱包主键id',
  `user_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户id',
  `amount` decimal(10, 2) NOT NULL COMMENT '账户余额',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`wallet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '钱包表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallet
-- ----------------------------
INSERT INTO `wallet` VALUES ('499424518117392384', '789', 888.80, '2023-02-20 20:55:36', '2023-02-20 20:55:36', 0);
INSERT INTO `wallet` VALUES ('499424729942327296', '888', 888.88, '2023-02-20 20:56:27', '2023-02-21 10:27:39', 0);
INSERT INTO `wallet` VALUES ('499424847579971584', '999', 492.48, '2023-02-20 20:56:55', '2023-02-21 09:30:53', 0);
INSERT INTO `wallet` VALUES ('499427806585946112', '666', 666.00, '2023-02-20 21:08:40', '2023-02-20 21:08:40', 0);

SET FOREIGN_KEY_CHECKS = 1;
