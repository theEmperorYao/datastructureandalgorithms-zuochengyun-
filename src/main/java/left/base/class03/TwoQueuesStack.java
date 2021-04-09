package left.base.class03;

import java.util.LinkedList;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月29日 18:17:00
 */
public class TwoQueuesStack {

    LinkedList<Integer> listData;
    LinkedList<Integer> listHelp;
    int size;

    public TwoQueuesStack(int i) {
        listData = new LinkedList();
        listHelp = new LinkedList();
        size = 0;
    }

    public void push(int num) {
        listData.add(num);
    }

    public int peek() {
        if (listData.isEmpty()) {
            throw new RuntimeException("栈中没元素了");
        }
        while (listData.size() > 1) {
            listHelp.add(listData.poll());
        }
        Integer poll = listData.poll();
        listHelp.add(poll);
        swap();

        return poll;
    }

    public int pop() {
        if (listData.isEmpty()) {
            throw new RuntimeException("栈中没元素了");
        }

        while (listData.size() > 1) {
            listHelp.add(listData.poll());
        }
        int poll = listData.poll();
        swap();
        return poll;
    }

    private void swap() {
        LinkedList<Integer> list = listData;
        listData = listHelp;
        listHelp = list;
    }

    public static void main(String[] args) {
        TwoQueuesStack stack = new TwoQueuesStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int peek = stack.peek();
        System.out.println("peek = " + peek);
        for (int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        }

    }
}
