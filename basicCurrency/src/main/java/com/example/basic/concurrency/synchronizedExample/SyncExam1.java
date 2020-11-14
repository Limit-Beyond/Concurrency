package com.example.basic.concurrency.synchronizedExample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExam1 {

    public void test1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("num-{}",i);
            }
        }
    }
    public synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            log.info("num-{}",i);
        }
    }

    public static void main(String[] args) {
        SyncExam1 syncExam1 = new SyncExam1();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->{
//            syncExam1.test1();
//        });
//        executorService.execute(()->{
//            syncExam1.test1();
//        });

        executorService.execute(()->{
            syncExam1.test2();
        });
        executorService.execute(()->{
            syncExam1.test2();
        });


    }
}
