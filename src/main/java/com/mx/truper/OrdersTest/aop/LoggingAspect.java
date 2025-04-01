package com.mx.truper.OrdersTest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Component
public class LoggingAspect {
	
//	@Around(value = "execution(* com.mx.truper.OrdersTest.controllers..*(..))")
	@Around(value = "execution(* com.mx.truper.OrdersTest.services.OrdenService..*(..))")
	public Object logExecTime(ProceedingJoinPoint joinPoint) {
	
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object proceed = null;
		try {
			
			proceed = joinPoint.proceed();
			
		} catch (Throwable e) {

			log.error(e.getMessage());
			
		}
		
		stopWatch.stop();
		log.info("Tiempo de ejecucion: {} nanosegundos", stopWatch.getTotalTimeNanos());
		
		return proceed;
		
	}
	
}
