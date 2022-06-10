package com.md.arif.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Before("com.md.arif.aop.CommonJoinPointConfig.dataLayerExecution()")
	public void before(JoinPoint joinPoint){
		//Advice
		logger.info(" Check for user access ");
		logger.info(" User is Allowed for {}", joinPoint);
	}
}