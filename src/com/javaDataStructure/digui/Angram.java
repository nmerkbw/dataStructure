package com.javaDataStructure.digui;

import org.junit.Test;

public class Angram {

    private int count = 1;
    private char[] charArray = "abcd".toCharArray();

    public void doAngram(int newSize) {

        // 只剩下一个元素的时候返回
        if (newSize == 1) {
            return;
        }

        for (int i = 0; i < newSize; i++) {
            doAngram(newSize - 1);
            // 只剩下两个元素的时候将其打印
            if (newSize == 2) {
                System.out.print("第"+(count++)+"个: ");
                for (int j = 0; j < charArray.length; j++) {
                    System.out.print(charArray[j]);
                }
                System.out.println();
            }
            swapPosTail(newSize);
        }
    }

    private void swapPosTail(int newSize) {

        int pos = charArray.length - newSize;
        int i = pos + 1;
        char temp = charArray[pos];
        for (i = pos + 1; i < charArray.length; i++) {
            charArray[i - 1] = charArray[i];
        }
        charArray[i - 1] = temp;
    }

    @Test
    public void test() {

        int newSize = charArray.length;
        doAngram(newSize);
    }
}
