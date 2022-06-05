package left.intermediate.class02;

import java.util.*;

/**
 * @Classname Code_02_SubValueEqualK
 * @Description TODO
 * @Date 2022/6/4 22:32
 * @Author by tangyao
 */
public class Code_03_SubValueEqualK {


    public static List<List<Integer>> process(int[] arr, int k) {

        Set<Integer> set = new HashSet<>();


        List<List<Integer>> res = new ArrayList<>();

        for (int i : arr) {
            set.add(i);
        }

        for (Integer num : set) {
            if (set.contains(num + k)) {
                res.add(Arrays.asList(num, num + k));
            }
        }
        return res;

    }


    public static void main(String[] args) {

        int[] arr = {0, 23, 2, 4, 5, 6};

        List<List<Integer>> process = process(arr, 2);
        System.out.println("process = " + process);

    }
}
