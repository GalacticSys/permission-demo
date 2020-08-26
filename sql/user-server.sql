/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : user-server

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 26/08/2020 19:13:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT ' 路径',
  `menu_parent_id` int(0) NULL DEFAULT NULL COMMENT '父id',
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单名称',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '/', 0, '权限管理');
INSERT INTO `sys_menu` VALUES (2, 'query_user', 1, '用户列表');
INSERT INTO `sys_menu` VALUES (3, 'query_role', 1, '角色列表');
INSERT INTO `sys_menu` VALUES (4, 'query_permission', 1, '权限列表');
INSERT INTO `sys_menu` VALUES (5, '/', 0, '商品管理');
INSERT INTO `sys_menu` VALUES (6, 'query_goods', 5, '商品列表');
INSERT INTO `sys_menu` VALUES (7, 'query_category', 5, '分类列表');
INSERT INTO `sys_menu` VALUES (8, 'query_brand', 5, '品牌列表');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permission_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `permission_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限code',
  `permission_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 'query_user', '查询用户');
INSERT INTO `sys_permission` VALUES (2, 'delete_user', '删除用户');
INSERT INTO `sys_permission` VALUES (3, 'edit_user', '修改用户');
INSERT INTO `sys_permission` VALUES (4, 'add_user', '新增用户');
INSERT INTO `sys_permission` VALUES (5, 'query_role', '查询角色');
INSERT INTO `sys_permission` VALUES (6, 'delete_role', '删除角色');
INSERT INTO `sys_permission` VALUES (7, 'edit_role', '修改角色');
INSERT INTO `sys_permission` VALUES (8, 'add_role', '增加角色');
INSERT INTO `sys_permission` VALUES (9, 'query_permission', '查询权限');
INSERT INTO `sys_permission` VALUES (10, 'delete_permission', '删除权限');
INSERT INTO `sys_permission` VALUES (11, 'edit_permission', '修改权限');
INSERT INTO `sys_permission` VALUES (12, 'add_permission', '新增权限');
INSERT INTO `sys_permission` VALUES (13, '*', '所有权限');
INSERT INTO `sys_permission` VALUES (21, '测试！测试！测试！', '测试！');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色名',
  `role_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色说明',
  `role_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '普通用户', '拥有查询权限列表，用户列表，角色列表的权限', 'ROLE_user');
INSERT INTO `sys_role` VALUES (2, '管理员', ' 拥有所有权限', 'ROLE_admin');
INSERT INTO `sys_role` VALUES (12, '测试1', '拥有删除用户，删除角色，删除权限的权限，', 'ROLE_delete');

-- ----------------------------
-- Table structure for sys_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_relation`;
CREATE TABLE `sys_role_menu_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `r_id` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `m_id` int(0) NULL DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色与菜单联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu_relation
-- ----------------------------
INSERT INTO `sys_role_menu_relation` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu_relation` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu_relation` VALUES (3, 1, 3);
INSERT INTO `sys_role_menu_relation` VALUES (4, 1, 4);
INSERT INTO `sys_role_menu_relation` VALUES (5, 1, 5);
INSERT INTO `sys_role_menu_relation` VALUES (7, 2, 1);
INSERT INTO `sys_role_menu_relation` VALUES (8, 2, 2);
INSERT INTO `sys_role_menu_relation` VALUES (9, 2, 3);
INSERT INTO `sys_role_menu_relation` VALUES (10, 2, 4);
INSERT INTO `sys_role_menu_relation` VALUES (11, 2, 5);
INSERT INTO `sys_role_menu_relation` VALUES (12, 2, 6);
INSERT INTO `sys_role_menu_relation` VALUES (13, 2, 7);
INSERT INTO `sys_role_menu_relation` VALUES (14, 2, 8);

-- ----------------------------
-- Table structure for sys_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission_relation`;
CREATE TABLE `sys_role_permission_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` int(0) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色-权限关联关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission_relation
-- ----------------------------
INSERT INTO `sys_role_permission_relation` VALUES (21, NULL, 2);
INSERT INTO `sys_role_permission_relation` VALUES (22, NULL, 5);
INSERT INTO `sys_role_permission_relation` VALUES (23, NULL, 9);
INSERT INTO `sys_role_permission_relation` VALUES (24, NULL, 1);
INSERT INTO `sys_role_permission_relation` VALUES (25, NULL, 13);
INSERT INTO `sys_role_permission_relation` VALUES (26, 1, 5);
INSERT INTO `sys_role_permission_relation` VALUES (27, 1, 1);
INSERT INTO `sys_role_permission_relation` VALUES (28, 1, 9);
INSERT INTO `sys_role_permission_relation` VALUES (29, 2, 13);
INSERT INTO `sys_role_permission_relation` VALUES (30, 12, 2);
INSERT INTO `sys_role_permission_relation` VALUES (31, 12, 6);
INSERT INTO `sys_role_permission_relation` VALUES (32, 12, 10);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账号',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户密码',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次登录时间',
  `enabled` bit(1) NULL DEFAULT b'1' COMMENT '账号是否可用。默认为1（可用）',
  `not_expired` bit(1) NULL DEFAULT b'0' COMMENT '是否过期。默认为0（没有过期）',
  `account_not_locked` bit(1) NULL DEFAULT b'0' COMMENT '账号是否锁定。默认为0（没有锁定）',
  `credentials_not_expired` bit(1) NULL DEFAULT b'0' COMMENT '证书（密码）是否过期。默认为0（没有过期）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (2, '用户1', '用户1', '$2a$10$UAK3qVF0IMl/1LAk6tu/mORx.G/.QQXIPzfojCqp/izgPMvfzUUf2', NULL, b'1', b'0', b'0', b'0', '2020-08-14 17:35:32', NULL, NULL, '用户1');
INSERT INTO `sys_user` VALUES (9, '用户2', '用户2', '$2a$10$MxucRVPKkQh1XAHT976cH.pRQUwG5XQK667VwO/h9QJ/9vzt3Kh5G', NULL, b'1', b'0', b'0', b'0', '2020-08-15 22:01:15', NULL, '用户2', NULL);
INSERT INTO `sys_user` VALUES (10, '用户3', '用户3', '$2a$10$.y5/TLXynyWnfSjkHmaxTeBVamy2g/hkcNvSpWD.A9QhBkhi4CgDe', NULL, b'1', b'0', b'0', b'0', '2020-08-15 22:04:23', NULL, '用户2', NULL);
INSERT INTO `sys_user` VALUES (11, '用户4', '用户4', '$2a$10$B3WyEkWrDZXjET/JcYLZlO0hiJjZOqKX5fWFRV/Sm4k6KMJJYtM5G', NULL, b'1', b'0', b'0', b'0', '2020-08-15 22:05:49', NULL, '用户2', NULL);
INSERT INTO `sys_user` VALUES (12, '用户5', '用户5', '$2a$10$6ZpBtAC1b6aw2MldS.frwuoPbymXpgtjmBBmxTWUsjpqAeISKYfr2', NULL, b'1', b'0', b'0', b'0', '2020-08-16 01:17:59', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (15, '用户22', '用户22', '$2a$10$UtJ54Ud1R9FM1hW/nUBQSuD5FcNj/dvCyIjClGVW.PmVfD3nEGvb.', NULL, b'1', b'0', b'0', b'0', '2020-08-16 02:17:57', NULL, '用户1', '用户1');

-- ----------------------------
-- Table structure for sys_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_relation`;
CREATE TABLE `sys_user_role_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户角色关联关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role_relation
-- ----------------------------
INSERT INTO `sys_user_role_relation` VALUES (9, 1, 2);
INSERT INTO `sys_user_role_relation` VALUES (10, 1, 1);
INSERT INTO `sys_user_role_relation` VALUES (23, 11, 1);
INSERT INTO `sys_user_role_relation` VALUES (24, 10, 1);
INSERT INTO `sys_user_role_relation` VALUES (27, 9, 2);
INSERT INTO `sys_user_role_relation` VALUES (31, 12, 12);
INSERT INTO `sys_user_role_relation` VALUES (35, 2, 2);
INSERT INTO `sys_user_role_relation` VALUES (36, 2, 1);
INSERT INTO `sys_user_role_relation` VALUES (37, 2, 19);

SET FOREIGN_KEY_CHECKS = 1;
