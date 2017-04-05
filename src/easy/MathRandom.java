package easy;

import java.util.Iterator;
import java.util.Random;

public class MathRandom {
	public static double heartCurve(double x, double y) {
		return Math.pow((x*x+y*y-1), 3) - x*x*Math.pow(y, 3);
	}
	
	public static double getPossibility() {
		double possibility = 0,x=0,y=0;
		Random random = new Random();
		double mu1 = 3, theta1 = 3;
		double mu2 = 4, theta2 = 4;
		double count = 0;
		
		for (int i = 0; i < 10000; i++) {
			x = theta1 * random.nextGaussian() + mu1;
			y = theta2 * random.nextGaussian() + mu2;
			if (heartCurve(x, y) < 0) {
				count++;
			}
		}
		possibility = count/10000.00;
		return possibility;
	}

	public static void main(String[] args) {
		double possibility = getPossibility();
		System.out.println(possibility);

	}

}
