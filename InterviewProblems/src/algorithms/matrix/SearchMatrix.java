package algorithms.matrix;

public class SearchMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		int i = 0; int j = col - 1;
		while(i<= row && j>=0) {
			if(matrix[i][j] == target)
				return true;
			if(matrix[i][j] < target)
				i++;
			if(matrix[i][j] > target)
				j--;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] arr = {
					{1,3,5,7},
					{10,12,16,30},
					{45,48,50,55}
		};
		
		System.out.println(searchMatrix(arr, 15));
		

	}

}
