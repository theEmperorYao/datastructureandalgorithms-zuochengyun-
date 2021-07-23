package left.baseascension.code5;

/**
 * @Classname Code03_AddMinusMultiDivideByBit
 * @Description TODO
 * @Date 2021/7/8 11:09 下午
 * @Created by tangyao
 */
public class Code03_AddMinusMultiDivideByBit {

    /***
     * @description 如果用户给出的两个数就是溢出的，那返回结果就是溢出的
     * @return int
     * @version V1.0.0
     * @date 11:10 下午 2021/7/8
     * @author tangyao
     */
    public static int add(int a, int b) {

        // ^ 是无进位相加， & 是 进位

        int sum = a;

        // b 相当于进位信息 ，a相当于 无进位为相加结果
        while (b != 0) {
            sum = a ^ b;// 无进位相加结果
            b = (a & b) << 1;//进位信息
            a = sum;
        }
        return sum;
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    private static int negNum(int b) {
        return add(~b, 1);
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            // b & 1 就是看b最右边一位是不是1
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;

    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("divisor is 0");
        }
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            int res = div(add(a, 1), b);
            return add(res, div(minus(a, multi(res, b)), b));
        } else {
            return div(a, b);
        }
    }


    public static void main(String[] args) {
        int add = add(10, 12);
        System.out.println("add = " + add);

        int minus = minus(10, -1);
        System.out.println("minus = " + minus);

        int multi = multi(3, 4);
        System.out.println("multi = " + multi);

        int divide = divide(Integer.MIN_VALUE, 3);
        int a = Integer.MIN_VALUE/3;
        System.out.println("divide = " + (a==divide));
    }
}
