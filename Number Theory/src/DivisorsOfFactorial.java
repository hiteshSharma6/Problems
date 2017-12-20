import java.util.Arrays;
import java.util.Scanner;

public class DivisorsOfFactorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		long count = numberOfDivisors(n);
		System.out.println("Number of divisors of it's factorial: "+ count);

	}

	private static long numberOfDivisors(int n) {
		boolean arr[] = new boolean[n+1]; 		//from 0 to n
		Arrays.fill(arr, true);
		sieve(arr, n);
		long count = 1;
		for(int i=2; i<=n; ++i) {
			if(arr[i]) {
				int currentCount = 0;
				int j = i;
				while(j <= n) {
					currentCount += n/j;
					j *= i;
				}
				count *= currentCount+1;
			}
		}
		return count;
	}

	private static void sieve(boolean[] arr, int n) {
		for(int i=2; i*i<=n; ++i) {
			if(arr[i]) {
				int j = i;
				while(j*i <= n) {
					arr[i*j] = false;
					++j;
				}
			}
		}
		
	}

}
