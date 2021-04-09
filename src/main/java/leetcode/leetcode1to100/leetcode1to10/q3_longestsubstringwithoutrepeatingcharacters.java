package leetcode.leetcode1to100.leetcode1to10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年08月19日 20:35:00
 */
public class q3_longestsubstringwithoutrepeatingcharacters {

    public static void main(String[] args) {
        List<String> list = lengthOfLongestSubstring("耳机卡好看价格合理回归了较大两个文件和规划局卡哈市");
        System.out.println("list = " + list);

    }

    public static List<String> lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        List<String> list=new ArrayList<>();
        int begin = 0;
        int maxLength = 0;
        int right = -1;
        int n = s.length();
        String str = "";
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            maxLength = Math.max(maxLength, right - i + 1);
            if (str.length() <= right - i + 1) {
                str = s.substring(i, right+1);
                list.add(str);
            }
        }
        return list;
    }
}
