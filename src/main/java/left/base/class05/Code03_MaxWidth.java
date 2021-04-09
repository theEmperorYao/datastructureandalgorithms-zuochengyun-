package left.base.class05;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年03月17日 08:46:00
 */
public class Code03_MaxWidth {
    static class Node {
        Integer value;
        Node left;
        Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static Integer getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();

        map.put(head, 1);

        queue.add(head);

        Integer curLevel = 1;
        Integer max = Integer.MIN_VALUE;
        Integer maxWidth = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            Integer curNodeLevel = map.get(cur);
            if (curNodeLevel.equals(curLevel)) {
                maxWidth++;

            } else {
                max = Math.max(max, maxWidth);
                curLevel++;
                maxWidth = 1;
            }


            if (cur.left != null) {
                map.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }


        }

        return Math.max(max,maxWidth);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Integer maxWidth = getMaxWidth(node1);
        System.out.println("maxWidth = " + maxWidth);

    }
}
