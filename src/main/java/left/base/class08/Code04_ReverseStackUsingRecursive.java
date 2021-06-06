package left.base.class08;

import java.util.Stack;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数。 如何实现?
 * @createTime 2021年06月06日 17:06:00
 */
public class Code04_ReverseStackUsingRecursive {

    /**
     * 只将一个栈最底下的元素弹出，其余不变
     *
     * @param stack
     */
    public static Integer getAndRemoveLastElement(Stack<Integer> stack) {

        int result = stack.pop();

        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    /**
     * 将栈中所有元素从底往上全部取出来，利用系统栈保存的信息依次填回去
     *
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        Integer lastElement = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(lastElement);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        reverse(stack);

        stack.forEach(System.out::println);

    }


}
