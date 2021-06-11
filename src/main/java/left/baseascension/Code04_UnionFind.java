package left.baseascension;

import java.lang.reflect.Array;
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
        private HashMap<Element<V>, Element<V>> fatherMap;
        private HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list) {
            this.elementHashMap = new HashMap<>();
            this.fatherMap = new HashMap<>();
            this.rankMap = new HashMap<>();

            for (V item : list) {
                Element<V> element = new Element<V>(item);
                elementHashMap.put(item, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }

        }


        public boolean isSameSet(V a, V b) {

            if (!elementHashMap.containsKey(a) || !elementHashMap.containsKey(b)) {
                return false;
            }

            return findFather(elementHashMap.get(a)) == findFather(elementHashMap.get(b));
        }

        private Element<V> findFather(Element<V> element) {
            Stack<Element<V>> stack = new Stack<>();

            while (element != fatherMap.get(element)) {
                stack.push(element);
                element = fatherMap.get(element);
            }
            for (Element<V> item : stack) {
                fatherMap.put(item, element);
                rankMap.put(element, rankMap.get(element) + 1);
            }

            return element;
        }

        public void union(V a, V b) {
            if (isSameSet(a, b)) {
                return;
            }
            Element<V> aFather = findFather(elementHashMap.get(a));
            Element<V> bFather = findFather(elementHashMap.get(b));
//            Element<V> big = rankMap.get(aFather) >= rankMap.get(bFather) ? aFather : bFather;
//
//            if (big == aFather) {
//                fatherMap.put(bFather, aFather);
//                rankMap.put(aFather, rankMap.get(aFather) + rankMap.get(bFather));
//                rankMap.remove(bFather);
//            } else {
//                fatherMap.put(aFather, bFather);
//                rankMap.put(bFather, rankMap.get(bFather) + rankMap.get(aFather));
//                rankMap.remove(aFather);
//            }

            if (aFather != bFather) {
                Element<V> big = rankMap.get(aFather) >= rankMap.get(bFather) ? aFather : bFather;
                Element<V> small = big == aFather ? bFather : aFather;
                fatherMap.put(big, small);
                rankMap.put(big, rankMap.get(big) + rankMap.get(small));
                rankMap.remove(rankMap.get(small));
            }


        }

    }

    public static void main(String[] args) {
        UnionFindSet unionFindSet = new UnionFindSet(Arrays.asList(1, 3, 4, 5, 6, 7));

        boolean sameSet = unionFindSet.isSameSet(1, 4);
        System.out.println("sameSet = " + sameSet);

        unionFindSet.union(1, 4);
        sameSet = unionFindSet.isSameSet(1, 4);
        System.out.println("sameSet = " + sameSet);


    }


}
