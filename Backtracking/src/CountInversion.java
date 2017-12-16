import java.util.Scanner;

public class CountInversion {
	
	private static int divide(int arr[], int start, int end) {
		if(start >= end) {
			return 0;
		}
		int mid = (start + end)/2;
		int a = divide(arr, start, mid);
		int b = divide(arr, mid + 1, end);
		int c = merge(arr, start, mid, end);
		return a+b+c;
	}

	private static int merge(int[] arr, int start, int mid, int end) {
		int count = 0, i = start, j = mid+1, k = 0;
		int sorted[] = new int[end - start + 1];
		while(i<=mid && j<=end) {
			if(arr[j] < arr[i]) {	//inversion - second array has element of less value
				sorted[k++] = arr[j++];
				count += mid - i + 1;
			}
			else {
				sorted[k++] = arr[i++];
			}
		}
		while(i <= mid) {
			sorted[k++] = arr[i++];
		}
		while(j <= end) {
			sorted[k++] = arr[j++];
		}
		System.arraycopy(sorted, 0, arr, start, end-start+1);
		return count;
	}
	
	static void printArray(int A[], int size)
	{
	    int i;
	    for (i=0; i < size; i++)
	        System.out.print(A[i]);
	    System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = sc.nextInt();
		System.out.println("Enter the array: ");
		int arr[] = new int[n];
		for(int i=0; i < n; ++i)
			arr[i] = sc.nextInt();
		int count = divide(arr, 0, n-1);
		System.out.println("Sorted array");
		printArray(arr, n);
		System.out.println("Number of inversions(A[i]>A[j], i<j): "+ count);
	}

}
