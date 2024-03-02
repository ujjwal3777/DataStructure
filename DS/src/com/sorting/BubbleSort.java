package com.sorting;

import java.util.Arrays;

public class BubbleSort {
    /* Bubble sort Compares adjacent element and later is less than previous its swap
     in this way it keeps on sorting elements from last on each iteration of an array
     bubble sort is a stable sorts meaning it preserves the order of sorting
     time Complexity - n*n
     space complexity : in place algorithm */
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
        for(int i =0; i< length; i++) {
            for(int j=0; j < length -i ; j++) {
                if(array[j] > array[j +1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] =temp;
                }
            }
        }
        Arrays.stream(array).forEach(System.out :: println);
    }
}
