package left.base.class02;

import java.util.PriorityQueue;

/**
 * @Classname Code01_SortArrayDistanceLessK
 * @Description 堆排序扩展题目 已知一个几乎有序的数组，几乎有序
 * 是指，如果把数组排好顺序的话，每个元 素移动的距离可以不超过k，
 * 并且k相对于数组来说比较小。请选择一个合适的 排序算法针对这个数据进行排序。
 * @Date 2021/8/15 5:02 下午
 * @Created by tangyao
 */
public class Code02_SortArrayDistanceLessK {


    /**
     * 小跟堆的应用
     * 时间复杂度 O(N*logK)
     *
     * @param arr
     * @param k
     */
    public static void sortArrayDistanceLessK(int[] arr, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int index = 0;

        for (; index < Math.min(arr.length, k); index++) {
            priorityQueue.add(arr[index]);
        }

        int i = 0;
        for (; index < arr.length; index++) {
            priorityQueue.add(arr[index]);
            arr[i++] = priorityQueue.poll();
        }
        while (priorityQueue.size() != 0) {
            arr[i++] = priorityQueue.poll();
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

    }


    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 4, 5, 3, 6, 7, 3, 5};
        sortArrayDistanceLessK(arr, 5);

    }
}
