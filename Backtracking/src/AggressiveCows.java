import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		countInversions(arr);

	}

}