package left.intermediate.class06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Title:Code_03_zero_one
 * @Author: tangyao
 * @CreateTime: 2023/01/10  11:40
 * @Description: TODO
 * @Version: 1.0
 */
public class Code_03_Zero_One {


    public static void main(String[] args) {

//        getNum();
        int num2 = getNum2(10);
        System.out.println("num2 = " + num2);
        int num = getNum(10);
        System.out.println("num = " + num);


    }

    private static void getNum() {
        for (int i = 1; i <= 10; i++) {
            int pow = (int) Math.pow(2, i);
            int finalI1 = i;
            long count = IntStream.range(0, pow).mapToObj(Integer::toBinaryString).filter(str -> filter(str, finalI1)).count();
            System.out.println(i + ":" + count);
        }
    }

    private static int getNum2(int num) {
        int[] ints = Stream.iterate(new int[]{1, 2}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(num)
                .mapToInt(n -> n[0])
                .toArray();

//        for (int anInt : ints) {
//            System.out.println("anInt = " + anInt);
//        }
        return ints[ints.length - 1];
    }


    public static int getNum(int num) {
        int[][] matrix = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] ints1 = Code_01_Fibonacci.matrixPower(matrix, num-3);
        return 3 * ints1[0][0] + 2 * ints1[1][0] + ints1[2][0];
    }


    public static boolean filter(String str, int finalI1) {

        if ("0".equals(str) || str.length() < finalI1) {
            return false;
        }

        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {

            if (chars[i - 1] == '0' && chars[i] == '0') {
                return false;
            }
        }
        return true;
    }

}
