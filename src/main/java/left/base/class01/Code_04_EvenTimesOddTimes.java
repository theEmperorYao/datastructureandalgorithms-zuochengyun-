package left.base.class01;

/**
 * @Classname Code_04_PrintOddTimesNum
 * @Description TODO
 * @Date 2021/8/13 1:23 上午
 * @Created by tangyao
 */
public class Code_04_EvenTimesOddTimes {


    public static int printOddTimesNum(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }
        return eor;
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }
        // eor = a^b

        // 取非0数最右面的1
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int num : arr) {
            if ((rightOne & num) == 0) {
                // 最终等于a或b
                onlyOne ^= num;
            }
        }
        System.out.println("出现奇数次的数分别为" + onlyOne + " 和" + (eor ^ onlyOne));

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2};
        int i = printOddTimesNum(arr);
        System.out.println("i = " + i);

        int[] arr2 = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        printOddTimesNum2(arr2);

    }
}
