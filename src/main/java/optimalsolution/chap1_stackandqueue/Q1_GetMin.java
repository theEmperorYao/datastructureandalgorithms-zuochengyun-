package optimalsolution.chap1_stackandqueue;

import java.util.Stack;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月13日 20:40:00
 */
class MyStack {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int a) {
        stackData.push(a);
        if (stackMin.isEmpty()) {
            stackMin.push(a);
        } else {
            if (a <= getMin()) {
                stackMin.push(a);
            }
        }
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Integer value = stackData.pop();
        if (value <= getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("栈为空");
        } else {
            return stackMin.peek();
        }
    }
}

public class Q1_GetMin {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(4);
        myStack.push(1);
        myStack.push(-3);
        myStack.push(9);
        myStack.push(-33);
        myStack.push(9);

        int pop = myStack.pop();
        System.out.println("pop = " + pop);

        int min = myStack.getMin();
        System.out.println("min = " + min);
    }
}

