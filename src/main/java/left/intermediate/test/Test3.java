package left.intermediate.test;

public class Test3 {


    public static int maxValue(int[] weight, int[] values, int bag) {
        if (weight == null || values == null || weight.length != values.length || weight.length == 0) {
            return 0;
        }

        return process(weight, values, 0, bag);
    }

    /**
     * @param weight
     * @param values
     * @param bag
     * @return
     */
    private static int process(int[] weight, int[] values, int index, int bag) {

        if (bag < 0) {
            return -1;
        }
        if (index == weight.length) {
            return 0;
        }

        int p1 = process(weight, values, index + 1, bag);
        int p2 = 0;
        int process = process(weight, values, index, bag - weight[index]);

        if (process != -1) {
            p2 = values[index] + process;
        }
        return Math.max(p1, p2);
    }


    public static int dp(int[] weight, int[] values, int bag) {
        if (weight == null || values == null || weight.length != values.length || weight.length == 0) {
            return 0;
        }

        int N = weight.length;
        //范围
        // index 0~N
        // rest 0~bag
        int[][] dp = new int[N + 1][bag + 1];

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                int next = rest - weight[index] < 0 ? -1 : dp[index][rest - weight[index]];
                if (next != -1) {
                    p2 = values[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);

            }
        }

        return dp[0][bag];
    }


    public static void main(String[] args) {
        int[] weights = {12, 3, 4, 6, 3, 16};
        int[] values = {4, 57, 7, 27, 5, 8};
        int bag = 200;
        int i = maxValue(weights, values, bag);
        System.out.println("i = " + i);

        int dp = dp(weights, values, bag);

        System.out.println("dp = " + dp);


    }
}
