package com.javaDataStructure.sort;

public class TestClient {

    public static void main(String[] args) {

        int[] nums = {23,12,56,3,5,1,38,9,17,33,20,14,24,18};
        int[] arrays = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//        Bubble bubble = new Bubble();
//        Selection selection = new Selection();
//        Insertion insertion = new Insertion();
//        printArray(bubble.bubbleSort(nums));
//        System.out.println();
//        printArray(selection.selectionSort(nums));
//        System.out.println();
//        printArray(insertion.insertionSort(nums));
//        System.out.println();
//        DownToUpMergeSort downToUp = new DownToUpMergeSort();
//        printArray(downToUp.downToUpMergeSort(nums));
//        System.out.println();

//        QuickSort quickSort = new QuickSort();
//        printArray(quickSort.quickSort(arrays));

        HeapSort heapSort = new HeapSort();
        printArray(heapSort.sort(nums));
        System.out.println();
        System.out.println(nums[0]);
    }

    public static void printArray(int[] numbers){

        for (int i = 0;i<numbers.length;i++) {
            System.out.print(numbers[i]+" ");
        }
    }
}
