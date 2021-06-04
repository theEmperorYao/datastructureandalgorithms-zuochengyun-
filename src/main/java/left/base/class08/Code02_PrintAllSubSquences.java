package left.base.class08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月04日 09:43:00
 */
public class Code02_PrintAllSubSquences {


    /**
     * @param str
     * @param i   位置
     * @param res 最后生成的结果
     */
    public static void process(char[] str, int i, List<Character> res) {
        if (i == str.length) {
            printList(res);
            return;
        }

        //1.要当前数据
        List<Character> resKeep = copyList(res);
        res.add(str[i]);
        process(str, i + 1, resKeep);

        //2.不要当前数据
        List<Character> resNoInclude = copyList(res);
        process(str, i + 1, resNoInclude);

    }

    private static List<Character> copyList(List<Character> res) {

        List<Character> newList = new ArrayList<>();

        res.forEach(item -> newList.add(item));
        return newList;
    }

    private static void printList(List<Character> res) {
        res.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void function(String str) {
        char[] chars = str.toCharArray();
        process(chars, 0, new ArrayList<>());
    }

    public static void function2(String str) {
        char[] chars = str.toCharArray();
        process(chars, 0);
    }

    public static void main(String[] args) {
        function("abc");
        function2("efg");
    }


    /**
     * 用系统栈去保留
     * @param str
     * @param i
     */
    public static void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }

        process(str, i + 1);
        char temp = str[i];
        str[i] = 0;
        process(str, i + 1);
        str[i] = temp;

    }


}
