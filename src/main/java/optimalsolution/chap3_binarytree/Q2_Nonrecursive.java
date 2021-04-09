package optimalsolution.chap3_binarytree;

import java.util.Stack;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年01月04日 23:17:00
 */

public class Q2_Nonrecursive {

    /**
     * 非递归先序遍历
     *
     * @param head
     */
    public static void preOrderNonrecursive(Node head) {
        // 1.先将头结点压入栈，然后弹出栈，
        //2.将该节点的右孩子压入栈(如果有的话)，左孩子压入栈(如果有的话)
        //3.不断重复2
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                System.out.println(cur.value + " ");
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    public static void inOrderNonrecursive(Node head) {
        // 1. 先将根节点的左子树都压进去，
        //2.弹出时打印，如果存在右子树，将右子树重复1，

        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (head.left != null) {
            head = head.left;
            stack.push(head);
        }
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value + " ");
            if (head.right != null) {
                head = head.right;
                stack.push(head);
                while (head.left != null) {
                    head = head.left;
                    stack.push(head);
                }
            }
        }
    }

    public static void inOrderNonrecursive2(Node head) {
        // 1. 先将根节点的左子树都压进去，
        //2.弹出时打印，如果存在右子树，将右子树重复1，

        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    public static void postOrderUnRecur(Node head) {
        // 准备两个栈，完成根右左的收集，反过来就可以了。

        //1.压a栈，记为cur，弹出，压b栈，a分别压入left，和right

        //2.弹出，重复1

        //,a栈为空，依次打印b栈元素

        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(head);
        Node cur;
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            stack2.push(cur);
            Node left = cur.left;
            if (left != null) {
                stack1.push(left);
            }

            Node right = cur.right;
            if (right != null) {
                stack1.push(right);
            }
        }

//        stack2.stream().forEach(node -> System.out.print(node.value + " "));
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value);
        }


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
//        preOrderNonrecursive(node1);
//        inOrderNonrecursive(node1);
//        inOrderNonrecursive2(node1);
        postOrderUnRecur(node1);

    }
}
