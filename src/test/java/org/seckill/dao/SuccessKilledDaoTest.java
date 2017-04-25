package org.seckill.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载sprigIOC容器
 * @author 雨巷等你
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {

	//注入Dao实现类依赖
//	@Resource
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() {
		/*
		 * 第一次 insertCount = 1
		 * 第二次 insertCount = 0
		 * 由于忽略了异常所有返回了0
		 */
		long id = 1001l;
		long phone = 22222222222l;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println(insertCount);
	}

	@Test
	public void testQueryByIdWithSeckill() {
		
		long id = 1000l;
		long phone = 11111111111l;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled.getSeckillId());
		System.out.println(successKilled.getSeckill());
	}

}
