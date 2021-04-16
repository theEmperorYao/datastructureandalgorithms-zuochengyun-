package left.base.class06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description Dijkstra 某一个点到其他点的最短距离
 * 可以有权值为负数的边，但是不能有权值为负数的环 ，因为会为了得到最小值一直转下去
 * @createTime 2021年04月16日 00:01:00
 */
public class Code06_Dijkstra {

    public static Node getMinDistanceAndUnselectedNode(Map<Node, Integer> distanceMap, Set<Node> selectNodeSet) {


        Integer minDistance = Integer.MAX_VALUE;
        Node minNode = null;

        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectNodeSet.contains(node) && distance < minDistance) {
                minDistance = distance;
                minNode = node;
            }
        }

        return minNode;

    }

    /**
     * distanceMap 存放从一个点到所有点的最短距离（必须是连着的）
     * selectNodeSet 被锁定的集合
     * <p>
     * 将一个点所有连接的节点也放入map，挑选最短距离的节点，再更新到每一个结点的距离，
     * 更新结束后，锁定，不能再参与比较，直到所有的节点都被锁定
     *
     * @param head
     * @return
     */
    public static Map<Node, Integer> dijkstra(Node head) {

        Map<Node, Integer> distanceMap = new HashMap<>();

        Set<Node> selectNodeSet = new HashSet<>();

        distanceMap.put(head, 0);
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectNodeSet);

        while (minNode != null) {
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                Integer distance = distanceMap.get(minNode);
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(toNode, Math.min(distanceMap.get(toNode), edge.weight + distance));
            }
            selectNodeSet.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectNodeSet);
        }

        return distanceMap;
    }

    public static void main(String[] args) {
        Integer[][] arr = new Integer[][]{{1, 2, 3}, {1, 4, 8}, {2, 4, 1}, {2, 3, 9}, {2, 5, 2},
                {3, 4, 4}, {2, 1, 3}, {4, 1, 8}, {4, 2, 1}, {3, 2, 9}, {5, 2, 2},
                {4, 3, 4}};
        Graph graph = GraphGenerator.createGraph(arr);

        Node node = graph.nodes.get(1);

        Map<Node, Integer> dijkstraMap = dijkstra(node);
        dijkstraMap.forEach((k, v) -> System.out.println("k: " + k + "v: " + v));

    }

}
