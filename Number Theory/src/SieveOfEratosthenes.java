import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to find prime numbers among it: ");
		int n = sc.nextInt();
		boolean arr[] = new boolean[n];
		findPrimes(arr, n);
		System.out.println("\nThe prime numbers upto "+ n+ " are: ");
		for(int i = 0; i < n; ++i) {
			if(arr[i] == true)
				System.out.println(i + 1);
		}

	}

	private static void findPrimes(boolean[] arr, int n) {
		Arrays.fill(arr, true);
		arr[0] = false;
		for(int i = 2; i*i <= n ; ++i) {
			if(arr[i-1]) {
				for(int j = i; j*i <= n; ++j) {
					arr[i*j - 1] = false;
				}
			}
		}
		
	}

}
