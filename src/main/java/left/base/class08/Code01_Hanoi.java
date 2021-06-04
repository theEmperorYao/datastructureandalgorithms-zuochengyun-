package left.base.class08;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 汉诺塔问题
 * @createTime 2021年06月04日 01:18:00
 */
public class Code01_Hanoi {

    /**
     * 分为三部分，from ，to，与other
     * 假如i个圆盘需要从from移动到to，
     * 1. 先将 1 ~ i-1个从from移动到 other
     * 2.再将 第i个 从from 移动到 to
     * 3.再将第 1~ i-1从other 移动到 to
     */
    public static void func(int i, String start, String end, String other) {

        if (i == 1) {
            System.out.println(" Move 1 from " + start + " to " + end);
        } else {
            func(i - 1, start, other, end);
            System.out.println(" Move " + i + "  from " + start + " to " + end);
            func(i - 1, other, end, start);
        }
    }

    public static void hanoi(int n) {
        func(n, "左", "中", "右");
    }

    public static void main(String[] args) {
        hanoi(3);
    }

}
