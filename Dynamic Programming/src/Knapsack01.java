import java.util.Arrays;
import java.util.Scanner;

public class Knapsack01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of weights: ");
		int n = sc.nextInt();
		System.out.println("Enter the weights: ");
		int wt[] = new int[n];
		for(int i=0; i<n; ++i)
			wt[i] = sc.nextInt();
		System.out.println("Enter the values: ");
		int v[] = new int[n];
		for(int i=0; i<n; ++i)
			v[i] = sc.nextInt();
		System.out.println("Enter the knapsack: ");
		int w = sc.nextInt();
		int dp[][] = new int[n+1][w+1];
		for(int i=0; i<=n; ++i)
			Arrays.fill(dp[i], -1);
		int max = knapsack(n, w, wt, v, dp);
		System.out.println("The maximum knapsack value is: "+ max);
		max = knapsackIterative(n, w, wt, v, dp);
		System.out.println("The maximum knapsack value is: "+ max);

	}

	private static int knapsackIterative(int n, int w, int[] wt, int[] v, int[][] dp) {
		for(int i=0; i<=w; ++i)
			dp[0][i] = 0;
		for(int i=0; i<=n; ++i)
			dp[i][0] = 0;
		for(int i=1; i<=n; ++i)
			for(int j=1; j<=w; ++j) {
				int ans = dp[i-1][j];
				if(wt[i-1] <= j)
					ans = Integer.max(dp[i-1][j-wt[i-1]] + v[i-1], ans);
				dp[i][j] = ans;
			}
		return dp[n][w];
	}

	private static int knapsack(int n, int w, int[] wt, int[] v, int[][] dp) {
		if(n == 0)
			return 0;
		if(w < 0)
			return Integer.MIN_VALUE;
		if(dp[n][w] > -1)
			return dp[n][w];
		int ans = Integer.max(knapsack(n-1, w, wt, v, dp), (knapsack(n-1, w-wt[n-1], wt, v, dp) + v[n-1]));
		dp[n][w] = ans;
		return ans;
	}

}
