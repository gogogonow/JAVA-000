-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) NOT NULL,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
   id                   varchar(64) NOT NULL COMMENT '商品分类id',
   parent_id            varchar(64) DEFAULT NULL COMMENT '上级分类的id：一级分类的父节点为null',
   name                 varchar(64) DEFAULT NULL COMMENT '名称',
   sort                 int DEFAULT 0 COMMENT '排序',
   icon                 varchar(255) DEFAULT NULL COMMENT '图标',
   keywords             varchar(255) DEFAULT NULL COMMENT '关键字',
   description          text DEFAULT NULL COMMENT '描述',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类表';


-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
   id                   varchar(64) NOT NULL COMMENT '品牌id',
   name                 varchar(64) DEFAULT NULL COMMENT '名称',
   first_letter         varchar(8) DEFAULT NULL COMMENT '首字母',
   sort                 int DEFAULT 0 COMMENT '排序',
   logo                 varchar(255) DEFAULT NULL COMMENT '品牌logo',
   brand_story          text DEFAULT NULL COMMENT '品牌故事',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌表';


-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
   id                   varchar(64) NOT NULL COMMENT '商品id',
   brand_id             varchar(64) COMMENT '品牌id',
   product_category_id  varchar(64) COMMENT '商品分类id',
   name                 varchar(64) NOT NULL COMMENT '商品名称',
   pic                  varchar(255) DEFAULT NULL COMMENT '图片',
   delete_status        int(1) DEFAULT 0 COMMENT '删除状态：0->未删除；1->已删除',
   publish_status       int(1) DEFAULT 0 COMMENT '上架状态：0->下架；1->上架',
   sort                 int DEFAULT 0 COMMENT '排序',
   sale                 int DEFAULT 0 COMMENT '销量',
   price                decimal(10,2) DEFAULT 0 COMMENT '价格',
   promotion_price      decimal(10,2) DEFAULT 0 COMMENT '促销价格',
   sub_title            varchar(255) DEFAULT NULL COMMENT '副标题',
   description          text DEFAULT NULL COMMENT '商品描述',
   stock                int DEFAULT 0 COMMENT '库存',
   unit                 varchar(16) DEFAULT NULL COMMENT '单位',
   weight               decimal(10,2) DEFAULT 0 COMMENT '商品重量，默认为克',
   keywords             varchar(255) DEFAULT NULL COMMENT '关键字',
   note                 varchar(255) DEFAULT NULL COMMENT '备注',
   album_pics           varchar(255) DEFAULT NULL COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
   detail_title         varchar(255) DEFAULT NULL COMMENT '详情标题',
   detail_desc          text DEFAULT NULL COMMENT '详情描述',
   detail_html          text DEFAULT NULL COMMENT '产品详情网页内容',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';


-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
   id                   varchar(64) NOT NULL COMMENT '订单id',
   order_sn             varchar(64) NOT NULL COMMENT '订单编号',
   create_time          datetime NOT NULL COMMENT '提交时间',
   member_username      varchar(64) NOT NULL COMMENT '用户帐号',
   total_amount         decimal(10,2) COMMENT '订单总金额',
   pay_amount           decimal(10,2) COMMENT '应付金额（实际支付金额）',
   pay_type             int(1) COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
   status               int(1) COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
   delivery_company     varchar(64) COMMENT '物流公司(配送方式)',
   delivery_sn          varchar(64) COMMENT '物流单号',
   receiver_name        varchar(100) NOT NULL COMMENT '收货人姓名',
   receiver_phone       varchar(32) NOT NULL COMMENT '收货人电话',
   receiver_post_code   varchar(32) COMMENT '收货人邮编',
   receiver_province    varchar(32) COMMENT '省份/直辖市',
   receiver_city        varchar(32) COMMENT '城市',
   receiver_region      varchar(32) COMMENT '区',
   receiver_detail_address varchar(200) COMMENT '详细地址',
   note                 varchar(500) DEFAULT NULL COMMENT '订单备注',
   confirm_status       int(1) COMMENT '确认收货状态：0->未确认；1->已确认',
   delete_status        int(1) NOT NULL DEFAULT 0 COMMENT '删除状态：0->未删除；1->已删除',
   use_integration      int COMMENT '下单时使用的积分',
   payment_time         datetime COMMENT '支付时间',
   delivery_time        datetime COMMENT '发货时间',
   receive_time         datetime COMMENT '确认收货时间',
   COMMENT_time         datetime COMMENT '评价时间',
   modify_time          datetime COMMENT '修改时间',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
