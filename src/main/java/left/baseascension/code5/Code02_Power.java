package left.baseascension.code5;

/**
 * @Classname Code02_Power
 * @Description TODO
 * @Date 2021/7/8 10:20 下午
 * @Created by tangyao
 */
public class Code02_Power {

    public static boolean is2Power(int n) {
        // n & (~n + 1) 获取到 一个数最右侧 的1 ，和自己比较 ，相等 说明是2 的幂，因为2的幂的二进制只能有一个1
        return (n & (~n + 1)) == n;
    }

    // 000 ... 1000与 0000.... 0111 & 的结果为0
    public static boolean is2Power2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static boolean is4Power(int n) {

        //0x55555555 为 ....01010101 32位，因为4的幂只能在0，2，4，8...位置为1且只有1个1（首先满足是2的幂）
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(is2Power(10));
        System.out.println(is2Power(4));
        System.out.println(is2Power2(10));
        System.out.println(is2Power2(4));
        System.out.println(is4Power(10));
        System.out.println(is4Power(4));
    }

}
