package com.sorting;

import java.util.Arrays;

public class BubbleSort implements Sort{
    /* Bubble sort Compares adjacent element and later is less than previous its swap
     in this way it keeps on sorting elements from last on each iteration of an array
     bubble sort is a stable sorts meaning it preserves the order of sorting
     time Complexity - n*n
     space complexity : in place algorithm */
    public static void main (String ... args) {
        Sort.initializeArray();
        sort(array);

    }


    protected static void sort(int[] array) {
        int length =array.length-1;
        for(int i =0; i< length; i++) {
            for(int j=0; j < length -i ; j++) {
                if(array[j] > array[j +1]) {
                    Sort.swap(array,j,j+1);
                }
            }
        }
        Arrays.stream(array).forEach(System.out :: println);
    }
}
