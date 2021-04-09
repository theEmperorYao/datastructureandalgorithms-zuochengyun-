package leetcode.leetcode1to100.leetcode1to10;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年08月20日 11:47:00
 */
public class q7_ReverseInteger {
    public static int reverse(int x) {
        String s = String.valueOf(x);
        char sign = 0;
        if (s.charAt(0) == '-') {
            s = s.substring(1);
            sign = '-';
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            chars[i] ^= chars[chars.length - i - 1];
            chars[chars.length - i - 1] ^= chars[i];
            chars[i] ^= chars[chars.length - i - 1];
        }
        int num = Integer.parseInt(chars.toString());
        if (Integer.toString(num).charAt(0) == sign) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        reverse(-999);
    }

}
