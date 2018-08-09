package com.yang.multi.thread.future.task;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2018/8/9.
 */
public class FutureCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
        return threadName;
    }
}
