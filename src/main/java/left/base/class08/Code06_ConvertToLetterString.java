package left.base.class08;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 规定1和A对应、2和B对应、3和C对应...
 * 那么一个数字字符串比如"111"，就可以转化为"AAA"、"KA"和"AK"。
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果。
 * @createTime 2021年06月06日 17:30:00
 */
public class Code06_ConvertToLetterString {

    /**
     * 如果
     *
     * @param str
     * @param i
     */
    public static int process(char[] str, int i) {

        // base case
        if (i == str.length) {
            return 1;
        }

        if (str[i] == '0') {
            return 0;
        }

        if (str[i] == '1') {
            int result = process(str, i + 1);

            if (i + 1 < str.length) {
                result += process(str, i + 2);
            }

            return result;
        }

        if (str[i] == '2') {
            int result = process(str, i + 1);

            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                result += process(str, i + 2);
            }

            return result;
        }

        // 3~9
        return process(str, i + 1);

    }

    public static void main(String[] args) {
        System.out.println(number("224321"));
    }

    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

}
