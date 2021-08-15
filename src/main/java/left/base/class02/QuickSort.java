package left.base.class02;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月25日 23:48:00
 */
public class  QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {

        if (l < r) {
            //随机交换
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {

        int less = l - 1;
        int more = r;
        //l被复用，当做待选区的指针，l<more，说明待选区还有数字没有比较过，就继续比较
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        //这次交换是因为一开始就用数组最后一位来当划分数，所以把他和大于划分数的第一个数字交换，因为此时more指在大于划分数的左边界
        swap(arr, more, r);
        //这里是more因为换完之后，more此时指的就是等于划分数区间的右边界
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 4, 1, 2, 9, 4};
        quickSort(arr);

    }
}
