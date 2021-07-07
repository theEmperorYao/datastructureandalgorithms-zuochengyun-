package left.baseascension.code5;

/**
 * @Classname GetMax
 * @Description TODO
 * @Date 2021/7/7 10:26 下午
 * @Created by tangyao
 */
public class GetMax {


    public static int flip(int n) {
        // ^异或 相同为0 不同为1
        return n ^ 1;
    }

    public static int sign(int n) {
        //正整数和0（非负数） ： 1  负数 ： 0     & 与 都是1为1 ，否则为0
        return flip((n >> 31) & 1);
    }

    public static int getMax1(int a, int b) {
        int c = a - b;
        int sign = sign(c);
        return a * sign + b * flip(sign);
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int signA = sign(a);
        int signB = sign(b);
        int signC = sign(c);

        // a和b的符号不一样为1，一样为0
        int disSab = signA ^ signB;
        // a和b的符号不一样为0，一样为1
        int sameSab = flip(disSab);
        //如果符号不相同(disSab==1)，且A是非负数(signA==1)，
        // 或者 符号相同(sameSab == 1)，A>=B(差值C>=0，signC==1),因为符号相同作差不会溢出
        int returnA = disSab * signA + sameSab * signC;
        int returnB = flip(returnA);

        // 就是将if else 换成了 数学中的 + ，因为 + 两边互斥
        return returnA * a + returnB * b;
    }


    public static void main(String[] args) {

        int a = -16;
        int b = 1;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147480000;
        System.out.println(getMax1(a, b)); // wrong answer because of overflow
        System.out.println(getMax2(a, b));
    }
}
