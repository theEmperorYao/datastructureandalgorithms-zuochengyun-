package left.baseascension.code6;

/**
 * @Classname Code02_CoinsMin
 * @Description TODO
 * @Date 2021/7/25 7:48 下午
 * @Created by tangyao
 */
public class Code02_CoinsMin {

    /***
     * @description
     * @param arr 很多面值组成的数组，面值可相同
     * @param index 当前位置
     * @param rest 剩余的钱
     * @return int
     * @version V1.0.0
     * @date 7:50 下午 2021/7/25
     * @author tangyao
     */
    public static int process(int[] arr, int index, int rest) {

        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        // rest>0
        if (index == arr.length) {
            return -1;
        }
        // 不收集该位置 金币
        int p1 = process(arr, index + 1, rest);

        // 收集该位置金币
        int p2 = process(arr, index + 1, rest - arr[index]);

        if (p1 == -1 && p2 == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2 + 1;
            }
            if (p2 == -1) {
                return p1;
            }
            return Math.min(p1, p2 + 1);
        }
    }

    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    public static int process2(int[] arr, int index, int rest, int[][] dp) {

        // 前两个判断当做缓存命中条件判断，因为数组下标不能表示负数
        if (rest < 0) {
            return -1;
        }
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }


        if (rest == 0) {
            // 一个正确解
            dp[index][rest] = 0;
        } else if (index == arr.length) {
            // rest>0 ,此时 金币加起来不够 目标值，但是没有值可以再取了
            dp[index][rest] = -1;
        } else {
            // rest>0
            // 不收集该位置 金币
            int p1 = process2(arr, index + 1, rest, dp);
            // 收集该位置金币
            int p2 = process2(arr, index + 1, rest - arr[index], dp);

            if (p1 == -1 && p2 == -1) {
                dp[index][rest] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][rest] = p2 + 1;
                } else if (p2 == -1) {
                    dp[index][rest] = p1;
                } else {
                    dp[index][rest] = Math.min(p1, p2 + 1);
                }
            }
        }
        return dp[index][rest];
    }

    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -2;
            }
        }
        return process2(arr, 0, aim, dp);
    }


    public static int minCoins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        int row = arr.length + 1;
        int col = aim + 1;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j < col; j++) {
            dp[row - 1][j] = -1;
        }

        // index 为 row ，rest 为 col 的二维坐标 某一个位置的值，
        // 最终求得的结果是dp[0][aim];从 process(arr, 0, aim)这里得知
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {


                // 依赖于 [index + 1][rest] 也就是[index ][rest]下面这个值，意思是不将这枚硬币计入结果中的一枚，直接统计下面的结果
                // 或者 [index + 1][rest - arr[index] + 1 意思是将这枚硬币计入结果中的一枚，并统计下面的结果
                int p1 = dp[index + 1][rest];

                int p2 = -1;
                if (rest - arr[index] >= 0) {
                    p2 = dp[index + 1][rest - arr[index]];
                }

                if (p1 == -1 && p2 == -1) {
                    dp[index][rest] = -1;
                } else {
                    if (p1 == -1) {
                        dp[index][rest] = p2 + 1;
                    } else if (p2 == -1) {
                        dp[index][rest] = p1;
                    } else {
                        dp[index][rest] = Math.min(p1, p2 + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 3, 4, 5, 6, 2, 23};
        long start = System.nanoTime();
        int minCoins1 = minCoins1(arr, 9);
        System.out.println("minCoins1 = " + minCoins1);
        long end1 = System.nanoTime();
        System.out.println("start1 - end1 = " + (end1 - start));


        int minCoins2 = minCoins2(arr, 9);
        System.out.println("minCoins2 = " + minCoins2);
        long end2 = System.nanoTime();
        System.out.println("end2 - end1 = " + (end2 - end1));

        int minCoins3 = minCoins3(arr, 9);
        System.out.println("minCoins3 = " + minCoins3);
        long end3 = System.nanoTime();
        System.out.println("end2 - end1 = " + (end3 - end2));
    }

}
