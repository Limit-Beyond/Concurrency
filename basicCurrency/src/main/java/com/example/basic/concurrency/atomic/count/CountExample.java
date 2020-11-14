package com.example.basic.concurrency.atomic.count;

import com.example.basic.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ThreadSafe
public class CountExample {
    private static Integer clientRequestNum = 1000;

    private static Integer clientNum = 20;

    private static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientRequestNum);
        final Semaphore semaphore = new Semaphore(clientNum);
        for (int i = 0; i <clientRequestNum ; i++) {
            executorService.execute(()-> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("num:{}",num.get());
    }

    private static void add(){
        num.incrementAndGet();
    }
}
