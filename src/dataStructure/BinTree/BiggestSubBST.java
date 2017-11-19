package dataStructure.BinTree;

/**
 * Created by Administrator on 2017/10/22.
 */

/**
 * 找到二叉搜索树中的最大搜索二叉子树，并返回改子树的头结点
 */
public class BiggestSubBST {
    class Node {
        Node left = null;
        Node right = null;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node biggestSubBST(Node head) {
        int[] record = new int[3]; // 0: max nodes num; 1:min value; 2: max value
        return helper(head, record);
    }

    public static Node helper(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;

            return head;
        }

        int val = head.val;
        Node left = head.left;
        Node right = head.right;

        Node lBst = helper(left, record);
        int lNums = record[0];
        int lMin = record[1];
        int lMax = record[2];

        Node rBst = helper(right, record);
        int rNums = record[0];
        int rMin = record[1];
        int rMax = record[2];

        if (left == lBst && right == rBst && lMax < val && val < rMin) {
            record[0] = lNums + rNums + 1;
            return head;
        }

        record[0] = Math.max(lNums, rNums);

        return lNums > rNums ? lBst : rBst;
    }
}
