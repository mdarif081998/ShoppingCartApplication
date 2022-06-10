package com.md.arif.aop;
import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	@Pointcut("execution(* com.md.arif.repository.*.*(..))")
	public void dataLayerExecution(){}
	
	@Pointcut("execution(* com.md.arif.service.*.*(..))")
	public void businessLayerExecution(){}
	
	@Pointcut("@annotation(com.md.arif.aop.TrackTime)")
	public void trackTimeAnnotation(){}

}
