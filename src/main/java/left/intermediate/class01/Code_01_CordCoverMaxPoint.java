package left.intermediate.class01;

import lombok.Data;

/**
 * @Classname CordCoverMaxPoint
 * @Description TODO
 * @Date 2022/2/10 10:24 下午:
 * @Author by tangyao
 */
public class Code_01_CordCoverMaxPoint {

    public static int process(int[] arr, int cordLength) {

        if (arr == null || arr.length <= 1) {
            return -1;
        }

        int left = arr[0];
        int right = arr[0];

        int rightIndex = 0;
        int leftIndex = 0;

        // 最多覆盖几个点
        int max = 0;

        int coverPoint = 0;

        while (rightIndex < arr.length - 1) {

            if ((right - left <= cordLength)) {
                coverPoint++;
                right = arr[++rightIndex];

            } else {
                max = Math.max(coverPoint, max);
                coverPoint--;
                left = arr[++leftIndex];
            }
        }

        return max;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 4, 5, 7, 23, 35, 44, 45, 46, 47, 56};
        int max = process(arr, 40);
        System.out.println("maxCoverPoint = " + max);


        int[] arr2 = {0, 13, 24, 35, 46, 57, 60, 72, 87};
        int L = 6;

        System.out.println(maxPoint(arr2, L));
        int max2 = process(arr2, L);
        System.out.println(max2);


    }

    /**
     * 长度为L的绳子最多覆盖几个点，请保证arr有序
     */

    public static int maxPoint(int[] arr, int L) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    // 在arr[0..R]范围上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }


}
