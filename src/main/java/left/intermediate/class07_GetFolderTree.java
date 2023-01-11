package left.intermediate;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Title:class07_GetFolderTree
 * @Author: tangyao
 * @CreateTime: 2023/01/11  17:30
 * @Description: TODO
 * @Version: 1.0
 */
public class class07_GetFolderTree {

    static class Node {
        String name;
        TreeMap<String, Node> nextMap;

        public Node(String name) {
            this.name = name;
            this.nextMap = new TreeMap<>();
        }
    }

    public static void print(String[] foldPaths) {
        if (foldPaths == null || foldPaths.length == 0) {
            return;
        }
        Node head = generateFolderTree(foldPaths);
        printProcess(head, 0);
    }

    private static void printProcess(Node head, int level) {
        if (level != 0) {
            System.out.println(get2nSpace(level) + head.name);
        }

        for (Node node : head.nextMap.values()) {
            printProcess(node, level + 1);
        }


    }

    private static String get2nSpace(int level) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < (level - 1) * 2; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }


    public static Node generateFolderTree(String[] foldPaths) {

        Node head = new Node("");
        for (String foldPath : foldPaths) {
            String[] paths = foldPath.split("\\\\");
            Node cur = head;
            for (String s : paths) {
                if (!cur.nextMap.containsKey(s)) {
                    cur.nextMap.put(s, new Node(s));
                }
                cur = cur.nextMap.get(s);
            }
        }
        return head;
    }


    public static void main(String[] args) {

        String[] foldPaths = {
                "a\\b\\c", "a\\c\\e", "e\\a\\c"
        };

        print(foldPaths);
    }
}
