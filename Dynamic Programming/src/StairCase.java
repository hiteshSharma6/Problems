import java.util.Arrays;
import java.util.Scanner;

/*A child is running up a staircase with n steps and can hop either 
1 step, 2 steps or 3 steps at a time. Implement a method to count 
how many possible ways the child can run up to the stairs. 
You need to return all possible number of ways.
*/
public class StairCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the steps: ");
		int n = sc.nextInt();
		long count = stairCase(n);
		System.out.println("Total possible combinations: "+ count);

	}

	private static long stairCase(int n) {
		long combinations[] = new long[n+1];
		Arrays.fill(combinations, 0);
		return countCombinations(n, combinations);
//		for(int i=0; i<n; ++i) {
//			System.out.println(combinations[i]);
//		}
	}

	private static long countCombinations(int n, long[] combinations) {
		if(n == 0)
			return 1;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		if(combinations[n] > 0)
			return combinations[n];
		long c1 = countCombinations(n-1, combinations);
		long c2 = countCombinations(n-2, combinations);
		long c3 = countCombinations(n-3, combinations);
		long total = c1 + c2 + c3;
		combinations[n] = total;
		return total;
	}

}
