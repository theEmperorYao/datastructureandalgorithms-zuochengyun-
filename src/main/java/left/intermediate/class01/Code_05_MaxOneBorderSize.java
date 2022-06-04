package left.intermediate.class01;

/**
 * @Classname Code_05_MaxOneBorderSize
 * @Description TODO
 * @Date 2022/3/7 11:02 PM
 * @Author by tangyao
 */
public class Code_05_MaxOneBorderSize {

    public static int maxAllOneBorder(int[][] array) {


        int[][] arrayRightToLeft = new int[array.length][array[0].length];
        int[][] arrayDownToUp = new int[array.length][array[0].length];

        int N = array.length;
        int M = array[0].length;

        for (int row = N - 1; row >= 0; row--) {
            for (int col = M - 1; col >= 0; col--) {
                if (col == M - 1) {
                    arrayRightToLeft[row][col] = array[row][col] == 1 ? 1 : 0;
                } else {
                    if (array[row][col] == 1) {
                        arrayRightToLeft[row][col] = arrayRightToLeft[row][col + 1] + 1;
                    }
                }
            }
        }

        for (int col = M - 1; col >= 0; col--) {
            for (int row = N - 1; row >= 0; row--) {
                if (row == N - 1) {
                    arrayDownToUp[row][col] = array[row][col] == 1 ? 1 : 0;
                } else {
                    if (array[row][col] == 1) {
                        arrayDownToUp[row][col] = arrayDownToUp[row + 1][col] + 1;
                    }
                }
            }
        }

        int maxLength = 0;

        // 枚举边长
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                // 左上角点（row，col）边长是border
                for (int border = 1; border < Math.min(N - row, M - col); border++) {

                    // 验证这个正方形，四条边，是不是上面都是1;
                    int a = arrayRightToLeft[row][col];
                    int b = arrayDownToUp[row][col];
                    int c = arrayDownToUp[row][col + border];
                    int d = arrayRightToLeft[row + border][col];

                    if (a >= border && b >= border && c >= border && d >= border) {
                        if (border > maxLength) {
                            maxLength = border;
                        }
                    }

                }
            }
        }
        return maxLength == 0
                ? maxLength
                : maxLength + 1;
    }

    public static void main(String[] args) {
//        int[][] array = {
//                {0, 1, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0}};

        int[][] array = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}};
        int i = maxAllOneBorder(array);
        System.out.println("i = " + i);
    }

}
