package left.intermediate.class07;

/**
 * @Title:code_02_A
 * @Author: tangyao
 * @CreateTime: 2023/01/17  18:13
 * @Description: TODO
 * @Version: 1.0
 */
class Node {
    Node left;
    Node right;

    int value;

    public Node(int value) {
        this.value = value;
    }
}

/**
 * 搜索二叉树转双向链表，头和尾返回
 */
class Info {
    Node start;
    Node end;

    public Info(Node start, Node end) {
        this.start = start;
        this.end = end;
    }
}

public class Code_02_BSTtoDoubleLinkedList {

    public static Node convert(Node head) {

        if (head == null) {
            return null;
        }
        return process(head).start;
    }

    private static Info process(Node X) {

        if (X == null) {
            return new Info(null, null);
        }
        Info leftHeadEnd = process(X.left);
        Info rightHeadEnd = process(X.right);
        if (leftHeadEnd.end != null) {
            leftHeadEnd.end.right = X;
        }
        X.left = leftHeadEnd.end;
        X.right = rightHeadEnd.start;
        if (rightHeadEnd.start != null) {
            rightHeadEnd.start.left = X;
        }

        return new Info(leftHeadEnd.start != null ? leftHeadEnd.start : X,
                rightHeadEnd.end != null ? rightHeadEnd.end : X);
    }


    public static void printBSTInOrder(Node head) {
        System.out.println("BST in-order:");
        while (head != null) {
            System.out.println(head.value);
            head = head.right;
        }
    }

    public static void main(String[] args) {

        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node5.left = node3;
        node3.left = node2;
        node3.right = node4;
        node5.right = node7;
        node7.left = node6;
        node7.right = node8;
        // 方式一 相当于搜索二叉树的中序遍历 ，将遍历结果转化为双向链表模式
        // 方式二
        // 我们定义一个方法process(Node) ，这个方法返回以Node为根的搜索二叉树转化成的双向链表，返回这个双向链表的头节点和尾结点。
        // 在搜索二叉树根节点取到左子树的双向链表同时也取到右子树的双向链表，把这两个双向链表以及根节点结合成一个完整的双向链表。
        Node convert = convert(node5);
        printBSTInOrder(convert);


    }

}
