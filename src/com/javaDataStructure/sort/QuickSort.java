package com.javaDataStructure.sort;

public class QuickSort {

    public int[] quickSort(int[] nums) {

        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int low, int high) {

        if (high <= low) {
            return;
        }
        int j = partition(nums, low, high);
        sort(nums, low, j - 1);
        sort(nums, j + 1, high);
    }

    public int partition(int[] nums, int low, int high) {

        int i = low;
        int j = high + 1;
        int val = nums[low];
        while (true) {
            while (nums[++i] < val && i != high) ;
            while (nums[--j] > val && j != low) ;
            if (i >= j) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }
}
