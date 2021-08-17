package left.baseCopy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Classname Code_10_MaxWidth
 * @Description TODO
 * @Date 2021/8/17 3:27 下午
 * @Created by tangyao
 */
public class Code03_MaxWidth {
    static class Node {
        Integer value;
        Node left;
        Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static int getMaxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Map<Node, Integer> map = new HashMap<>();
        map.put(head, 1);

        int curLevel = 1;
        int curLevelNum = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Integer curNodeLevel = map.get(poll);
            if (curNodeLevel == curLevel) {
                curLevelNum++;
            } else {
                max = Math.max(curLevelNum, max);
                curLevel++;
                curLevelNum = 1;
            }
            if (poll.left != null) {
                map.put(poll.left, curLevel + 1);
                queue.add(poll.left);
            }
            if (poll.right != null) {
                map.put(poll.right, curLevel + 1);
                queue.add(poll.right);
            }
        }
        return Math.max(max, curLevelNum);

    }

    public static int getMaxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        Node curEnd = head;
        Node nextEnd = null;

        int curLevel = 1;
        int curLevelNodeNum = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                nextEnd = poll.left;
            }
            if (poll.right != null) {
                queue.add(poll.right);
                nextEnd = poll.right;
            }

            curLevelNodeNum++;
            if (curEnd == poll) {
                max = Math.max(curLevelNodeNum, max);
                curEnd = nextEnd;
                curLevelNodeNum = 0;
            }

        }
        return max;

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

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (getMaxWidthUseMap(head) != getMaxWidthNoMap(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

    }
}
