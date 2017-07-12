DROP TABLE IF EXISTS `wanghao_demo_words`;

CREATE TABLE `wanghao_demo_words` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `word` varchar(50) NOT NULL COMMENT '单词文本',
  `word_type` varchar(50) DEFAULT NULL COMMENT '类型, 以"\\n"分隔',
  `mean` varchar(500) DEFAULT NULL COMMENT '释义',
  `pronounce` varchar(100) DEFAULT NULL COMMENT '音标读音，以"\\n"分隔',
  `demo_senten` text COMMENT '中文例句，以"<br>"分隔',
  `parsed` tinyint(4) DEFAULT '0' COMMENT '0-未处理 1-以处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10211 DEFAULT CHARSET=utf8mb4;