package left.base.class01;



/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月14日 23:53:00
 */
public class Code_01_InsertionSort {

    public static void insertionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        // i是要往前面有序数中插入的当前数
        for (int i = 1; i < arr.length; i++) {
            //j是有序数组中最大的数，如果与j+1(待插入数)位置交换，还要继续往前比较直到不能交换为止
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
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
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

}
