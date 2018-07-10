package com.javaDataStructure.sort;

public class Insertion {

    public int[] insertionSort(int[] nums) {

        int length = nums.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
