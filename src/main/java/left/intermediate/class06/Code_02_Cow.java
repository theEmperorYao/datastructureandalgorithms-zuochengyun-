package left.intermediate.class06;

/**
 * @Title:Cow
 * @Author: tangyao
 * @CreateTime: 2023/01/09  11:18
 * @Description:
 * @Version: 1.0
 */
public class Code_02_Cow {

    //  1 2 3 5 7
    // f(n) = f(n-1)+f(n-3)
    public static long getCowNum1(int year) {
        if (year == 1 || year == 2 || year == 3) {
            return year;
        }
        long res = getCowNum1(year - 1) + getCowNum1(year - 3);
        return res;
    }


    public static long getCowNum2(int year) {
        if (year <= 0) {
            return -1;
        }
        long[] dp = new long[year + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[dp.length - 1];
    }

    public static long getCowNum3(int year) throws Exception {

        if (year < 1) {
            return 0;
        }
        if (year == 1 || year == 2 || year == 3) {
            return year;
        }

        // 这是根据 f(n) = f(n-1)+f(n-3) 所以这是3阶的矩阵
        // 所以
        /**
         *    1     2    3      4   6   9    13
         *   f(1) f(2)  f(3)  f(4) f(5) f(6)  f(7)
         *   代入得到
         *                                                   n-3
         *                                            a b c
         *   [f(n) f(n-1) f(n-2)] = [f(3) f(2) f(1)]  d e f
         *                                            g h i
         *
         *  算出这个矩阵为 1 1 0
         *               0 0 1
         *               1 0 0
         */
        int[][] matrix = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] ints = Code_01_Fibonacci.matrixPower(matrix, year - 3);
        // f(n) = 3*a+2*d +g
        // 时间复杂度为logn 级别
        return 3L * ints[0][0] + 2L * ints[1][0] + ints[2][0];

    }


    public static void main(String[] args) throws Exception {
        long cowNum = getCowNum1(19);
        System.out.println("cowNum = " + cowNum);
////
        long cowNum2 = getCowNum2(19);
        System.out.println("cowNum2 = " + cowNum2);

        long cowNum3 = getCowNum3(19);
        System.out.println("cowNum3 = " + cowNum3);
    }

}
