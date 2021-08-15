package left.base.class02;

/**
 * @Classname Code03_RadixSort
 * @Description TODO
 * @Date 2021/8/15 6:17 下午
 * @Created by tangyao
 */
public class Code03_RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    private static void radixSort(int[] arr, int L, int R, int digit) {

        final int radix = 10;

        // 辅助数组，和待排序数组一样容量
        int[] help = new int[R - L + 1];

        // 一共多少为就进出多少次，只和最高位有关
        for (int d = 0; d < digit; d++) {

            // 10个空间，统计词频
            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是(0和1)的数字有多少个
            // count[2] 当前位(d位)是(0、1和2)的数字有多少个
            // count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix];

            for (int i = L; i <= R; i++) {
                // 填充词频位置,j是下标
                int index = getDigit(arr[i], d);
                count[index]++;
            }
            //整理词频统计
            for (int k = 1; k < radix; k++) {
                count[k] = count[k] + count[k - 1];
            }

            // 从左到右出 比如 count[3]=7  3位置是7 ，代表某一位（假设是个位）<=3的数的数量是7个，因为是从后往前遍历，
            // 所以L+6的位置表示本次排序 某个数应该在的位置 ，然后count[3]--
            for (int i = R; i >= L; i--) {
                int index = getDigit(arr[i], d);
                help[--count[index]] = arr[i];
            }


            for (int i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }

        }

    }

    private static int getDigit(int num, int d) {

        for (int i = 0; i < d; i++) {
            num = num / 10;
        }
        return num % 10;
    }

    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }

        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {247, 7, 66, 525};
        radixSort(arr);
    }

}
