package left.baseascension.code3;

/**
 * @Classname Code02_Manacher
 * @Description TODO
 * @Date 2021/6/25 12:24 下午
 * @Created by tangyao
 */
public class Code02_Manacher {

    public static char[] manacherString(String str) {
        char[] chars = str.toCharArray();
        char[] result = new char[str.length() * 2 + 1];

        int index = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return result;
    }

    public static int maxLcpsLength(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] charArr = manacherString(str);
        //记录最大回文半径
        int[] pArr = new int[charArr.length];
        //记录中间位置
        int middle = -1;
        //回文右边界再往右一个位置，最右值有效区域是R-1位置
        int right = -1;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < charArr.length; i++) {
            // 小加速，获取到不用重新比较的部分

            //分为两种大情况
            //1，如果i在right右边，直接扩
            //2. 如果i在right和left里面
            //2.1 如果 i`（i关于middle 对称点）的回文范围在left到middle里面，免检区域为 pArr[i`] 不可扩
            //2.1 如果 i`（i关于middle 对称点）的回文范围超过left，免检区域为 i`-left 也就是right - i 不可扩
            //2.1 如果 i`（i关于middle 对称点）的回文范围正好在left，免检区域为 right - i 可扩
            pArr[i] = right > i ? Math.min(pArr[2 * middle - i], right - i) : 1;

            // 这里没有分类讨论，因为如果不可扩，会直接break
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] > right) {
                right = i + pArr[i];
                middle = i;
            }
            max = Math.max(max, pArr[i]);
        }
        //回文子串的长度 = 回文半径 -1
        return max - 1;
    }


    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));

    }

}
