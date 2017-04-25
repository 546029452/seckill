--数据库初始化脚本

--创建数据库
create database seckill;

--使用数据库
use seckill;

--创建秒杀数据库
create table seckill(
	`seckill_id` BIGINT not null auto_increment comment '商品库存id',
	`name` VARCHAR(120) not null COMMENT '商品名称',
	`number` INT not null COMMENT '库存数量',
	`start_time` TIMESTAMP not null COMMENT '秒杀开启时间',
	`end_time` TIMESTAMP not null comment '秒杀结束时间',
	`create_time` TIMESTAMP not null  default CURRENT_TIMESTAMP comment  '创建时间',
	PRIMARY KEY (seckill_id),
	KEY idx_start_time(start_time),
	KEY idx_end_time(end_time)
)ENGINE=INNODB auto_increment=1000 default CHARSET=utf8 COMMENT ='秒杀库存表'

--初始化数据
insert into  seckill(name,number,start_time,end_time)
	values 
		('100元秒杀联想笔记本',1000,'2017-04-15 00:00:00','2017-04-16 00:00:00'),
		('100元秒杀iphone7',1000,'2017-04-15 00:00:00','2017-04-16 00:00:00'),
		('100元秒杀苹果笔记本',1000,'2017-04-15 00:00:00','2017-04-16 00:00:00'),
		('100元秒杀华为9',1000,'2017-04-15 00:00:00','2017-04-16 00:00:00')
	
--秒杀成功明细
--用户登录认证相关信息
create table success_killed(
	`seckill_id` bigint not null comment '秒杀商品id',
	`user_phone` bigint not null comment '用户手机号',
	`state` tinyint not null default -1  comment '状态标示：-1：无效 0：成功  1：已付款',
	`create_time` timestamp not null comment '创建时间',
	PRIMARY KEY(seckill_id,user_phone),/*联合主键*/
	key idx_create_time(create_time)
)engine=INNODB default charset=utf8 comment='秒杀成功明细表';
--连接数据库控制台
mysql -uroot -p

--为什么手写ddl
--记录每次上线的ddl修改
--上线v1.1
alter table seckill
drop index idx_create_time,
add index idx_c_s(start_time,create_time);
--上线v1.2
--。。。
		