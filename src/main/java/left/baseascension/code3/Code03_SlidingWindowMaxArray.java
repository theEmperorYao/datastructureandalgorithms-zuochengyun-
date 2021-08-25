package left.baseascension.code3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Classname Code03_SlidingWindowMaxArray
 * @Description TODO
 * @Date 2021/6/25 11:54 下午
 * @Created by tangyao
 */
public class Code03_SlidingWindowMaxArray {

    /**
     * @param arr 待处理数组
     * @param w   最大的窗口宽度
     * @return int[]
     * @description 获取由每个窗口最大值组成的数组
     * @version V1.0.0
     * @date 11:57 下午 2021/6/25
     * @author tangyao
     */
    public static int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || arr.length < w || w < 1) {
            return null;
        }

        //双端队列 维持的信息是 某一时刻，窗口不扩（R不动），L依次往右动，谁会成为最大值的优先级信息
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            //双端队列，保持队列首端是永远是窗口的最大值的下标，随后进入的值依次降低，不符合要求就从尾端弹出去
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            deque.add(i);

            // 时刻保证队列里面是有w个数值
            if (deque.peekFirst() == i - w) {
                deque.pollFirst();
            }

            //将窗口中最大值记录下来,(至少满足组成一个窗口在统计最大值)
            if (i >= w - 1) {
                result.add(arr[deque.peekFirst()]);
            }

        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);
        for (int i : maxWindow) {
            System.out.print(" " + i);
        }
    }

}
