package com.sshmygin.aoppractice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Pointcut("within(com.sshmygin.aoppractice.app..*)")
    private void allClasses(){}

    @Around("allClasses()")
    private Object logTimeExecutionForAllClasses(ProceedingJoinPoint joinPoint) {

        long startTime = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("Execution of method {} in {} has took {}ms", joinPoint.getSignature().getName(), joinPoint.getThis(), executionTime);
        return proceed;
    }
}
