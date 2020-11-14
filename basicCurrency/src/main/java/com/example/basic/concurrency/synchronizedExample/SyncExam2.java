package com.example.basic.concurrency.synchronizedExample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作用于静态方法和类的情况下syn
 */
@Slf4j
public class SyncExam2 {

    public static void test1(){
        synchronized (SyncExam2.class){
            for (int i = 0; i < 10; i++) {
                log.info("num-{}",i);
            }
        }
    }
    public static synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            log.info("num-{}",i);
        }
    }

    public static void main(String[] args) {
        SyncExam2 syncExam1 = new SyncExam2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            syncExam1.test1();
        });
        executorService.execute(()->{
            syncExam1.test1();
        });
//        executorService.execute(()->{
//            syncExam1.test2();
//        });
//        executorService.execute(()->{
//            syncExam1.test2();
//        });


    }
}
