package left.base.class07;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description 字典树，
 * @createTime 2021年04月18日 02:54:00
 */
public class Code01_TrieTree {


    static class TireNode {
        int pass;
        int end;
        /**
         * 指向所有出现的字符，可以用Map<Character,Node >替代 </>
         */
        TireNode[] nextNodes;

        public TireNode() {
            pass = 0;
            end = 0;
            //用nextNodes[0]~nextNodes[25] 表示a~z
            nextNodes = new TireNode[26];
        }
    }

    static class Tire {

        public Tire() {
            this.root = new TireNode();
        }

        private TireNode root;

        public void insert(String str) {
            if (str == null) {
                return;
            }
            char[] chars = str.toCharArray();
            TireNode node = root;
            for (int i = 0; i < chars.length; i++) {

                int index = chars[i] - 'a';
                // 没有字典则创建一个
                if (node.nextNodes[index] == null) {
                    node.nextNodes[index] = new TireNode();
                }
                node = node.nextNodes[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String str) {
            if (search(str) != 0) {
                char[] chars = str.toCharArray();
                TireNode node = root;

                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    if (--node.nextNodes[index].pass == 0) {
                        node.nextNodes[index] = null;
                        return;
                    }
                    node = node.nextNodes[index];
                }
                node.end--;
            }
        }

        public int search(String str) {
            if (str == null) {
                return 0;
            }

            TireNode node = root;
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {

                int index = chars[i] - 'a';
                // 字典树里面没有
                if (node.nextNodes[index] == null) {
                    return 0;
                }
                node = node.nextNodes[index];

            }

            return node.end;
        }

        public int preFixNumber(String str) {

            if (str == null) {
                return 0;
            }

            TireNode node = root;

            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (node.nextNodes[index] == null) {
                    return 0;
                }
                node = node.nextNodes[index];
            }
            return node.pass;
        }


    }

    public static void main(String[] args) {
        Tire tire = new Tire();

        tire.insert("abc");
        tire.insert("abc");
        tire.insert("abc");
        tire.insert("abc");
        tire.insert("abb");
        tire.insert("aba");
        tire.insert("ae");
        tire.insert("abf");
        tire.insert("abg");
        tire.insert("abq");

        tire.delete("abc");
        tire.delete("ab");

        int abc = tire.search("abc");
        System.out.println("abc = " + abc);

        int ab = tire.preFixNumber("ab");
        System.out.println("ab = " + ab);


    }
}
