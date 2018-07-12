package com.javaDataStructure.digui;

import org.junit.Test;

public class Factorial {

    public int getFactorial(int n) {

        if (n == 0) {
            return 1;
        }
        int temp = n * getFactorial(n - 1);
        return temp;
    }

    @Test
    public void test() {

        System.out.println(getFactorial(5));
    }
}
