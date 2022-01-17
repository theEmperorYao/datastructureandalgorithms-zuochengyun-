package left.base.class02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname SingleNumber
 * @Description TODO
 * @Date 2022/1/17 9:45 下午
 * @Created by tangyao
 */
public class SingleNumber {


    /**
     * 一个数组中有一种数出现K次，其他数都出现了M次，
     * M > 1, K < M
     * 找到，出现了K次的数，
     * 要求，额外空间复杂度O(1)，时间复杂度O(N)
     */
    public static int singleNumber(int[] arr, int k, int m) {

        int[] ans = new int[32];

        for (int num : arr) {

            for (int i = 0; i < 32; i++) {

                ans[i] += (num >> i) & 1;
            }

        }

        int result = 0;


        for (int i = 0; i < ans.length; i++) {
            // 判断每一位是不是能不能被m整除，如果不能，说明 这一位是出现了k次的那个数的那一位的数字。
            if (ans[i] % m == 0) {
                continue;
            }

            if (ans[i] % m == k) {
                result |= (1 << i);
            } else {
                return -1;
            }
        }

        // 可能这个数就是0
        if (result == 0) {
            int count = 0;
            for (int i : arr) {
                if (i == 0) {
                    count++;
                }
            }
            if (count == k) {
                return 0;
            } else {
                return -1;
            }
        }

        return result;

    }


    public static int KM(int[] arr, int k, int m) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == k) {
                return entry.getKey();
            }
        }
        return result;

    }

    public static void main(String[] args) {

        int kinds = 5;
        int range = 30;

        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");

        for (int i = 0; i < testTime; i++) {
            int a = (int) ((Math.random() * max) + 1);
            int b = (int) ((Math.random() * max) + 1);

            int k = Math.min(a, b);
            int m = Math.max(a, b);

            if (k == m) {
                m++;
            }

            int[] arr = randomArray(kinds, range, k, m);

            int km = KM(arr, k, m);

            int singleNumber = singleNumber(arr, k, m);

            if (km != singleNumber) {
                System.out.println("km = " + km);
                System.out.println("singleNumber = " + singleNumber);
                System.out.println("出错了！");
            }

        }
        System.out.println("测试结束");

    }

    private static int[] randomArray(int kinds, int range, int k, int m) {
        int kTimeNum = randomNumber(range);

        int times = Math.random() < 0.5 ? k : (int) ((Math.random() * (m - 1)) + 1);

        int numKinds = (int) (Math.random() * kinds + 2);

        int[] arr = new int[times + (numKinds - 1) * m];

        int index = 0;

        while (index < times) {
            arr[index] = kTimeNum;
            index++;
        }

        numKinds--;

        Set<Integer> set = new HashSet<>();

        set.add(kTimeNum);

        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);

            } while (set.contains(curNum));

            set.add(curNum);

            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }

        }
        for (int i = 0; i < arr.length; i++) {

            int j = (int) (Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return arr;


    }

    private static int randomNumber(int range) {


        return (int) (Math.random() * (range + 1) - Math.random() * (range + 1));

    }


}
