import java.util.Scanner;

/*Given n, calculate and print the sum :
LCM(1,n) + LCM(2,n) + .. + LCM(n,n)
where LCM(i,n) denotes the Least Common Multiple of the integers i and n.
*/
public class SumOfLCM {
	private static final int mod = (int) (Math.pow(10, 9) + 7);
	private static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		arr = new int[n+1];
		for(int i=0; i<=n ; ++i) {
			arr[i] = i;
		}
		divideByPrimeDivisors(n);
		int count = sum(n);
		System.out.println("Sum of alla LCM's before "+ n+ " is: "+ count);

	}

	private static void divideByPrimeDivisors(int n) {
		for(int i=2; i<=n/2; ++i) {
//			if i is a divisor of n then it itself and its multiple will also be
			if(n%i == 0) {
				for(int j=i; j<=n; j += i) {
//					here we divide that index multiples value with it's value
//					so this means that the value at jth index is being reduced 
//					by a common factor with n
					arr[j] /= arr[i];
				}
			}
		}
//		Because last number which is 'n' has LCM(n,n) = n;
		arr[n] = 1;
	}

	private static int sum(int n) {
		int sum = 0;
		for(int i=1; i<=n ;++i) {
			sum = (sum + (arr[i]*n)%mod)%mod;
		}
		return sum;
	}

}
