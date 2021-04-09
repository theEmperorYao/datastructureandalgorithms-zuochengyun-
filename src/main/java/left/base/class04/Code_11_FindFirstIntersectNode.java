package left.base.class04;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年03月03日 01:15:00
 */
public class Code_11_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 两个链表相交的情况
     * <p>
     * 2.
     * <p>
     * <p>
     * 首先判断一条单链表是无环还是有环
     * 1.如果都是无环单链表，能相交，方法用快慢指针
     * 2.一条无环，一条有环，不能相交
     * 3，都是环，能相交，分两种情况
     * 3.1 1个相交点
     * 3.2 2个相交点
     */

    public static Node getLoopNode(Node head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }

        Node longHead = n >= 0 ? head1 : head2;
        Node shortHead = n < 0 ? head1 : head2;

        n = Math.abs(n);

        while (n != 0) {
            n--;
            longHead = longHead.next;
        }
        while (longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return longHead;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {

        Node cur1;
        Node cur2;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1.next != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2) {
                n--;
                cur2 = cur2.next;
            }

            Node longHead = n >= 0 ? head1 : head2;
            Node shortHead = n < 0 ? head1 : head2;

            n = Math.abs(n);

            while (n != 0) {
                n--;
                longHead = longHead.next;
            }
            while (longHead != shortHead) {
                longHead = longHead.next;
                shortHead = shortHead.next;
            }

            return longHead;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);


    }

    private static Node getIntersectNode(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            return null;
        }

        Node loop1 = getLoopNode(node1);
        Node loop2 = getLoopNode(node2);
        if (loop1 == null && loop2 == null) {
            return noLoop(node1, node2);
        } else if (loop1 != null && loop2 != null) {
            return bothLoop(node1, loop1, node2, loop2);
        }
        return null;
    }


}
