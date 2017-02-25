package easy;

public class IslandPerimeter463 {
	/*public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rowNum=grid.length, columnNum=grid[0].length;
        int[][] xGrid = new int[rowNum+1][columnNum+1];
        int[][] yGrid = new int[rowNum+1][columnNum+1];
        int oneCount = 0;
        for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				if (grid[i][j] == 1) {
					oneCount++;
					xGrid[i][j] += 1;
					xGrid[i+1][j] += 1;
					yGrid[i][j] +=1;
					yGrid[i][j+1] += 1;
				}
			}
		}
        int dulCount = 0;
        for (int i = 0; i < rowNum+1; i++) {
			for (int j = 0; j < columnNum+1; j++) {
				if (xGrid[i][j]==2) {
					dulCount++;
				}
				if (yGrid[i][j]==2) {
					dulCount++;
				}
			}
		}
        
        perimeter = 4*oneCount - 2*dulCount;
        return perimeter;
    }*/
	
	public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {//row
			for (int j = 0; j < grid[0].length; j++) {//column
				if (grid[i][j] == 1) {
					if (j==0 || grid[i][j-1]==0) {//left:water or null
						perimeter++;
					}
					if (j==grid[0].length-1 || grid[i][j+1]==0) {
						perimeter++;
					}
					if (i==0 || grid[i-1][j]==0) {
						perimeter++;
					}
					if (i==grid.length-1 || grid[i+1][j]==0) {
						perimeter++;
					}
				}
			}
		}
        return perimeter;
    }

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		int num = islandPerimeter(grid);
		System.out.println("perimeter: "+num);
	}

}
