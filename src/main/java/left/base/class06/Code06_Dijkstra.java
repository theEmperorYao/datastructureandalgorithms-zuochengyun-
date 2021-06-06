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

        HashMap<Node, Integer> nodeIntegerHashMap = dijkstra2(node, 5);

        nodeIntegerHashMap.forEach((k, v) -> System.out.println("k: " + k + "v: " + v));
    }


    public static class NodeRecord {
        public Node node;
        public int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }


    public static class NodeHeap {
        private Node[] nodes;

        // 记录结点在数组中位置，如果进入过又出去过，value 为 -1
        private HashMap<Node, Integer> heapIndexMap;

        // 记录任意顶点到 head 的最短距离
        private HashMap<Node, Integer> distanceMap;

        // 堆的容量
        private int size;

        public NodeHeap(int size) {
            this.nodes = new Node[size];
            this.heapIndexMap = new HashMap<>();
            this.distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        /**
         * 新增或更新或者忽略 新加入的结点
         *
         * @param node     新的结点
         * @param distance 新的结点到 head结点的距离
         */
        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }

            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return nodeRecord;
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }


        private void insertHeapify(Node node, Integer index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);

            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
    }
    public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();

        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }


}







































