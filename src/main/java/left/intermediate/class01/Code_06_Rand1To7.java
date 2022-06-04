package left.intermediate.class01;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @Classname Code_06_Rand5To7
 * @Description TODO
 * @Date 2022/6/4 16:00
 * @Author by tangyao
 */
public class Code_06_Rand1To7 {


    public static int f() {
        return new Random().nextInt(0, 5) + 1;
    }


    /**
     * 把f转换为0，1发生器
     *
     * @return
     */
    public static int getRandom() {

        int rand = 0;

        do {
            rand = f();
        } while (rand == 5);
        // 1，2 为 0 ，3，4为1

        return rand >= 3 ? 1 : 0;
    }

    public static int get1To7() {

        int rand;
        do {
            rand = getRandom() + (getRandom() << 1) + (getRandom() << 2);

        } while (rand == 7);
        return rand + 1;
    }

    public static int get13To21() {
        return new Random().nextInt(13, 22);
    }

    public static int get0Or1() {

        int rand = 0;

        do {
            rand = get13To21();
        } while (rand == 21);
        // 13,14,15,16,17,18,19,20,21
        return rand >= 17 ? 1 : 0;
    }

    public static int get30To59() {

        // 0~29

        // 需要四位二进制，0~31

        int rand = 0;

        do {
            rand = (get0Or1() << 4) + (get0Or1() << 3) + (get0Or1() << 2) + get0Or1();
        } while (rand >= 30);

        return rand + 30;

    }

    public static int f1() {

        int rand;
        do {
            rand = p();
            // 保证两次不相同
        } while (rand == p());

        return rand;

    }

    public static int p() {
        double p = 0.83;
        return Math.random() > p ? 1 : 0;

    }


    public static void main(String[] args) {


        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < 100000; i++) {

//            int num = get1To7();
//            int num = get30To59();
            int num = f1();

            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        map.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });

    }
}
