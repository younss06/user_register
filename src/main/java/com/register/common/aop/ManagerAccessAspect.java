package com.register.common.aop;

import com.register.common.utils.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * The ManagerAccessAspect class
 *
 * @author Younuss EL KASSMI
 */

@Aspect
@Configuration
public class ManagerAccessAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.register.manager.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        LOGGER.info("Before method:" + joinPoint.getSignature() + " "
                + DateUtils.getCurrentDateTime("yyyy/MM/dd HH:mm:ss"));
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                LOGGER.info("Input " + i + ": " + args[i].toString());
            }
        }
    }

    @After("execution(* com.register.manager.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        LOGGER.info("After method:" + joinPoint.getSignature()
                + " " + DateUtils.getCurrentDateTime("yyyy/MM/dd HH:mm:ss"));
    }

    @AfterReturning(pointcut = "execution(* com.register.manager.*.*(..))", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        LOGGER.info("AfterReturning method:" + joinPoint.getSignature() + ", Result: " + result);
    }
}