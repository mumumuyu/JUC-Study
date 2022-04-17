package com.lgd.demo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/17 15:48
 */
public class Ticket_Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
//        ExecutorService service = Executors.newFixedThreadPool(5);
//        service.execute(ticket);
//        service.execute(ticket);
//        service.execute(ticket);
//        service.shutdown();
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
class Ticket {
    private int tickets = 100;

    public synchronized void buy(){
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "拿到了最后第" + tickets-- + "张票");
        }
    }
}
