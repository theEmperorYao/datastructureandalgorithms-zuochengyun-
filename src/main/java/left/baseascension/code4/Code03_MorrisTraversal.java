package left.baseascension.code4;

/**
 * @Classname Code03_MorrisTraversal
 * @Description Morris遍历细节 假设来到当前节点cur，开始时cur来到头节点位置
 * 1）如果cur没有左孩子，cur向右移动(cur = cur.right)
 * 2）如果cur有左孩子，找到左子树上最右的节点mostRight：
 * a.如果mostRight的右指针指向空，让其指向cur， 然后cur向左移动(cur = cur.left)
 * b.如果mostRight的右指针指向cur，让其指向null， 然后cur向右移动(cur = cur.right)
 * 3）cur为空时遍历停止
 * @Date 2021/7/3 11:25 下午
 * @Created by tangyao
 */
public class Code03_MorrisTraversal {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @param node
     * @return void
     * @description
     * @version V1.0.0
     * @date 2:59 下午 2021/7/4
     * @author tangyao
     */
    public static void morris(Node node) {
        if (node == null) {
            return;
        }
        Node cur = node;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {// 第一次来
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {// 第二次来
                    mostRight.right = null;
                }
            }
            // 1）没有左孩子，直接向右移动
            // 2）有左孩子，第二次来到节点位置，向右移动到该节点
            cur = cur.right;
        }
    }

    public static void morrisPre(Node node) {
        if (node == null) {
            return;
        }
        Node cur = node;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {// 第一次来
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                } else {// 第二次来
                    mostRight.right = null;
                }
            } else {
                System.out.print(cur.value + " ");
            }
            // 1）没有左孩子，直接向右移动
            // 2）有左孩子，第二次来到节点位置，向右移动到该节点
            cur = cur.right;
        }
    }

    public static void morrisIn(Node node) {
        if (node == null) {
            return;
        }
        Node cur = node;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {// 第一次来
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {// 第二次来
                    mostRight.right = null;
                }
            }
            // 1）没有左孩子，直接向右移动
            // 2）有左孩子，,但是mostRight.right ==  cur 会第二次来到节点位置
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
    }

    public static boolean isBST(Node node) {
        if (node == null) {
            return true;
        }
        Node cur = node;
        Node mostRight;
        int preValue = Integer.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {// 第一次来
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {// 第二次来
                    mostRight.right = null;
                }
            }
            // 1）没有左孩子，直接向右移动
            // 2）有左孩子，,但是mostRight.right ==  cur 会第二次来到节点位置
            System.out.print(cur.value + " ");
            if (cur.value <= preValue) {
                return false;
            }
            preValue = cur.value;
            cur = cur.right;
        }
        return true;
    }

    /***
     * @description 第二次到达节点的时候，逆序打印左子树
     * @param node
     * @return void
     * @version V1.0.0
     * @date 11:01 下午 2021/7/5
     * @author tangyao
     */
    public static void morrisPos(Node node) {
        if (node == null) {
            return;
        }
        Node cur = node;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {// 第一次来
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {// 第二次来
                    mostRight.right = null;
                    printNode(cur.left);
                }
            }
            // 1）没有左孩子，直接向右移动
            // 2）有左孩子，,但是mostRight.right ==  cur 会第二次来到节点位置;
            cur = cur.right;
        }
        printNode(node);

    }

    private static Node reverseList(Node from) {

        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;

    }

    public static void printNode(Node head) {
        Node tail = reverseList(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseList(tail);
    }


    public static void main(String[] args) {


        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);

        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);
        Node node1 = new Node(1, node2, node3);

        morrisPre(node1);
        System.out.println();
        morrisIn(node1);
        System.out.println();
        morrisPos(node1);

        boolean bst = isBST(node1);
        System.out.println("bst = " + bst);

    }
}
