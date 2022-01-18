package left.base.class03;

/**
 * @Classname DeleteListValue
 * @Description TODO
 * @Date 2022/1/18 11:58 下午
 * @Created by tangyao
 */
public class DeleteListValue {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node deleteNode(Node head, int value) {

        // 找到第一个不删除的位置
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;

        while (cur != null) {

            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        return head;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(4);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node node = deleteNode(node1, 1);

        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }


    }


}
