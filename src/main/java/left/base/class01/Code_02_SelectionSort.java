package left.base.class01;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月15日 00:06:00
 */
public class Code_02_SelectionSort {

    public static void selectionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        //i是开头的位置哪个开始到最后-1的位置 0~N-1 1~N-1
        // i < arr.length - 1中没有=，因为如果到了最后一个位置，就没必要比较了
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, minIndex, i);
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 334, 53, 34, 63, 6, 32};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
