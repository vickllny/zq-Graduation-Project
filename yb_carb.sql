/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 127.0.0.1
 Source Database       : yb_carb

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 03/17/2019 20:43:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `amount_recharge_record`
-- ----------------------------
DROP TABLE IF EXISTS `amount_recharge_record`;
CREATE TABLE `amount_recharge_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员id',
  `recharge_amount` decimal(32,0) DEFAULT NULL COMMENT '充值金额',
  `recharge_time` datetime DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `amount_spend_record`
-- ----------------------------
DROP TABLE IF EXISTS `amount_spend_record`;
CREATE TABLE `amount_spend_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员id',
  `product_id` varchar(32) NOT NULL COMMENT '商品id',
  `amount_spend` decimal(10,0) DEFAULT NULL COMMENT '花费金额',
  `spend_time` datetime DEFAULT NULL COMMENT '消费时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `balance`
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员ID',
  `balance` decimal(10,0) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '名字',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '电话',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `customer_numbers`
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
--  Table structure for `menu`
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
--  Records of `menu`
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('5fd7333f6966df53016966e1e26b0001', '系统管理', '#', '#'), ('5fd7333f698525d00169855250c00000', '用户管理', '5fd7333f6966df53016966e1e26b0001', '/user/list'), ('5fd7333f698525d001698554e0ec0001', '菜单管理', '5fd7333f6966df53016966e1e26b0001', '/menu/list'), ('5fd7333f698525d001698555a4af0002', '角色管理', '5fd7333f6966df53016966e1e26b0001', '/role/list'), ('5fd7333f6989a45c016989a9d8c40000', '会员管理', '#', '#'), ('5fd7333f6989a45c016989aae41c0001', '会员消费', '5fd7333f6989a45c016989a9d8c40000', '#'), ('5fd7333f6989b25a016989b349050000', '会员充值', '5fd7333f6989a45c016989a9d8c40000', '#'), ('5fd7333f6989b25a016989b375160001', '会员还款', '5fd7333f6989a45c016989a9d8c40000', '#'), ('5fd7333f6989b25a016989b3a20d0002', '会员提醒', '5fd7333f6989a45c016989a9d8c40000', '#'), ('5fd7333f6989b25a016989b3d1510003', '会员管理', '5fd7333f6989a45c016989a9d8c40000', '#'), ('5fd7333f6989b25a016989b406500004', '套餐管理', '5fd7333f6989a45c016989a9d8c40000', '#'), ('5fd7333f6989b25a016989b692990005', '商品管理', '#', '#'), ('5fd7333f6989b25a016989b6f9070006', '商品管理', '5fd7333f6989b25a016989b692990005', '#'), ('5fd7333f6989b25a016989b72e590007', '库存管理', '5fd7333f6989b25a016989b692990005', '#'), ('5fd7333f6989b25a016989b7f5200008', '统计报表', '#', '#'), ('5fd7333f6989b25a016989b842f90009', '业务统计', '5fd7333f6989b25a016989b7f5200008', '#'), ('5fd7333f6989b25a016989b885d0000a', '业务排行', '5fd7333f6989b25a016989b7f5200008', '#'), ('5fd7333f6989b25a016989b8af19000b', '员工提成', '5fd7333f6989b25a016989b7f5200008', '#'), ('5fd7333f6989b25a016989b8ea9a000c', '会员情况统计', '5fd7333f6989b25a016989b7f5200008', '#'), ('5fd7333f6989b25a016989b92785000d', '库存统计', '5fd7333f6989b25a016989b7f5200008', '#');
COMMIT;

-- ----------------------------
--  Table structure for `numbers_recharge_record`
-- ----------------------------
DROP TABLE IF EXISTS `numbers_recharge_record`;
CREATE TABLE `numbers_recharge_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员ID',
  `recharge_numbers` int(11) DEFAULT NULL COMMENT '充值次数',
  `recharge_time` datetime DEFAULT NULL COMMENT '充值时间',
  `service_id` varchar(32) NOT NULL COMMENT '服务id',
  `spend_balance` decimal(10,0) DEFAULT NULL COMMENT '消费金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `numbers_spend_record`
-- ----------------------------
DROP TABLE IF EXISTS `numbers_spend_record`;
CREATE TABLE `numbers_spend_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `customer_id` varchar(32) NOT NULL COMMENT '会员ID',
  `spend_numbers` int(11) DEFAULT NULL COMMENT '消费次数',
  `spend_time` datetime DEFAULT NULL COMMENT '消费时间',
  `service_id` varchar(32) NOT NULL COMMENT '服务id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `product_information`
-- ----------------------------
DROP TABLE IF EXISTS `product_information`;
CREATE TABLE `product_information` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `product_id` varchar(32) NOT NULL COMMENT '商品ID',
  `purchase_price` decimal(10,0) DEFAULT NULL COMMENT '商品进价',
  `selling_price` decimal(10,0) DEFAULT NULL COMMENT '商品卖价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `product_stock`
-- ----------------------------
DROP TABLE IF EXISTS `product_stock`;
CREATE TABLE `product_stock` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `product_id` varchar(32) NOT NULL COMMENT '商品id',
  `product_stock_number` int(11) DEFAULT NULL COMMENT '商品库存数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `product_stock_out`
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
--  Table structure for `product_stock_purchase`
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
--  Table structure for `service_information`
-- ----------------------------
DROP TABLE IF EXISTS `service_information`;
CREATE TABLE `service_information` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(128) DEFAULT NULL COMMENT '服务名称',
  `description` varchar(255) DEFAULT NULL COMMENT '服务描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `service_class_id` varchar(32) NOT NULL COMMENT '服务类别id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `set_meal_information`
-- ----------------------------
DROP TABLE IF EXISTS `set_meal_information`;
CREATE TABLE `set_meal_information` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '套餐id',
  `meal_timelimit` datetime DEFAULT NULL COMMENT '套餐时限',
  `is_use` int(1) DEFAULT NULL COMMENT '是否消费：1已消费，0未消费',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `set_meal_information_product`
-- ----------------------------
DROP TABLE IF EXISTS `set_meal_information_product`;
CREATE TABLE `set_meal_information_product` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `set_meal_information_id` varchar(32) NOT NULL COMMENT '套餐id',
  `product_id` varchar(32) NOT NULL COMMENT '商品id',
  `count` int(11) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `set_meal_information_service`
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
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `user_nane` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone_number` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `work_number` varchar(255) DEFAULT NULL COMMENT '工号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('5fd7333f698b52ca01698b681bb50001', 'admin', 'wisesoft', '18215511645', '001', '2019-03-17 06:27:30', '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
