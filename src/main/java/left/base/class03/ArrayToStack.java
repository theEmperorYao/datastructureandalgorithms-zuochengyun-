package left.base.class03;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020??10??28?? 23:52:00
 */
public class ArrayToStack {

    static class ArrayStack {

        int[] arrayStack;
        int size;

        public ArrayStack(int length) {

            if (length < 0) {
                throw new IllegalArgumentException("栈空");
            }
            arrayStack = new int[length];
            size = 0;
        }

        public int pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("没有数据了");
            }
            return arrayStack[--size];
        }

        public int peek() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("没有数据了");
            }
            return arrayStack[size - 1];
        }

        public void push(int num) {
            if (size == arrayStack.length) {
                throw new ArrayIndexOutOfBoundsException("栈满了");
            }
            arrayStack[size++] = num;
        }

    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(10);
        arrayStack.push(11);
        arrayStack.push(12);
//        int peek = arrayStack.peek();
//        System.out.println("peek = " + peek);
        arrayStack.push(1);
        while (arrayStack.size != 0) {
            System.out.println(arrayStack.pop());
        }
//        int pop = arrayStack.pop();
//        System.out.println("pop = " + pop);
    }
}
