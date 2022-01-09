package com.example.basic.concurrency.synchronizedExercise;

public class SynchorizedExercise02 {


    Object obj = new Object();

    public void func() {
        synchronized (obj) {

        }
        method2();
    }

    private void method2() {
        System.out.println("2233");
    }
}
