package left.intermediate.class02;

/**
 * @Classname Code_01_UniqueBST
 * @Description TODO
 * @Date 2022/6/4 18:30
 * @Author by tangyao
 */
public class Code_01_UniqueBST {

    public static int process(int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int res = 0;
        for (int left = 0; left <= n - 1; left++) {
            int leftWays = process(left);
            int rightWays = process(n - 1 - left);
            res += leftWays * rightWays;
        }

        return res;

    }

    public static int dpProcess(int n) {

        if (n < 2) {
            return 1;
        }

        int[] dp = new int[n + 1];


        dp[0] = 1;

        // 节点个数为i的时候
        for (int i = 1; i <= n; i++) {

            // 左侧节点个数为j，右侧节点个数为n-1-j
            for (int j = 0; j <= i - 1; j++) {

                dp[i] += dp[j] * dp[i - 1 - j];
            }

        }
        return dp[n];


    }


    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            if (process(i) == dpProcess(i)) {
                System.out.println("正确！！！");
            } else {
                System.out.println("错误！！！");
            }
        }

        int i = dpProcess(50);
        System.out.println("i = " + i);

    }
}
