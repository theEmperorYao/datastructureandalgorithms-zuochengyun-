package left.base.class01;

/**
 * @Classname Code08_BSAwesome
 * @Description 局部最小值，也采用二分法
 * @Date 2021/8/13 1:59 下午
 * @Created by tangyao
 */
public class Code08_BSAwesome {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 2] < arr[arr.length - 1]) {
            return arr[arr.length - 2];
        }

        int left = 1;
        int right = arr.length - 2;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {100, 34, 3, 45, 42, 321, 4, 624, 6, 4236, 43, 62, 23, 243, 1};
        int lessIndex = getLessIndex(arr);
        System.out.println("lessIndex = " + lessIndex);

    }
}
