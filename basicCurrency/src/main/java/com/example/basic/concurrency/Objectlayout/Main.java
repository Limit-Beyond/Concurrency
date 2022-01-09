package com.example.basic.concurrency.Objectlayout;

import org.openjdk.jol.info.ClassLayout;

public class Main {

    public static void main(String[] args) {
        ObjectLayoutDTO objectLayoutDTO = new ObjectLayoutDTO();
        //输出 objectLayoutDTO对象 的布局
        System.out.println(ClassLayout.parseInstance(objectLayoutDTO).toPrintable());
    }
}
