package left.intermediate.class04;


/**
 * @author tangyao
 */
public class Code_01_PackingMachine {

    public static int minOps(int[] arr) {
        //1、左右皆负，至少 { |左| + |右| }
        //2、左右皆正，至少 { |左| , |右| }max
        //3、左负有正（左正右负），至少 { |左| , |右| } max
        //4、从左往右，每个位置的瓶颈求出来，解决了最大瓶颈就一定解决了其他位置的瓶颈，想到于网络流中的瓶颈

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % arr.length != 0) {
            return -1;
        }
        int size = arr.length;
        int avg = sum / size;

        int leftSum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {

            int leftRest = leftSum - avg * i;
            int rightRest = (sum - leftSum - arr[i]) - (size - i - 1) * avg;

            if (leftRest < 0 && rightRest < 0) {
                max = Math.max(max, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                max = Math.max(max, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }

            leftSum += arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {100, 0, 0, 0};
        int i = minOps(arr);
        System.out.println("i = " + i);
    }
}
