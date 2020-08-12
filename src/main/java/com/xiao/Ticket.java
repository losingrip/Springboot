package com.xiao;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ticket extends Thread {

    public static void main(String[] args) {
        window w = new window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);


        t1.setName("窗口1");
        t2.setName("窗口2");

        t1.start();
        t2.start();
    }

    static class window  implements Runnable {
        private static int ticket = 30;
        public void run() {
            while (true) {
                if (ticket > 0) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "当前售出" + ticket + "票");
                    ticket--;
                }
            }
        }
    }

    public static class runmost {
        public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            much much = new much();
            more more = new more();
            executorService.execute(much);
            executorService.execute(more);

        }
    }

    static class much implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<=30;i++){
                if (i%2==0)
                    System.out.println(Thread.currentThread().getName()+"==="+i);
            }
        }
    }
    static class more implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<=30;i++){
                if (i%2==1)
                    System.out.println(Thread.currentThread().getName()+"==="+i);
            }
        }
    }
}
