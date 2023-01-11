package left.intermediate.class06;

/**
 * @Title:Code_06_Convert
 * @Author: tangyao
 * @CreateTime: 2023/01/11  15:48
 * @Description: TODO
 * @Version: 1.0
 */
public class Code_06_Convert {

    public static boolean isValid(char[] str) {
        if (str[0] != '-' && (str[0] < '0' || str[0] > '9')) {
            return false;
        }
        if (str[0] == '-' && (str.length == 1 || str[1] == '0')) {
            return false;
        }

        for (int i = 1; i < str.length; i++) {
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static int convert(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        if (!isValid(str)) {
            throw new RuntimeException("can't not convert");
        }
        boolean neg = str[0] == '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;

        for (int i = neg ? 1 : 0; i < str.length; i++) {
            // 用'0' - str[i] 是因为想得到负数，负数表示范围比正数多1
            cur = '0' - str[i];
            // 中途转换的时候移除的情况
            if ((res < minq) || ((res == minq) && cur < minr)) {
                throw new RuntimeException("can not convert");
            }
            res = res * 10 + cur;
        }
        if (!neg && res == Integer.MIN_VALUE) {
            throw new RuntimeException("can not convert");
        }

        return neg ? res : -res;

    }


    public static void main(String[] args) {

        int maxValue = Integer.MAX_VALUE;
        System.out.println("maxValue = " + maxValue);
        int convert = convert("2147483648");
        System.out.println("convert = " + convert);
    }

}
