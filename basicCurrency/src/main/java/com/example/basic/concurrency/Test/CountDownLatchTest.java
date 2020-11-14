package com.example.basic.concurrency.Test;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
@Slf4j
@NotThreadSafe
public class CountDownLatchTest {

    private static Integer clientRequestNum = 1000;

    private static Integer clientNum = 20;

    private static Integer num = 0;

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
        log.info("num:{}",num);
    }

    private static void add(){
        num++;
    }
}
