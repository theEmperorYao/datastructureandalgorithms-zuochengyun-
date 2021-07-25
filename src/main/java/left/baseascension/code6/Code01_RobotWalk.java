package left.baseascension.code6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname T
 * @Description TODO
 * @Date 2021/7/24 9:58 下午
 * @Created by tangyao
 */
public class Code01_RobotWalk {

    public final static AtomicInteger atomicInteger = new AtomicInteger();
    public final static AtomicInteger atomicInteger2 = new AtomicInteger();

    /***
     * @description
     * @param n n个位置
     * @param end 到达的位置
     * @param rest 剩余的步数 (可变 ，逐渐减小）
     * @param cur 当前位置（可变）
     * @return int
     * @version V1.0.0
     * @date 10:13 下午 2021/7/24
     * @author tangyao
     */
    public static int walk1(int n, int end, int rest, int cur) {
        if (rest == 0) {
            //base case
            atomicInteger.getAndAdd(1);
            return cur == end ? 1 : 0;
        } else if (cur == 1) {
            return walk1(n, cur + 1, rest - 1, end);
        } else if (cur == n) {
            return walk1(n, cur - 1, rest - 1, end);
        } else {
            return walk1(n, cur + 1, rest - 1, end) + walk1(n, cur - 1, rest - 1, end);

        }
    }

    public static int ways1(int n, int end, int rest, int cur) {
        if (n < 0 || end < 1 || end > n || rest < 1 || cur < 1 || cur > n) {
            return 0;
        }
        return walk1(n, end, rest, cur);
    }


    public static int walk2(int n, int end, int rest, int cur, int[][] dp) {

        //缓存命中
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }


        //没命中
        if (rest == 0) {
            //base case
            dp[rest][cur] = (cur == end ? 1 : 0);
        } else if (cur == 1) {
            dp[rest][cur] = walk1(n, cur + 1, rest - 1, end);
        } else if (cur == n) {
            dp[rest][cur] = walk1(n, cur - 1, rest - 1, end);
        } else {
            dp[rest][cur] = walk1(n, cur + 1, rest - 1, end) + walk1(n, cur - 1, rest - 1, end);
        }


        return dp[rest][cur];
    }

    /**
     * 加缓存
     */
    public static int ways2(int n, int end, int rest, int cur) {
        if (n < 0 || end < 1 || end > n || rest < 1 || cur < 1 || cur > n) {
            return 0;
        }
        // rest 取值 0~ rest cur范围为1~n ，不能取0
        int[][] dp = new int[rest + 1][cur + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return walk2(n, end, rest, cur, dp);
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        int times1 = ways1(100, 4, 20, 10);
        long end = System.nanoTime();
        System.out.println("times1 = " + times1);
        System.out.println("atomicInteger = " + atomicInteger);
        System.out.println("消耗时间" + (end - start));

        long start2 = System.nanoTime();
        int times2 = ways2(100, 4, 20, 10);
        long end2 = System.nanoTime();
        System.out.println("times2 = " + times2);
        System.out.println("atomicInteger2 = " + atomicInteger2);

        System.out.println("消耗时间" + (end2 - start2));
    }

}
