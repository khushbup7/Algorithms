package algorithms.dp;

// buy stock at any time and sell at  any time to get max profit

import java.util.Scanner;
import java.util.Stack;

public class profit {
	public static void main(String args[]) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		 Scanner s = new Scanner(System.in);
		 int t = s.nextInt();
		 for (int i = 0; i < t; i++) {
		 int n = s.nextInt();
		 int[] arr = new int[n];
		 for (int j = 0; j < n; j++) {
		 arr[j] = s.nextInt();
		 }
		
		 calculateProfit(arr);
		 }

		 s.close();

	}

	static void calculateProfit(int[] prices) {
		int i;
		for(i =1; i< prices.length; i++) {
            if(prices[i] > prices[i-1])
                break;
        }
        
        if(i == prices.length) {
            System.out.println(0);
            return;
        }
        
		int maxprofit = 0;
		int last = i-1;
		while (i < prices.length) {
			while (i < prices.length && prices[i] > prices[i - 1]) {
				i++;
			}

			for (; last < i - 1; last++)
				maxprofit += (prices[i - 1] - prices[last]);
			last = i ;
			i++;
		}
		System.out.println(maxprofit);
	}

}