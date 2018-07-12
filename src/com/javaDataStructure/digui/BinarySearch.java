package com.javaDataStructure.digui;

import org.junit.Test;

public class BinarySearch {

    /**
     * 二分查找（循环版本）
     * */
    public int binarySearchLoop(int[] nums, int searchKey) {

        int low = 0;
        int high = nums.length - 1;

        while (true) {
            if (low > high) {
                return -1;
            }
            int middle = (low + high) >> 1;
            if (nums[middle] == searchKey) {
                return middle;
            } else if (nums[middle] < searchKey) {
                low = middle + 1;
            } else if (nums[middle] > searchKey) {
                high = middle - 1;
            }
        }
    }

    public int binarySearchDigui(int[] nums, int searchKey) {

        return recFind(nums, searchKey, 0, nums.length - 1);
    }

    private int recFind(int[] nums, int searchKey, int low, int high) {

        if (low > high) {
            return -1;
        }
        int middle = (low + high) >> 1;
        if (nums[middle] == searchKey) {
            return middle;
        } else if (nums[middle] < searchKey) {
            low = middle + 1;
            return recFind(nums, searchKey, low, high);
        } else if (nums[middle] > searchKey) {
            high = middle - 1;
            return recFind(nums, searchKey, low, high);
        }
        return -1;
    }

    @Test
    public void test() {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        int searchKey = 8;
        System.out.println(binarySearchLoop(nums,searchKey));
        System.out.println(binarySearchDigui(nums,searchKey));
    }
}
