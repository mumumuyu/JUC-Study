package com.lgd.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/17 15:48
 */
public class Ticket_Lock {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.buy();
            }
        },"小明").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.buy();
            }
        },"小红").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.buy();
            }
        },"小兰").start();
    }
}

class Ticket2 {
    private int tickets = 100;
    private Lock lock = new ReentrantLock();

    public void buy(){
        lock.lock();
        try{
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "拿到了最后第" + tickets-- + "张票");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("好像出现了异常捏");
        }finally {
         lock.unlock();
        }
    }
}
