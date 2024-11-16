-- 菜单配置表
CREATE TABLE `kcnq2_menu_config` (
                                     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                     `menu_category` varchar(20) NOT NULL COMMENT '菜单分类',
                                     `menu_subtype` varchar(20) NOT NULL COMMENT '菜单子类',
                                     `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
                                     `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
                                     `jump_url` varchar(255) DEFAULT NULL COMMENT '跳转链接URL',
                                     `display_order` int(11) DEFAULT 0 COMMENT '排序order：越大越靠前',
                                     `is_show` tinyint(1) DEFAULT 1 COMMENT '是否展示',
                                     `status` tinyint(4) DEFAULT 1 COMMENT '处理状态',
                                     `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                     `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
                                     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
                                     `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                     PRIMARY KEY (`id`),
                                     KEY `idx_parent_id` (`parent_id`),
                                     KEY `idx_display_order` (`display_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单配置表';

-- Banner表
CREATE TABLE `kcnq2_banner` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                `banner_name` varchar(100) NOT NULL COMMENT 'banner名称',
                                `image_url` varchar(255) NOT NULL COMMENT '图片url',
                                `jump_url` varchar(255) DEFAULT NULL COMMENT '跳转URL',
                                `display_order` int(11) DEFAULT 0 COMMENT '排序order：越大越靠前',
                                `is_show` tinyint(1) DEFAULT 1 COMMENT '是否展示：1-展示，0-隐藏',
                                `status` tinyint(4) DEFAULT 1 COMMENT '处理状态',
                                `start_time` datetime DEFAULT NULL COMMENT '开始时间',
                                `end_time` datetime DEFAULT NULL COMMENT '结束时间',
                                `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
                                `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                PRIMARY KEY (`id`),
                                KEY `idx_display_order` (`display_order`),
                                KEY `idx_time` (`start_time`, `end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Banner表';

-- 团队成员表
CREATE TABLE `kcnq2_team_member` (
                                     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                     `display_order` int(11) DEFAULT 0 COMMENT '展示排序',
                                     `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
                                     `chinese_name` varchar(50) NOT NULL COMMENT '中文名',
                                     `english_name` varchar(50) DEFAULT NULL COMMENT '英文名',
                                     `position` varchar(100) DEFAULT NULL COMMENT '职位信息',
                                     `description` text COMMENT '详细简介',
                                     `status` tinyint(4) DEFAULT 1 COMMENT '处理状态',
                                     `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                     `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
                                     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
                                     `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                     PRIMARY KEY (`id`),
                                     KEY `idx_display_order` (`display_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='团队成员表';

-- 团队宗旨表
CREATE TABLE `kcnq2_team_purpose` (
                                      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                      `display_order` int(11) DEFAULT 0 COMMENT '展示排序',
                                      `title` varchar(100) NOT NULL COMMENT '主题',
                                      `image_url` varchar(255) DEFAULT NULL COMMENT '图片',
                                      `jump_url` varchar(255) DEFAULT NULL COMMENT '跳转链接',
                                      `brief` varchar(500) DEFAULT NULL COMMENT '简介',
                                      `detail` text COMMENT '详细介绍',
                                      `status` tinyint(4) DEFAULT 1 COMMENT '处理状态',
                                      `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                      `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
                                      `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
                                      `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                      PRIMARY KEY (`id`),
                                      KEY `idx_display_order` (`display_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='团队宗旨表';

-- 文章表
CREATE TABLE `kcnq2_article` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                 `main_title` varchar(200) NOT NULL COMMENT '主标题',
                                 `sub_title` varchar(200) DEFAULT NULL COMMENT '副标题',
                                 `summary` text COMMENT '概要(富文本)',
                                 `category` varchar(50) NOT NULL COMMENT '分类大类：初级科普、进阶科普、表型分类、病例分析、患后事项、药物推荐',
                                 `sub_category` varchar(50) DEFAULT NULL COMMENT '分类小类',
                                 `thumbnail` varchar(255) DEFAULT NULL COMMENT '缩略图',
                                 `summary_image` varchar(255) DEFAULT NULL COMMENT '概要图',
                                 `extra_info1` varchar(500) DEFAULT NULL COMMENT '其他备用信息1',
                                 `extra_info2` varchar(500) DEFAULT NULL COMMENT '其他备用信息2',
                                 `extra_info3` varchar(500) DEFAULT NULL COMMENT '其他备用信息3',
                                 `extra_info4` varchar(500) DEFAULT NULL COMMENT '其他备用信息4',
                                 `extra_info5` varchar(500) DEFAULT NULL COMMENT '其他备用信息5',
                                 `content_id` varchar(24) DEFAULT NULL COMMENT 'MongoDB中文章内容ID',
    -- SEO相关字段
                                 `seo_title` varchar(200) DEFAULT NULL COMMENT 'SEO标题，用于设置页面的title标签',
                                 `seo_keywords` varchar(500) DEFAULT NULL COMMENT 'SEO关键词，多个关键词用英文逗号分隔，用于meta keywords标签',
                                 `seo_description` varchar(1000) DEFAULT NULL COMMENT 'SEO描述，用于meta description标签',
                                 `canonical_url` varchar(255) DEFAULT NULL COMMENT '规范链接(canonical URL)，用于处理重复内容',
                                 `og_title` varchar(200) DEFAULT NULL COMMENT 'Open Graph标题，用于社交媒体分享',
                                 `og_description` varchar(500) DEFAULT NULL COMMENT 'Open Graph描述，用于社交媒体分享',
                                 `og_image` varchar(255) DEFAULT NULL COMMENT 'Open Graph图片URL，用于社交媒体分享预览',
                                 `structured_data` text DEFAULT NULL COMMENT '结构化数据(JSON-LD格式)',
                                 `status` tinyint(4) DEFAULT 1 COMMENT '处理状态',
                                 `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                 `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
                                 `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
                                 `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 PRIMARY KEY (`id`),
                                 KEY `idx_category` (`category`),
                                 KEY `idx_sub_category` (`sub_category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';

-- 留言表
CREATE TABLE `kcnq2_message` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                 `topic` varchar(100) NOT NULL COMMENT '留言主题',
                                 `message_content` text NOT NULL COMMENT '留言内容',
                                 `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
                                 `attachments` text DEFAULT NULL COMMENT '附件内容',
                                 `status` tinyint(4) DEFAULT 1 COMMENT '处理状态',
                                 `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                 `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
                                 `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
                                 `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='留言表';