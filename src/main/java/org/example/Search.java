package org.example;

import java.util.Scanner;

public class Search {
    final static int[] buffer = new int[100000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длинну массива -> ");
        Integer length = scanner.nextInt();

        int[] array = interArray(length);
//        int[] array = new int[]{2, 57, 52, 1, 52, 88, 94, 41, 93};
        Integer x = array.length / 2 - 1;
        Integer end = array.length -1;
        heap(array, x, end);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
    public static int[]interArray (int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }
    public static void heap(int[] array, int x, int end){
        if (end == x){
            return;
        }
        int largest = x;
        if (end == 1){
            if(array[largest] < array[end])
                return;
        }

//        int left = 2 * x + 1;
//        int right = 2 * x + 2;
        while (x >= 0) {
            int left = 2 * x + 1;
            int right = 2 * x + 2;
            if (left <= end && array[left] > array[x]){
                largest =  left;
            }
            if (right <= end && array[right] > array[largest]){
                largest =  right;
            }
            if (largest != x){
                int temp = array[x];
                array[x] = array[largest];
                array[largest] = temp;
                x--;
                largest = x;
            } else {
                x--;
                largest = x;
            }

        }
        int temp = array[end];
        array[end] = array[0];
        array[0] = temp;

        x = end / 2 - 1;

        if (2 * x + 1 <= end-1 || 2 * x + 2 <= end-1) {
            heap(array, end / 2 - 1, end-1);
        } else {
            heap(array, x-1, end-1);
        }

    }
}
