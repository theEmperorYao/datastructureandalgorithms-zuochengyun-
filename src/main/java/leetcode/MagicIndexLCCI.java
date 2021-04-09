package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年07月31日 20:53:00
 */
public class MagicIndexLCCI {
    public static int findMagicIndex(int[] nums) {
        int index = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                if (k == 0) {
                    index = i;
                    k++;
                } else {
                    index = i > index ? index : i;
                }
            }
        }
        if (k == 1) {
            return index;
        } else {
            return -1;
        }
    }

    public static int findMagicIndex2(int[] nums) {
        for (int i = 0, length = nums.length; i < length; i++) {
            if (i == nums[i]) {
                return i;
            }
            if (nums[i] > i + 1) {
                //如果nums[i]大于i+1,我们就让i加上nums[i] - 1，
                // 这里减1的目的是为了抵消上面for循环中的i++。
                //这里判断的时候为什么是nums[i] > i + 1而不是
                //nums[i] > i ,因为如果num[i]只比i大1的话，
                //直接执行上面的i++就可以了，没必要再执行下面的计算
                i = nums[i] - 1;
            }
        }
        return -1;
    }

    public  int findMagicIndex3(int[] nums) {
        String string = "123";
        return 1;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 2};
        System.out.println(findMagicIndex2(nums));
    }
}
