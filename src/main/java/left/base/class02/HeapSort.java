package left.base.class02;

import java.util.Arrays;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月26日 20:25:00
 */
public class HeapSort {


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length - 1;

        while (heapSize > 0) {
            swap(arr, 0, heapSize--);
            heapify(arr, 0, heapSize);
        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

    }

    private static void heapify(int[] arr, int index, int heapSize) {
        while (index * 2 + 1 <= heapSize) {
            int left = index * 2 + 1;
//            int largest = left;
//            if (left + 1 <= heapSize) {
//                largest = arr[left] > arr[left + 1] ? left : left + 1;
//            }
            int largest = (left + 1 <= heapSize && arr[left] < arr[left + 1])
                    ? left + 1 : left;

            if (arr[largest] > arr[index]) {
                swap(arr, largest, index);
                index = largest;
            } else {
                break;
            }
        }
    }


    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {-82, -47, 20, 2, 11};
        heapSort(arr);
        System.out.println();
    }

}
