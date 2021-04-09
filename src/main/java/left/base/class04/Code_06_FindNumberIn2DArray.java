package left.base.class04;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年11月03日 01:30:00
 */
public class Code_06_FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int columns = matrix[0].length;
        int column = columns - 1;

        while (row <= matrix.length - 1 && column >= 0) {
            int num = matrix[row][column];
            if (num < target) {
                row++;
            } else if (num > target) {
                column--;
            } else {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] arr2 = {{1, 1}};
        boolean numberIn2DArray = findNumberIn2DArray(arr2, 2);

        System.out.println("numberIn2DArray = " + numberIn2DArray);


    }
}
