package left.baseascension;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月11日 21:42:00
 */
public class Code03_Islands {

    public static int countIslands(int[][] arr) {

        if (arr == null || arr[0] == null) {
            return 0;
        }

        int m = arr.length;
        int n = arr[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    ++res;
                    infect(arr, i, j, m, n);
                }
            }

        }
        return res;

    }

    public static void infect(int[][] arr, int i, int j, int m, int n) {
        if (i < 0 || i > m || j < 0 || j > n || (arr[i][j] != 1)) {
            return;
        }

        arr[i][j] = 2;
        infect(arr, i + 1, j, m, n);
        infect(arr, i, j + 1, m, n);
        infect(arr, i - 1, j, m, n);
        infect(arr, i, j - 1, m, n);
    }

    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m2));
    }
}
