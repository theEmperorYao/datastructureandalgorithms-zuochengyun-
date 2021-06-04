package left.base.class08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 打印一个字符串的全部排列，要求不要出现重复的排列
 * @createTime 2021年06月05日 00:50:00
 */
public class Code03_Permutation {


    /**
     * 从第i的位置往后，都可以与第i个位置交换进行尝试
     *
     * @param str
     * @param i
     * @param res
     */
    public static List<String> process(char[] str, int i, List<String> res) {
        //base case
        if (i == str.length) {
            res.add(String.valueOf(str));
        }

        // 去重，重复的字符不参与交换位置
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if ((visit[str[j] - 'a']) == true) {
                continue;
            }
            visit[str[j] - 'a'] = true;
            swap(str, i, j);
            process(str, i + 1, res);
            swap(str, i, j);
        }

        return res;
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static List<String> function(String str) {
        char[] chars = str.toCharArray();
        List<String> res = new ArrayList<>();
        return process(chars, 0, res);
    }

    public static void main(String[] args) {
        List<String> res = function("abcdefghjk");
        res.forEach(x -> System.out.println(x));
    }

}
