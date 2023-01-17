package left.intermediate.class07;

/**
 * @Title:code_02_A
 * @Author: tangyao
 * @CreateTime: 2023/01/17  18:13
 * @Description: TODO
 * @Version: 1.0
 */
record Node(Node left, Node right) {

}

record Info(Node start, Node end) {
}

public class Code_02_BSTtoDoubleLinkedList {

    public static Node convert(Node head) {

        if (head == null) {
            return null;
        }
        return process(head).start();
    }

    private static Info process(Node head) {

        //todo 待完成
        return null;
    }

}
