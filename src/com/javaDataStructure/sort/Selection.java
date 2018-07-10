package com.javaDataStructure.sort;

public class Selection {

    public int[] selectionSort(int[] nums) {

        int length = nums.length;
        int min;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[min] > nums[j]) {
                    int temp = min;
                    min = j;
                    j = temp;
                }
            }
        }
        return nums;
    }
}
