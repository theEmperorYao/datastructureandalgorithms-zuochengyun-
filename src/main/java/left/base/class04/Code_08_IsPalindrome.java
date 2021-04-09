package left.base.class04;

import java.util.List;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年11月03日 11:53:00
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

 class IsPalindrome {

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        if (head.next != null && head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        ListNode cur = fast;
        slow.next = null;

        while (fast.next != null) {
            fast = fast.next;
            cur.next = slow;
            slow = cur;
            cur = fast;
        }
        cur.next = slow;

        slow = head;

        boolean result = true;
        while (slow.next != null) {
            if (slow.val == fast.val) {
                slow = slow.next;
                fast = fast.next;
            } else {
                result = false;
                break;
            }
        }
        if (result) {
            result = slow.val == fast.val ? true : false;
        }


        ListNode reverse = new ListNode(1);
        slow = cur;
        while (slow.next != null) {
            slow = slow.next;
            cur.next = reverse.next;
            reverse.next = cur;
            cur = slow;

        }
        fast.next = reverse.next;


        return result;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = null;
        node3.next = null;
        boolean palindrome = isPalindrome(node1);
        System.out.println("palindrome = " + palindrome);

    }
}
