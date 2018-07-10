package com.javaDataStructure.sort;

public class Bubble {

    public int[] bubbleSort(int[] nums) {

        int length = nums.length;
        boolean hasSorted = false;

        for(int i = 0; i < length && !hasSorted; i++) {
            hasSorted = true;
            for(int j = 0; j < length - 1 - i; j++) {
                if(nums[j]>nums[j+1]) {
                    hasSorted = false;
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}
