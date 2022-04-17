package com.lgd.demo01;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/17 15:13
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());//获取cpu
        long l = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
}
