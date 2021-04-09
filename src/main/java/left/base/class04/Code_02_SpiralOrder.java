package left.base.class04;

import com.sun.javafx.image.IntPixelGetter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月30日 23:53:00
 */
public class Code_02_SpiralOrder {

    public static final List<Integer> list = new ArrayList<>();

    public static List<Integer> spiralOrder(int[][] arr) {

        //这里需要一个判断二维数组为空的操作{{}}
        if ((arr == null || arr.length == 0) || (arr.length == 1 && arr[0].length == 0)) {
            return new ArrayList<>();
        }

        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;

        while (a <= c && b <= d) {
            spiralOrder(arr, a++, b++, c--, d--);
        }
        return list;
    }

    private static void spiralOrder(int[][] arr, int a, int b, int c, int d) {
        if (a == c && b != d) {
            while (b <= d) {
                list.add(arr[a][b++]);
            }
        } else if (a != c && b == d) {
            while (a <= c) {
                list.add(arr[a++][b]);
            }
        } else if (a == c && b == d) {
            list.add(arr[a][b]);
        } else if (a != c && b != d) {

            int cur1 = a;
            int cur2 = b;
            while (cur2 < d) {
                list.add(arr[a][cur2++]);
            }
            while (cur1 < c) {
                list.add(arr[cur1++][d]);
            }

            while (cur2 > b) {
                list.add(arr[c][cur2--]);
            }

            while (cur1 > a) {
                list.add(arr[cur1--][b]);
            }

        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
        List<Integer> list = spiralOrder(arr);
        System.out.println(list);
    }
}
