package com.yang.multi.thread.future;

import com.yang.multi.thread.future.config.FutureConfig;
import com.yang.multi.thread.future.service.IFutureService;
import com.yang.multi.thread.future.service.impl.FutureServiceImpl;

/**
 * Created by Administrator on 2018/7/31.
 */
public class Application {

    public static void main(String[] args) {
        int sum = 0;
        IFutureService futureService = new FutureServiceImpl();
        for (int i = 0; i < 10; i++) {
            int ret = futureService.createItems(i);
            System.out.println(ret);
            sum += ret;
        }
        System.out.println(String.valueOf(sum));
        FutureConfig.pool.shutdown();
    }
}
