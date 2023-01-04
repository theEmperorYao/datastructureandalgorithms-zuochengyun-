package left.intermediate.class05;

import java.lang.reflect.Array;

/**
 * @Classname NearMultiple4Times
 * @Description
 * @Date 2023/1/4 09:21
 * @Author by tangyao
 */
public class NearMultiple4Times {

    /**
     * 给定一个数组arr，如果通过调整可以做到arr中任意两个相邻的数字相乘是4的倍数， 返回true；如果不能返回false
     *
     * @param nums
     */
    public static boolean nearMultiple4Times(int[] nums) {

        // 统计 奇数个数 a，2因子个数 b ，4因子个数 c
        // 如果 a==0  ; 奇4奇4奇4奇   c>=a-1
        // 如果 a!=0   否则 2222222 4奇4奇4奇  c>=a
        int a = 0, b = 0, c = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                a++;
            }
            if (num % 2 == 0 && num % 4 != 0) {
                b++;
            }
            if (num % 4 == 0) {
                c++;
            }

        }
        return b == 0 ? c >= a - 1 : c >= a;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 33, 3, 4, 4, 4};
        boolean b = nearMultiple4Times(arr);
        System.out.println("b = " + b);
    }

}
