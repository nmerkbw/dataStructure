package com.javaDataStructure.sort;

public class Selection {

    public int[] selectionSort(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
}
