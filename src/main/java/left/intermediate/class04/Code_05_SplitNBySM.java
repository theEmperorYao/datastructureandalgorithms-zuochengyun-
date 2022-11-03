package left.intermediate.class04;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Code_05_SplitNBySM {


    public static int[] divsSumAndCount(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            // 这里使用while将每一个 质数 因子 全部除干净
            while (n % i == 0) {
                sum += i;
                count++;
                n = n / i;
            }
        }

        return new int[]{sum, count};
    }

    /**
     * s=a ,m =a
     * 1） m =s ; s = s+s;
     * 2) s=  s+m
     *
     * @param n
     * @return
     */
    public static int minOp(int n) {
        if (n < 2) {
            return 0;
        }

        // 是质数
        if (isPrime(n)) {
            return n - 1;
        }
        // 不是质数 拆分为 N = a*b*c*d 为最优顺序 a,b,c,d 为质数 所以次数 是 a+b+c+d - 因子个数
        int[] ints = divsSumAndCount(n);
        return ints[0] - ints[1];

    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int i = minOp(6);
        System.out.println("i = " + i);

    }

}
