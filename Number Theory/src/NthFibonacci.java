import java.util.Scanner;

public class NthFibonacci {
	final static int M[][] = {{1, 1},{1, 0}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the index of fibonacci series: ");
		int n = sc.nextInt();
		long ans = fibonacci(n);
		System.out.println("Nth fibonacci number is: "+ ans);

	}

	private static long fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		int a[][] = {{1, 1},{1, 0}};
		power(a, n-1);
		return a[0][0];
	}

	private static void power(int[][] a, int n) {
		if(n == 0 || n == 1) {
			return;
		}
		power(a, n/2);
		multiply(a, a);
		if(n%2 != 0) {
			multiply(a, M);
		}
	}

	private static void multiply(int[][] a1, int[][] a2) {
		int fValue = a1[0][0]*a2[0][0] + a1[0][1]*a2[1][0];
		int sValue = a1[0][0]*a2[0][1] + a1[0][1]*a2[1][1];
		int tValue = a1[1][0]*a2[0][0] + a1[1][1]*a2[1][0];
		int lValue = a1[1][0]*a2[0][1] + a1[1][1]*a2[1][1];		//This is not needed
		
		a1[0][0] = fValue;
		a1[0][1] = sValue;
		a1[1][0] = tValue;
		a1[1][1] = lValue;
	}

}
