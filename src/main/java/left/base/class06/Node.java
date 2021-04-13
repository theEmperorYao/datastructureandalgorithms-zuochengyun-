package left.base.class06;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月12日 22:53:00
 */
public class Node {
    int value;
    int from;
    int to;
    List<Node> nodes;
    List<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.from = 0;
        this.to = 0;
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "value=" + value +
//                ", from=" + from +
//                ", to=" + to +
//                ", nodes=" + nodes +
//                ", edges=" + edges +
//                '}';
//    }
}
