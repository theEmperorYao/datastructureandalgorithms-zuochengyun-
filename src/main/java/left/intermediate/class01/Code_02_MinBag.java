package left.intermediate.class01;

/**
 * @Classname MinBag
 * @Description
 *          小虎去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个
 *          每袋的包装包装不可拆分。可是小虎现在只想购买恰好n个苹果，小虎想购买尽量少的袋数方便携带。
 *          如果不能购买恰好n个苹果，小虎将不会购买。
 *          输入一个 整数n，表示小虎想购买的个苹果，返回最小使用多少袋子。
 *          如果无论如何都不 能正好装下，返回-1
 * @Date 2022/2/12 10:43 下午
 * @Author by tangyao
 */

public class Code_02_MinBag {

    public static int getMinBag(int appleNum) {

        if (appleNum < 0 || appleNum % 2 == 1) {
            return -1;
        }

        int bag6 = -1;
        int bag8 = appleNum / 8;

        int left = appleNum - bag8 * 8;
        while (bag8 >= 0 && left <= 24) {

            int minBag6 = getMinBag6(left);
            if (minBag6 != -1) {
                bag6 = minBag6;
                break;
            }
            left = appleNum - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;

    }

    private static int getMinBag6(int left) {

        return left % 6 == 0 ? left / 6 : -1;
    }


    /**
     * 打标发
     * @param appleNum
     * @return
     */
    public static int getMinBag2(int appleNum) {

        // 奇数返回-1
        if ((appleNum & 1) == 1) {
            return -1;
        }
        if (appleNum < 18) {
            return appleNum == 0
                    ? 0 : (appleNum == 6 || appleNum == 8)
                    ? 1 : (appleNum == 12) || (appleNum == 14) || (appleNum == 16)
                    ? 2 : -1;
        }
        return (appleNum - 18) / 8 + 3;

    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {

            System.out.println("result " + (getMinBag(i) == getMinBag2(i)));
        }

        int minBag = getMinBag(92);

    }


}
