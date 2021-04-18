package left.base.class07;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月18日 20:48:00
 */
public class Code06_FindMiddleNumber {

    static Queue<Integer> largeHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1) > 0 ? 1 : -1);
    static Queue<Integer> smallHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1) > 0 ? -1 : 1);

    public static int getMiddleNumber() {
        int largeHeapSize = largeHeap.size();
        int smallHeapSize = smallHeap.size();
        if (largeHeapSize == smallHeapSize) {
            return (largeHeap.peek() + smallHeap.peek()) / 2;
        } else if (largeHeapSize == smallHeapSize + 1) {
            return largeHeap.peek();
        } else {
            return smallHeap.peek();
        }
    }

    public static void setArrayNumber(int[] arr) {

        for (int number : arr) {
            if (largeHeap.size() == 0) {
                largeHeap.add(number);
            } else {
                if (number <= largeHeap.peek()) {
                    largeHeap.add(number);
                } else {
                    smallHeap.add(number);
                }

                if (largeHeap.size() - smallHeap.size() == 2) {
                    smallHeap.add(largeHeap.poll());
                } else if (smallHeap.size() - largeHeap.size() == 2) {
                    largeHeap.add(smallHeap.poll());
                }
            }


        }
    }

    public static void main(String[] args) {
        setArrayNumber(new int[]{6, 1, 2, 10, 3, 4, 5});
        int middleNumber = getMiddleNumber();
        System.out.println("middleNumber = " + middleNumber);
    }
}
