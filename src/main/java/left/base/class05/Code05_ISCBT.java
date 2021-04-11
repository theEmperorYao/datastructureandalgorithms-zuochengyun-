package left.base.class05;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月11日 16:26:00
 */
public class Code05_ISCBT {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static boolean isCBT(Node head) {
        if (head == null) {
            return false;
        }
        //广度优先遍历
        //1).如果由右孩子，无左孩子，返回false
        //2).在满足一的情况下，如果一个节点左右孩子不全，那这个结点之后必都是叶节点，否则返回false
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        Node left;
        Node right;
        boolean flag = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            left = node.left;
            right = node.right;

            if (right != null && left == null) {
                return false;
            }

            //遇到不双全节点之后，发现当前节点居然还有孩子
            if (flag && (left != null || right != null)) {
                return false;
            }


            if (right == null || left == null) {
                flag = true;
            }

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        boolean isCBT = isCBT(head);
        System.out.println("isCBT = " + isCBT);
    }
}
