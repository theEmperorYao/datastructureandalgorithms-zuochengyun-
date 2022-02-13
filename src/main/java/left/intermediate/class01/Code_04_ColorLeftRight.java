package left.intermediate.class01;

/**
 * @Classname Code_04_ColorLeftRight
 * @Description 牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
 * 牛牛现在可 以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将 会被覆盖。
 * 牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。
 * 牛牛想知道他最少需要涂染几个正方形。
 * 如样例所示: s = RGRGR 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案
 * @Date 2022/2/13 3:28 下午
 * @Author by tangyao
 */
public class Code_04_ColorLeftRight {


    /**
     * 采用预处理的方式
     *
     * @param s
     * @return
     */
    public static int colorLeftRight(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }

        char[] chars = s.toCharArray();

        // RGRGR->RRRGG
        // 统计多少个G变成R
        int[] leftArr = new int[chars.length];

        // 统计多少个R变成G
        int[] rightArr = new int[chars.length];

        leftArr[0] = chars[0] == 'G' ? 1 : 0;
        rightArr[chars.length - 1] = chars[chars.length - 1] == 'R' ? 1 : 0;
        for (int i = 1; i < chars.length; i++) {
            leftArr[i] = leftArr[i - 1] + (chars[i] == 'G' ? 1 : 0);
        }
        for (int i = chars.length - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] + (chars[i] == 'R' ? 1 : 0);
        }
        int N = chars.length - 1;

        int result = Integer.MAX_VALUE;

        for (int L = 0; L <= N; L++) {
            if (L == 0) {
                // 统计[0,N]有多少个R 变成G
                result = Math.min(result, rightArr[0]);
            } else if (L == N) {
                // 统计[0,N]多少个G 变成R
                result = Math.min(result, leftArr[N]);
            } else {
                // [0,L] 多少个G 变成R  ， [L+1,N] 多少个R 变成G

                // RGRGR->RRRGG
                result = Math.min(result, leftArr[L] + rightArr[L + 1]);
            }
        }
        return result;


    }


    public static int minPaint(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }

        char[] chars = s.toCharArray();

        // RGRGR->RRRGG  R->G
        int[] right = new int[chars.length];

        right[chars.length - 1] = chars[chars.length - 1] == 'R' ? 1 : 0;

        for (int i = chars.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (chars[i] == 'R' ? 1 : 0);
        }

        int left = 0;
        // 所有的R->G的次数
        int result = right[0];
        for (int i = 0; i < chars.length - 1; i++) {

            // left 为这个位置多少个G->R
            left += (chars[i] == 'G' ? 1 : 0);
            result = Math.min(result, left + right[i + 1]);

        }
        // 最后一次是所有的G ->R的次数
        return Math.min(result, left + (chars[chars.length - 1] == 'G' ? 1 : 0));


    }


    public static void main(String[] args) {
        var a = "GGRGGRRRGGRGRGRRGRRGGGRRGGGGRRGR";
        int rrrgg = colorLeftRight(a);
        int i = minPaint(a);
        System.out.println("i = " + i);
        System.out.println("RGRGR = " + rrrgg);
    }

}
