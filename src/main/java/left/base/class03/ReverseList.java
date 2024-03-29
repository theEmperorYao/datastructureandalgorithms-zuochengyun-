//package left.base.class03;
//
//import left.baseCopy.copy2.Code_08_ReverseList;
//
///**
// * @Classname ReverseList
// * @Description TODO
// * @Date 2021/8/16 7:54 上午
// * @Created by tangyao
// */
//public class ReverseList {
//    static class Node {
//        public int value;
//        Node next;
//
//        public Node(int value) {
//            this.value = value;
//        }
//
//        public Node() {
//        }
//    }
//
//    static class DoubleNode {
//        public int value;
//        DoubleNode next;
//        DoubleNode pre;
//
//        public DoubleNode(int value) {
//            this.value = value;
//        }
//    }
//
//
//    // 递归方式
//    public static Node reverse(Node head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        Node temp = head.next;
//
//        Node newNode = reverse(head.next);
//
//        temp.next = head;
//        head.next = null;
//        return newNode;
//    }
//
//    // 遍历方式
//    public static Node reverse2(Node head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//
//        Node newNode = new Node();
//        Node cur = null;
//
//        newNode.next = head;
//        while (head.next != null) {
//            cur = head.next;
//            head.next = head.next.next;
//            cur.next = newNode.next;
//            newNode.next = cur;
//        }
//        return newNode.next;
//
//    }
//
//    public static Node reverseList3(Node head) {
//
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Node pre = null;
//        Node next = null;
//
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//
//        return pre;
//
//    }
//
//
//    public static DoubleNode reverse(DoubleNode head) {
//
//        DoubleNode pre = null;
//        DoubleNode next = null;
//
//        while (head != null) {
//
//            next = head.next;
//            head.next = pre;
//            head.pre = next;
//
//            pre = head;
//            head = next;
//        }
//        return pre;
//
//
//    }
//
//
//    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//
//        Node reverse = reverse(node1);
////        Node reverse = reverse2(node1);
//
//        while (reverse != null) {
//            System.out.println(reverse.value);
//            reverse = reverse.next;
//        }
//
//    }
//}
