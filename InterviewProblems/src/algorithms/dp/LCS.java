package algorithms.dp;

public class LCS {
	public static void main(String[] args) {
		lcs("ABCBA", "CABCA");
	}

	static void lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		System.out.println("Length of LCS:" + dp[m][n]);
		
		int index = dp[m][n];
		
		int i = m;
		int j = n;
		char[] res = new char[index];
		
		while(i>0 && j>0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				res[--index] = s1.charAt(i-1);
				i--;
				j--;
			}
			
			else {
				if(dp[i][j] == dp[i-1][j]) {
					i--;
				}
				else j--;
			}
			
		}
		
		for(char c: res)
			System.out.print(c);
	}
}
