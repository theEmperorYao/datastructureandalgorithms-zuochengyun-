package left.base.class06;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 最小生成树，先不用并查集 实现
 * @createTime 2021年04月14日 23:26:00
 */
public class Code04_Kruskal {


    /**
     * 1.对于图中的每个节点都对应一个集合地址，地址放到map里面，然后根据边数的权值最小的先累加，
     * 2.判断有没有成环，没有成环添加到list中，在map中新创建映射关系，例如 a -> list  a,b - > list
     */
    static class MySet {
        Map<Node, List<Node>> setMap = new HashMap<>();

        public MySet(List<Node> nodes) {
            nodes.forEach(node -> {
                List<Node> list = Arrays.asList(node);
                setMap.put(node, list);
            });
        }


        public boolean isSameSet(Node from, Node to) {
            return setMap.get(from) == setMap.get(to);
        }

        /**
         * 将 to节点 添加到 from 节点所在的集合
         * @param from
         * @param to
         */
        public void union(Node from, Node to) {

            List<Node> fromList = setMap.get(from);
            List<Node> toList = setMap.get(to);

            toList.forEach(node -> {
                fromList.add(node);
                setMap.put(node, fromList);
            });
        }
    }

    /**
     * 从边的角度来想这件事，有可能 两个集合最终合并
     * 根据比较器生成优先级队列，将edge按照权值由小到大放入到queue里面，
     * 出队列，比较 这条边连接的两个结点 ，如果不成环 （map 中的value不是同一个集合，即他们不在一个集合中 ），
     *  将新的边连接的两个节点 放入result ，最后生成一个边的集合就是最小生成树。
     *  （最终只是完成一个集合的查询和合并）
     * @param graph
     */
    public static Set<Edge> kruskal(Graph graph) {
        MySet mySet = new MySet((List<Node>) graph.nodes);

        Queue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        // M条边 O(logM)
        graph.edges.forEach(priorityQueue::offer);

        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!mySet.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                mySet.union(edge.from, edge.to);
            }
        }
        return result;

    }


}
