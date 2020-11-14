package com.example.basic.concurrency.atomic.count;

import com.example.basic.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater
 */
@Slf4j
@ThreadSafe
public class AtomicExample3 {

    private static AtomicIntegerFieldUpdater<AtomicExample3>  updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample3.class,"count");

    @Getter
    public volatile int count = 100;

    private static AtomicExample3 atomicExample3 = new AtomicExample3();

    public static void main(String[] args) {
        if(updater.compareAndSet(atomicExample3,100,120)){
            log.info("update success,{}",atomicExample3.getCount());
        }

        if(updater.compareAndSet(atomicExample3,100,120)){
            log.info("update success,{}",atomicExample3.getCount());
        }else{
            log.info("update failed,{}",atomicExample3.getCount());
        }

    }

}
