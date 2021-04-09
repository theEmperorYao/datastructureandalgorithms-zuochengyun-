package left.base.class04;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年11月03日 00:28:00
 */
public class Code_05_ZhiPrint {

    public static void zhiPrint(int[][] arr) {


        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = arr.length - 1;
        int endC = arr[0].length - 1;
        boolean flag = false;

        while (aR != endR + 1) {
            print(arr, aR, aC, bR, bC, flag);
            //a先左移再下移动，b先下移再左移
            //因为a行和列是以aC做判断的，所以1、2这个判断顺序不能乱
            //b同理
            aR = aC == endC ? aR + 1 : aR;//1
            aC = aC == endC ? aC : aC + 1;//2
            bC = bR == endR ? bC + 1 : bC;//3
            bR = bR == endR ? bR : bR + 1;//4
            flag = !flag;
        }

    }

    private static void print(int[][] arr, int aR, int aC, int bR, int bC, boolean flag) {
        if (flag) {
            while (aR != bR + 1) {
                System.out.println(arr[aR++][aC--] + " ");
            }
        } else {
            while (bR + 1 != aR) {
                System.out.println(arr[bR--][bC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        zhiPrint(arr);
    }
}
