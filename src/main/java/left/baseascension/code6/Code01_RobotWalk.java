package left.baseascension.code6;

/**
 * @Classname T
 * @Description TODO
 * @Date 2021/8/26 0:00
 * @Created by tangyao
 */
public class Code01_RobotWalk {

    /**
     * @param n    N个位置
     * @param cur  当前位置
     * @param rest 剩余步数
     * @param aim  目标位置
     * @return void
     * @description
     * @version V1.0.0
     * @date 8:42 下午 2021/8/25
     * @author tangyao
     */
    public static int walk1(int n, int cur, int rest, int aim) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        } else if (cur == 1) {
            return walk1(n, cur + 1, rest - 1, aim);
        } else if (cur == n) {
            return walk1(n, cur - 1, rest - 1, aim);
        } else {
            return walk1(n, cur + 1, rest - 1, aim) + walk1(n, cur - 1, rest - 1, aim);
        }
    }


    public static int walk2(int n, int cur, int rest, int aim) {

        if (n < 2 || cur < 1 || cur > n || rest < 0 || aim < 0 || aim > n) {
            return 0;
        }

        int[][] dp = new int[n + 1][rest + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return walk2(n, cur, rest, aim, dp);
    }

    public static int walk2(int N, int cur, int rest, int aim, int[][] dp) {

        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            dp[cur][rest] = walk2(N, cur + 1, rest - 1, aim, dp);
        } else if (cur == N) {
            dp[cur][rest] = walk2(N, cur - 1, rest - 1, aim, dp);
        } else {
            dp[cur][rest] = walk2(N, cur + 1, rest - 1, aim, dp) + walk2(N, cur - 1, rest - 1, aim, dp);
        }

        return dp[cur][rest];
    }

    public static int walk3(int n, int cur, int rest, int aim) {

        if (n < 2 || cur < 1 || cur > n || rest < 0 || aim < 0 || aim > n) {
            return 0;
        }
        int[][] dp = new int[n + 1][rest + 1];
        dp[aim][0] = 1;
        for (int j = 1; j <= rest; j++) {
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    dp[i][j] = dp[2][j - 1];
                } else if (i == n) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[cur][rest];

    }


    public static void main(String[] args) {

        long start = System.nanoTime();
        int times1 = walk1(100, 4, 20, 10);
        System.out.println("times1 = " + times1);
        long end = System.nanoTime();
        System.out.println("end - start = " + (end - start));

        start = System.nanoTime();
        int times2 = walk2(100, 4, 20, 10);
        end = System.nanoTime();
        System.out.println("times2 = " + times2);
        System.out.println("end - start = " + (end - start));

        start = System.nanoTime();
        int times3 = walk3(100, 4, 20, 10);
        end = System.nanoTime();
        System.out.println("times3 = " + times3);
        System.out.println("end - start = " + (end - start));

    }

}
