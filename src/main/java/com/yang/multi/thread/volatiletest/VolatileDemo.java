package com.yang.multi.thread.volatiletest;

/**
 * @Author: yangguojun01
 * @Date: 2020/11/20
 */
public class VolatileDemo {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;// 1
        flag = true;// 2
    }

    public void reader() {
        if (flag) { // 3
            System.out.println(a); //4
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileDemo demo = new VolatileDemo();
        Thread t1 = new Thread(() -> {
            demo.writer();
        });
        Thread t2 = new Thread(() -> {
            demo.reader();
        });
        t1.start();
        t2.start();
        Thread.sleep(100);
    }
}
