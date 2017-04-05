package easy;

public class DynamicPlanning {
	public static void DynamicPlanning() {
		final int pkgWeight = 10;
		Package[] pkgs = {
				new Package(6, 2, "a"),
				new Package(3, 2, "b"),
				new Package(5, 6, "c"),
				new Package(4, 5, "d"),
				new Package(6, 4, "e")
		};
		int[][] bestValues = new int[pkgs.length+1][pkgWeight+1];
		for (int i = 1; i <= pkgs.length; i++) {
			for (int j = 1; j <= pkgWeight; j++) {
				if(i==0 || j==0) {
					bestValues[i][j] = 0;
				}
				else {
					if(j<pkgs[i-1].getWeight()) {
						bestValues[i][j] = bestValues[i-1][j];
					}else {
						int value = pkgs[i-1].getValue();
						int weight = pkgs[i-1].getWeight();
						bestValues[i][j] = Math.max(bestValues[i-1][j], bestValues[i-1][j-weight]+value);
						if(i==pkgs.length && j==pkgWeight) {
							int max = bestValues[i][j];
						}
					}
				}
			}
		}
		System.out.println("BestVaule is "+bestValues[pkgs.length][pkgWeight]);
	}
	public static void main(String[] args) {
		DynamicPlanning();

	}

}

