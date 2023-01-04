package left.intermediate.class05;

import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @Classname Code_04_Coffee
 * @Description 给定一个数组arr，arr[i]代表第i号咖啡机泡一杯咖啡的时间
 * 给定一个正数N，表示N个人等着咖啡机泡咖啡，每台咖啡机只能轮流泡咖啡
 * 只有一台洗咖啡机，一次只能洗一个杯子，时间耗费a，洗完才能洗下一杯
 * 每个咖啡杯也可以自己挥发干净，时间耗费b，咖啡杯可以并行挥发
 * 假设所有人拿到咖啡之后立刻喝干净，
 * 返回从开始等到所有咖啡机变干净的最短时间
 * 三个参数：int[] arr、int N，int a、int b
 * @Date 2022/11/27 21:37
 * @Author by tangyao
 */
public class Code_04_Coffee {

    @Data
    static class Node {
        /**
         * 咖啡机什么时候能醒来提供服务
         */
        int timePoint;
        /**
         * 泡一杯咖啡所需的时间
         */
        int workTime;

        public Node(int start, int time) {
            this.timePoint = start;
            this.workTime = time;
        }
    }


    public static int coffee(int[] arr, int N, int a, int b) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        /**
         * 一堆人都想喝咖啡，相当于并行来的，给他们拍个队，让他们整体等待时间最短
         */
        PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> (o.timePoint + o.workTime)));

        for (int i : arr) {
            nodes.add(new Node(0, i));
        }

//        int[] drinks = new int[N];
//        for (int i = 0; i < N; i++) {
//            Node node = nodes.poll();
//            // i号小人喝完的时间
//            node.timePoint += node.workTime;
//            drinks[i] = node.timePoint;
//            nodes.add(node);
//        }

        int[] drinks = IntStream.range(0, N - 1)
                .map(i -> {
                    Node poll = nodes.poll();
                    poll.timePoint += poll.workTime;
                    nodes.add(poll);
                    return poll.timePoint;
                }).toArray();


        return bestTime(drinks, a, b, 0, 0);
    }


    /**
     * @param drinks   所有杯子可以开始洗的时间
     * @param wash     单杯可以洗干净的时间
     * @param air      自然挥发后的时间
     * @param washTime 洗的机器什么时候可用
     * @param index    当前位置
     * @return drinks[index...] 最早的结束时间
     */
    public static int bestTime(int[] drinks, int wash, int air, int washTime, int index) {

        if (index == drinks.length) {
            return 0;
        }

        // 这杯子决定洗 我喝完和咖啡机什么时候可用的时间
        int t1 = Math.max(drinks[index], washTime) + wash;

        // 洗这个杯子，后面杯子的决策
        int t2 = bestTime(drinks, wash, air, t1, index + 1);
        int max = Math.max(t1, t2);


        //这杯子决定不洗
        int t3 = drinks[index] + air;

        //不洗杯子之后的决策
        int t4 = bestTime(drinks, wash, air, washTime, index + 1);
        int max2 = Math.max(t3, t4);

        return Math.min(max, max2);
    }

    public static int bestTimeDp(int[] drinks, int air, int wash) {

        // 全都洗咖啡杯所消耗的时间
        int maxFree = 0;
        for (int drink : drinks) {
            maxFree = Math.max(drink, maxFree) + wash;
        }

        int N = drinks.length;
        int[][] dp = new int[N + 1][maxFree];

        // dp[N][...] = 0

//        for (int index = N - 1; index >= 0; index--) {
//            for (int free = 0; free <= maxFree; free++) {
//
//
//            }
//        }
        return 0;


    }

    public static void main(String[] args) {

        int[] ints = {3, 4, 1, 2, 7};
        int coffee = coffee(ints, 20, 2, 3);
        System.out.println("coffee = " + coffee);

    }
}
