package left.baseascension.code6;

public class Code04_BobDie {

    public static int process(int m, int n, int x, int y, int rest) {
        if (x < 0 || x == m || y < 0 || y == n) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }

        return process(m, n, x, y - 1, rest - 1) +
                process(m, n, x, y + 1, rest - 1) +
                process(m, n, x + 1, y, rest - 1) +
                process(m, n, x - 1, y, rest - 1);
    }

    public static String getBobChanceOfSurvival1(int m, int n, int x, int y, int rest) {


        long pow = (long) Math.pow(4, rest);
        int live = process(m, n, x, y, rest);
        long gcd = gcd(pow, live);
        return (live / gcd) + "/" + (pow / gcd);

    }

    public static String getBobChanceOfSurvival2(int m, int n, int x, int y, int rest) {

        long pow = (long) Math.pow(4, rest);
        int live = process2(m, n, x, y, rest);
        long gcd = gcd(pow, live);
        return (live / gcd) + "/" + (pow / gcd);

    }


    public static int process2(int m, int n, int x, int y, int rest) {

        if (x < 0 || x == m || y < 0 || y == n || rest < 0) {
            return 0;
        }
        // 防止 +1 -1 数组越界 ，所以 取值为 m+2和 n+2 实际用的是 1~m 和 1~n
        int[][][] dp = new int[m + 2][n + 2][rest + 1];

        // rest 为 0 且x ,y 没越界 dp[i][j][h] 就是1 一个解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int h = 1; h <= rest; h++) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j][h] += dp[i][j - 1][h - 1];
                    dp[i][j][h] += dp[i][j + 1][h - 1];
                    dp[i][j][h] += dp[i - 1][j][h - 1];
                    dp[i][j][h] += dp[i + 1][j][h - 1];
                }
            }
        }
        return dp[x + 1][y + 1][rest];
    }


    // 取两个数的最大公约数 辗转相除法
    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }


    public static void main(String[] args) {
        String bobChanceOfSurvival1 = getBobChanceOfSurvival1(10, 9, 4, 5, 10);
        System.out.println("bobChanceOfSurvival1 = " + bobChanceOfSurvival1);

        String bobChanceOfSurvival2 = getBobChanceOfSurvival2(10, 9, 4, 5, 10);
        System.out.println("bobChanceOfSurvival2 = " + bobChanceOfSurvival2);

    }
}
