package left.baseascension.code3;

public class Code01_KMP {

    /**
     *
     * @param s 原字符串
     * @param m 待比较字符串
     * @return
     */
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }

        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();

        int si = 0;
        int mi = 0;
        int[] nextArray = getNextArray(ms);

        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (nextArray[mi] == -1) {
                // 如果 nextArray[mi] == -1 也就是mi = 0了,都没有匹配上的，所以si比较位置后移一位
                si++;
            } else {
                // 向前跳到上一个前后相等的字符串位置的下一个字符去比较
                mi = nextArray[mi];
            }
        }

        return mi == ms.length ? si - mi : -1;
    }

    /**
     *
     * @param ms 需要解析的字符数组
     * @return
     */
    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;

        int pos = 2;
        int cn = 0;//相同部分的前一部分相同部分的后一个位置
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));
    }
}
