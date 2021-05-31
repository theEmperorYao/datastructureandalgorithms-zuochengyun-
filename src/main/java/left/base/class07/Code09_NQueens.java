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

        int number2 = getNumber2(8);
        System.out.println("number2 = " + number2);

    }

    public static int getNumber2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }

        // 假如 n == 8 limit 就为 0000 0000 0000 0000 0000 0000 1111 1111
        //limit 作用是 限制位数
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);

    }

    /**
     * 左中右限制
     *
     * @param limit       限制死可以在哪些位置尝试皇后
     * @param colLim      之前皇后对我列的限制
     * @param leftDiaLim  之前皇后对我左斜线的限制
     * @param rightDialim 之前皇后对我右斜线的限制
     * @return
     */
    private static int process2(int limit, int colLim, int leftDiaLim, int rightDialim) {

        // base case
        if (colLim == limit) {
            return 1;
        }

        int mostRightOne = 0;
        // & 两个都是1 才为 1 ，否则为 0
        // | 两个数一个为1 就为 1 ，否则为 0 ，
        // limit 是为了截掉 8皇后 前面所有的 0（不能填皇后的位置）
        // 所有可以填皇后的列都在这个位信息上
        int pos = limit & (~(colLim | leftDiaLim | rightDialim));

        int res = 0;
        while (pos != 0) {
            // 提取出候选皇后位置状态中最右侧的1来
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;

            res += process2(limit, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDialim | mostRightOne) >>> 1);
        }

        return res;

    }


}





































