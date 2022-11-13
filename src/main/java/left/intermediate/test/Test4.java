package left.intermediate.test;

public class Test4 {

    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        return process(str.toCharArray(), 0);

    }

    private static int process(char[] arr, int index) {

        if (arr.length == index) {
            return 1;
        }

        if (arr[index] == '0') {
            return 0;
        }

        int ways = process(arr, index + 1);

        if (index + 1 < arr.length && (arr[index] - '0') * 10 + arr[index + 1] - '0' < 27) {
            ways += process(arr, index + 2);
        }
        return ways;
    }


    public static int dp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] arr = s.toCharArray();

        int N = arr.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] != '0') {
                dp[i] = dp[i + 1];
                if (i + 1 < arr.length && (arr[i] - '0') * 10 + arr[i + 1] - '0' < 27) {
                    dp[i] += dp[i + 2];
                }
            }

        }
        return dp[0];

    }


    public static void main(String[] args) {

        String s = "34110451414";
        int number = number(s);
        System.out.println("number = " + number);
        int dp = dp(s);
        System.out.println("dp = " + dp);

    }
}
