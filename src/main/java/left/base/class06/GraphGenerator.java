package left.base.class06;

import java.security.acl.Group;
import java.util.List;
import java.util.Map;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月12日 22:59:00
 */
public class GraphGenerator {

    /**
     * from to weight
     *
     * @param matrix
     * @return
     */
    public static Graph createGraph(Integer[][] matrix) {

        Graph graph = new Graph();

        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            fromNode.to++;
            toNode.from++;

            Edge edge = new Edge(fromNode, toNode, weight);

            graph.edges.add(edge);

        }

        return graph;
    }
}
