package left.base.class04;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年01月16日 20:54:00
 */


public class Code_10_CopyListWithRandom {

    static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;

        }
    }

    public static Node copyListWithRandom1(Node head) {

        //利用哈希表，时间复杂度O(n),空间复杂度O(n)
        // 1.将每一个node的value取出，然后k，v方式绑定在一起，
        // 2.遍历每一个node，将node.random也挨个绑定

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = cur.rand;
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRandom2(Node head) {

        if (head == null) {
            return null;
        }

        // 2.不需要额外的数据结构，就需要若干个变量

        Node cur = head;
        while (cur != null) {
            Node copyNode = new Node(cur.value);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        cur = head;
        Node copyHeadNode = cur.next;
        Node copyNode = copyHeadNode;


        while (cur != null && copyNode.next != null) {
            //设置复制结点的rand
            copyNode = cur.next;
            copyNode.rand = cur.rand;

            //拆分并连接
            cur.next = cur.next.next;
            copyNode.next = copyNode.next.next;


            cur = cur.next;
            copyNode = copyNode.next;
        }
        return copyHeadNode;
    }

    public static Node copyListWithRandom3(Node head) {
        //1.先用哈希表创建所有的结点
        //2.通过哈希表每一个对应关系来去深度拷贝

        Map<Node, Node> map = new HashMap<>(16);
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        node1.rand = node4;
        node2.rand = node1;
        node3.rand = node2;
        node4.rand = null;
        Node copyNode = copyListWithRandom3(node1);

        while (copyNode != null) {
            Integer value;
            if (copyNode.rand != null) {
                value = copyNode.rand.value;

            } else {
                value = null;
            }

            System.out.println(copyNode.value + " " + value);
            copyNode = copyNode.next;
        }


    }

}
