package medium;

public class SearchA2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int l = 0;
        int r = row*column-1;
        while(l!=r) {
            int mid = l+((r-l)>>1);
            if(matrix[mid/column][mid%column] == target) {
                return true;
            }else if(matrix[mid/column][mid%column] > target) {
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        if(matrix[l/column][l%column] == target) {
            return true;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target = 3;
		System.out.println(searchMatrix(matrix, target));
	}

}
