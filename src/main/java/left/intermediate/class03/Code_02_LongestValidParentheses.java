package left.intermediate.class03;

public class Code_02_LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int pre;
        int max = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = longestValidParentheses("()()()))((()))()()");
        System.out.println("i = " + i);
    }
}