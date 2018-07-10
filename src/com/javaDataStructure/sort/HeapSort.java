package com.javaDataStructure.sort;

public class HeapSort {


    public int[] sort(int[] nums) {

        int N = nums.length - 1;
        for (int k = N / 2; k >= 0; k--) {
            sink(nums, k, N);
        }
        while (N > 1) {
            // 一交换就断
            swap(nums, 1, N--);
            sink(nums,1,N);
        }
        return nums;
    }
    /**
     * @description 上浮操作
     */
    private void swim(int[] nums, int k) {

        while (k > 1 && nums[k / 2] < nums[k]) {
            swap(nums, k / 2, k);
            k = k / 2;
        }
    }

    /**
     * @description 下沉操作
     */
    public void sink(int[] nums, int k, int N) {

        while (k * 2 <= N) {
            int j = 2 * k;
            if (j < N && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[k] >= nums[j]) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    /**
     * @description 数组交换操作
     */
    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
