package left.base.class05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月01日 23:45:00
 */

class Node {
    public int value;
    public Node left;
    public Node right;

    Node(int value) {
        this.value = value;
    }

}

/**
 * static 作用
 * 三次到达自己，但是选择打印的时机不同来实现
 */
public class Code01_OrderRecur {
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> inOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
//        preOrderList.add(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }

        inOrderRecur(head.left);
//        inOrderList.add(head.value);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }

    public static void postOrderRecur(Node head) {
        if (head == null) {
            return;
        }

        postOrderRecur(head.left);
        postOrderRecur(head.right);
//        postOrderList.add(head.value);
        System.out.println(head.value);
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
        preOrderRecur(node1);
        inOrderRecur(node1);
        postOrderRecur(node1);

//        preOrderList.forEach(x -> System.out.print(x + " "));
//        System.out.println();
//        inOrderList.forEach(x -> System.out.print(x + " "));
//        System.out.println();
//        postOrderList.forEach(x -> System.out.print(x + " "));
//        System.out.println();
    }


}
