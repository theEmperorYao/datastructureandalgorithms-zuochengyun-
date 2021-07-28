package left.baseascension.code6;

/**
 * @Classname Code03_HorseJump
 * @Description 请同学们自行搜索或者想象一个象棋的棋盘，然后把整个棋盘放入第一象限，
 * 棋盘的最左下 角是(0,0)位置。那么整个棋盘就是横坐标上9条线、纵坐标上10条线的一个区域。
 * 给你三个 参数，x，y，k，返回如果“马”从(0,0)位置出发，必须走k步，最后落在(x,y)上的方法数 有多少种？
 * @Date 2021/7/28 10:59 下午
 * @Created by tangyao
 */
public class Code03_HorseJump {


    public static int process(int x, int y, int rest) {

        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }

        //base case
        if (rest == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }

        return process(x - 1, y + 2, rest - 1) +
                process(x + 1, y + 2, rest - 1) +
                process(x + 1, y - 2, rest - 1) +
                process(x - 1, y - 2, rest - 1) +
                process(x + 2, y + 1, rest - 1) +
                process(x - 2, y + 1, rest - 1) +
                process(x + 2, y - 1, rest - 1) +
                process(x - 2, y - 1, rest - 1);

    }

    public static int getWays1(int x, int y, int rest) {
        return process(x, y, rest);
    }

    public static int getWays2(int x, int y, int rest) {
        // 想想一个立方体泡在池子里，周围都是0
        if (x < 0 || x > 8 || y < 0 || y > 9 || rest < 0) {
            return 0;
        }

        int[][][] dp = new int[9][10][rest + 1];
        dp[0][0][0] = 1;
        for (int h = 1; h <= rest; h++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 10; j++) {
                    dp[i][j][h] = (
                            getValue(dp, i - 1, j + 2, h - 1) +
                                    getValue(dp, i - 1, j - 2, h - 1) +
                                    getValue(dp, i + 1, j + 2, h - 1) +
                                    getValue(dp, i + 1, j - 2, h - 1) +
                                    getValue(dp, i - 2, j + 1, h - 1) +
                                    getValue(dp, i + 2, j + 1, h - 1) +
                                    getValue(dp, i - 2, j - 1, h - 1) +
                                    getValue(dp, i + 2, j - 1, h - 1)
                    );
                }
            }
        }
        return dp[x][y][rest];
    }

    private static int getValue(int[][][] dp, int x, int y, int h) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        return dp[x][y][h];
    }

    public static void main(String[] args) {
        long start1 = System.nanoTime();
        int ways1 = getWays1(7, 7, 10);
        System.out.println("ways1 = " + ways1);
        long start2 = System.nanoTime();

        System.out.println("start2- start1 = " + (start2 - start1));


        int ways2 = getWays2(7, 7, 10);
        System.out.println("ways2 = " + ways2);
        long start3 = System.nanoTime();

        System.out.println("start3- start2 = " + (start3 - start2));
    }


}
