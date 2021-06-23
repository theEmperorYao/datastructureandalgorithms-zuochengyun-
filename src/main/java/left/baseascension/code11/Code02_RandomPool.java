package left.baseascension.code11;

import java.util.HashMap;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月08日 01:04:00
 */
public class Code02_RandomPool {

    public static class Pool<K> {

        HashMap<K, Integer> keyIndexMap;
        HashMap<Integer, K> indexKeyMap;
        int size;

        public Pool() {
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key) {

            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key, size);
                indexKeyMap.put(size++, key);
            }

        }

        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                Integer deleteIndex = keyIndexMap.get(key);
                Integer lastIndex = --size;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);

                indexKeyMap.remove(deleteIndex);
                keyIndexMap.remove(key);

            }
        }

        public K getRandom() {

            return size == 0
                    ? null
                    : indexKeyMap.get((int) (Math.random() * size));
        }
    }


    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }
}
