package com.host.logging.service;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class HostEventLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(HostEventLoggingAspect.class);


    @Around("@annotation(com.host.logging.service.HostEventLogger)")
    public  void hostLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        logger.info("Host logging started -----------------------------------");
        logger.info(Arrays.toString(args));
        logger.info("Host logging ended -------------------------------------");
        Object result = joinPoint.proceed();

        logger.info("Host logging started second -----------------------------------");
        logger.info((String) result);
        logger.info("Host logging ended -------------------------------------");
//        return result;
    }


    @AfterReturning(pointcut = "execution(* org.springframework.amqp.rabbit.core.RabbitTemplate.convertAndSend(..))", returning = "result")
    public void afterConvertAndSend(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        String exchange = (String) args[0];
        String routingKey = (String) args[1];
        Object message = args[2];

        // Log the message
        logger.info("Intercepted Message: " + Arrays.toString(args) + " sent to exchange: " + exchange + " with routingKey: " + routingKey );
    }
}
