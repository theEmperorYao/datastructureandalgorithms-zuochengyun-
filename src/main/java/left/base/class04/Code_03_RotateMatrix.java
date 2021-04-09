package left.base.class04;

import java.util.List;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月31日 10:08:00
 */
public class Code_03_RotateMatrix {

    public static void rotateMatrix(int[][] arr) {
        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;
        while (a <= c && b <= d) {
            rotateMatrix(arr, a++, b++, c--, d--);
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.println("anInt = " + anInt);
            }
        }
    }

    private static void rotateMatrix(int[][] arr, int a, int b, int c, int d) {
        int cur1 = b;
        int cur2 = a;
        int cur3 = d;
        int cur4 = c;
        while (cur1 < d) {

            int temp = arr[a][cur1];
            arr[a][cur1] = arr[cur4][a];
            arr[cur4][a] = arr[c][cur3];
            arr[c][cur3] = arr[cur2][d];
            arr[cur2][d] = temp;

            cur1++;
            cur2++;
            cur3--;
            cur4--;
        }

    }


    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrix(arr);
    }
}
