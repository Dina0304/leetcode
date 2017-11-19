package dataStructure.BinTree;

/**
 * Created by Administrator on 2017/10/22.
 */

/**
 * 返回二叉树节点间的最大距离
 */
public class MaxDistance {
    class Node {
        Node left = null;
        Node right = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    public static int maxDistance( Node head ) {
        int[] record = new int[1]; // 用于存储左右子树距离当前节点的最大深度
        return helper(head, record);
    }

    public static int helper(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }

        int leftMax = helper(head.left, record);
        int maxFromLeft = record[0]; // head 的左子树上，距离 head 左孩子的最远距离
        int rightMax = helper(head.right, record);
        int maxFromRight = record[0]; // head 的右子树上，距离 head 右孩子的最远距离

        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        int curNodeMax = maxFromLeft + maxFromRight + 1;

        return Math.max(Math.max(leftMax, rightMax), curNodeMax);
    }

    public static String addStrings(String num1, String num2) {
        if(num1==null || num2==null) return null;

        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int sum = 0;

        while(i<a.length || i<b.length) {
            if(i < a.length) {
                sum += (a[i]-'0');
            }
            if(i < b.length) {
                sum += (b[i]-'0');
            }

            sb.append(sum%10);
            sum /= 10;
            i++;
        }
        if(sum == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("98", "9"));
    }
}
