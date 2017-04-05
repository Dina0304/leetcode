package microsoft;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1 {
	public class State{
		public int step;
		public int collected;
		public int currentPro;
		public double totalPro;
		public State(int step, int collected, int currentPro, double totalPro){
			this.step = step;
			this.collected = collected;
			this.currentPro = currentPro;
			this.totalPro = totalPro;
		}
	}
	public static void main(String[] args){
		

		int P, Q, N;
		Scanner scanner = new Scanner(System.in);
		P = scanner.nextInt();
		Q = scanner.nextInt();
		N = scanner.nextInt();
		
		double expect = 0;
		
		
		Queue<State> queue = new LinkedList<State>();
		State state = new Question1().new State(0, 0, P, 1);
		queue.add(state);
		while(queue.size() > 0){
			State cur = queue.poll();
			if(cur.collected == N){
				expect += cur.totalPro * cur.step;
			}
			else{
				// get 
				int next_currentPro = (int) Math.floor((double)P / Math.pow(2, cur.collected + 1));
				State s = new Question1().new State(cur.step + 1, cur.collected + 1, next_currentPro, cur.totalPro  * (double)cur.currentPro / 100);
				queue.add(s);
				if(cur.currentPro < 100){
					next_currentPro = Math.min(100, cur.currentPro + Q);
					State s2 = new Question1().new State(cur.step + 1, cur.collected, next_currentPro, cur.totalPro  * (double)(100 - cur.currentPro) / 100);
					queue.add(s2);
				}
				
			}
		}
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(expect));
		
	}
}
