package left.baseascension.code2;

import left.baseCopy.Code_30_RandomPool;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月08日 01:04:00
 */
public class Code02_RandomPool {

    static class RandomPool<V> {

        Map<Integer, V> indexKeyMap;
        Map<V, Integer> keyIndexMap;
        int size;

        public RandomPool() {
            this.indexKeyMap = new HashMap<>();
            this.keyIndexMap = new HashMap<>();
            size = 0;
        }

        public void insert(V v) {
            if (!keyIndexMap.containsKey(v)) {
                indexKeyMap.put(size, v);
                keyIndexMap.put(v, size++);
            }

        }

        public void delete(V v) {
            if (keyIndexMap.containsKey(v)) {
                Integer deleteIndex = keyIndexMap.get(v);
                Integer lastIndex = --size;
                V lastKey = indexKeyMap.get(lastIndex);

                indexKeyMap.remove(lastIndex);
                indexKeyMap.put(deleteIndex, lastKey);

                keyIndexMap.put(lastKey, deleteIndex);
                keyIndexMap.remove(v);
            }

        }

        public V getRandom() {
            return size == 0
                    ? null
                    : indexKeyMap.get((int) (Math.random() * size));
        }
    }

    public static void main(String[] args) {
        RandomPool<String> pool = new RandomPool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

        pool.delete("zuo");
        pool.indexKeyMap.forEach((k, v) -> System.out.print(k + " : " + v + " "));
        System.out.println();
        pool.keyIndexMap.forEach((k, v) -> System.out.print(k + " : " + v + " "));

    }
}
