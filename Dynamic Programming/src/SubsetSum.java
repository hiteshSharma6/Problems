import java.util.Arrays;
import java.util.Scanner;

/*Given a set of n integers, find if a subset of sum k can be formed 
from the given set. Print Yes or No.
*/
public class SubsetSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of integers: ");
		int n = sc.nextInt();
		System.out.println("Enter the integers: ");
		int arr[] = new int[n];
		for(int i=0; i<n; ++i)
			arr[i] = sc.nextInt();
		System.out.println("Enter the number you want to form: ");
		int sum = sc.nextInt();
		boolean dp[][] = new boolean[n+1][sum+1];
		for(int i=0; i<=n; ++i) {
			Arrays.fill(dp[i], false);
			dp[i][0] = true;
		}
		boolean value = sumExist(arr, 0, n, sum);
		String ans = "NO";
		if(value)
			ans="YES";
		System.out.println("The sum exist?: "+ ans);

	}

	private static boolean sumExist(int[] arr, int i, int n, int sum) {
		if(sum == 0)
			return true;
		if(i == n)
			return false;
		boolean opt1 = sumExist(arr, i+1, n, sum);
		boolean opt2 = sumExist(arr, i+1, n, sum-arr[i]);
		return (opt1 || opt2);
	}

}
