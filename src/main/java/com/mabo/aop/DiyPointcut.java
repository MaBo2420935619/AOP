package com.mabo.aop;

/**
 * @Author mabo
 * @Description   定义切点
 */

public class DiyPointcut {

    public void before(){
        System.out.println("---------方法执行前---------");
    }

    public void after(){
        System.out.println("---------方法执行后---------");
    }

}
