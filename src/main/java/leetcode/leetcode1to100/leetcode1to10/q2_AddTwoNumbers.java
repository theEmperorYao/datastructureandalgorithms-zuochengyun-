package leetcode.leetcode1to100.leetcode1to10;


import java.util.*;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年07月31日 23:23:00
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class q2_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<ListNode> list = new ArrayList<>();
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        while (l1 != null) {
            deque1.add(l1.val);
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                break;
            }
        }
        deque1.add(l1.val);
        while (l2 != null) {
            deque2.add(l2.val);
            if (l2.next != null) {
                l2 = l2.next;
            } else {
                break;
            }
        }
        deque2.add(l2.val);
        int k = 0;

        while (deque1 != null || deque2 != null) {

            int val = deque1.removeFirst() + deque2.removeFirst();
            if (k == 1) {
                k = 0;
                if (val >= 10) {
                    list.add(new ListNode(val - 10 + 1));
                    k = 1;
                } else {
                    list.add(new ListNode(val + 1));
                }
            } else {
                if (val >= 10) {
                    list.add(new ListNode(val - 10));
                    k = 1;
                } else {
                    list.add(new ListNode(val));
                }
            }
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode result = new ListNode(0);
        ListNode r = result;
        int carry = 0;
        while (p != null || q != null) {
            int sum;
            if (p == null) {
                sum = q.val;
            } else if (q == null) {
                sum = p.val;
            } else {
                sum = p.val + q.val;
            }
            int rest = sum % 10;
            if (rest + carry == 10) {
                result.next = new ListNode(0);
            } else {
                result.next = new ListNode(rest + carry);
            }
            result = result.next;
            if (sum != rest || rest + carry == 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            if (p != null && p.next != null) {
                p = p.next;
            } else {
                p = null;
            }
            if (q != null && q.next != null) {
                q = q.next;
            } else {
                q = null;
            }
        }
        if (carry == 1) {
            result.next = new ListNode(1);
        }
        return r.next;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = value1 + value2 + addOne;
            result.next = new ListNode(sum % 10);
            result = result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            addOne = sum / 10;
        }
        return head.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(9);
//        ListNode l6 = new ListNode(1);
//        ListNode l7 = new ListNode(1);
        l1.next = l2;
        l3.next = l4;
        l4.next = l5;

        ListNode listNode = addTwoNumbers3(l1, l3);
        while (listNode.next != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.print(listNode.val + " -> ");
        System.out.println("null");
    }
}
