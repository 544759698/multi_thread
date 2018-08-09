package com.yang.multi.thread.future.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/8/9.
 */
@Component
public class FutureConfig {

    public static ExecutorService pool = null;


    /**
     * 初始化线程池大小
     */
    public static synchronized void createPool() {
        pool = Executors.newFixedThreadPool(100);
    }
}
