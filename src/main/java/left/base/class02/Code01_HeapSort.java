package left.base.class02;

/**
 * @Classname Code_06_HeapSort
 * @Description TODO
 * @Date 2021/8/15 11:11 上午
 * @Created by tangyao
 */
public class Code01_HeapSort {


    /**
     * 删除任意位置节点 向下调整一次的时间复杂度是 logN
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {

        int left = index * 2 + 1;
        // heapSize 来判断有没有越界 。left存在说明一定有孩子（至少存在左孩子）
        while (left < heapSize) {
            // 算出左右孩子最大值下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 如果 孩子中最大的值大于父节点的值，则交换
            if (arr[largest] <= arr[index]) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    /**
     * 增加一个新的节点 调整代价 时间复杂度是logN
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = arr.length;

        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }

        // 第一个与最后一个位置交换，调整大根堆 循环以上
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {

        int[] arr = {3, 34, 13214, 2314, 341, 53, 341, 321432, 3214, 31, 53, 15, 123, 123};

        heapSort(arr);

    }
}
