package left.base.class07;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 贪心算法，安排时间开会
 * @createTime 2021年04月18日 15:25:00
 */
public class Code04_BestArrange {

    static class Program {
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
        Arrays.sort(programs, Comparator.comparingInt(Program::getEnd));

        int result = 0;
        for (Program program : programs) {
            int end = program.end;
            if (start <= start) {
                start = end;
                result++;
            }
        }
        return result;
    }

}
