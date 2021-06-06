package left.base.class08;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 给定两个长度都为N的数组weights和values，
 * weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物 品不能超过这个重量。
 * 返回你能装下最多的价值是多少？
 * @createTime 2021年06月06日 23:52:00
 */
public class Code07_Knapsack {

    public static int process(int[] weights, int[] values, int i, int alreadyWeight, int bag) {

//        if (alreadyWeight > bag) {
//            return 0;
//        }

        if (i == weights.length) {
            return 0;
        }

        int a = alreadyWeight + weights[i] <= bag ? values[i] + process(weights, values, i + 1,
                alreadyWeight + weights[i]
                , bag) : 0;

        int b = process(weights, values, i + 1, alreadyWeight, bag);
        int c = values[i] + process(weights, values, i + 1, alreadyWeight + weights[i], bag);
        return Math.max(b, a);
    }

    public static int maxValue1(int[] weights, int[] values, int bag) {
        return process(weights, values, 0, 0, bag);
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(maxValue1(weights, values, bag));
    }

}
