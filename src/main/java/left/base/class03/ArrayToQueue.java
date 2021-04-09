package left.base.class03;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月29日 00:13:00
 */
public class ArrayToQueue {

    static class ArrayQueue {
        int[] arrayQueue;
        //要出列的位置
        int start;
        //要入列的位置
        int end;
        //队列中元素个数
        int size;

        public ArrayQueue(int length) {
            if (length < 0) {
                throw new IllegalArgumentException("栈空");
            }
            arrayQueue = new int[length];
            start = 0;
            end = 0;
            size = 0;
        }

        public int poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("队列为空");
            }

            size--;
            int result = arrayQueue[start];
            start = start == arrayQueue.length - 1 ? 0 : start + 1;
            return result;

        }

        public int peek() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("队列为空");
            }
            return arrayQueue[start];
        }

        public void push(int num) {
            if (size == arrayQueue.length) {
                throw new ArrayIndexOutOfBoundsException("队列满了");
            }
            size++;
            arrayQueue[end] = num;
            end = end == arrayQueue.length - 1 ? 0 : end + 1;
        }


    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);

        arrayQueue.push(10);
        int peek = arrayQueue.peek();
        System.out.println("peek = " + peek);
        int poll = arrayQueue.poll();
        System.out.println("poll = " + poll);
        arrayQueue.push(10);
        arrayQueue.push(1);
        arrayQueue.push(13434);
        while (arrayQueue.size != 0) {
            System.out.println(arrayQueue.poll());
        }
    }
}
