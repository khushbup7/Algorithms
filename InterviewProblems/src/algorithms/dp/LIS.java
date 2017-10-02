package algorithms.dp;

public class LIS {
	
	int size = 10;
	int[] dp = new int[size];
	public static int getLIS(int[] nums) {
		return getLIS1(nums, Integer.MIN_VALUE, 0);
	}
	
	//  Brute force
	// Time Complexity  - 2^n
	// Space Complexity - n^2
	public static int getLIS1(int[] nums,int prev, int curpos) {
		
		if(curpos == nums.length)
			return 0;
		int length = 0;
		if(prev < nums[curpos])
			length = 1 + getLIS1(nums, nums[curpos], curpos + 1);
		
		int nlength = getLIS1(nums, prev, curpos + 1);
		return Math.max(length, nlength);
	}
	
	// Dynamic programming
	// Time Complexity - n^2
	// Space Complexity - n
	public static int getLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxVal = 1;
		for(int i =1; i< nums.length; i++) {
			int maxCur = 0;
			for(int j= 0; j < i; j++) {
				if(nums[i] > nums[j])
					maxCur = Math.max(maxCur, dp[j]);
			}
			dp[i] = maxCur + 1;
			maxVal = Math.max(dp[i], maxVal);
		}
		return maxVal;
	}
	
	//Dynaic Programming with Binary Seacrh
	public static int getLIS3(int[] nums) {
		
		//TODO
		return 0;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 2, 3, 7, 12, 19};
		System.out.println(getLIS2(arr));
	}
}
