package left.baseascension.code3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Code04_MonotonousStack
 * @Description 单调栈
 * @Date 2021/6/26 2:32 下午
 * @Created by tangyao
 */
public class Code04_MonotonousStack {

    //如果是获取一个数组某一个位置向两边，的一个最大值。单调栈从栈底到栈顶是从大到小。

    public static int[][] getNearLess(int[] arr) {

        int[][] result = new int[arr.length][2];

        //单调栈 递增（从底往上依次增加）
        Stack<List<Integer>> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            //弹出栈中比待入栈元素大的值，弹出的时候记录结果到result
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> pop = stack.pop();
                for (Integer integer : pop) {
                    result[integer][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                    result[integer][1] = i;
                }
            }

            //添加下一个元素 一定要判空，否则空指针异常
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        //结束的栈中剩余元素的处理
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            for (Integer integer : pop) {
                result[integer][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                result[integer][1] = -1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr =new int[]{1,3,4,3,5,6,43,6,4};
        int[][] nearLess = getNearLess(arr);
        for (int[] less : nearLess) {
            for (int i : less) {
                System.out.print(" " +i);
            }
            System.out.println();
        }
    }

}
