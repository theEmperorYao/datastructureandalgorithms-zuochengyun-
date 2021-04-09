package left.base.class03;

import java.util.Stack;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月29日 19:02:00
 */
public class GetMin {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int num) {
        stack.push(num);
        stackMin.push(stackMin.size() == 0 ? num : Math.min(stackMin.peek(), num));
    }

    public int pop() {
        if (stack.size()==0){
            throw  new RuntimeException("栈已空");
        }
        stackMin.pop();
        return stack.pop();
    }

    public int getMin() {
        if (stackMin.size() == 0) {
            throw  new RuntimeException("栈已空");
        }
        return stackMin.peek();
    }

    public int peek() {
        return stack.peek();
    }

    public static void main(String[] args) {
        GetMin stack = new GetMin();

        stack.push(1);
        stack.push(6);
        stack.push(-1);
        stack.push(43);
        stack.push(34);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        int min = stack.getMin();
        System.out.println("min = " + min);

    }


}
