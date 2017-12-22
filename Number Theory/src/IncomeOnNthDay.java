import java.util.Scanner;

/*Daulat Ram is an affluent business man. After demonetization, 
IT raid was held at his accommodation in which all his money was 
seized. He is very eager to gain his money back, he started 
investing in certain ventures and earned out of them. On the 
first day, his income was Rs. X, followed by Rs. Y on the second day. 
Daulat Ram observed his growth as a function and wanted to calculate 
his income on the Nth day.
The function he found out was FN = FN-1 + FN-2 + FN-1×FN-2
Given his income on day 0 and day 1, calculate his income on the Nth day.
*/
public class IncomeOnNthDay {
	final static int M[][] = {{1, 1},{1, 0}};
	final static int MODULO = (int) Math.pow(10, 9)+7;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first day income: ");
		int f0 = sc.nextInt();
		System.out.println("Enter the second day income: ");
		int f1 = sc.nextInt();
		System.out.println("Enter the Nth day to find it's income: ");
		int n = sc.nextInt();
		int a = f0 + 1;
		int b = f1 + 1;
		int income = nthDay(a, b, n) - 1;
		System.out.println("The "+ n+ "th day income is: "+ income);

	}

	private static int nthDay(int a, int b, int n) {
		if(n == 0)
			return a;
		else if(n == 1)
			return b;
		int fTerm = modExp(a, fib(n-1))%MODULO;
		int sTerm = modExp(b, fib(n))%MODULO;
		return (fTerm * sTerm)%MODULO;
	}

	private static int modExp(int a, int b) {
		if(a == 0) {
			return 0;
		}
		else if(a == 1) {
			return 1;
		}
		int ans = 1;
		while(b > 0) {
			if((b&1) == 1) {
				ans = (ans*a)%MODULO;
			}
			a = (a*a)%MODULO;
			b /= 2;
		}
		return ans;
	}

	private static int fib(int n) {
		int A[][] = {{1, 1},{1, 0}};
		if(n == 0) {
			return 0;
		}
		power(A, n-1);
		return A[0][0];
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
