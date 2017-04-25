package org.seckill.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Autowired
	@Resource
	private SeckillService seckillService;
	@Test
	public void testGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}",list);
		
	}

	@Test
	public void testGetById() {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}",seckill);
	}

	@Test
	public void testExportSeckillUrl() {
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("exposer={}",exposer);
	}

	@Test
	public void testExecuteSeckill() {
		long id = 1000;
		long phone = 123123;
		String md5 = "0d247cd070d0150c908740714954e194";
		try{
			SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
			logger.info("result={}"+execution);
		}catch(RepeatKillException e){
			logger.error(e.getMessage());
		}catch(SeckillCloseException e){
			logger.error(e.getMessage());
		}
	}

	
}
