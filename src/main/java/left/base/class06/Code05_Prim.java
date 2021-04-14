package left.base.class06;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.*;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月15日 00:57:00
 */
public class Code05_Prim {

    /**
     * 从节点的角度
     * 1.随便选择一个点，将点所连的边解锁，放入小根堆,选择最短的那条，继续解锁点，和边，
     * nodeSet收集点，不能重复，edgesQueue收集边并排序，不能重复
     *
     * @return
     */
    public static Set<Edge> prim(Graph graph) {

        //解锁的边
        Queue<Edge> edgesQueue = new PriorityQueue<>(Comparator.comparing(edge -> edge.weight));

        // 解锁的点
        Set<Node> nodeSet = new HashSet<>();

        Set<Edge> result = new HashSet<>();

        // for 解决森林问题
        for (Node node : graph.nodes.values()) {
            if (!nodeSet.contains(node)) {
                nodeSet.add(node);

                for (Edge edge : node.edges) {
                    edgesQueue.add(edge);
                }

                while (!edgesQueue.isEmpty()) {
                    Edge edge = edgesQueue.poll();
                    Node toNode = edge.to;
                    if (!nodeSet.contains(toNode)) {
                        nodeSet.add(toNode);
                        result.add(edge);

                        //会把重复的边放到队列里面，但是前面nodeSet检测直接就跳过了
                        for (Edge nextEdge : toNode.edges) {
                            edgesQueue.add(nextEdge);
                        }
                    }

                }
            }

        }
        return result;
    }
}
