package com.javaDataStructure.sort;

public class DownToUpMergeSort {

    public int[] downToUpMergeSort(int[] nums) {

        int length = nums.length;
        int[] aux = new int[length];
        int i = 0;
        int j = 0;
        int mid = 0;
        int high = 0;
        for (int size = 1; size < length; size = size * 2) {
            for (int low = 0; low < length - size; low = low + size * 2) {
                i = low;
                mid = low + size - 1;
                high = Math.min(low + size + size - 1, length - 1);
                j = mid + 1;
                // 复制数组
                for (int k = low; k <= high; k++) {
                    aux[k] = nums[k];
                }
                for (int k = low; k <= high; k++) {
                    if (i > mid) {
                        nums[k] = aux[j++];
                    } else if (j > high) {
                        nums[k] = aux[i++];
                    } else if (aux[i] < aux[j]) {
                        nums[k] = aux[i++];
                    } else {
                        nums[k] = aux[j++];
                    }
                }
            }
        }
        return nums;
    }
}
