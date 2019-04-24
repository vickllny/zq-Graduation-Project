/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 127.0.0.1:3306
 Source Schema         : yb_carb

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 25/04/2019 01:18:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for amount_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `amount_recharge_record`;
CREATE TABLE `amount_recharge_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员id',
  `recharge_amount` decimal(32,3) DEFAULT NULL COMMENT '充值金额',
  `recharge_time` datetime DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of amount_recharge_record
-- ----------------------------
BEGIN;
INSERT INTO `amount_recharge_record` VALUES ('402816816a0cbd1b016a0cd6bf340003', '4028168169b581450169b586e9780001', 11.111, '2019-04-11 22:39:21');
INSERT INTO `amount_recharge_record` VALUES ('402816816a0cbd1b016a0cdb02490005', '4028168169b581450169b586e9780001', 22.886, '2019-04-11 22:44:00');
INSERT INTO `amount_recharge_record` VALUES ('402816816a0cbd1b016a0cee3e720006', '402816816a0c6ef4016a0cb27db70000', 87.934, '2019-04-11 23:05:01');
INSERT INTO `amount_recharge_record` VALUES ('402816816a174260016a180770450003', '4028168169b581450169b586e9780001', 1000.000, '2019-04-14 02:48:21');
INSERT INTO `amount_recharge_record` VALUES ('402816816a4569e2016a458510820005', '4028168169b581450169b586e9780001', 1000.000, '2019-04-22 22:48:29');
INSERT INTO `amount_recharge_record` VALUES ('402816816a45a627016a45a9fb120001', '4028168169b581450169b586e9780001', 1000.000, '2019-04-22 23:28:48');
COMMIT;

-- ----------------------------
-- Table structure for amount_spend_record
-- ----------------------------
DROP TABLE IF EXISTS `amount_spend_record`;
CREATE TABLE `amount_spend_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员id',
  `product_id` varchar(32) NOT NULL COMMENT '商品id',
  `amount_spend` decimal(10,2) DEFAULT NULL COMMENT '花费金额',
  `spend_time` datetime DEFAULT NULL COMMENT '消费时间',
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `create_user_id` varchar(36) NOT NULL COMMENT '创建人id',
  `type` varchar(11) NOT NULL COMMENT '类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of amount_spend_record
-- ----------------------------
BEGIN;
INSERT INTO `amount_spend_record` VALUES ('402816816a4569e2016a458549310006', '4028168169b581450169b586e9780001', '402816816a157c48016a159d01240000', 99.99, '2019-04-22 22:48:44', 1, '', '');
INSERT INTO `amount_spend_record` VALUES ('402816816a458cda016a459e10bb0004', '4028168169b581450169b586e9780001', '402816816a157c48016a159d01240000', 899.91, '2019-04-22 23:15:48', 9, '402816816a078232016a078f4f5c0021', '');
INSERT INTO `amount_spend_record` VALUES ('5fd7333f6a4ff6cf016a502118f40000', '4028168169b581450169b586e9780001', '402816816a157c48016a159d01240000', NULL, '2019-04-25 00:15:07', 1, '402816816a078232016a078f4f5c0021', '2');
INSERT INTO `amount_spend_record` VALUES ('5fd7333f6a4ff6cf016a5023b3a20001', '4028168169b581450169b586e9780001', '402816816a157c48016a159f64cc0001', NULL, '2019-04-25 00:17:58', 1, '402816816a078232016a078f4f5c0021', '2');
INSERT INTO `amount_spend_record` VALUES ('5fd7333f6a502e70016a502f97ec0002', '4028168169b581450169b586e9780001', '402816816a157c48016a159f64cc0001', NULL, '2019-04-25 00:30:57', 1, '402816816a078232016a078f4f5c0021', '2');
INSERT INTO `amount_spend_record` VALUES ('5fd7333f6a502e70016a502f9ef40003', '4028168169b581450169b586e9780001', '402816816a157c48016a159d01240000', NULL, '2019-04-25 00:30:59', 1, '402816816a078232016a078f4f5c0021', '2');
COMMIT;

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员ID',
  `balance` decimal(10,3) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`,`customer_id`),
  KEY `customer_for_pk` (`customer_id`),
  CONSTRAINT `customer_for_pk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of balance
-- ----------------------------
BEGIN;
INSERT INTO `balance` VALUES ('402816816a0cbd1b016a0cd6bf520004', '4028168169b581450169b586e9780001', 244.107);
INSERT INTO `balance` VALUES ('402816816a0cbd1b016a0cee3e790007', '402816816a0c6ef4016a0cb27db70000', 87.934);
COMMIT;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '名字',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '电话',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `del` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除 1->删除 0>未删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES ('4028168169b581450169b586e9780001', '邹倩', 1, '15775967871', 22, 0, '2019-04-25 01:14:57');
INSERT INTO `customer` VALUES ('402816816a0c6ef4016a0cb27db70000', '邓刚', 1, '15777776666', 22, 0, '2019-04-25 01:15:03');
INSERT INTO `customer` VALUES ('402816816a0c6ef4016a0cb2b8ed0001', '蒋安琼', 0, '15755556666', 22, 0, '2019-04-25 01:15:09');
COMMIT;

-- ----------------------------
-- Table structure for customer_numbers
-- ----------------------------
DROP TABLE IF EXISTS `customer_numbers`;
CREATE TABLE `customer_numbers` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员ID',
  `numbers` int(11) DEFAULT NULL COMMENT '次数',
  `service_id` varchar(32) NOT NULL COMMENT '服务id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer_set_meal
-- ----------------------------
DROP TABLE IF EXISTS `customer_set_meal`;
CREATE TABLE `customer_set_meal` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `customer_id` varchar(36) NOT NULL,
  `set_meal_id` varchar(36) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_set_meal
-- ----------------------------
BEGIN;
INSERT INTO `customer_set_meal` VALUES ('402816816a4abb75016a4abfd40a0006', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '2019-04-23 23:10:46', '402816816a078232016a078f4f5c0021');
INSERT INTO `customer_set_meal` VALUES ('402816816a4ad953016a4add27ee0000', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '2019-04-23 23:42:48', '402816816a078232016a078f4f5c0021');
COMMIT;

-- ----------------------------
-- Table structure for customer_set_meal_production
-- ----------------------------
DROP TABLE IF EXISTS `customer_set_meal_production`;
CREATE TABLE `customer_set_meal_production` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `customer_id` varchar(36) NOT NULL COMMENT '会员id',
  `set_meal_id` varchar(36) NOT NULL COMMENT '套餐id',
  `customer_set_meal_id` varchar(36) NOT NULL,
  `product_id` varchar(36) NOT NULL,
  `type` varchar(5) NOT NULL COMMENT '1->商品  2->服务',
  `count` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_set_meal_production
-- ----------------------------
BEGIN;
INSERT INTO `customer_set_meal_production` VALUES ('402816816a4abb75016a4abfd4240007', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '402816816a4abb75016a4abfd40a0006', '402816816a157c48016a159d01240000', '1', 0);
INSERT INTO `customer_set_meal_production` VALUES ('402816816a4abb75016a4abfd42d0008', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '402816816a4abb75016a4abfd40a0006', '402816816a157c48016a159f64cc0001', '1', 0);
INSERT INTO `customer_set_meal_production` VALUES ('402816816a4abb75016a4abfd4310009', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '402816816a4abb75016a4abfd40a0006', '402816816a2bb6d6016a2bc0c2080000', '2', 0);
INSERT INTO `customer_set_meal_production` VALUES ('402816816a4abb75016a4abfd435000a', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '402816816a4abb75016a4abfd40a0006', '402816816a2bb6d6016a2bc1a7e50001', '2', 0);
INSERT INTO `customer_set_meal_production` VALUES ('402816816a4ad953016a4add284b0001', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '402816816a4ad953016a4add27ee0000', '402816816a157c48016a159d01240000', '1', 0);
INSERT INTO `customer_set_meal_production` VALUES ('402816816a4ad953016a4add28540002', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '402816816a4ad953016a4add27ee0000', '402816816a157c48016a159f64cc0001', '1', 0);
INSERT INTO `customer_set_meal_production` VALUES ('402816816a4ad953016a4add285a0003', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '402816816a4ad953016a4add27ee0000', '402816816a2bb6d6016a2bc0c2080000', '2', 0);
INSERT INTO `customer_set_meal_production` VALUES ('402816816a4ad953016a4add285f0004', '4028168169b581450169b586e9780001', '402816816a4abb75016a4abe176a0001', '402816816a4ad953016a4add27ee0000', '402816816a2bb6d6016a2bc1a7e50001', '2', 0);
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `ID` varchar(36) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PID` varchar(36) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('4028168169b37b870169b37cc7cb0000', '会员余额', '5fd7333f6989a45c016989a9d8c40000', '/balance/list');
INSERT INTO `menu` VALUES ('402816816a1a8811016a1a8ab10f0000', '系统编码设置', '5fd7333f6966df53016966e1e26b0001', '/sysCode/list');
INSERT INTO `menu` VALUES ('402816816a26bc7b016a26bdeb7e0000', '服务管理', '5fd7333f6989b25a016989b692990005', '/serviceInformation/list');
INSERT INTO `menu` VALUES ('402816816a2bf57d016a2bf70ba70000', '会员次数充值', '5fd7333f6989a45c016989a9d8c40000', '/numbersRechargeRecord/list');
INSERT INTO `menu` VALUES ('402816816a3ad380016a3ad61bf70000', '会员次数消费', '5fd7333f6989a45c016989a9d8c40000', '/numbersSpendRecord/list');
INSERT INTO `menu` VALUES ('402816816a3b2efc016a3b2fec620000', '会员次数管理', '5fd7333f6989a45c016989a9d8c40000', '/numbers/list');
INSERT INTO `menu` VALUES ('402816816a45b5fc016a45b6a4fc0000', '会员套餐管理', '5fd7333f6989a45c016989a9d8c40000', '/customerSetMeal/list');
INSERT INTO `menu` VALUES ('5fd7333f6966df53016966e1e26b0001', '系统管理', '#', '#');
INSERT INTO `menu` VALUES ('5fd7333f698525d00169855250c00000', '用户管理', '5fd7333f6966df53016966e1e26b0001', '/user/list');
INSERT INTO `menu` VALUES ('5fd7333f698525d001698554e0ec0001', '菜单管理', '5fd7333f6966df53016966e1e26b0001', '/menu/list');
INSERT INTO `menu` VALUES ('5fd7333f698525d001698555a4af0002', '角色管理', '5fd7333f6966df53016966e1e26b0001', '/role/list');
INSERT INTO `menu` VALUES ('5fd7333f6989a45c016989a9d8c40000', '会员管理', '#', '#');
INSERT INTO `menu` VALUES ('5fd7333f6989a45c016989aae41c0001', '会员消费', '5fd7333f6989a45c016989a9d8c40000', '/amountSpendRecord/list');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b349050000', '会员充值', '5fd7333f6989a45c016989a9d8c40000', '/amountRechargeRecord/list');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b375160001', '会员还款', '5fd7333f6989a45c016989a9d8c40000', '#');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b3a20d0002', '会员提醒', '5fd7333f6989a45c016989a9d8c40000', '#');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b3d1510003', '会员操作', '5fd7333f6989a45c016989a9d8c40000', '/customer/list');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b406500004', '套餐管理', '5fd7333f6989a45c016989a9d8c40000', '/setMealInformation/list');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b692990005', '商品管理', '#', '#');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b6f9070006', '商品管理', '5fd7333f6989b25a016989b692990005', '/productInformation/list');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b72e590007', '库存管理', '5fd7333f6989b25a016989b692990005', '/productStock/list');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b7f5200008', '统计报表', '#', '#');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b842f90009', '业务统计', '5fd7333f6989b25a016989b7f5200008', '#');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b885d0000a', '业务排行', '5fd7333f6989b25a016989b7f5200008', '#');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b8af19000b', '员工提成', '5fd7333f6989b25a016989b7f5200008', '#');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b8ea9a000c', '会员注册统计', '5fd7333f6989b25a016989b7f5200008', '/customer/registerList');
INSERT INTO `menu` VALUES ('5fd7333f6989b25a016989b92785000d', '库存统计', '5fd7333f6989b25a016989b7f5200008', '#');
COMMIT;

-- ----------------------------
-- Table structure for numbers
-- ----------------------------
DROP TABLE IF EXISTS `numbers`;
CREATE TABLE `numbers` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `customer_id` varchar(36) DEFAULT NULL COMMENT '会员id',
  `service_id` varchar(36) DEFAULT NULL COMMENT '服务id',
  `numbers` int(11) DEFAULT NULL COMMENT '次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of numbers
-- ----------------------------
BEGIN;
INSERT INTO `numbers` VALUES ('402816816a3b2efc016a3b33b1660003', '4028168169b581450169b586e9780001', '402816816a2bb6d6016a2bc0c2080000', 3);
COMMIT;

-- ----------------------------
-- Table structure for numbers_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `numbers_recharge_record`;
CREATE TABLE `numbers_recharge_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员ID',
  `recharge_numbers` int(11) DEFAULT NULL COMMENT '充值次数',
  `recharge_time` datetime DEFAULT NULL COMMENT '充值时间',
  `service_id` varchar(32) NOT NULL COMMENT '服务id',
  `spend_balance` decimal(10,0) DEFAULT NULL COMMENT '消费金额',
  `create_user_id` varchar(36) DEFAULT '' COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of numbers_recharge_record
-- ----------------------------
BEGIN;
INSERT INTO `numbers_recharge_record` VALUES ('402816816a3b2efc016a3b33b1520002', '4028168169b581450169b586e9780001', 1, '2019-04-20 22:43:24', '402816816a2bb6d6016a2bc0c2080000', 88, NULL);
INSERT INTO `numbers_recharge_record` VALUES ('402816816a3b3eab016a3b424fc10000', '4028168169b581450169b586e9780001', 2, '2019-04-20 22:59:22', '402816816a2bb6d6016a2bc0c2080000', 176, NULL);
INSERT INTO `numbers_recharge_record` VALUES ('402816816a45a627016a45aac73e0004', '4028168169b581450169b586e9780001', 3, '2019-04-22 23:29:41', '402816816a2bb6d6016a2bc0c2080000', 264, '402816816a078232016a078f4f5c0021');
COMMIT;

-- ----------------------------
-- Table structure for numbers_spend_record
-- ----------------------------
DROP TABLE IF EXISTS `numbers_spend_record`;
CREATE TABLE `numbers_spend_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员ID',
  `spend_numbers` int(11) DEFAULT NULL COMMENT '消费次数',
  `spend_time` datetime DEFAULT NULL COMMENT '消费时间',
  `service_id` varchar(32) NOT NULL COMMENT '服务id',
  `type` varchar(11) NOT NULL COMMENT '类别 1->普通次数消费  2->套餐次数消费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of numbers_spend_record
-- ----------------------------
BEGIN;
INSERT INTO `numbers_spend_record` VALUES ('402816816a3b469a016a3b49cd420001', '4028168169b581450169b586e9780001', 1, '2019-04-20 23:07:33', '402816816a2bb6d6016a2bc0c2080000', '');
INSERT INTO `numbers_spend_record` VALUES ('402816816a45a627016a45aa47540002', '4028168169b581450169b586e9780001', 1, '2019-04-22 23:29:08', '402816816a2bb6d6016a2bc0c2080000', '');
INSERT INTO `numbers_spend_record` VALUES ('402816816a45a627016a45aaf4b20005', '4028168169b581450169b586e9780001', 1, '2019-04-22 23:29:52', '402816816a2bb6d6016a2bc0c2080000', '');
INSERT INTO `numbers_spend_record` VALUES ('5fd7333f6a502e70016a502ed5bd0000', '4028168169b581450169b586e9780001', 1, '2019-04-25 00:30:08', '402816816a2bb6d6016a2bc0c2080000', '2');
INSERT INTO `numbers_spend_record` VALUES ('5fd7333f6a502e70016a502f76010001', '4028168169b581450169b586e9780001', 1, '2019-04-25 00:30:49', '402816816a2bb6d6016a2bc1a7e50001', '2');
INSERT INTO `numbers_spend_record` VALUES ('5fd7333f6a502e70016a502fa7fe0004', '4028168169b581450169b586e9780001', 1, '2019-04-25 00:31:02', '402816816a2bb6d6016a2bc1a7e50001', '2');
INSERT INTO `numbers_spend_record` VALUES ('5fd7333f6a502e70016a502fba700005', '4028168169b581450169b586e9780001', 1, '2019-04-25 00:31:06', '402816816a2bb6d6016a2bc0c2080000', '2');
COMMIT;

-- ----------------------------
-- Table structure for product_information
-- ----------------------------
DROP TABLE IF EXISTS `product_information`;
CREATE TABLE `product_information` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '商品名称',
  `purchase_price` decimal(10,2) NOT NULL COMMENT '商品进价',
  `selling_price` decimal(10,2) NOT NULL COMMENT '商品卖价',
  `unit` varchar(255) NOT NULL COMMENT '单位',
  `quantity` int(255) DEFAULT '0' COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_information
-- ----------------------------
BEGIN;
INSERT INTO `product_information` VALUES ('402816816a157c48016a159d01240000', '汽车香水', 66.66, 99.99, '瓶', -1);
INSERT INTO `product_information` VALUES ('402816816a157c48016a159f64cc0001', '装饰贴', 50.00, 88.88, '套', 0);
COMMIT;

-- ----------------------------
-- Table structure for product_stock
-- ----------------------------
DROP TABLE IF EXISTS `product_stock`;
CREATE TABLE `product_stock` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `product_id` varchar(32) NOT NULL COMMENT '商品id',
  `product_stock_number` int(11) DEFAULT NULL COMMENT '商品库存数量',
  `type` int(11) NOT NULL COMMENT '类别 1->入库数量  -1->出库数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_stock
-- ----------------------------
BEGIN;
INSERT INTO `product_stock` VALUES ('402816816a157c48016a15ca5dc20005', '402816816a157c48016a159d01240000', 11, 1, NULL);
INSERT INTO `product_stock` VALUES ('402816816a157c48016a15d17cd80006', '402816816a157c48016a159d01240000', 22, 1, NULL);
INSERT INTO `product_stock` VALUES ('402816816a174260016a1759fdd60000', '402816816a157c48016a159d01240000', -11, -1, NULL);
INSERT INTO `product_stock` VALUES ('402816816a174260016a175cda100001', '402816816a157c48016a159d01240000', 3, 1, '2019-04-13 23:42:02');
INSERT INTO `product_stock` VALUES ('402816816a458cda016a458de4e40000', '402816816a157c48016a159d01240000', 20, 1, '2019-04-22 22:58:08');
INSERT INTO `product_stock` VALUES ('402816816a458cda016a458e04d50001', '402816816a157c48016a159d01240000', -20, -1, '2019-04-22 22:58:16');
INSERT INTO `product_stock` VALUES ('402816816a458cda016a459585f10002', '402816816a157c48016a159d01240000', 9, 1, '2019-04-22 23:06:28');
INSERT INTO `product_stock` VALUES ('402816816a458cda016a459cb83c0003', '402816816a157c48016a159d01240000', -9, -1, '2019-04-22 23:14:19');
COMMIT;

-- ----------------------------
-- Table structure for product_stock_out
-- ----------------------------
DROP TABLE IF EXISTS `product_stock_out`;
CREATE TABLE `product_stock_out` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `product_id` varchar(32) NOT NULL COMMENT '商品ID',
  `product_out_number` int(11) DEFAULT NULL COMMENT '商品出库数量',
  `product_out_people` varchar(32) DEFAULT NULL COMMENT '商品出库人',
  `product_out_time` datetime DEFAULT NULL COMMENT '商品出库时间',
  PRIMARY KEY (`id`),
  KEY `stock_product_pk` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_stock_purchase
-- ----------------------------
DROP TABLE IF EXISTS `product_stock_purchase`;
CREATE TABLE `product_stock_purchase` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `product_id` varchar(32) NOT NULL COMMENT '商品ID',
  `product_purchase_number` int(11) DEFAULT NULL COMMENT '商品进库数量',
  `product_purchase_people` varchar(32) DEFAULT NULL COMMENT '商品进库人',
  `product_purchase_time` datetime DEFAULT NULL COMMENT '商品进库时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态，0->禁用，1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `role_code` varchar(64) NOT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('4028168169a5bc720169a5cc649f0000', '普通管理员', 1, NULL, 'admin');
COMMIT;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  `menu_id` varchar(36) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
BEGIN;
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf768f0000', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989b25a016989b692990005');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76970001', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989b25a016989b6f9070006');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76970002', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989a45c016989a9d8c40000');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76970003', '4028168169a5bc720169a5cc649f0000', '4028168169b37b870169b37cc7cb0000');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76980004', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989b25a016989b349050000');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76980005', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989b25a016989b375160001');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76980006', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989b25a016989b3a20d0002');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76980007', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989b25a016989b406500004');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76990008', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989b25a016989b3d1510003');
INSERT INTO `role_menu` VALUES ('402816816a07cb8f016a07cf76990009', '4028168169a5bc720169a5cc649f0000', '5fd7333f6989a45c016989aae41c0001');
COMMIT;

-- ----------------------------
-- Table structure for service_information
-- ----------------------------
DROP TABLE IF EXISTS `service_information`;
CREATE TABLE `service_information` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(128) DEFAULT NULL COMMENT '服务名称',
  `description` varchar(255) DEFAULT NULL COMMENT '服务描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type` varchar(32) NOT NULL COMMENT '服务类别',
  `unit_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service_information
-- ----------------------------
BEGIN;
INSERT INTO `service_information` VALUES ('402816816a2bb6d6016a2bc0c2080000', '洗车服务', '专业洗车20年', NULL, 'code1', 88.00);
INSERT INTO `service_information` VALUES ('402816816a2bb6d6016a2bc1a7e50001', '抛光服务', '抛光很舒服', '2019-04-17 22:44:32', 'code1', 188.00);
COMMIT;

-- ----------------------------
-- Table structure for set_meal_information
-- ----------------------------
DROP TABLE IF EXISTS `set_meal_information`;
CREATE TABLE `set_meal_information` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '套餐id',
  `meal_timelimit` datetime DEFAULT NULL COMMENT '套餐时限',
  `is_use` int(1) DEFAULT NULL COMMENT '是否消费：1已消费，0未消费',
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of set_meal_information
-- ----------------------------
BEGIN;
INSERT INTO `set_meal_information` VALUES ('4028168169b55b250169b55fbc860001', '111', '2019-04-23 00:00:00', 1, 886.00);
INSERT INTO `set_meal_information` VALUES ('4028168169b560350169b560cfee0000', 'll', '2019-03-27 00:00:00', 1, NULL);
INSERT INTO `set_meal_information` VALUES ('402816816a45b5fc016a45c51b510001', '222', '2019-04-30 00:00:00', 1, NULL);
INSERT INTO `set_meal_information` VALUES ('402816816a4abb75016a4abe176a0001', '333', '2019-04-30 00:00:00', 1, 255.00);
COMMIT;

-- ----------------------------
-- Table structure for set_meal_information_product
-- ----------------------------
DROP TABLE IF EXISTS `set_meal_information_product`;
CREATE TABLE `set_meal_information_product` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `set_meal_information_id` varchar(32) NOT NULL COMMENT '套餐id',
  `product_id` varchar(32) NOT NULL COMMENT '商品id',
  `count` int(11) DEFAULT NULL COMMENT '商品数量',
  `type` varchar(3) DEFAULT NULL COMMENT '类别 1->商品  2->服务',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of set_meal_information_product
-- ----------------------------
BEGIN;
INSERT INTO `set_meal_information_product` VALUES ('402816816a4569e2016a4574721b0001', '4028168169b560350169b560cfee0000', '402816816a157c48016a159f64cc0001', 1, '1');
INSERT INTO `set_meal_information_product` VALUES ('402816816a4569e2016a457fc5c90002', '4028168169b55b250169b55fbc860001', '402816816a4569e2016a4573d2dc0000', 1, '1');
INSERT INTO `set_meal_information_product` VALUES ('402816816a4569e2016a457fc5ca0003', '4028168169b55b250169b55fbc860001', '402816816a2bb6d6016a2bc0c2080000', 1, '2');
INSERT INTO `set_meal_information_product` VALUES ('402816816a4569e2016a457fc5ca0004', '4028168169b55b250169b55fbc860001', '402816816a2bb6d6016a2bc1a7e50001', 1, '2');
INSERT INTO `set_meal_information_product` VALUES ('402816816a4abb75016a4abe378e0002', '402816816a4abb75016a4abe176a0001', '402816816a157c48016a159d01240000', 1, '1');
INSERT INTO `set_meal_information_product` VALUES ('402816816a4abb75016a4abe37900003', '402816816a4abb75016a4abe176a0001', '402816816a157c48016a159f64cc0001', 1, '1');
INSERT INTO `set_meal_information_product` VALUES ('402816816a4abb75016a4abe37900004', '402816816a4abb75016a4abe176a0001', '402816816a2bb6d6016a2bc0c2080000', 1, '2');
INSERT INTO `set_meal_information_product` VALUES ('402816816a4abb75016a4abe37910005', '402816816a4abb75016a4abe176a0001', '402816816a2bb6d6016a2bc1a7e50001', 1, '2');
COMMIT;

-- ----------------------------
-- Table structure for set_meal_information_service
-- ----------------------------
DROP TABLE IF EXISTS `set_meal_information_service`;
CREATE TABLE `set_meal_information_service` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `set_meal_information_id` varchar(32) NOT NULL COMMENT '套餐id',
  `service_id` varchar(32) NOT NULL COMMENT '服务id',
  `count` int(11) DEFAULT NULL COMMENT '服务次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_code`;
CREATE TABLE `sys_code` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `code` varchar(255) NOT NULL COMMENT 'code',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_code
-- ----------------------------
BEGIN;
INSERT INTO `sys_code` VALUES ('402816816a1a8811016a1a8d7ff00002', '服务分类', '服务（商品）的类别', 'service_category', '2019-04-14 14:34:02');
INSERT INTO `sys_code` VALUES ('402816816a3afb67016a3aff17390001', '111', '111', '111', '2019-04-20 21:45:57');
COMMIT;

-- ----------------------------
-- Table structure for sys_code_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_code_item`;
CREATE TABLE `sys_code_item` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `code` varchar(255) NOT NULL COMMENT 'code',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `sys_code_id` varchar(36) NOT NULL COMMENT 'code_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_code_item
-- ----------------------------
BEGIN;
INSERT INTO `sys_code_item` VALUES ('402816816a1ae0eb016a1afa02d40002', '名称1', 'code1', 1, '402816816a1a8811016a1a8d7ff00002');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone_number` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `work_number` varchar(255) DEFAULT NULL COMMENT '工号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('402816816a078232016a078f4f5c0021', 'admin', '111', '15775967871', '15775967871', '2019-04-10 22:03:13', '', '4028168169a5bc720169a5cc649f0000');
INSERT INTO `user` VALUES ('402816816a07d7bf016a07da54810000', 'zq', '111', '15775967871', '15775967871', '2019-04-10 23:25:10', '', '4028168169a5bc720169a5cc649f0000');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
