package left.base.class05;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月12日 00:47:00
 */
public class Code10_PaperFolding {


    public static void printAllFolds(int n) {
        printProcess(1, n, true);
    }


    /**
     * 中序遍历 ， 右子树节点为凹，其余为凸
     *
     * @param level
     * @param n
     * @param down
     */
    private static void printProcess(int level, int n, boolean down) {
        if (level > n) {
            return;
        }
        printProcess(level + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(level + 1, n, false);

    }

    public static void main(String[] args) {
        printAllFolds(3);
    }
}
