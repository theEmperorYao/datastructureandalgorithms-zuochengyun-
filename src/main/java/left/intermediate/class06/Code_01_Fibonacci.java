package left.intermediate.class06;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Title:Test6
 * @Author: tangyao
 * @CreateTime: 2023/01/06  16:04
 * @Description: TODO
 * @Version: 1.0
 */
public class Code_01_Fibonacci {


    public static int fastPower(int num, int power) {
        int res = 1;
        while (power != 0) {
            if ((power & 1) != 0) {
                res *= num;
            }
            power >>= 1;
            num *= num;
        }
        return res;
    }

    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }


    }

    public static long fibonacci2(long number) {

        if (number == 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }

        List<Integer> list = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(number).map(n -> n[1]).toList();
        return list.get(list.size() - 1);
    }


    public static int fi(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};

        int[][] ints = matrixPower(base, n - 2);
        return ints[0][0] + ints[1][0];
    }

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;
        for (; p != 0; p >>= 1) {
            // 相当于 p % 2 ！=0 ,也就是2进制 那一位为1
            if ((p & 1) != 0) {
                res = multiMatrix(res, t);
            }
            t = multiMatrix(t, t);
        }
        return res;

    }

    /**
     * 矩阵相乘
     *
     * @param m1
     * @param m2
     * @return
     */
    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int i = fastPower(5, 4);
        double pow = Math.pow(5, 4);
        System.out.println("i = " + i);
        System.out.println("pow = " + pow);

        int[][] a = {{1, 2}, {3, 4}};

        int[][] b = {{1, 0}, {1, 1}};
        int[][] ints = multiMatrix(a, b);

        System.out.println("ints = " + ints);

        for (int[] anInt : ints) {
            for (int ii : anInt) {
                System.out.print(ii + " ");
            }
            System.out.println();
        }

        int fi = fi(4);
        System.out.println("fi = " + fi);


        for (int j = 0; j < 10; j++) {
            if (fi(j) != fibonacci(j) || fi(j) != fibonacci2(j)) {
                System.out.println("错误！！！");
            }
        }
        System.out.println("全对！！！");

        long l = fibonacci2(3);
        long l2 = fi(3);
        System.out.println("l2 = " + l2);

    }

}
