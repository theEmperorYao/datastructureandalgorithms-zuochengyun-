package left.intermediate.class05;

/**
 * 长度为N的数组分为两部分，返回最大的左边部分最大值减去右边部分的最大值 的绝对值
 */
public class Code_02_MaxABSBetweenLeftAndRight {




    private static int maxABS(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        // 让右部分最大值尽量小，所以右边只有一个的时候最小，左边也是。
        return max - Math.min(arr[0], arr[arr.length - 1]);

    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 4};
        int i = maxABS(arr);
        System.out.println("i = " + i);
    }


}
