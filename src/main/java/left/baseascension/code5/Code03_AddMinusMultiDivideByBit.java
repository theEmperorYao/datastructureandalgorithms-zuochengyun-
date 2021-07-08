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


    public static void main(String[] args) {
        int add = add(10, 12);
        System.out.println("add = " + add);


        int minus = minus(10, -1);
        System.out.println("minus = " + minus);

        int multi = multi(3, 4);
        System.out.println("multi = " + multi);
    }
}
