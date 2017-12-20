import java.util.Scanner;

/*Your task is very simple. Given two non-negative integers N and M 
(N <= M), you have to calculate and return the 
sum (F(N) + F(N + 1) + ... + F(M)) mod 1000000007.
Input Format : Two non-negative integers N and M. (N <= M)
*/
public class FibonacciSum {
	final static int modulo = (int) Math.pow(10, 9) + 7;
	final static int M[][] = {{1, 1},{1, 0}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the smaller number: ");
		int n = sc.nextInt();
		System.out.println("Enter the larger number: ");
		int m = sc.nextInt();
		int ans = (fibonacci(m+2) - fibonacci(n+1))%modulo;
		System.out.println("Sum from Nth to Mth fibonacci numbers is: "+ ans);

	}

	private static int fibonacci(int n) {
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
		
		a1[0][0] = fValue%modulo;
		a1[0][1] = sValue%modulo;
		a1[1][0] = tValue%modulo;
		a1[1][1] = lValue%modulo;
	}

}
