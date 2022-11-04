package left.intermediate.class04;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tang
 */
public class Code_TopKTime2 {


    //    @Data
    public static class Node {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public static class TopKRecord {
        /**
         * 词频表
         */
        private Map<String, Node> strNodeMap;
        /**
         * 堆
         */
        private Node[] heap;
        /**
         * 堆位置表
         */
        private Map<Node, Integer> nodeIndexMap;
        /**
         * 堆中下一个元素位置
         */
        private int index;

        public TopKRecord(int k) {
            strNodeMap = new HashMap<>();
            heap = new Node[k];
            nodeIndexMap = new HashMap<>();
            index = 0;
        }

        public void add(String str) {
            Node curNode;
            // 默认不在堆上
            int preIndex = -1;
            // 词频表中没有
            if (!strNodeMap.containsKey(str)) {
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, -1);
            } else {
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }

            if (preIndex == -1) {
                // 说明不在堆上，看一下能不能超过小根堆的门槛
                if (heap.length == index) {
                    if (curNode.times > heap[0].times) {
                        nodeIndexMap.put(curNode, 0);
                        nodeIndexMap.put(heap[0], -1);
                        heap[0] = curNode;
                        heapify(0, index);
                    }

                } else {
                    nodeIndexMap.put(curNode, index);
                    heap[index] = curNode;
                    heapInsert(index++);
                }
            } else {
                // 如果在堆上，词频加1，然后heapify
                heapify(preIndex, index);
            }

        }

        /**
         * 一个节点上来看交换
         *
         * @param index
         */
        private void heapInsert(int index) {

            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[index].times < heap[parent].times) {
                    swap(parent, index);
                    index = parent;
                } else {
                    break;
                }
            }

        }

        private void swap(int parent, int index) {

            nodeIndexMap.put(heap[parent], index);
            nodeIndexMap.put(heap[index], parent);

            Node temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;


        }

        /**
         * 从一个位置开始往下保持小根堆
         *
         * @param index
         * @param heapSize
         */
        private void heapify(int index, int heapSize) {

            int l = index * 2 + 1;
            int r = index * 2 + 2;

            int smallest = index;
            while (l < heapSize) {

                if (heap[l].times < heap[index].times) {
                    smallest = l;
                }

                if (r < heapSize && heap[r].times < heap[smallest].times) {
                    smallest = r;
                }
                if (smallest != index) {
                    swap(smallest, index);
                } else {
                    break;
                }

                index = smallest;
                l = index * 2 + 1;
                r = index * 2 + 2;
            }

        }

        public void printTopK() {
            for (Node node : heap) {
                System.out.print(node.str + " : " + node.times);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        TopKRecord topKRecord = new TopKRecord(3);

        topKRecord.add("aaa");
        topKRecord.add("aaa");
        topKRecord.add("aaa");
        topKRecord.add("bb");
        topKRecord.add("bb");
        topKRecord.add("bb");
        topKRecord.add("bb");
        topKRecord.add("cc");
        topKRecord.add("cc");
        topKRecord.add("cc");
        topKRecord.add("cc");
        topKRecord.add("dd");
        topKRecord.add("dd");
        topKRecord.add("dd");
        topKRecord.add("dd");
        topKRecord.add("dd");

        topKRecord.printTopK();

    }


}
