package me.zarktao.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tao on 2017/3/29.
 * <p>
 * The aspect of API call for count;
 */

@Aspect
@Component
public class APICountAspect {
    private static final Logger logger = LoggerFactory.getLogger(APICountAspect.class);

    @Before("execution(* me.zarktao.service.controller.*.*(..))")
    public void apiCount(JoinPoint joinPoint) {
        logger.info("aspect in ===========================================================");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info("aspect == RequestURI: {}", request.getRequestURI());
        logger.info("joinPoint == Signature: {}", joinPoint.getSignature());
    }
}
