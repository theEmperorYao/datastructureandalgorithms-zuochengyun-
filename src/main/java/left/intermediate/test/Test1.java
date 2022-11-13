package left.intermediate.test;

public class Test1 {


    /**
     * @param N     n个位置
     * @param start 开始位置
     * @param aim   最终位置
     * @param K     走k步
     * @return
     */
    public static int way1(int N, int start, int aim, int K) {

        return process1(start, K, aim, N);
    }

    private static int process1(int cur, int rest, int aim, int n) {

        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }

        if (cur == 1) {
            process1(cur + 1, rest - 1, aim, n);
        }

        if (cur == n) {
            process1(cur - 1, rest - 1, aim, n);
        }

        return process1(cur + 1, rest - 1, aim, n) + process1(cur - 1, rest - 1, aim, n);

    }

    public static int way2(int N, int start, int aim, int K) {

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return process2(start, K, aim, N, dp);
    }


    private static int process2(int cur, int rest, int aim, int n, int[][] dp) {

        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }

        int ans;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(cur + 1, rest - 1, aim, n, dp);
        } else if (cur == n) {
            ans = process2(cur - 1, rest - 1, aim, n, dp);
        } else {

            ans = process2(cur + 1, rest - 1, aim, n, dp) + process2(cur - 1, rest - 1, aim, n, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    public static int way3(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        // N 位置 K剩余次数
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;// 第一列 填完

        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur <= N - 1; cur++) {
                dp[cur][rest] = dp[cur + 1][rest - 1] + dp[cur - 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }


        return dp[start][K];
    }


    public static void main(String[] args) {
        int i = way1(7, 2, 4, 4);
        System.out.println("i = " + i);
        int i1 = way2(7, 2, 4, 4);
        System.out.println("i1 = " + i1);
        int i2 = way3(7, 2, 4, 4);
        System.out.println("i2 = " + i2);
    }

}
