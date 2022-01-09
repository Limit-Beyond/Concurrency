package com.example.basic.concurrency.Lockcoarsening;

/**
 * 锁粗化
 */
public class LockcoarseningDemo {


    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("a");
        //每次的append操作都是对锁的加锁和释放锁的过程 即使不存在锁竞争，频繁地进行交互也会引发不必要的性能操作
        //此时锁会进行粗化 将append合并为一次加锁释放锁的过程
        sb.append("b");
        sb.append("c");
        System.out.println(sb.toString());
    }
}
