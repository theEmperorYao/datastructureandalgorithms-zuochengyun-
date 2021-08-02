package left.baseascension.code6;

/**
 * @Classname CoinWays
 * @Description
 * <p>
 * 换钱的最少货币数 【题目】 给定数组 arr，arr 中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值 的货币可以使用任意张，再给定一个整数 aim，
 * 代表要找的钱数，求组成 aim 的最少货币 数。
 * <p>
 * 【举例】 arr=[5,2,3]，aim=20。 4 张 5 元可以组成 20 元，
 * 其他的找钱方案都要使用更多张的货币，所以返回 4。 arr=[5,2,3]，aim=0。
 * 不用任何货币就可以组成 0 元，返回 0。 arr=[3,5]，aim=2。 根本无法组成 2 元，钱不能找开的情况下默认返回-1。
 * @Date 2021/8/2 11:10 下午
 * @Created by tangyao
 */
public class Code05_CoinWays {

    public static int way1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    /***
     * @description
     * @param arr 可供选择的数组
     * @param index 当前位置
     * @param rest 剩余的钱
     * @return int
     * @version V1.0.0
     * @date 11:11 下午 2021/8/2
     * @author tangyao
     */
    private static int process(int[] arr, int index, int rest) {

        // base case
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }

        int ways = 0;
        // arr[index] 0张，1张，2张不超过 aim
        for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            ways += process(arr, index + 1, rest - arr[index] * zhang);
        }

        return ways;
    }

    public static int way3(int[] arr, int aim) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                // arr[index] 0张，1张，2张不超过 aim
                for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
                    ways += dp[index + 1][rest - arr[index] * zhang];
                }
                dp[index][rest] = ways;
            }
        }

        return dp[0][aim];
    }

    public static int way2(int[] arr, int aim) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }

            }
        }

        return dp[0][aim];
    }


    public static void main(String[] args) {
        long start1 = System.nanoTime();
        int way1 = way1(new int[]{5, 2, 3}, 1000);
        long start2 = System.nanoTime();
        System.out.println("start2- start1 = " + (start2 - start1));
        System.out.println("way1 = " + way1);

        int way2 = way2(new int[]{5, 2, 3}, 1000);
        long start3 = System.nanoTime();
        System.out.println("start3- start2 = " + (start3 - start2));
        System.out.println("way2 = " + way2);
        System.out.println("way1 ==way2 = " + (way1 == way2));

        int way3 = way3(new int[]{5, 2, 3}, 1000);
        long start4 = System.nanoTime();
        System.out.println("start4- start3 = " + (start4 - start3));
        System.out.println("way3 = " + way3);

        System.out.println("way2 ==way3 = " + (way2 == way3));



    }
}
