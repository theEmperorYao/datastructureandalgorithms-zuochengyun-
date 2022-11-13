package left.intermediate.test;


public class Test2 {

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int f = f(arr, 0, arr.length - 1);
        int g = g(arr, 0, arr.length - 1);

        return Math.max(f, g);

    }


    public static int f(int[] arr, int L, int R) {

        if (L == R) {
            return arr[L];
        }

        int p1 = arr[L] + g(arr, L + 1, R);
        int p2 = arr[R] + g(arr, L, R - 1);

        return Math.max(p1, p2);

    }

    public static int g(int[] arr, int L, int R) {

        if (L == R) {
            return 0;
        }

        int p1 = f(arr, L + 1, R);
        int p2 = f(arr, L, R - 1);

        return Math.min(p1, p2);
    }

    public static int win2(int[] arr) {

        if (arr == null || arr.length < 1) {
            return 0;
        }

        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    fmap[i][j] = arr[i];
                }
            }
        }

        for (int startCol = 1; startCol < N; startCol++) {

            int row = 0;
            int col = startCol;

            while (col < N) {
                fmap[row][col] = Math.max(arr[row] + gmap[row + 1][col], arr[col] + gmap[row][col - 1]);
                gmap[row][col] = Math.min(fmap[row + 1][col], fmap[row][col - 1]);
                col++;
                row++;
            }
        }


        return Math.max(fmap[0][N - 1], gmap[0][N - 1]);

    }


    public static void main(String[] args) {

        int[] ints = {1, 100, 1, 3,343,3134,315};
        int i = win1(ints);
        System.out.println("i = " + i);
        int i1 = win2(ints);
        System.out.println("i1 = " + i1);
    }
}
