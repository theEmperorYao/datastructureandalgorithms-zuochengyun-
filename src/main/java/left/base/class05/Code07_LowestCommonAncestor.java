package left.base.class05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月11日 20:20:00
 */
public class Code07_LowestCommonAncestor {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 遍历树的时候生成映射关系，第一次遍历生成关于node1链，第二次遍历查找node2链，过程中去node1的链中对比是否包含。
     *
     * @param head
     * @param node1
     * @param node2
     */
    public static Node lowestCommonAncestor(Node head, Node node1, Node node2) {

        if (head == null || node1 == null || node2 == null) {
            return null;
        }
        Map<Node, Node> fatherMap = new HashMap<>();

        process(head, fatherMap);

        fatherMap.put(head, head);
        HashSet<Node> set1 = new HashSet<>();

        Node cur = node1;
        set1.add(cur);
        while (fatherMap.get(cur) != cur) {
            Node node = fatherMap.get(cur);
            set1.add(node);
            cur = node;
        }

        cur = node2;
        while (fatherMap.get(cur) != cur) {
            if (set1.contains(cur)) {
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return null;
    }

    private static void process(Node head, Map fatherMap) {

        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    public static Node lowestCommonAncestor2(Node head, Node node1, Node node2) {
        //1.node1是node2 或node2是node1的 公共父节点
        //2.在两个分支上最后相交

        if (head == null || head == node1 || head == node2) {
            return head;
        }

        Node left = lowestCommonAncestor2(head.left, node1, node2);
        Node right = lowestCommonAncestor2(head.right, node1, node2);

        // 此时是两个分支
        if (left != null && right != null) {
            return head;
        }

        return left != null ? left : right;

    }


    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.left = new Node(5);
        head.right.left.left.left = new Node(5);

        Node node = lowestCommonAncestor(head, head.left.right, head.left.right);
        System.out.println(node.value);
        Node node1 = lowestCommonAncestor2(head, head.left.right, head.left.right);
        System.out.println("node1 = " + node1.value);


    }
}
