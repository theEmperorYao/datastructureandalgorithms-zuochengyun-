package left.intermediate.class03;

public class Code_05_MaxSumInTree {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public static int MAX_DISTANCE = Integer.MIN_VALUE;

    public static int maxDistance(Node node) {
        if (node == null) {
            return 0;
        }
        p(node, 0);
        return MAX_DISTANCE;
    }

    /**
     * 先序遍历
     *
     * @param node
     * @param pre  从根节点出发，到上方的节点 获取的路径和
     * @return
     */
    public static void p(Node node, int pre) {

        if (node.left == null && node.right == null) {
            MAX_DISTANCE = Math.max(MAX_DISTANCE, pre + node.value);
        }

        if (node.left != null) {
            p(node.left, pre + node.value);
        }

        if (node.right != null) {
            p(node.right, pre + node.value);
        }

    }


    public static int maxDistance2(Node node) {
        if (node == null) {
            return 0;
        }
        return process2(node);
    }

    /**
     *  x 为 整棵书上，路径和最大是多少 返回
     *  路径要求，一定是从x出发，到叶节点，算作一个路径
     * @param node
     * @return
     */
    public static int process2(Node node) {

        if (node.left == null && node.right == null) {
            return node.value;
        }

        int next = Integer.MIN_VALUE;
        if (node.left != null) {
            next = process2(node.left);
        }
        if (node.right != null) {
            next = Math.max(next, process2(node.right));
        }

        return node.value + next;
    }

    public static void main(String[] args) {


        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(415);
        Node node4 = new Node(4);
        Node node5 = new Node(444);
        Node node6 = new Node(424);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        int i = maxDistance(node1);
        System.out.println("i = " + i);
        int i1 = maxDistance2(node1);
        System.out.println("i1 = " + i1);


    }
}
