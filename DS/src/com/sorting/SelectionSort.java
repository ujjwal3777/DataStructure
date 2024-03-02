package com.sorting;

import java.util.Arrays;

public class SelectionSort {
    /*Selection Sort finds maximum element in each iteration and swp the max element with last unsorted elements.
    Selection Sort is not stable sort
    Time Complexity : n*n
    Space Complexity : in place algorithm
    Doesn't require as much swap as Bubble Sort  */
    public static void main (String ... args) {
        int[] array = new int[7];
        array[0] =12;
        array[1] = 21;
        array[2] = 7;
        array[3] = 10;
        array[4] = 9;
        array[5] = 31;
        array[6] = 2;
        int temp =0;
        int length =array.length-1;
        for(int i =length; i>0; i--) {
            int max = 0;
            for(int j =1; j <=i; j++) {
                if(array[j] > array[max]) {
                    max = j;
                }
            }
            temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }

        Arrays.stream(array).forEach(System.out :: println);
    }

}
