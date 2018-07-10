package com.javaDataStructure.simpleSort;

public class QuickSort {

    public int[] quickSort(int[] nums) {

        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int low, int high) {

        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int val = nums[low];
        int temp = 0;

        while (i != j) {
            while (nums[j] >= val) {
                j--;
            }
            while (nums[i] <= val) {
                i++;
            }
            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[i];
        nums[i] = val;

        sort(nums, low, i - 1);
        sort(nums, i + 1, high);
    }
}
