package left.base.class02;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月25日 20:15:00
 */

/**
 * 小于区域在左边，推着等于区域往右跑，大于区域在右边，中间是待定区域
 */
public class NetherlandsGlag {

    public static int[] partition(int[] arr, int num, int left, int right) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        int less = left - 1;
        int more = right + 1;
        int cur = left;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        return new int[]{less + 1, more - 1};


    }

    private static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 9, 7, 2, 1, 4, 6};
        int[] partition = partition(arr, 4, 0, arr.length - 1);
        System.out.println();
        for (int i : partition) {
            System.out.print(i + " ");
        }

    }
}
