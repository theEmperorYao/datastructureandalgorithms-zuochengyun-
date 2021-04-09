package left.base.class03;

import java.util.Stack;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月29日 11:40:00
 */
public class TwoStacksQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public TwoStacksQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void add(int num) {
        stack1.push(num);
        stack1Tostack2();
    }

    public int peek() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("队列已空");
        }
        stack1Tostack2();
        return stack2.peek();
    }

    public int poll() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("队列已空");
        }
        stack1Tostack2();
        return stack2.pop();
    }

    private void stack1Tostack2() {
        if (!stack1.isEmpty() && stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.add(10);
        queue.add(11);
        queue.add(12);
        queue.add(13);

        int peek = queue.peek();
        System.out.println("peek = " + peek);
        int poll = queue.poll();
        System.out.println("poll = " + poll);
        for (int i = 0; i < 10; i++) {
            System.out.println("queue.poll() = " + queue.poll());
        }

    }

}
