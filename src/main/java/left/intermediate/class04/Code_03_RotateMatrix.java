package left.intermediate.class04;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 唐
 */
public class Code_03_RotateMatrix {


    public static void rotate(int[][] matrix) {

        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;

        while (a < c) {
            rotateEdge(matrix, a++, b++, c--, d--);
        }

    }

    /**
     * 左上角和右下角，旋转替换位置 然后进内圈继续
     *
     * @param matrix
     * @param a
     * @param b
     * @param c
     * @param d
     */
    private static void rotateEdge(int[][] matrix, int a, int b, int c, int d) {

        /**
         *  a,b
         *   1    2   3   4
         *   5    6   7   8
         *   9   10  11  12
         *   13  14  15  16
         *                 c,d
         *
         */

        // 逆时针
//        for (int i = 0; i < d - b; i++) {
//
//            int temp = matrix[a][b + i];
//            matrix[a][b + i] = matrix[a + i][d];
//            matrix[a + i][d] = matrix[c][d - i];
//            matrix[c][d - i] = matrix[c - i][b];
//            matrix[c - i][b] = temp;
//        }

        // 顺时针
        for (int i = 0; i < d - b; i++) {
            int temp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = temp;
        }


    }


    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}

        };


        rotate(arr);

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

}
