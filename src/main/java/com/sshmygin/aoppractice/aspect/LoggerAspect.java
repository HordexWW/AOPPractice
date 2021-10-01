package com.sshmygin.aoppractice.aspect;

import com.sshmygin.aoppractice.app.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Pointcut("within(com.sshmygin.aoppractice.app..*)")
    private void allClasses(){}

    @Pointcut("execution(public void com.sshmygin.aoppractice.app.service.MessageService.addMessage(..)) &&" +
            "args(message)")
    private void messageServiceAddMessageMethod(Message message) {}

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

    @AfterReturning(value = "messageServiceAddMessageMethod(message)", argNames = "message")
    public void logPostedMessage(Message message) {
        log.info("Message from {} has been posted. Content {}", message.getSender(), message.getContent());
    }

    @AfterThrowing(value = "execution(public void com.sshmygin.aoppractice.app.service.MessageService.throwException())", throwing = "e")
    public void logAfterThrowingExceptionIn(IllegalStateException e) {
        log.error(e.getMessage());
    }

}
