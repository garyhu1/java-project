package com.garyhu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	@Around(value="execution(* com.garyhu.service.ProductService.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("start log : "+joinPoint.getSignature().getName());
		Object obj = joinPoint.proceed();
		System.out.println("end log : "+joinPoint.getSignature().getName());
		return obj;
	}
}
