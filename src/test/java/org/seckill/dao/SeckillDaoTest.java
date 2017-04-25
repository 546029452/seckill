package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载sprigIOC容器
 * @author 雨巷等你
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration("classpath:spring-dao.xml")
public class SeckillDaoTest {

	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() {
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1000L, killTime);
		System.out.println(updateCount);
	}

	@Test
	public void testQueryById() {
		
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
	}
	
	/**
	 * java没有保存形参的记录：queryAll(arg0,arg1)
	 * 必须指定参数对应的哪个值
	 */
	@Test
	public void testQueryAll() {
		List<Seckill> seckills = seckillDao.queryAll(1, 2);
		for(Seckill seckill:seckills){
			System.out.println(seckill);
		}
	}

}
