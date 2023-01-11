package left.intermediate.class06;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title:Code_04_RemoveClub
 * @Author: tangyao
 * @CreateTime: 2023/01/10  17:36
 * @Description:
 * 在迷迷糊糊的大草原上， 小红捡到了n根木棍， 第i根木棍的长度为i，小红现在很开心。
 * 想选出其中的三根木棍组成美丽的三角形。但是小明想捉弄小红， 想去掉一些木棍， 使得小红任意选三根木棍都不能组成三角形。
 * 请问小明最少去掉多少根木棍呢？输入n 返回至少去掉多少根。
 * @Version: 1.0
 */
public class Code_04_RemoveClub {

    public static int removeClub(int[] nums) {

        Arrays.sort(nums);

        Set<Integer> set = Stream.iterate(new int[]{1, 2}, n -> new int[]{n[1], n[0] + n[1]})
                .map(n -> n[0])
                .limit(Integer.MAX_VALUE)
                .takeWhile(num -> num <= nums[nums.length - 1])
                .collect(Collectors.toSet());
        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        collect.removeAll(set);

        int size = collect.size();
        return size;
    }


    public static void main(String[] args) {

        int size = 17;
        int[] ints = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            ints[i] = i;
        }

        int i = removeClub(ints);
        System.out.println("i = " + i);
    }
}
