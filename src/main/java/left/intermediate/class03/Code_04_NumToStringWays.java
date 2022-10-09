package left.intermediate.class03;

import java.util.Random;

public class Code_04_NumToStringWays {

    public static int numToStringWays(int num) {

        if (num < 1) {
            return 0;
        }

        return process(String.valueOf(num).toCharArray(), 0);
    }

    /**
     * array[index] 能转出多少种有效的字符串表达
     *
     * @param array
     * @param index
     * @return
     */
    public static int process(char[] array, int index) {

        //1、如果到最后一个位置，那么他之前的就是一种情况
        if (index == array.length) {
            return 1;
        }

        //2、如果当前位置是0,那么不会有任何组合，结果就是0
        if (array[index] == '0') {
            return 0;
        }

        //3、如果 index 是 1~9
        //3.1 让 array[index] 自己作为一部分

        int res = process(array, index + 1);

        // 3.2除了index之外后面没有字符串了
        if (index == array.length - 1) {
            return res;
        }

        //4、如果 index + index+1 组合 小于 27 那就是另一种组合形式

        if (((array[index] - '0') * 10 + (array[index + 1] - '0')) < 27) {
            res += process(array, index + 2);
        }
        return res;
    }

    public static int dpWays(int num) {
        if (num < 1) {
            return 0;
        }

        char[] chars = String.valueOf(num).toCharArray();
        int N = chars.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;

        dp[N - 1] = chars[N - 1] == '0' ? 0 : 1;

        for (int i = N - 2; i >= 0; i--) {
            if (chars[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1] + ((((chars[i] - '0') * 10 + (chars[i + 1] - '0')) < 27) ? dp[i + 2] : 0);
            }
        }

        return dp[0];

    }

    public static void main(String[] args) {

        for (int j = 0; j < 10; j++) {
            int random = new Random().nextInt(1000);
            if (numToStringWays(random) != dpWays(random)) {
                System.out.println("错误！" + random);
                break;
            }
        }
        System.out.println("完美！");
    }
}
