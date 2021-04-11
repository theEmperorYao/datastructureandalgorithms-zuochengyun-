package left.base.class05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月11日 13:51:00
 */
public class Code04_IsBST {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int preValue = Integer.MIN_VALUE;

    /**
     * 中序遍历 打印时机换成比较时机
     *
     * @param head
     * @return
     */
    public static boolean isBst(Node head) {

        if (head == null) {
            return true;
        }

        boolean isBst = isBst(head.left);
        if (!isBst) {
            return false;
        }

        // 打印时机换成比较时机
        if (preValue <= head.value) {
            preValue = head.value;
        } else {
            return false;
        }

        return isBst(head.right);
    }

    /**
     * 中序遍历 收集所有元素后再比较
     *
     * @param head
     * @return
     */
    public static boolean isBst2(Node head) {

        List<Integer> list = new ArrayList<>();
        process(head, list);
        int preValue = Integer.MIN_VALUE;
        for (Integer value : list) {
            if (preValue <= value) {
                preValue = value;
            } else {
                return false;
            }
        }
        return true;

    }

    private static void process(Node head, List<Integer> list) {

        if (head == null) {
            return;
        }
        process(head.left, list);
        list.add(head.value);
        process(head.right, list);
    }

    //isBst3
    public static boolean inOrderNonrecursive(Node head, Predicate<Integer> predicate) {
        // 1. 先将根节点的左子树都压进去，
        //2.弹出时打印，如果存在右子树，将右子树重复1，

        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();

        int preValue = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                boolean test = predicate.test(head.value);
                if (!test) {
                    return false;
                }
                head = head.right;
            }
        }
        return true;
    }


    static class ReturnData {
        boolean isBinarySearchTree;
        int min;
        int max;

        public ReturnData(boolean isBinarySearchTree, int min, int max) {
            this.isBinarySearchTree = isBinarySearchTree;
            this.min = min;
            this.max = max;
        }

    }

    public static boolean isBst4(Node head) {
        return processHead(head).isBinarySearchTree;
    }

    private static ReturnData processHead(Node head) {
        if (head == null) {
            return null;
        }
        ReturnData leftData = processHead(head.left);
        ReturnData rightData = processHead(head.right);

        int min = head.value;
        int max = head.value;
        boolean isBST = true;

        if (leftData != null) {
            min = Math.min(min, leftData.max);
//            max = Math.max(max, leftData.max);
        }

        if (rightData != null) {
//            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.min);
        }


        if (leftData != null && (!leftData.isBinarySearchTree || leftData.max >= head.value)) {
            isBST = false;
        }

        if (rightData != null && (!rightData.isBinarySearchTree || rightData.min <= head.value)) {
            isBST = false;
        }
        return new ReturnData(isBST, min, max);
    }

    public static boolean isF(Node head) {
        if (head == null) {
            return true;
        }
        FullInfo fullInfo = processFull(head);
        return (1 << fullInfo.height) - 1 == fullInfo.nodes;

    }

    private static FullInfo processFull(Node head) {

        if (head == null) {
            return new FullInfo(0, 0);
        }
        FullInfo leftData = processFull(head.left);
        FullInfo rightData = processFull(head.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new FullInfo(height, nodes);

    }

    static class FullInfo {
        int height;
        int nodes;

        public FullInfo(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
//        head.right.right = new Node(10);

        boolean bst = isBst(head);
        System.out.println("bst = " + bst);

        boolean bst2 = isBst2(head);
        System.out.println("bst2 = " + bst2);
        int[] array = new int[1];

        array[0] = Integer.MIN_VALUE;
        boolean isBst = inOrderNonrecursive(head, a -> {
            if (array[0] <= a) {
                array[0] = a;
                return true;
            } else {
                return false;
            }
        });
        System.out.println("isBst = " + isBst);

        boolean bst4 = isBst4(head);
        System.out.println("bst4 = " + bst4);

        boolean f = isF(head);
        System.out.println("f = " + f);
    }
}
