package left.base.class07;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description record[i] 代表第i行所在的列是多少
 * @createTime 2021年04月19日 00:23:00
 */
public class Code09_NQueens {

    public static int getNumber(int n) {
        if (n < 1) {
            return 0;
        }

        //record[i] 代表第i行所在的列是多少
        int[] record = new int[n];

        return process1(0, record, n);
    }

    private static int process1(int row, int[] record, int queensNumber) {
        if (row == queensNumber) {
            return 1;
        }

        int result = 0;
        for (int col = 0; col < queensNumber; col++) {
            if (isVaild(row, col, record)) {
                record[row] = col;
                result += process1(row + 1, record, queensNumber);
            }
        }
        return result;
    }

    private static boolean isVaild(int row, int col, int[] record) {

        for (int existRow = 0; existRow < row; existRow++) {
            int existColumn = record[existRow];
            if (existColumn == col || (Math.abs(existRow - row) == Math.abs(existColumn - col))) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int number = getNumber(8);
        System.out.println("number = " + number);
    }

}
