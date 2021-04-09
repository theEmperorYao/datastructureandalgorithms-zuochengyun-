package left.base.class01;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年10月22日 22:07:00
 */
public class GetMinTest {

    public static int getMain(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int leftMax = getMain(arr, left, mid);
        int rightMax = getMain(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 34, 35, 7, 5, 517343431, 571, 1, 5771, 11788};
        System.out.println(getMain(arr, 0, arr.length - 1));
    }
}
