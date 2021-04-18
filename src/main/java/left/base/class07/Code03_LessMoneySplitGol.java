package left.base.class07;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月18日 16:24:00
 */
public class Code03_LessMoneySplitGol {

    public static int lessMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int number : arr) {
            queue.add(number);
        }

        int sum = 0;
        while (queue.size() > 1) {
            Integer value = queue.poll() + queue.poll();

            queue.add(value);
            sum += value;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {6, 5, 7, 8};
        System.out.println("lessMoney(arr) = " + lessMoney(arr));

    }
}
