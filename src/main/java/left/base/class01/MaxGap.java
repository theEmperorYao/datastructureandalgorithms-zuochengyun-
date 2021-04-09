package left.base.class01;

import java.util.Arrays;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月28日 21:28:00
 */
public class MaxGap {

    public static int getMaxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        if (max == min) {
            return 0;
        }

        boolean[] hasNumber = new boolean[nums.length + 1];
        int[] maxValue = new int[nums.length + 1];
        int[] minValue = new int[nums.length + 1];

        maxValue[nums.length] = max;
        minValue[0] = min;
        for (int i = 0; i < nums.length; i++) {

            //放到哪个桶
            int bucketId = getBucketId(nums[i], min, max, nums.length);
//            if (hasNumber[bucketId]) {
//                if (maxValue[bucketId] < nums[i]) {
//                    maxValue[bucketId] = nums[i];
//                }
//                if (minValue[bucketId] > nums[i]) {
//                    minValue[bucketId] = nums[i];
//                }
//            } else {
//                minValue[bucketId] = nums[i];
//                maxValue[bucketId] = nums[i];
//
//                hasNumber[bucketId] = true;
//            }
            maxValue[bucketId] = hasNumber[bucketId] ? Math.max(maxValue[bucketId], nums[i]) : nums[i];
            minValue[bucketId] = hasNumber[bucketId] ? Math.min(minValue[bucketId], nums[i]) : nums[i];
            hasNumber[bucketId] = true;

        }

        int result = 0;
        int lastMax = nums[0];
        for (int i = 0; i < hasNumber.length; i++) {
            if (hasNumber[i]) {
                result = Math.max(result, (minValue[i] - lastMax));
                lastMax = maxValue[i];
            }
        }
        return result;
    }

    private static int getBucketId(long num, long min, long max, long length) {
        //用long防止相乘溢出
        return (int) ((num - min) * length / (max - min));
    }


    //    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 7, 8, 20};
//        int maxGap = getMaxGap(arr);
//        System.out.println("maxGap = " + maxGap);
//
//    }
//     for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (getMaxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
