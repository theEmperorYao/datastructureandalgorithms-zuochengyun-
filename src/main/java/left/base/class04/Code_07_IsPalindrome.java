package left.base.class04;

/**
 * @Classname Code_07_
 * @Description TODO
 * @Date 2021/8/16 12:56 下午
 * @Created by tangyao
 */
public class Code_07_IsPalindrome {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        if (head.next != null && head.next.next == null) {
            return head.value == head.next.value;
        }

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 确定快慢指针位置
        fast = slow.next;


        // 将链表后半部分逆置，
        Node cur = fast.next;
        slow.next = null;
        Node cur2 = slow;// 记录逆置回来 要接的位置


        while (cur != null) {
            fast.next = slow;
            slow = fast;
            fast = cur;
            cur = cur.next;
        }
        // 逆置完成
        fast.next = slow;
        cur = fast;// 记录最后一个位置


        slow = head;

        boolean result = true;
        while (slow.next != null) {
            if (slow.value == fast.value) {
                slow = slow.next;
                fast = fast.next;
            } else {
                result = false;
                break;
            }
        }

        if (result) {
            result = slow.value == fast.value ? true : false;

        }
        Node node = reverse2(cur);
        cur2.next = node.next;

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

        return result;


    }

    public static Node reverse2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newNode = new Node(1);
        Node cur = null;

        newNode.next = head;
        while (head.next != null) {
            cur = head.next;
            head.next = head.next.next;
            cur.next = newNode.next;
            newNode.next = cur;
        }
        return newNode.next;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        Node node5 = new Node(4);
        Node node6 = new Node(3);
        Node node7 = new Node(2);
        Node node8 = new Node(1);
        Node node9 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
//        node4.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;


        boolean palindrome = isPalindrome(node1);
        System.out.println("palindrome = " + palindrome);

    }


}
