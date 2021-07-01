SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tbl_accountinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_accountinfo`;
CREATE TABLE `tbl_accountinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账号id',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称（中文显示名）',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账号类型（-1:超级用户，0:管理员，不能登录客户端；1：操作员，可登录客户端，运营后台暂时没有权限）（类型后续可扩展）',
  `cid` int(11) DEFAULT NULL COMMENT '所属的客户id',
  `did` int(11) DEFAULT NULL COMMENT '所属部门id',
  `state` int(11) DEFAULT '1' COMMENT '当前账号状态1正常2禁用',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_accountinfo
-- ----------------------------
INSERT INTO `tbl_accountinfo` VALUES ('1', 'root', '123456', 'admin', '-1', null, null, '1', '2019-03-11 09:49:24');
INSERT INTO `tbl_accountinfo` VALUES ('5', 'admin', '123456', 'admin', '0', '7', null, '1', '2019-03-11 09:49:24');
INSERT INTO `tbl_accountinfo` VALUES ('6', 'pctest', '123456', 'pctest', '1', '7', '14', '1', '2019-03-11 09:49:22');

-- ----------------------------
-- Table structure for tbl_commontaginfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_commontaginfo`;
CREATE TABLE `tbl_commontaginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL COMMENT '客户id',
  `did` int(11) DEFAULT NULL COMMENT '部门id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标签名称',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_commontaginfo
-- ----------------------------
INSERT INTO `tbl_commontaginfo` VALUES ('2', '7', '14', '有用客户', '2019-03-07 17:40:04');
INSERT INTO `tbl_commontaginfo` VALUES ('4', '7', '14', '他是好人', '2019-03-07 17:39:55');
INSERT INTO `tbl_commontaginfo` VALUES ('5', '7', '14', '潜在客户', '2019-03-07 17:40:18');
INSERT INTO `tbl_commontaginfo` VALUES ('6', '7', '14', '想打他', '2019-03-14 17:54:30');


-- ----------------------------
-- Table structure for tbl_commontermtype
-- ----------------------------
DROP TABLE IF EXISTS `tbl_commontermtype`;
CREATE TABLE `tbl_commontermtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL COMMENT '客户id',
  `did` int(11) DEFAULT NULL COMMENT '部门id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '术语分类名称',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `tbl_commontermtype` (`id`, `cid`, `did`, `name`, `create_time`) VALUES ('7', '7', '14', '常用语', '2019-06-13 11:31:23');


-- ----------------------------
-- Table structure for tbl_commonterminfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_commonterminfo`;
CREATE TABLE `tbl_commonterminfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL COMMENT '客户id',
  `did` int(11) DEFAULT NULL COMMENT '部门id',
  `tid` int(11) DEFAULT NULL COMMENT '术语分类id',
  `ctype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `content` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_commonterminfo
-- ----------------------------
INSERT INTO `tbl_commonterminfo` VALUES ('14', '7', '14', '1','7', '文本测试', '我们专注微信营销工具的研发多年，拥有全面的微信二次开发sdk！', '2019-03-22 15:31:04');

-- ----------------------------
-- Table structure for tbl_customerinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_customerinfo`;
CREATE TABLE `tbl_customerinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'SupplierId  UnionId,客户id',
  `suppliername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户名称（中文显示名）',
  `shortname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户缩写，字母（可包含数字）；如售后客服部->shkf;使用场景:比如自动生成Admin：shkf_admin，业务报表之类的',
  `level` int(11) DEFAULT NULL COMMENT '客户等级（待定）',
  `account_num` int(11) DEFAULT NULL COMMENT '最大账号（操作员）数量（依客户等级而定）',
  `device_num` int(11) DEFAULT NULL COMMENT '最大设备数量（依客户等级而定）',
  `validity` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '服务期限',
  `state` int(11) DEFAULT NULL COMMENT '当前客户状态',
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员账号',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人电话',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_customerinfo
-- ----------------------------
INSERT INTO `tbl_customerinfo` VALUES ('7', '售后客服部', 'shkf', '1', '100', '1000', '2018-09-20 14:52:47', '1', 'admin', 'admin', '', '', '2018-09-20 14:52:47');

-- ----------------------------
-- Table structure for tbl_departmentinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_departmentinfo`;
CREATE TABLE `tbl_departmentinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '父级id',
  `cid` int(11) DEFAULT NULL COMMENT '所属客户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid` (`cid`,`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of tbl_departmentinfo
-- ----------------------------
INSERT INTO `tbl_departmentinfo` VALUES ('14', null, '7', '公司总部', '公司总部', '2019-03-07 17:38:53');


-- ----------------------------
-- Table structure for tbl_wx_accountinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wx_accountinfo`;
CREATE TABLE `tbl_wx_accountinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wechatid` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '微信id',
  `wechatno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信账号',
  `wechatnick` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信昵称',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像url',
  `country` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '国家',
  `province` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '省份',
  `city` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '城市',
  `isonline` int(11) DEFAULT '1' COMMENT '是否在线   0上线   1下线',
  `islogined` int(11) DEFAULT '1' COMMENT '是否在pc客户端上登录   0上线   1下线',
  `deviceid` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '微信登陆的设备',
  `cid` int(11) DEFAULT NULL COMMENT '客户id',
  `did` int(11) DEFAULT NULL,
  `devnickname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '设备昵称',
  `brand` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机品牌',
  `module` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机型号',
  `accountid` int(11) DEFAULT NULL COMMENT 'Pc客户端正在操作该微信的操作员账号id',
  `login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `deviceid_wechatid` (`deviceid`,`wechatid`) USING BTREE,
  UNIQUE KEY `deviceid` (`deviceid`) USING BTREE,
  UNIQUE KEY `wechatid` (`wechatid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ----------------------------
-- Records of tbl_wx_accountinfo
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_wx_contactinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wx_contactinfo`;
CREATE TABLE `tbl_wx_contactinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL COMMENT '所属客户id',
  `wechatid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属的微信id',
  `friendid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人微信id',
  `friend_wechatno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人微信账号',
  `nickname` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系人微信昵称',
  `remark` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `gender` int(255) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像url',
  `country` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国家',
  `province` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省份',
  `city` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '城市',
  `type` int(11) DEFAULT NULL COMMENT '0通讯录 1群聊',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新时间',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid_wechatid_friendid` (`cid`,`wechatid`,`friendid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18346 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of tbl_wx_contactinfo
-- ----------------------------


-- ----------------------------
-- Table structure for tbl_version_controls
-- ----------------------------
DROP TABLE IF EXISTS `tbl_version_controls`;
CREATE TABLE `tbl_version_controls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL COMMENT 'cid',
  `version` varchar(255) DEFAULT NULL COMMENT '版本名称',
  `vernumber` int(11) DEFAULT NULL COMMENT '版本号',
  `packagename` varchar(255) DEFAULT NULL COMMENT '包名称',
  `packageurl` varchar(255) DEFAULT NULL COMMENT '软件包地址',
  `flag` int(11) DEFAULT NULL COMMENT '开关，是否开启升级',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;



-- ----------------------------
-- Table structure for tbl_wx_message
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wx_message`;
CREATE TABLE `tbl_wx_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `wechatId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '当前微信id',
  `friendId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '好友微信id',
  `msgSvrId` varchar(255) DEFAULT NULL COMMENT '唯一消息id',
  `isSend` varchar(255) DEFAULT NULL COMMENT '是否发送',
  `contentType` int(11) DEFAULT NULL COMMENT '消息类型',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '消息内容',
  `type` int(11) DEFAULT NULL COMMENT '0个人 1群聊',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37206 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_wx_message
-- ----------------------------


-- ----------------------------
-- Table structure for tbl_timetask
-- ----------------------------
DROP TABLE IF EXISTS `tbl_timetask`;
CREATE TABLE `tbl_timetask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) DEFAULT NULL COMMENT '操作员id',
  `cid` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `tasktype` int(11) DEFAULT NULL COMMENT '任务类型1群发消息2发朋友圈',
  `state` int(11) DEFAULT '1' COMMENT '状态1开启中0已完成',
  `execute_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '执行时间',
  `restype` int(11) DEFAULT NULL COMMENT '资源类型',
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文案内容',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论',
  `attachtype` int(11) DEFAULT NULL COMMENT '附件类型',
  `attachtcontent` varchar(1024) DEFAULT NULL COMMENT '附件内容',
  `whoinvisible` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '不给谁看',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_timetask_details
-- ----------------------------
DROP TABLE IF EXISTS `tbl_timetask_details`;
CREATE TABLE `tbl_timetask_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL COMMENT '主任务id',
  `json_content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '序列化的json字符串',
  `execute_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '子任务执行时间',
  `state` int(11) DEFAULT '1' COMMENT '执行状态1未执行   0已执行',
  `results` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190923 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for tbl_sys_autosettings
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_autosettings`;
CREATE TABLE `tbl_sys_autosettings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `auto_type` int(11) DEFAULT NULL,
  `wechatid` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- ----------------------------
-- Table structure for tbl_wechat_circleinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wx_circleinfo`;
CREATE TABLE `tbl_wx_circleinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sourcewechatid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `wechatid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `wechatnickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `circleid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `publishtime` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `thumbimages` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `images` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `link` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `videothumbimg` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `videourl` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `videodescription` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `videomediaid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `wechatid` (`wechatid`,`circleid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=112255 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



-- ----------------------------
-- Table structure for tbl_wx_friendaddtask
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wx_friendaddtask`;
CREATE TABLE `tbl_wx_friendaddtask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `execute_time` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `wechatid` varchar(255) DEFAULT NULL,
  `accountid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `between_time` int(11) DEFAULT NULL,
  `totalsize` int(11) DEFAULT NULL COMMENT '总次数',
  `doingsize` int(11) DEFAULT NULL COMMENT '剩余次数',
  `successsize` int(11) DEFAULT NULL,
  `sayhellosize` int(11) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tbl_wx_friendaddtask_details
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wx_friendaddtask_details`;
CREATE TABLE `tbl_wx_friendaddtask_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `json_content` varchar(2000) DEFAULT NULL,
  `execute_time` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `wechatid` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tbl_wx_phonenumber
-- ----------------------------
DROP TABLE IF EXISTS `tbl_wx_phonenumber`;
CREATE TABLE `tbl_wx_phonenumber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `wechatid` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '0已使用 1为使用',
  `task_result` int(11) DEFAULT NULL COMMENT '-1未知  0存在微信 1不存在微信',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phonenumber` (`phonenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
