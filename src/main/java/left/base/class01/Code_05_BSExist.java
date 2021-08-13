package left.base.class01;

import java.util.Arrays;

/**
 * @Classname Code_05_BSExist
 * @Description TODO
 * @Date 2021/8/13 9:34 上午
 * @Created by tangyao
 */
public class Code_05_BSExist {

    public static int exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = sortedArr.length - 1;

        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (num < sortedArr[middle]) {
                right = middle - 1;
            } else if (num > sortedArr[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return sortedArr[left] == num ? left : -1;
    }

    public static int test(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }

        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] == num) {
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
            int num2 = exist(arr, value);
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
