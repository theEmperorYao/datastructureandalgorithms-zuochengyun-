package left.intermediate.class03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Code_01_MagicOp
 * @Description
 * @Date 2022/6/5 22:28
 * @Author by tangyao
 */
public class Code_01_MagicOp {


    /**
     *
     */
    public static int maxOps(int[] arr1, int[] arr2) {

        int sum1 = 0;
        for (int i : arr1) {
            sum1 += i;
        }

        int sum2 = 0;
        for (int i : arr2) {
            sum2 += i;
        }


        double avg1 = avg(sum1, arr1.length);
        double avg2 = avg(sum2, arr2.length);

        if (Double.compare(avg1, avg2) == 0) {
            return 0;
        }


        int[] maxArr;
        int[] minArr;
        double maxSum;
        double minSum;
        if (avg1 > avg2) {

            maxArr = arr1;
            minArr = arr2;
            maxSum = sum1;
            minSum = sum2;
        } else {
            minArr = arr1;
            maxArr = arr2;
            minSum = sum1;
            maxSum = sum2;
        }

        Arrays.sort(maxArr);

        int maxLength = maxArr.length;
        int minLength = minArr.length;

        int res = 0;
        // 从maxArr中取出 >minAvg , <maxAvg 的数 加入到minArr

        Set<Integer> set = new HashSet<>();

        for (int i : minArr) {
            set.add(i);
        }


        for (int i = 0; i < maxArr.length; i++) {
            int cur = maxArr[i];
            if (cur < avg(maxSum, maxLength) && cur > avg(minSum, minLength) && !set.contains(cur)) {
                maxSum -= cur;
                minSum += cur;
                maxLength--;
                minLength++;
                set.add(cur);
                res++;
            }
        }


        return res;
    }


    public static double avg(double sum, int length) {

        return sum / length;
    }


    public static void main(String[] args) {

        int[] arr1 = {2, 3, 4, 4, 67, 7};
        int[] arr2 = {34, 431, 31, 5, 16, 1, 64};
        int i = maxOps(arr1, arr2);
        System.out.println("i = " + i);

    }
}
