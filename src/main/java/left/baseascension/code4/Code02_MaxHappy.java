package left.baseascension.code4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Code02_MaxHappy
 * @Description TODO
 * @Date 2021/7/3 10:32 下午
 * @Created by tangyao
 */
public class Code02_MaxHappy {


    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy, List<Employee> nexts) {
            this.happy = happy;
            this.nexts = nexts;
        }

    }


    public static class Info {
        public int laiMaxHappy;
        public int buMaxHappy;

        public Info(int laiMaxHappy, int buMaxHappy) {
            this.laiMaxHappy = laiMaxHappy;
            this.buMaxHappy = buMaxHappy;
        }
    }

    public static Info process(Employee employee) {
        if (employee.nexts.isEmpty()) {
            return new Info(employee.happy, 0);
        }

        int lai = employee.happy;
        int bu = 0;

        for (Employee next : employee.nexts) {
            Info process = process(next);
            lai += process.buMaxHappy;
            bu += Math.max(process.laiMaxHappy, process.buMaxHappy);
        }
        return new Info(lai, bu);
    }

    public static int maxHappy(Employee boss) {
        Info process = process(boss);
        return Math.max(process.laiMaxHappy, process.buMaxHappy);
    }

    public static void main(String[] args) {

        Employee e = new Employee(100, new ArrayList<>());
        Employee d = new Employee(50, new ArrayList<>());

        Employee b = new Employee(70, Arrays.asList(e));
        Employee c = new Employee(20, Arrays.asList(d));


        Employee a = new Employee(40, List.of(b, c));

        System.out.println(maxHappy(a));


    }


}
