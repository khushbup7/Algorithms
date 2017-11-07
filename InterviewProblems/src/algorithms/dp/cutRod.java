package algorithms.dp;

public class cutRod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(cutRodTake2(p, 8));
	}

	static int cutRodTake1(int[] prices, int n) {

		int max = Integer.MIN_VALUE;

		if (n <= 0)
			return 0;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, prices[i] + cutRodTake1(prices, n - 1 - i));
		}

		return max;
	}

	static int cutRodTake2(int[] prices, int n) {

		int[] maxForEach = new int[n + 1];
		maxForEach[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, prices[j] + maxForEach[i - j - 1]);
			}
			
			maxForEach[i] = max;
		}

		return maxForEach[n];

	}
}
