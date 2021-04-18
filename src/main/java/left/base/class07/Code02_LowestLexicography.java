package left.base.class07;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 最小字典集字符串
 * @createTime 2021年04月18日 15:34:00
 */
public class Code02_LowestLexicography {

    public static String lowestString(String[] strs) {

        if (strs == null | strs.length == 0) {
            return "";
        }

        String result = "";
        Arrays.sort(strs, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));

        for (String str : strs) {
            result += str;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(lowestString(strs2));
    }

}
