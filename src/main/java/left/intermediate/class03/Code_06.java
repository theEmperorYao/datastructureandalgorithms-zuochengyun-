package left.intermediate.class03;

import lombok.Data;

import java.io.IOException;
import java.util.*;

public class Code_06 {

    /**
     * 一个二维矩阵，从左到右 递增，从上到下递增，找出二维数组中 是否存在给定的值
     *
     * @param arr
     * @param num
     * @return
     */
    public static boolean process1(int[][] arr, int num) {

        int row = 0;
        int col = arr[0].length - 1;

        while (row <= arr.length - 1 && col >= 0) {
            int x = arr[row][col];
            if (x == num) {
                return true;
            } else if (x < num) {
                row++;
            } else {
                col--;
            }
        }

        return false;

    }


    @Data
    public static class Tuple {
        int row;
        int nums;
    }

    /**
     * 一个二维数组 由 0 ，1 组成，0从左往右连续，1从右往左连续
     * <p>
     * 求最长 1的 所在行数
     *
     * @param arr
     * @return
     */
    public static List<Tuple> process2(int[][] arr) {

        Deque<Tuple> deque = new LinkedList<>();
        int row = 0;
        int col = arr[0].length - 1;
        int ans = 0;

        // 找到第一个 为 1 的位置
        while (true) {
            if (row > arr.length - 1) {
                return new ArrayList<>();
            }
            if (arr[row][col] == 1) {
                break;
            }
            row++;
        }

        ans = 1;
        while (true) {
            if (row <= arr.length - 1 && col - 1 >= 0) {
                if (arr[row][col - 1] == 1) {
                    col--;
                    ans++;
                } else {
                    Tuple tuple = new Tuple();
                    tuple.setNums(ans);
                    tuple.setRow(row);
                    if (deque.isEmpty()) {
                        deque.add(tuple);
                        row++;
                        continue;
                    }
                    Tuple peek = deque.peek();

                    if (peek.getNums() == ans && arr[row][col] != 0) {
                        deque.add(tuple);
                    } else if (peek.getNums() < ans) {
                        deque = new LinkedList<>();
                        deque.add(tuple);
                    }
                    row++;
                }
            } else {
                break;
            }

        }

        return new ArrayList<>(deque);

    }


    public static void main(String[] args) throws IOException {

        int[][] ints = {
                {2, 3, 10, 12},
                {4, 5, 13, 17},
                {5, 9, 10, 19},
                {6, 11, 15, 21}
        };
        boolean b = process1(ints, 16);
        System.out.println("b = " + b);

        int[][] ints2 = {
                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1}
        };

        List<Tuple> tuples = process2(ints2);
        List<Integer> list = tuples.stream().map(Tuple::getRow).toList();
        System.out.println("list = " + list);

    }
}
