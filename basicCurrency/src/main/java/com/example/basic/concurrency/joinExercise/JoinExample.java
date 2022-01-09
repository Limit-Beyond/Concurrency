package com.example.basic.concurrency.joinExercise;

import org.junit.Test;

/**
 * 线程之间的协作
 * 在线程中调用另一个线程的join方法 会将当前线程挂起 而不是忙等 直到目标线程结束
 */
public class JoinExample {

    private class A extends Thread {
        public A() {
        }

        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {
        private A a;

        public B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    @Test
    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }
}
