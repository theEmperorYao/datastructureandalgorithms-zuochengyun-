package left.intermediate.class05;
/*
 * 给定一个正整数数组arr，把arr想象成一个直方图。返回这个直方图如果装水，能装下几格水？
 * */

public class Code_01_water {

    /**
     * 找到数组中 某个位置，最左边最大值，和最右边最大值，然后作差确定该位置多高水量
     *
     * @param arr
     * @return
     */
    public static int water1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int water = 0;
        for (int i = 1; i <= arr.length - 2; i++) {
            int leftMax = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(arr[j], leftMax);
            }

            int rightMax = Integer.MIN_VALUE;

            for (int j = i + 1; j <= arr.length-1; j++) {
                rightMax = Math.max(arr[j], rightMax);
            }

            water += Math.max(Math.min(leftMax, rightMax) - arr[i], 0);

        }

        return water;


    }


    /**
     * 优化过后 双指针 同时从两边往中间走，哪边小，从哪边走
     *
     * @param arr
     * @return
     */
    public static int water2(int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }

        int water = 0;

        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];

        int L = 1;
        int R = arr.length - 2;

        while (L <= R) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - arr[L]);
                leftMax = Math.max(arr[L++], leftMax);
            } else {
                water += Math.max(0, rightMax - arr[R]);
                rightMax = Math.max(arr[R--], rightMax);
            }
        }

        return water;
    }


    // for test
    public static int[] generateRandomArray(int len, int value) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * value) + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int value = 200;
        int testTimes = 100000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(len, value);
            int ans1 = water1(arr);
            int ans2 = water2(arr);
//            int ans3 = water3(arr);
//            int ans4 = water4(arr);
//            if (ans1 != ans2 || ans3 != ans4 || ans1 != ans3) {
//                System.out.println("Oops!");
//            }
            if (ans1 != ans2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
