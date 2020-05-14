

create database FindWork;
use FindWork;

create table t_role(
	Rid int(10) auto_increment unique not null primary key comment '角色ID，主键',
    Rname varchar(20) unique not null comment '角色名',
    delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    create_at datetime comment '创建时间',
    update_at datetime comment '修改时间'
);

create table t_business(
	Bid int(10) unique not null auto_increment primary key comment '企业ID，主键',
    Rid int (10) comment '角色ID，外键',
    Bname varchar(50) not null comment '企业名称',
    Bcity varchar (20) not null comment '企业所在城市',
    Btelephone int(12) not null comment '企业联系电话',
    Bemail varchar(50) comment '企业邮箱',
    Baddress varchar(255) comment '企业地址',
    Bdescription varchar(255) comment '企业简介',
    Burl varchar(255) comment '公司详情超链接',
    delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    create_at datetime comment '创建时间',
    update_at datetime comment '修改时间',
    constraint FK_BUSINESS_ROLE_RID foreign key(Rid) references t_role(Rid)
) comment='企业表';

create table t_user(
	Uid int(10) not null auto_increment unique  primary key comment '用户ID，主键',
    Rid int(10) comment '角色ID，外键',
    Uname varchar(20) not null comment '用户姓名',
    Upassword varchar(20) not null comment '密码',
    Uaddress varchar(255) comment '地址',
    Uimagepath varchar(255) comment '头像地址',
    Utelephone int(12) comment '用户联系电话',
    Uemail varchar(50) comment '邮箱',
    Ubirthday date comment '用户生日',
    delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    create_at datetime comment '创建时间',
    update_at datetime comment '修改时间',
    constraint FK_USER_ROLE_RID foreign key (Rid) references t_role(Rid)
) comment='用户表';

create table t_cv(
	Cid int(10) unique not null auto_increment primary key comment '简历ID，主键',
    Uid int(10) comment '用户ID，外键',
    Uname varchar(20) comment '简历所属用户姓名',
    Utelephone int(12) comment '联系电话',
    Ctitle varchar(100) comment '简历标题',
    Ccontent text comment '简历内容',
    Upolitics_status varchar(20) comment '政治面貌',
    Cskill varchar(255) comment '特长，技能',
    Cexperience varchar(255) comment '工作经历',
    Clive_province varchar(20) comment '居住省份',
    Clive_city varchar(20) comment '居住城市',
    Cwant_joy_type varchar(50) comment '想要的工作类型：实习、全职。。。',
    Cwant_province varchar(20) comment '想去的省份',
    Cwant_city varchar(20) comment '想去的城市',
    Cwant_low_wages int(10) comment '期望最低工资',
    Cwant_large_wages int(10) comment '期望最高工资',
    Cwant_post varchar(50) comment '意向行业职位',
    delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    create_at datetime comment '创建时间',
    update_at datetime comment '修改时间',
    constraint FK_CV_USER_UID foreign key(Uid) references t_user(Uid)
) comment='简历表';

create table t_advertise(
	Aid int(10) unique not null auto_increment primary key comment '主键',
    Bid int (10) comment '企业ID，外键',
    Bname varchar(50) comment '企业名',
    Atitle varchar(200) comment '招聘标题',
    Apost varchar(50) not null comment '招聘岗位',
    Alow_wages int(10) comment '最低工资',
    Alarge_wages int (10) comment '最高工资',
    Aask varchar(255) comment '岗位要求',
    Awant_joy_type varchar(50) comment '想招的工作类型：实习，全职。。',
    Adeadline datetime comment '接受报名截止日期',
    delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    create_at datetime comment '创建时间',
    update_at datetime comment '修改时间',
    constraint FK_ADVERTISE_BUSINESS_BID foreign key (Bid) references t_business(Bid)
) comment='招聘信息表';

create table t_comment(
	Cid int(10) unique not null auto_increment primary key comment '主键',
    Aid int(10) comment '外键（招聘信息表）',
    Uid int(10) comment '外键（用户表）',
    Ccontent varchar(255) not null comment '评论内容',
    Ctime datetime not null comment '何时评论',
    Canswer varchar(255) comment '企业回复内容',
    Canswer_time datetime comment '企业回复时间',
    delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    constraint FK_COMMENT_ADVERTISE_AID foreign key (Aid) references t_advertise(Aid),
    constraint FK_COMMENT_USER_UID foreign key (Uid) references t_user(Uid)
) comment='评论信息表';

create table t_collection_advertise(
	Cid int(10) unique not null auto_increment primary key comment '主键',
    Uid int(10) comment '外键（用户表）',
    Aid int(10) comment '外键（招聘信息表）',
    delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    create_at datetime comment '创建时间',
    update_at datetime comment '修改时间',
    constraint FK_COLLECTION_AD_USER_UID foreign key(Uid) references t_user(Uid),
    constraint FK_COLLECTION_AD_ADVERTISE_AID foreign key(Aid) references t_advertise(Aid)
) comment='收藏中心（简历）';

create table t_collection_Business(
	Cid int(10) unique not null auto_increment primary key comment '主键',
    Uid int(10) comment '外键（用户表）',
    Bid int(10) comment '外键（企业表）',
    delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    create_at datetime comment '创建时间',
    update_at datetime comment '修改时间',
    constraint FK_COLLECTION_BU_USER_UID foreign key(Uid) references t_user(Uid),
    constraint FK_COLLECTION_BU_BUSINESS_BID foreign key(Bid) references t_business(Bid)
) comment='收藏中心（企业）';

create table t_advertisement(
	Aid int(10) unique not null auto_increment primary key comment '主键',
    Atopic varchar(200) comment '广告主题',
    Bid int(10) comment '外键（企业表）',
    Acost int(10) not null comment '广告费用',
    Apicture varchar(150) comment '宣传图片地址',
    Aurl varchar(100) comment '宣传链接',
     delete_flag int(1) not null default 0 comment '删除标识，0：正常，1：已删除',
    comment varchar(255) comment '备注',
    create_at datetime comment '创建时间',
    update_at datetime comment '修改时间',
    constraint FK_ADVERTISEMRNT_BUSINESS_BID foreign key(Bid) references t_business(Bid)
) comment='广告表';


ALTER TABLE `findwork`.`t_cv` 
ADD COLUMN `Ceducation_background` VARCHAR(255) NULL COMMENT '学历' after `Ccontent`;

ALTER TABLE `findwork`.`t_cv` 
ADD COLUMN `Cself-appraisal` VARCHAR(255) NULL COMMENT '自我评价' AFTER `Ccontent`;

ALTER TABLE `findwork`.`t_advertise` 
ADD COLUMN `Aeducation_background` VARCHAR(255) NULL COMMENT '学历' AFTER `Apost`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `passowrd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;







