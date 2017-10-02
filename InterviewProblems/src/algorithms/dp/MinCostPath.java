package algorithms.dp;

public class MinCostPath {
	public static int minCostPath(int[][] matrix, int m, int n ) {
		int[][] dp = new int[m+1][n+1];
		dp[0][0] = matrix[0][0];
		
		for(int i = 1; i <= m; i++)
			dp[i][0] = dp[i-1][0] + matrix[i][0];
		
		for(int j =1; j<= n; j++) {
			dp[0][j] = dp[0][j-1] + matrix[0][j];
		}
		
		for(int i = 1; i<=m ; i++) {
			for(int j = 1; j<= n; j++) {
				dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + matrix[i][j];
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		int[][] cost = {
				{1,2,3},
				{4,8,2},
				{1,5,3}
				
		};
		System.out.println(minCostPath(cost, 2, 2));
	}
}
