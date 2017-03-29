package me.zarktao.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Tao on 2017/3/29.
 *
 * The aspect of API call for count;
 */

@Aspect
public class APICountAspect {

    @Before("execution(* me.zarktao.service.controller.*.*(..))")
    public void apiCount(){
        System.out.println("aspect in ===========================================================");
    }
}