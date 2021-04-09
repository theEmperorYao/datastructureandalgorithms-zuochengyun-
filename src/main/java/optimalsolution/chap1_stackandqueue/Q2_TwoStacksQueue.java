package optimalsolution.chap1_stackandqueue;

import java.util.Stack;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月13日 22:27:00
 */
public class Q2_TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    private Q2_TwoStacksQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(int num) {
        stackPush.push(num);
        if (stackPop.isEmpty()) {
            this.pushToPop();
        }
    }

    public int peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        pushToPop();
        return stackPop.peek();
    }

    public int poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        pushToPop();
        return stackPop.pop();
    }

    private void pushToPop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public static void main(String[] args) {
        Q2_TwoStacksQueue queue = new Q2_TwoStacksQueue();
        queue.add(1);
        queue.add(2);
        System.out.println("queue.peek() = " + queue.peek());
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println("queue.poll1() = " + queue.poll());
        for (int i = 0; i < 10; i++) {
            System.out.println("queue.poll() = " + queue.poll());
        }

    }
}
