import java.util.Scanner;

/*As we all know RK loves his name very much especially the character 
'R' so this time task for you is based on his awesome name. RK gives 
you a string S consisting of characters 'R' and 'K' only. Now you 
are allowed to do exactly one move that is you have to choose two 
indices i and j (1<=i<=j<=|S| where |S| is string length ) and flip 
all the characters at position X where i<=X<=j. 
Now your goal is that after exactly one move you have to obtain the 
maximum number of R's as RK loves this character very much. So help 
RK with maximum R's.
*/	
public class NumberOfR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String s = sc.next();
		int max = countR(s);
		System.out.println("The maximum posiible no of R's are: "+ max);

	}

	private static int countR(String s) {
		int length = s.length();
		if(length < 1)
			return 0;
		int dp[] = new int[length];
		dp[0] = checkNeg(checkChar(s.charAt(0)));
		int j = checkR(s, dp, dp[0]-1);		//If dp[0]=1, bestPos=0 & if dp[0]=0, bestPos=-1
		int totalR = totalR(s);
		if(dp[j] > -1)
			totalR += dp[j];
		return totalR;
	}

	private static int totalR(String s) {
		int count = 0;
		for(int i=0; i<s.length(); ++i) {
			if(s.charAt(i) == 'r' || s.charAt(i) == 'R')
				++count;
		}
		return count;
	}

	private static int checkR(String s, int[] dp, int bestPos) {
		for(int i=1; i<s.length(); ++i) {
			int curr = checkChar(s.charAt(i)) + dp[i-1];
			dp[i] = checkNeg(curr);
			if(dp[i] > dp[bestPos])
				bestPos = i;
		}
		return bestPos;
	}

	private static int checkChar(char c) {
		if(c == 'k' || c == 'K') {
			return 1;
		}
		return -1;
	}

	private static int checkNeg(int i) {
		if(i < 0)
			return 0;
		return i;
	}

}
