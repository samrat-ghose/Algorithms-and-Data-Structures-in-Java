package me.ramswaroop.tests;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/15/15
 * Time: 11:27 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class Threads {
    public static void main(String[] a) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    System.out.println("====== " + Thread.currentThread().getName() + " woke up ======");
                }
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
    }
}
