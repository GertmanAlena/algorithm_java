package org.example;

import java.util.Date;
import java.util.Scanner;

public class Search {
    final static int[] buffer = new int[100000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длинну массива -> ");
        Integer length = scanner.nextInt();

        int[] array = interArray(length);

//        Integer x = array.length / 2 - 1;
//        Integer end = array.length -1;
//        Date startSort = new Date();
//        heap(array, x, end);
//        Date endSort = new Date();
//        long time1 = endSort.getTime() - startSort.getTime();
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

        // второй вариант из интернета
        // построение кучи
        Date startSort2 = new Date();
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            hearyfy(array, array.length, i);
        }
        // один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // вызваем процедуру hearyfy на уменьшенной куче
            hearyfy(array, i, 0);
        }
        Date endSort2 = new Date();
        long time2 = endSort2.getTime() - startSort2.getTime();
        System.out.println();
        for (int o = 0; o < array.length; o++) {
            System.out.print(array[o] + " ");
        }
        System.out.println();
//        System.out.printf("time1 = %d, time2 = %d", time1, time2);

    }

    private static void hearyfy(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = rootIndex * 2 + 1;
        int rightChild = rootIndex * 2 + 2;

        if (leftChild < heapSize && array[leftChild] > array[rootIndex]){
            largest = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        if (largest != rootIndex){ //если самый большой элемент не корень
            int temp = array[largest];
            array[largest] = array[rootIndex];
            array[rootIndex] = temp;

            hearyfy(array, heapSize, largest);
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
