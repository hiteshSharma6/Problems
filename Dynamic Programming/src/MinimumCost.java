import java.util.Scanner;

public class MinimumCost {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimension: ");
		int n = sc.nextInt();
		System.out.println("Enter cost, row wise: ");
		int arr[][] = new int[n][n];
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
				arr[i][j] = sc.nextInt();
		int output[][] = new int[n][n];
		int minCost = minCost(arr, 0, 0, n-1, n-1, output);
		System.out.println("Minimum Cost by recursive solution: "+ minCost);
		minCost = minCostIterative(arr, n, n);
		System.out.println("Minimum Cost by iterative solution: "+minCost);

	}

	private static int minCostIterative(int[][] arr, int er, int ec) {
		int output[][] = new int[er][ec];
		output[er-1][ec-1] = arr[er-1][ec-1];
		for(int i=er-2; i>=0; --i) {
			output[i][ec-1] = output[i+1][ec-1] + arr[i][ec-1];
		}
		for(int j=ec-2; j>=0; --j) {
			output[er-1][j] = output[er-1][j+1] + arr[er-1][j];
		}
		for(int i=er-2; i>=0; --i) {
			for(int j=ec-2; j>=0; --j) {
				output[i][j] = min(output[i+1][j+1], min(output[i+1][j], output[i][j+1])) + arr[i][j];
			}
		}
		return output[0][0];
	}

	private static int minCost(int[][] arr, int si, int sj, int ei, int ej, int[][] output) {
		if(si > ei || sj > ej)
			return Integer.MAX_VALUE;			//Choose MIN_VALUE if you want max. of values
		if(si == ei && sj == ej)
			return arr[si][sj];
		if(output[si][sj] > 0)
			return output[si][sj];
		int bottom = minCost(arr, si+1, sj, ei, ej, output);
		int diagonal = minCost(arr, si+1, sj+1, ei, ej, output);
		int right = minCost(arr, si, sj+1, ei, ej, output);
		output[si][sj] = min(right, min(diagonal, bottom)) + arr[si][sj];
		return output[si][sj];
	}

	private static int min(int a, int b) {
		if(a > b)
			return b;
		return a;
	}

}
