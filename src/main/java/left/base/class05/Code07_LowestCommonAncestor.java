package left.base.class05;

import java.util.ArrayList;
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
    public static Node lowestAncestor1(Node head, Node node1, Node node2) {

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

        while (!set1.contains(cur)) {
            cur = fatherMap.get(cur);
        }
        return cur;
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

    public static Node lowestAncestor2(Node head, Node node1, Node node2) {
        //1.node1是node2 或node2是node1的 公共父节点
        //2.在两个分支上最后相交

        if (head == null || head == node1 || head == node2) {
            return head;
        }

        Node left = lowestAncestor2(head.left, node1, node2);
        Node right = lowestAncestor2(head.right, node1, node2);

        // 此时是两个分支
        if (left != null && right != null) {
            return head;
        }

        return left != null ? left : right;

    }


    static class ReturnType {

        boolean findA;
        boolean findB;
        Node ans;

        public ReturnType(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }


    public static Node lowestAncestor3(Node head, Node node1, Node node2) {

        return process(head, node1, node2).ans;
    }

    private static ReturnType process(Node head, Node node1, Node node2) {
        if (head == null) {
            return new ReturnType(false, false, null);
        }

        ReturnType left = process(head.left, node1, node2);
        ReturnType right = process(head.right, node1, node2);

        boolean findA = head == node1 || left.findA || right.findA;
        boolean findB = head == node2 || right.findB || left.findB;

        Node ans = null;

        if (left.ans != null) {
            ans = left.ans;
        } else if (right.ans != null) {
            ans = right.ans;
        } else {
            if (findA && findB) {
                ans = head;
            }
        }

        return new ReturnType(findA, findB, ans);
    }


    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    // for test
    public static Node pickRandomOne(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> arr = new ArrayList<>();
        fillPrelist(head, arr);
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }

    // for test
    public static void fillPrelist(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            Node o1 = pickRandomOne(head);
            Node o2 = pickRandomOne(head);
            if (lowestAncestor1(head, o1, o2) != lowestAncestor3(head, o1, o2)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
