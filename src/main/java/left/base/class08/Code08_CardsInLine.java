package left.base.class08;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸 牌，
 * 规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家A 和玩家B都绝顶聪明。请返回最后获胜者的分数。
 * @createTime 2021年06月06日 16:07:00
 */
public class Code08_CardsInLine {

    /**
     * 第一次选，选择最好结果
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int f(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        return Math.max(arr[left] + s(arr, left + 1, right), arr[right] + s(arr, left, right - 1));
    }

    /**
     * 第二次选，返回最差结果，剩下最好的结果给自己
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int s(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        return Math.min(f(arr, left + 1, right), f(arr, left, right - 1));
    }

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 19, 1};
        int i = win1(arr);
        System.out.println("i = " + i);
    }

}
