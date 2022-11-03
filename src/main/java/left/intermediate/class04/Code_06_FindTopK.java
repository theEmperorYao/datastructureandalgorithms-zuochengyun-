package left.intermediate.class04;

import javax.swing.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Code_06_FindTopK {


    public static void main(String[] args) {


        String[] strs = {"abc", "bcd", "abc", "bcd", "abc", "bcd", "24", "d34", "abc"};


        PriorityQueue<Object[]> pq = getPriorityQueue(strs, 3);

        while (!pq.isEmpty()) {
            Object[] poll = pq.poll();
            System.out.println("poll = " + poll[0] + ":" + poll[1]);
        }


    }

    private static PriorityQueue<Object[]> getPriorityQueue(String[] strs, int n) {


        Map<String, Integer> map = new HashMap<>();

        for (String str : strs) {
            map.put(str, map.get(str) == null ? 1 : map.get(str) + 1);
        }

        System.out.println("map = " + map);

        PriorityQueue<Object[]> pq = new PriorityQueue<>(n,
                Comparator.comparingInt(arr -> Integer.parseInt(arr[1].toString())));
        map.forEach((k, v) -> {

            if (pq.size() < n) {
                pq.offer(new Object[]{k, v});
            } else {
                Integer o = (Integer) pq.peek()[1];
                if (o < v) {
                    pq.poll();
                    pq.add(new Object[]{k, v});
                }

            }
        });
        return pq;
    }

}
