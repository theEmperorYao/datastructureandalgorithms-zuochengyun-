package left.base.class05;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月11日 17:01:00
 */
public class Code06_IsBalancedTree {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalancedTree(Node head) {
        return process(head).isBalanced;
    }


    public static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType left = process(head.left);
        ReturnType right = process(head.right);

        int height = Math.max(left.height, right.height) + 1;

        Boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs((left.height - right.height)) <= 1;
        return new ReturnType(isBalanced, height);
    }


    /**
     * 返回结构，
     * 是否是搜索二叉树
     * 树的高度
     */
    static class ReturnType {
        boolean isBalanced;
        int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }


    public static void main(String[] args) {

        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.left = new Node(5);
        head.right.left.left.left = new Node(5);

        boolean isBalancedTree = isBalancedTree(head);
        System.out.println("isBalancedTree = " + isBalancedTree);

    }
}
