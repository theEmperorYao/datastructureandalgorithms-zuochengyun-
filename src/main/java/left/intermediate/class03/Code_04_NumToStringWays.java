package left.intermediate.class03;

public class Code_04_NumToStringWays {

    public static int numToStringWays(int num) {

        if (num < 1) {
            return 0;
        }

        return process(String.valueOf(num).toCharArray(), 0);
    }

    public static int process(char[] array, int index) {

        //1、如果到最后一个位置，那么他之前的就是一种情况
        if (index == array.length) {
            return 1;
        }

        //2、如果当前位置是0,那么不会有任何组合，结果就是0
        if (array[index] == '0') {
            return 0;
        }

        //3、如果 index 是 1~9
        //3.1 让 array[index] 自己作为一部分

        int res = process(array, index + 1);

        // 3.2除了index之外后面没有字符串了
        if (index == array.length - 1) {
            return res;
        }

        //4、如果 index + index+1 组合 小于 27 那就是另一种组合形式

        if (((array[index] - '0') * 10 + (array[index + 1] - '0')) < 27) {
            res += process(array, index + 2);
        }
        return res;
    }

    public static void main(String[] args) {
        int i = numToStringWays(267);
        System.out.println("i = " + i);
    }
}
