package left.baseascension.code4;

/**
 * @Classname Code01_MaxDistanceInTree
 * @Description TODO
 * @Date 2021/7/1 11:44 下午
 * @Created by tangyao
 */
public class Code01_MaxDistanceInTree {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }

    }

    public static class ReturnType {
        public int maxDistance;
        public int height;

        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }


    public static ReturnType process(Node head) {

        if (head == null) {
            return new ReturnType(0, 0);
        }
        ReturnType left = process(head.left);
        ReturnType right = process(head.right);

        int height = left.height + right.height + 1;
        int leftMaxDistance = left.maxDistance;
        int rightMaxDistance = right.maxDistance;

        int maxDistance = Math.max(Math.max(leftMaxDistance, rightMaxDistance), height);
        return new ReturnType(maxDistance, Math.max(left.height, right.height) + 1);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(process(head1).maxDistance);
    }



}
