package org.seckill.exception;

/**
 * 秒杀关闭异常（运行期异常）
 * @author 雨巷等你
 *
 */
public class SeckillException extends RuntimeException {

	public SeckillException(String message){
		super(message);
	}
	
	public SeckillException(String message,Throwable cause){
		super(message,cause);
	}
	
}
