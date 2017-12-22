import java.util.Scanner;

/*You are given an array of positive integers as input. Write a code 
to return the length of the largest such sub-array in which the 
values are arranged first in strictly ascending order and 
then in strictly descending order.
Such a sub-array is known as bitonic sub-array.  A purely increasing 
or purely decreasing subsequence will also be considered as a 
bitonic sequence with the other part empty.
Note that the elements in bitonic sub-array need not be consecutive 
in the given array but the order should remain same.
*/

//THIS IS WRONG
public class LargestBitonicSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		System.out.println("Enter the array elements: ");
		int arr[] = new int[n];
		for(int i=0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
		int size = maxSize(arr, 0, n);
		System.out.println("Largest Bitonic Subsequence has size: "+ size);

	}

	private static int maxSize(int[] arr, int start, int size) {
		if(size == 0 || start > size) {
			return 0;
		}
		if(start == size-1) {
			return 1;
		}
		int max;
		int j = start;
		while(j < size-1) {
			if(arr[j] > arr[j+1]) {
				++j;
				break;
			}
			++j;
		}
		while(j < size-1) {
			if(arr[j] < arr[j+1]) {
				++j;
				break;
			}
			++j;
		}
		max = j - start;
		System.out.println(max);
		int fCount = maxSize(arr, j, size);
		if(fCount > max)
			max = fCount;
		return max;
	}

}
