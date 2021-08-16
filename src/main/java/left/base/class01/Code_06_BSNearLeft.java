package left.base.class01;

import java.util.Arrays;

/**
 * @Classname Code_06BSNearLeft
 * @Description TODO
 * @Date 2021/8/13 12:34 下午
 * @Created by tangyao
 */
public class Code_06_BSNearLeft {

    public static int nearestIndex(int[] arr, int value) {

        int left = 0;
        int right = arr.length - 1;
        int middle = 0;
        int finalLeftPoint = 0;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (value <= arr[middle]) {
                right = middle - 1;
                finalLeftPoint = middle;
            } else {
                left = middle + 1;
            }

        }
        return finalLeftPoint;
    }


    public static int test(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        int[] errorArr = null;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int value = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random());
            Arrays.sort(arr);
            int num1 = test(arr, value);
            int num2 = nearestIndex(arr, value);
            if (num1 != -1 && num2 != -1 && arr[num1] != arr[num2]) {
                System.out.println("正确的下标为" + num1 + "的值为 " + value);
                System.out.println("错误的下标为" + num2 + "的值为 " + value);
                succeed = false;
                errorArr = arr;
                break;
            }
        }

        long end = System.nanoTime();
        System.out.println("一共用时" + (end - start));

        if (succeed) {
            System.out.println(testTime + "次测试用例全部通过");
        } else {
            System.out.println("errorArr :");
            for (int num : errorArr) {
                System.out.print(num + " ");
            }
        }


    }


}
