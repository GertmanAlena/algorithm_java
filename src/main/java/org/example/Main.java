package org.example;

import java.util.Date;
import java.util.Scanner;

public class Main {

    final static int[] buffer = new int[100000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длинну массива -> ");
        Integer length = scanner.nextInt();

        int[] array1 = interArray(length);
//        Date start = new Date();
        mergeSort(array1);
//        Date end = new Date();
//        long timeMerge = end.getTime() - start.getTime();
//        System.out.print("after -> ");
        System.out.print("отсортированный массив ->  ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
//        Date start2 = new Date();
//        arraySort(interArray(length));
//        Date end2 = new Date();
//        long timeInter = end2.getTime() - start2.getTime();

        System.out.println();
//        System.out.printf("timeMerge = %d, timeInter = %d", timeMerge, timeInter);

        System.out.print("Какое число ищем? -> ");
        int value = scanner.nextInt();

//        Date startBinarySearch = new Date();
        binarySearch(array1, value);
//        Date endBinarySearch = new Date();
//        long BinarySearch = endBinarySearch.getTime() - startBinarySearch.getTime();

//        Date startBinarySearch2 = new Date();
        binarySearch2(array1, value);
//        Date endBinarySearch2 = new Date();
//        long BinarySearch2 = endBinarySearch2.getTime() - startBinarySearch2.getTime();

//        System.out.printf("BinarySearch = %d, BinarySearch2 = %d", BinarySearch, BinarySearch2);

    }
    public static void binarySearch(int[]array, int value){ // 3, 5, 8, 10, 15, 28, 36
        System.out.println("binarySearch " + binarySearch(array, value, 0, array.length -1));
    }
    private static Integer binarySearch(int[]array, int value, int left, int right){
        int midpoint;
        if (right < left){
            return -1;
        } else {
            midpoint = (right - left) / 2 + left;
        }

        if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, right);
        } else {
            if (array[midpoint] > value) {
                return binarySearch(array, value, left, midpoint - 1);
            } else {
                return midpoint;
            }
        }

    }

    private static Integer binarySearch2(int[]array, int value){

        int left = 0, right = array.length - 1;
        while (right - left > 1){
            int mid = (right - left) / 2;
            if (array[mid] < value){
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[left] == value){
            System.out.println("binarySearch2 " + left);
            return left;
        }
        if (array[right] == value){
            System.out.println("binarySearch2 " + right);
            return right;
        }
        System.out.println("binarySearch2 " + null);
        return null;

    }
    public static void mergeSort (int[] array){  // сотрировка слиянием
        mergeSort(array, 0, array.length - 1);

    }

    private static void mergeSort (int[] array, int left, int right){
        if (left == right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        //слияние
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                buffer[k] = array[i];
                i++;
            } else {
                buffer[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            buffer[k++] = array[i++];
        }
        while (j <= right) {
           buffer[k++] = array[j++];
        }
        // перекладываем из буфера в array

        for (int l = left; l <= right; l++) {
            array[l] = buffer[l];
//            System.out.print(array[l] + " ");
        }

    }


    public static int[]interArray (int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.print("первоначальный массив - >  ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }
    public static int[]arraySort (int[] array) { //сортировка вставками

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++){
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        return array;
    }

}
