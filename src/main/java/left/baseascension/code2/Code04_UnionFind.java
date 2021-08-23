package left.baseascension.code2;

import left.baseCopy.Code_32_UnionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 并查集
 * @createTime 2021年06月12日 02:03:00
 */
public class Code04_UnionFind {

    static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }


    static class UnionFindSet<V> {

        //1.记录包裹自己一层的类
        //2.记录自己的父节点
        //3.如果自己就是父节点，记录自己的子节点个数
        private HashMap<V, Element<V>> elementHashMap;
        private HashMap<Element<V>, Element<V>> fatherHashMap;
        private HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list) {
            this.elementHashMap = new HashMap<>();
            this.fatherHashMap = new HashMap<>();
            this.rankMap = new HashMap<>();

            for (V item : list) {
                Element<V> element = new Element<V>(item);
                elementHashMap.put(item, element);
                fatherHashMap.put(element, element);
                rankMap.put(element, 1);
            }

        }


        public boolean isSameSet(V v1, V v2) {

            if (!elementHashMap.containsKey(v1) || !elementHashMap.containsKey(v2)) {
                return false;
            }
            return findFather(elementHashMap.get(v1)) == findFather(elementHashMap.get(v2));
        }

        public void union(V v1, V v2) {
            if (!isSameSet(v1, v2)) {
                Element<V> e1 = findFather(elementHashMap.get(v1));
                Element<V> e2 = findFather(elementHashMap.get(v2));

                Integer r1 = rankMap.get(e1);
                Integer r2 = rankMap.get(e2);

                Element<V> big = r1 > r2 ? e1 : e2;
                Element<V> small = big == e1 ? e2 : e1;

                fatherHashMap.put(small, big);
                Integer smallRank = rankMap.get(small);
                rankMap.put(big, rankMap.get(big) + smallRank);
                rankMap.remove(small);
            }

        }

        public Element<V> findFather(Element<V> element) {

            Stack<Element> stack = new Stack<>();
            while (element != fatherHashMap.get(element)) {
                stack.push(element);
                element = fatherHashMap.get(element);
            }

            for (Element ele : stack) {
                fatherHashMap.put(ele, element);
                rankMap.put(element, rankMap.get(element) + 1);
            }

            return element;
        }

    }

    public static void main(String[] args) {
        UnionFindSet unionFindSet = new UnionFindSet(Arrays.asList(1, 3, 4, 5, 6, 7));

        boolean sameSet = unionFindSet.isSameSet(1, 4);
        System.out.println("sameSet = " + sameSet);

        unionFindSet.union(1, 4);
        sameSet = unionFindSet.isSameSet(1, 4);
        System.out.println("sameSet = " + sameSet);

        unionFindSet.union(5,3);
        unionFindSet.union(3,6);
        boolean sameSet1 = unionFindSet.isSameSet(3, 4);
        System.out.println("sameSet1 = " + sameSet1);
        unionFindSet.union(3,4);
        boolean sameSet2 = unionFindSet.isSameSet(3, 4);
        System.out.println("sameSet2 = " + sameSet2);


    }


}
