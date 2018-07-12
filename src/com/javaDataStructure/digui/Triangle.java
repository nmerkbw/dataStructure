package com.javaDataStructure.digui;

import org.junit.Test;

public class Triangle {

    /**
     * 循环实现
     * */
    public int getTriangleLoop(int n) {

        int total = 0;
        for (int i = n; i > 0; i--) {
            total += i;
        }
        return total;
    }

    /**
     * 递归实现
     */
    public int getTriangleDigui(int n) {

        System.out.println("Entering: n = " + n);
        if (n == 1) {
            System.out.println("Returning: 1");
            return 1;
        }
        int temp = n + getTriangleDigui(n - 1);
        System.out.println("Returning: " + temp);
        return temp;
    }

    @Test
    public void test() {

        System.out.println(getTriangleLoop(10));
        System.out.println(getTriangleDigui(10));
    }
}
