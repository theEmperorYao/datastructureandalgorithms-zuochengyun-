package left.base.class06;

import java.util.*;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月12日 23:54:00
 */
public class Code01_BFS {


    /**
     * 1.queue和set，
     * 每一个节点进队列弹出后，将相邻的每一个结点都进队列和去重集合，最后队列为空 结束
     */
    public static void bfs(Node node) {

        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.value);
            for (Node adjacentNode : poll.nodes) {
                if (!set.contains(adjacentNode)) {
                    queue.offer(adjacentNode);
                    set.add(adjacentNode);
                }
            }
        }

    }
}
