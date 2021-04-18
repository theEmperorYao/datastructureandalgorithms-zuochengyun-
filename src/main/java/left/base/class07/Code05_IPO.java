package left.base.class07;

import left.base.class06.Node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月18日 16:50:00
 */
public class Code05_IPO {

    static class Node {
        int cost;
        int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }

        public int getCost() {
            return cost;
        }

        public int getProfit() {
            return profit;
        }
    }

    /**
     * 全部进小根堆，根据花费排序，锁定，
     * 根据现在的资金，将能够投资的项目出队列，放进大根堆，根据收益排序
     *
     * @param k       次数
     * @param w       钱数
     * @param profits
     * @param costs
     * @return
     */
    public static Integer getMaxProfit(int k, int w, int[] profits, int[] costs) {
        PriorityQueue<Node> minCostQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getProfit).reversed());

        for (int i = 0; i < costs.length; i++) {
            minCostQueue.add(new Node(costs[i], profits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= w) {
                maxProfitQueue.add(minCostQueue.poll());
            }

            if (maxProfitQueue.isEmpty()) {
                return w;
            }
            Node profitNode = maxProfitQueue.poll();
            w += profitNode.profit;
        }
        return w;
    }

    public static void main(String[] args) {


        Integer maxProfit = getMaxProfit(3, 1, new int[]{4, 5, 1, 3}, new int[]{3, 4, 5, 1});
        System.out.println("maxProfit = " + maxProfit);
    }

}
