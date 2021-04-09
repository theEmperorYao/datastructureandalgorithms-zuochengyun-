package left.base.class02;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月25日 19:53:00
 */

/**
 * 如果当前数<=num,把这个数和<=区域下一个数的位置交换，然后<=区域扩一个位置
 */
public class Partition {

    public static void partition(int[] arr, int num) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int cur = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                swap(arr, i, cur + 1);
                cur++;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 7, 2, 1, 64,4,4,4,4,4,4,4};
        partition(arr, 4);
    }
}
