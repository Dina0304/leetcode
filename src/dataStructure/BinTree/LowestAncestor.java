package dataStructure.BinTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by dina on 17/10/22.
 */
public class LowestAncestor {

    class Node {
        Node left = null;
        Node right = null;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 寻找节点 n1 和 n2 的最近公共父节点
     * @param head
     * @param n1
     * @param n2
     * @return
     */
    public static Node lowestAncestor(Node head, Node n1, Node n2) {
        if (head==null || head==n1 || head==n2) {
            return head;
        }

        Node left = lowestAncestor(head.left, n1, n2);
        Node right = lowestAncestor(head.right, n1, n2);

        if (left!=null && right!=null) {
            return head;
        }

        return left!=null?left:right;
    }

    private static Map<Node, Node> map;

    public LowestAncestor(Node head) {
        map = new HashMap<>();
        if (head != null) {
            map.put(head, null);
        }

        setMap(head);
    }

    // --------------------------------------------

    /**
     * 构建 节点-父节点 的 hashmap
     * @param head
     */
    public static void setMap(Node head) {
        if (head == null) {
            return;
        }

        if (head.left != null) {
            map.put(head.left, head);
        }

        if (head.right != null) {
            map.put(head.right, head);
        }

        setMap(head.left);
        setMap(head.right);
    }

    /**
     * 查找 n1 和 n2 节点的最近公共父节点并返回
     * @param n1
     * @param n2
     * @return
     */
    public static Node query(Node n1, Node n2) {
        Set<Node> set = new HashSet<>();
        while (n1 != null) {
            set.add(n1);
            n1 = map.get(n1);
        }

        while (!set.contains(n2)) {
            n2 = map.get(n2);
        }

        return n2;
    }
}
