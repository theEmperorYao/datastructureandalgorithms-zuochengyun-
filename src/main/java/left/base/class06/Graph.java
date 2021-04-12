package left.base.class06;

import java.util.*;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月12日 22:53:00
 */
public class Graph {
    public Map<Integer, Node> nodes;
    public Set<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }


}
