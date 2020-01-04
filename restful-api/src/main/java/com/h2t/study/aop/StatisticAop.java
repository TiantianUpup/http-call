package com.h2t.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/04 10:37
 */
@Aspect
public class StatisticAop {
    private final Logger LOGGER = LoggerFactory.getLogger(StatisticAop.class);

    @Pointcut("execution(* com.h2t.study.controller..*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        Object result = null;

        try {
            result = pjp.proceed();
            String declaringTypeName = pjp.getSignature().getDeclaringTypeName();
            String methodName = pjp.getSignature().getName();
            System.out.println(declaringTypeName);
            System.out.println(methodName);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            LOGGER.error(throwable.getMessage(), throwable);
            throw new RuntimeException(throwable);
        } finally {
            LOGGER.info("cost {}msc", System.currentTimeMillis() - start);
        }

        return result;
    }
}
