package left.base.class05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月11日 23:19:00
 */
public class Code09_SerializeAndReconstructTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static String serialByPre(Node head) {
        //1.先序遍历，以下划线分割
        if (head == null) {
            return "#_";
        }

        serialByPre(head.left);
        serialByPre(head.right);

        String result = head.value + "_";
        result += serialByPre(head.left);
        result += serialByPre(head.right);
        return result;
    }

    public static Node reconByPreString(String preStr) {
        String[] nodeStrings = preStr.split("_");
        Queue<Node> queue = Arrays.stream(nodeStrings)
                .map(str -> "#".equals(str) ? null : new Node(Integer.valueOf(str)))
                .collect(Collectors.toCollection(LinkedList::new));
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<Node> queue) {
        Node node = queue.poll();
        if (node != null) {
            node.left = reconPreOrder(queue);
            node.right = reconPreOrder(queue);
        }
        return node;
    }

    public static Node reconByPreString2(String preStr) {
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder2(queue);
    }

    public static Node reconPreOrder2(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder2(queue);
        head.right = reconPreOrder2(queue);
        return head;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(6);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = null;

        node3.left = null;
        node3.right = node4;

        String s = serialByPre(node);
        System.out.println("s = " + s);

        Node node7 = reconByPreString(s);
        System.out.println("node7.value = " + node7.value);

        Node node8 = reconByPreString2(s);
        System.out.println("node8.value = " + node8.value);

    }

}
