package com.yang.multi.thread.future.service.impl;

import com.yang.multi.thread.future.config.FutureConfig;
import com.yang.multi.thread.future.service.IFutureService;
import com.yang.multi.thread.future.task.FutureCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2018/8/9.
 */
public class FutureServiceImpl implements IFutureService {
    @Override
    public int createItems(int i) {
        if (i > 0) {
            if (FutureConfig.pool == null || FutureConfig.pool.isShutdown()) {
                FutureConfig.createPool();
            }
            List<Future<String>> listFuture = new ArrayList<Future<String>>();
            for (int j = 0; j < 10; j++) {
                Callable<String> callable = new FutureCallable();
                Future<String> future = FutureConfig.pool.submit(callable);
                listFuture.add(future);
            }
            for (Future<String> item : listFuture) {
                try {
                    while (true) {
                        if (item.isDone() && !item.isCancelled()) {
                            System.out.println(String.valueOf(i) + "------" + item.get());
                            break;
                        } else {
                            Thread.sleep(100);
                        }
                    }
//                    System.out.println(String.valueOf(i) + "------" + item.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }
}
