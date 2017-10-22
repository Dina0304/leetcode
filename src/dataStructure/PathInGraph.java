package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dina on 17/10/15.
 */
public class PathInGraph {
    static class Node{
        int x,y;
        Node node = null;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static List<List<String>> findPaths(int[][] m, List<Node> magicNodes) {
        List<List<String>> res = new ArrayList<>();

        int row = m.length;
        int col = m[0].length;

        helper(m, res, new ArrayList<String>(), 0, 0, row, col, magicNodes);

        return res;
    }

    public static Node isMagicNode(int x, int y, List<Node> magicNodes) {
        for(Node node : magicNodes) {
            if (node.x == x && node.y == y) {
                return node;
            }
        }

        return null;
    }

    public static void helper(int[][] m, List<List<String>> res, List<String> list, int x, int y, int row, int col, List<Node> magicNodes) {
        if(x==row-1 && y==col-1) {
            m[x][y] = 5;
            list.add(getFormat(x, y));
            System.out.println("Result:");
            printMatrix(m);

            res.add(new ArrayList<>(list));
            m[x][y] = 0;
            return;
        }

        if(x<0 || x>=row || y<0 || y>=col) {
            return;
        } else {
            if(m[x][y] == 0) {
                Node newNode = isMagicNode(x, y, magicNodes);
                if (newNode != null) {
                    m[newNode.node.x][newNode.node.y] = 0;
                    System.out.println("magic:");
                    printMatrix(m);
                }
                m[x][y] = 5;
                list.add(getFormat(x, y));
                helper(m, res, list, x-1, y, row, col, magicNodes);
                helper(m, res, list, x+1, y, row, col, magicNodes);
                helper(m, res, list, x, y-1, row, col, magicNodes);
                helper(m, res, list, x, y+1, row, col, magicNodes);
//                if(newNode == null) {
                    list.remove(list.size() - 1);
                    m[x][y] = 0;
//                }
            }
        }
    }

    public static String getFormat(int x, int y) {
        return "("+x+","+y+")";
    }

    public static void printMatrix(int[][] m) {
        int row = m.length;
        int col = m[0].length;

        for(int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    public static void printPaths(List<List<String>> list) {
        for(List<String> cur : list) {
            System.out.println(cur.toString());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{0,0,1,1,1}, {1,0,0,0,1}, {1,0,1,0,0}, {1,1,0,0,1}, {1,0,0,0,1}, {1,1,1,1,1}, {1,0,0,0,0}};
        printMatrix(m);
        List<Node> magicNodes = new ArrayList<>();
        Node m1 = new Node(2,1);
        m1.node = new Node(5,3);

        Node m2 = new Node(2,4);
        m2.node = new Node(5,4);

        magicNodes.add(m1);
        magicNodes.add(m2);

        List<List<String>> list = findPaths(m, magicNodes);
        System.out.println("Path number: " + list.size());
        printPaths(list);
    }
}
