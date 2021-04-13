package left.base.class06;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月13日 22:49:00
 */
public class Code03_TopologySort {

    /**
     * 建立map<Node,Integer> 存储节点和自身的度数，
     * 先找到入度为0的节点，进入队列，
     * <p>
     * 出队列，放入list result 中 去除出队列节点出度，去除对于其他节点的入度影响，期间如果度数为0 加入队列 ，
     *
     * @param graph
     */
    public static List<Node> topologySort(Graph graph) {


        Map<Node, Integer> nodeDegreeMap = new HashMap<>();

        Queue<Node> zeroInQueue = new LinkedList<>();

        graph.nodes.forEach((nodeNumber, node) -> {
            nodeDegreeMap.put(node, node.from);
            if (node.from == 0) {
                zeroInQueue.offer(node);
            }
        });

        List<Node> result = new ArrayList<>();

        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);

            for (Node node : cur.nodes) {
                nodeDegreeMap.put(node, nodeDegreeMap.get(node) - 1);
                if (nodeDegreeMap.get(node) == 0) {
                    zeroInQueue.offer(node);
                }
            }

        }
        return result;

    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 100}, {1, 3, 100}, {2, 3, 100}, {3, 4, 100}, {2, 4, 100},
                {4, 5, 100}, {4, 6, 100}, {6, 5, 100}};

        Integer[][] array = new Integer[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                array[i][j] = arr[i][j];
            }
        }

        Graph graph = GraphGenerator.createGraph(array);
        List<Node> topologyList = topologySort(graph);
        Map<Integer, Node> map = graph.nodes;

        topologyList.stream().forEach(t ->
                map.forEach((cityNumber, city) -> {
                    if (t == city) {
                        System.out.println(cityNumber);
                    }
                })
        );

        //1,2,3,4,6,5
    }
}
