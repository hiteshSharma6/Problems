import java.util.Scanner;

public class Euclid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 2 numbers: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = gcdEuclid(a, b);
		System.out.println("The GCD is: "+ gcd);

	}

	private static int gcdEuclid(int a, int b) {
		if(b == 0) {
			return a;
		}
		int gcd;
		if(b > a) {
			gcd = gcdEuclid(b, a);
		}
		else {
			gcd = gcdEuclid(b, a%b);
		}
		return gcd;
	}

}
