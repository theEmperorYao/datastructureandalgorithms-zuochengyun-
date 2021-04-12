package left.base.class06;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月12日 23:55:00
 */
public class Code02_DFS {

    /**
     * stack 和 set
     * 1、先进stack和set，
     * 2、然后弹出，对于所有相邻节点判断 时候 在set集合中，不在则添加到 stack和set，不断循环 2,结束标准为stack为空
     *
     * @param node
     */
    public static void dfs(Node node) {

        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        stack.push(node);
        set.add(node);

        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node adjacentNode : cur.nodes) {
                if (!set.contains(adjacentNode)) {
                    stack.push(adjacentNode);
                    set.add(adjacentNode);
                    System.out.println(adjacentNode.value);
                    break;
                }
            }

        }

    }
}
