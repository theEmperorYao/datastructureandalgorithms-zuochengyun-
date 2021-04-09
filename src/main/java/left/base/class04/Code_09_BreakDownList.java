package left.base.class04;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年01月13日 23:23:00
 */

class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }
}

public class Code_09_BreakDownList {

    //思路
    //1.遍历一下链表 准备三个变量，less，equal，more 分别来保存第一个小于、等于和大于指定的数字
    //2.第二次遍历，对于小于、等于和大于指定的数字 分别挂在less，equal，more 后面，
    //3.最后把三部分串起来

    public static Node listPartition2(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }

        Node less = null;
        Node equal = null;
        Node more = null;

        Node curLess = null;
        Node curEqual = null;
        Node curMore = null;


        Node cur = head;
        while (head != null) {
            if (head.value < pivot) {
                if (less == null) {
                    less = head;
                    curLess = head;
                } else {
                    curLess.next = head;
                    curLess = curLess.next;
                }

            } else if (head.value == pivot) {
                if (equal == null) {
                    equal = head;
                    curEqual = head;
                } else {
                    curEqual.next = head;
                    curEqual = curEqual.next;
                }
            } else if (head.value > pivot) {
                if (more == null) {
                    more = head;
                    curMore = head;
                } else {
                    curMore.next = head;
                    curMore = curMore.next;
                }
            }
            head = head.next;

        }

        if (curLess != null) {
            curLess.next = equal;
            curEqual = curEqual == null ? curLess : curEqual;
        }

        // 对curEqual做判断的原因是，万一上一个if没有走，且curEqual为null就会报npe
        if (curEqual != null) {
            curEqual.next = more;
        }

        return less != null ? less : equal != null ? equal : more;

    }

    public static void main(String[] args) {
        Node node1 = new Node(150);
        Node node2 = new Node(11);
        Node node3 = new Node(612);
        Node node4 = new Node(314);
        Node node5 = new Node(16);
        Node node6 = new Node(130);
        Node node7 = new Node(10631);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        Node node = listPartition2(node1, 99);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }


    }


}
