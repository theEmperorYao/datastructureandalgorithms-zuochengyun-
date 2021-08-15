package left.base.class01;

/**
 * @Classname Code_08GetMax
 * @Description TODO
 * @Date 2021/8/14 2:37 下午
 * @Created by tangyao
 */
public class Code_08GetMax {


    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = left + ((right - left) >> 1);
        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, 13, 4, 1, 323, 64, 3, 32, 17, 1, 13, 321, 1};
        int process = process(arr, 0, arr.length-1);
        System.out.println("process = " + process);

    }
}
