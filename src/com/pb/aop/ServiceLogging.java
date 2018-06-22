package com.pb.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ServiceLogging {
	private Log log = LogFactory.getLog(this.getClass());	
	@Pointcut("execution(public * com.pb.service.*.*(..))")
	public void myPointcut(){}	
	@Before("myPointcut()")
	//@Before("execution(public * com.pb.service.*.*(..))")
	public void beforeService(JoinPoint joinPoint){	
		log.info("前置增强处理被执行");
		log.info("连接点对象："+joinPoint.getTarget().getClass().getSimpleName());
		log.info("连接点方法："+joinPoint.getSignature());
		log.info("连接点方法参数："+joinPoint.getArgs()[0]);
	}
	@After("myPointcut()")
	public void after(){
		log.info("最终增强处理被执行");
	}
	@AfterReturning(pointcut="myPointcut()",returning="returnVal")
	public void afterReturning(Object returnVal){
		log.info("后置增强处理被执行");
		log.info("后置增强处理：方法返回值为："+returnVal);
	}
	@AfterThrowing(pointcut="myPointcut()",throwing="ex")
	public void afterThrowing(Exception ex){
		log.info("业务方法抛出了异常，异常增强处理被执行");
		log.info("抛出的异常为："+ex.getMessage());
	}
	@Around("myPointcut()")
	public Boolean around(ProceedingJoinPoint pjp) throws Throwable{
		log.info("环绕增强处理：目标方法执行前织入");
		log.info("环绕增强处理：目标方法的参数："+pjp.getArgs()[0]);
		Boolean b = null;
		if(true){
			b = (Boolean)pjp.proceed(pjp.getArgs());
		}
		log.info("环绕增强处理：目标方法的返回值为："+b);
		log.info("环绕增强处理：目标方法执行后织入");
		return b;
	}
}
