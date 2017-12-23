import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st String: ");
		String s1 = sc.next();
		System.out.println("Enter 2nd String: ");
		String s2 = sc.next();
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<s1.length()+1; ++i) {
			Arrays.fill(dp[i], -1);
		}
		int max = lcs(s1, s2, dp);
		System.out.println("Maximum length of Common Subsequence is: "+ max);

	}
	
	private static int lcs(String s1, String s2, int[][] dp) {
		if(s1.length() == 0 || s2.length() == 0)
			return 0;
		if(dp[s1.length()][s2.length()] > -1)
			return dp[s1.length()][s2.length()];
		int ans;
		if(s1.charAt(0) == s2.charAt(0)) {
			ans = 1 + lcs(s1.substring(1), s2.substring(1), dp);
		}
		else {
			int opt1 = lcs(s1, s2.substring(1), dp);
			int opt2 = lcs(s1.substring(1), s2, dp);
			ans = max(opt1, opt2);
		}
		dp[s1.length()][s2.length()] = ans;
		return ans;
	}

	private static int max(int opt1, int opt2) {
		if(opt1 > opt2)
			return opt1;
		return opt2;
	}

}
