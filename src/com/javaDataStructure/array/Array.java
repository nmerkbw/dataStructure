package com.javaDataStructure.array;

import java.util.NoSuchElementException;

public class Array {

    private long[] a;
    // 数组中元素的个数
    private int nElems;

    public Array(int max) {

        a = new long[max];
        nElems = 0;
    }

    /**
     * 返回数组中的元素个数
     */
    public int size() {

        return nElems;
    }

    /**
     * 在数组中插入元素（插入后数组保持有序）
     */
    public void insert(long value) {

        int index;
        for (index = 0; index < nElems; index++) {
            if (a[index] > value) {
                break;
            }
        }
        // 元素向后移一位
        for (int i = nElems;i>index;i--) {
            a[i] = a[i - 1];
        }
        a[index] = value;
        nElems++;
    }

    /**
     * 在数组中删除指定值的元素
     */
    public void delete(long value) {

        int index = find(value);
        // 因为定义的数组尺寸是16，所以为达到最大尺寸时，若i+1=nElems时，不会报错
        for (int i = index; i < nElems; i++) {
            a[i] = a[i + 1];
        }
        nElems--;
    }

    /**
     * 查找数组中任意元素的的位置
     *
     * @require 数组为有序数组
     */
    public int find(long searchValue) {

        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {

            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchValue) {
                return curIn;
            } else if (lowerBound > upperBound) {
                throw new NoSuchElementException("数组列表中未找到该元素！");
            } else{
                if (a[curIn] > searchValue) {
                    upperBound = curIn - 1;
                }else {
                    lowerBound = curIn + 1;
                }
            }
        }
    }

    public void display() {

        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int maxsize = 16;
        Array array = new Array(maxsize);
        array.insert(1);
        array.insert(8);
        array.insert(3);
        array.insert(9);
        array.insert(4);
        array.insert(6);
        array.display();
        System.out.println(array.find(3));
        array.delete(9);
        array.display();
    }
}
