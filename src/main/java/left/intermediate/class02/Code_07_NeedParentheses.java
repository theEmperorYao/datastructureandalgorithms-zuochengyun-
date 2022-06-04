package left.intermediate.class02;

/**
 * @Classname Code_07_NeedParentheses
 * @Description TODO
 * @Date 2022/6/4 22:21
 * @Author by tangyao
 */
public class Code_07_NeedParentheses {


    public static int process(String str) {

        // 需要填补的左括号
        int ans = 0;
        // 需要填补的右括号
        int count = 0;
        for (int i = 0; i < str.length(); i++) {


            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    ans++;
                } else {
                    count--;
                }
            }
        }
        return ans + count;


    }

    public static void main(String[] args) {

        int process = process("(()()())))()");
        System.out.println("process = " + process);
    }
}
