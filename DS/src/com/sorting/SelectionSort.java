package com.sorting;

import java.util.Arrays;

public class SelectionSort implements Sort{
    /*Selection Sort finds maximum element in each iteration and swp the max element with last unsorted elements.
    Selection Sort is not stable sort
    Time Complexity : n*n
    Space Complexity : in place algorithm
    Doesn't require as much swap as Bubble Sort  */
    public static void main (String ... args) {
        Sort.initializeArray();
        sort(array);
    }
    protected static void sort(int[] array) {
        int length =array.length-1;
        for(int i =length; i>0; i--) {
            int max = 0;
            for(int j =1; j <=i; j++) {
                if(array[j] > array[max]) {
                    max = j;
                }
            }
            Sort.swap(array,i,max);
        }
        Arrays.stream(array).forEach(System.out :: println);
    }

}
