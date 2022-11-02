package left.intermediate.class04;

/**
 * @author 唐
 */
public class Code_04_ZigZagPrintMatrix {


    public static void zigZagPrintMatrix(int[][] matrix) {

        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;

        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;

        boolean fromUp = false;
        // 临界条件，因为a先向右，再向下，所以最终a = endR + 1 为结束位置
        while (aR != endR + 1) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            // a能先向右走，走到头往下走 a先赋值行，再列，因为先赋值列 行会跟着变化，b同理
            // b能先向下走，走到头往右走
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            fromUp = !fromUp;
        }


    }

    public static void printLevel(int[][] matrix, int aR, int aC, int bR, int bC, boolean fromUp) {
        if (fromUp) {
            while (aR != bR + 1) {
                System.out.print(matrix[aR++][aC--] + " ");
            }
        } else {
            while (bR != aR - 1) {
                System.out.print(matrix[bR--][bC++] + " ");
            }
        }

    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}

        };
        zigZagPrintMatrix(arr);

    }


}
