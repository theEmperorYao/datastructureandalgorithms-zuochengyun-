package left.intermediate.class03;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Code_03_SortElementInStack {

    public static Stack<Integer> sortElementInStack(Stack<Integer> stack) {

        // 1、原始栈挨个弹出，和辅助栈作比较，将辅助栈中的没有原始栈中的元素大的全部弹出，入原始栈，再将从原始栈中弹出的元素入辅助栈

        Stack<Integer> auxiliaryStack = new Stack<>();

        while (!stack.isEmpty()) {
            compareStack(stack, auxiliaryStack);
        }

        auxiliaryStack.forEach(stack::push);

        return stack;

    }

    public static void compareStack(Stack<Integer> stack, Stack<Integer> auxiliaryStack) {

        Integer pop = stack.pop();

        if (auxiliaryStack.isEmpty()){
            auxiliaryStack.push(pop);
            return;
        }

        while (true) {
            if (!auxiliaryStack.isEmpty()){
                Integer peek = auxiliaryStack.peek();
                if (peek > pop) {
                    stack.push(auxiliaryStack.pop());
                } else {
                    auxiliaryStack.push(pop);
                    break;
                }
            }else {
                auxiliaryStack.push(pop);
                break;
            }
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(0);
        stack.push(30);
        stack.push(140);
        stack.push(130);
        Stack<Integer> integers = sortElementInStack(stack);
        integers.forEach(System.out::println);

        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println("instant = " + instant);
        long epochSecond = instant.getEpochSecond();
        System.out.println("epochSecond = " + epochSecond);
        System.out.println(Integer.MAX_VALUE);
    }

}
