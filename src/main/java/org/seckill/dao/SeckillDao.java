package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import com.sun.org.glassfish.gmbal.ParameterNames;

public interface SeckillDao {

	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return 如果影响行数>1，表示更新的记录行数
	 * 多个参数，必须指定实际的形参
	 */
	int reduceNumber(@Param("seckillId")Long seckillId,@Param("killTime")Date killTime);
	
	/**
	 * 根据id查询秒杀对象
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(Long seckillId);
	
	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param offset
	 * @param limit
	 * @return
	 * 多个参数，必须指定实际的形参
	 */
	List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit);
}
