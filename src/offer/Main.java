package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] y = new int[n];
        int[] x = new int[n];
        
        int p=0;
        int q=0;
        while(p < n) {
        	x[p] = in.nextInt();
        	p++;
        }
        
        while(q < n) {
        	y[q] = in.nextInt();
        	q++;
        }
        
        List<Chess> chesses = new ArrayList<Chess>();
        int index = 0;
        while(index < n) {
        	chesses.add(new Chess(x[index], y[index], 0));
        	index++;
        }

        int distance[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            List<Chess> tmp = new LinkedList<>();
            
            Chess mid = new Chess(chesses.get(i).x, chesses.get(i).y, 0);
            for (int j = 0; j < n; j++) {
            	int bdistance = Math.abs(chesses.get(j).x - mid.x) + Math.abs(chesses.get(j).y - mid.y);
                Chess curChess = new Chess(chesses.get(j).x, chesses.get(j).y, bdistance);
                tmp.add(curChess);
            }
            
            Collections.sort(tmp);
            distance[i][0] = 0;
            int j=1;
            while(j < n) {
            	distance[i][j] = distance[i][j - 1] + tmp.get(j).distance;
            	j++;
            }
        }

        int matrix[] = new int[n];
        for (int i = 0; i < n; i++) {
            int minValue = distance[0][i];
            for (int j = 0; j < n; j++) {
                if (minValue > distance[j][i]) {
                    minValue = distance[j][i];
                }
            }
            matrix[i] = minValue;
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(matrix[i] + " ");
        }
        System.out.println(matrix[n - 1]);
        in.close();
    }
}

class Chess implements Comparable<Chess> {
    int x;
    int y;
    int distance;

    public Chess(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Chess o) {
        return distance - o.distance;
    }
}

