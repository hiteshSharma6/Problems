import java.util.Scanner;

/*Finding the maximum sum of consecutive subarray's possible*/

public class KadaneAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size: ");
		int n = sc.nextInt();
		System.out.println("Enter the values of array: ");
		int arr[] = new int[n];
		for(int i=0; i<n ; ++i) {
			arr[i] = sc.nextInt();
		}
		long sum = kadane(arr, n);
		System.out.println("Maximum subarray's sum is: "+sum);

	}

	private static long kadane(int[] arr, int n) {
		long currentSum = 0;
		long bestSum = 0;
		for(int i=0; i<n; ++i) {
			currentSum += arr[i];
			if(bestSum < currentSum)
				bestSum = currentSum;
			if(currentSum < 0)
				currentSum = 0;
		}
		return bestSum;
	}

}
