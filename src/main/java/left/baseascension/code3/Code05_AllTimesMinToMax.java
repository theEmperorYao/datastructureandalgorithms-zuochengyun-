package left.baseascension.code3;

import java.util.Stack;

/**
 * @Classname Code05_AllTimesMinToMax
 * @Description TODO
 * @Date 2021/6/27 11:03 下午
 * @Created by tangyao
 */
public class Code05_AllTimesMinToMax {

    // 每一个数必须找到子数组中最小值，如果很多数组都达标，找累加和最大的那个

    public static int getMax(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        //所有位置到 0 位置的累加和
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            // 从上往下计算出最大 乘积的值
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                Integer pop = stack.pop();
                // 如果能弹出，说明后面有一个较小的值，那么对于前面的值进行分段 求和 并 相乘
                max = Math.max(max, (stack.isEmpty() ? sum[i - 1] : sum[i - 1] - sum[stack.peek()]) * arr[pop]);
            }
            stack.push(i);
        }

        //结束之后，如果只剩下一个，说明是最小的，结果为 所有数的和 乘 最后一个数，否则是这个数与弹出的下一个数中间所有数的和 乘 这个数
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sum[arr.length - 1] : sum[arr.length - 1] - sum[stack.peek()]) * arr[pop]);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,2,8,10,1};
        int max = getMax(arr);
        System.out.println("max = " + max);
    }
}
