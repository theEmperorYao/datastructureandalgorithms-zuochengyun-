package left.intermediate.class04;


/**
 * @author 唐
 */
public class Code_02_PrintMatrixSpiralOrder {

    public static void SpiralOrderPrint(int[][] arr) {

        // 宏观调度，左上角 a,b 右下角 c,d 一圈一圈打印,然后进内圈打印，如果左上角的点和右下角的点错开，就结束

        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;

        while (a <= c && b <= d) {
            printEdge(arr, a++, b++, c--, d--);
        }

    }

    private static void printEdge(int[][] arr, int a, int b, int c, int d) {

        if (a == c) {
            // 一条线，从左向右打印
            while (b <= d) {
                System.out.println(arr[a][b] + " ");
                b++;
            }
        } else if (b == d) {
            // 一条线，从上向下打印
            while (a <= c) {
                System.out.println(arr[a][b] + " ");
                a++;
            }
        } else {
            // 从左到右，从上到下，从右到左，从下到上
            int x1 = a;
            int x2 = b;
            while (x2 != d) {
                System.out.println(arr[a][x2] + " ");
                x2++;
            }
            while (x1 != c) {
                System.out.println(arr[x1][d] + " ");
                x1++;
            }
            while (x2 != b) {
                System.out.println(arr[c][x2] + " ");
                x2--;
            }
            while (x1 != a) {
                System.out.println(arr[x1][b] + " ");
                x1--;
            }

        }

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        SpiralOrderPrint(arr);

    }

}
