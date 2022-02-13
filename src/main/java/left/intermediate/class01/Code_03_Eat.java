package left.intermediate.class01;

/**
 * @Classname Code_03_Eat
 * @Description TODO
 * @Date 2022/2/13 12:35 上午
 * @Author by tangyao
 */
public class Code_03_Eat {

    public static String winner1(int num) {

        //0, 1,  2, 3, 4,
        //后，先，后，先，先，

        if (num < 5) {
            return (num == 0 || num == 2) ? "后手" : "先手";
        }

        int base = 1;

        while (base <= num) {

            // 子过程的先手是对方，后手是自己
            if (winner1(num - base).equals("后手")) {
                return "先手";
            }

            // 防止溢出
            if (base > num / 4) {
                break;
            }
            base *= 4;

        }

        return "后手";

    }

    /**
     * 打表法
     */

    public static String winner2(int num) {
        if (num % 5 == 0 || num % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }

    }

    public static void main(String[] args) {


        for (int i = 0; i <= 50; i++) {
            String s = winner1(i);
            System.out.println(i + " : " + s);
            System.out.println((winner1(i) == winner2(i)));
        }

    }

}
