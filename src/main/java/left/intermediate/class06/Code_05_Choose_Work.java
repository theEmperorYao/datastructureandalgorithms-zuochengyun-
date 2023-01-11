package left.intermediate.class06;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Title:Code_05_Job
 * @Author: tangyao
 * @CreateTime: 2023/01/11  14:50
 * @Description: TODO
 * @Version: 1.0
 */
public class Code_05_Choose_Work {

    static class Job {
        int hard;
        int money;

        public Job(int hard, int money) {
            this.hard = hard;
            this.money = money;
        }

    }

    public static int[] getMoney(Job[] job, int[] ability) {

        Arrays.sort(job, ((o1, o2) ->
                o1.hard != o2.hard
                        ? o1.hard - o2.hard
                        : o2.money - o1.money));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard > pre.hard && job[i].money > pre.money) {
                map.put(job[i].hard, job[i].money);
                pre = job[i];
            }
        }


        return Arrays.stream(ability).map(i -> {
            Integer key = map.floorKey(i);
            return key != null ? map.get(key) : 0;
        }).toArray();
    }


    public static void main(String[] args) {

        Job[] jobs = new Job[]{
                new Job(1, 4),
                new Job(2, 6),
                new Job(4, 3),
                new Job(3, 7),
                new Job(6, 9)
        };
        int[] ability = {1, 3, 4, 5, 2};

        int[] money = getMoney(jobs, ability);

        for (int i : money) {
            System.out.println("i = " + i);
        }
    }
}
