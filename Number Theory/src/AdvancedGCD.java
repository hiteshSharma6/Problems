import java.util.Scanner;

/*Varun explained its friend Sanchit the algorithm of Euclides to 
calculate the GCD of two numbers. Then Sanchit implements it 
algorithm and it proposes to Varun that makes it but with a little 
integer and another integer that has up to 250 digits.
*/
public class AdvancedGCD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 2 numbers(2nd number can be upto 250 digits): ");
		int a = sc.nextInt();
		String s = sc.next();
		int b = advanced(s, a);
		int gcd = euclid(a, b);
		System.out.println("GCD is: "+ gcd);

	}

	private static int euclid(int a, int b) {
		if(b == 0) {
			return a;
		}
		int gcd;
		if(b > a) {
			gcd = euclid(b, a);
		}
		else {
			gcd = euclid(b, a%b);
		}
		return gcd;
	}

	private static int advanced(String s, int a) {
		int i = 0;
		int b = 0;
		while(i < s.length()) {
			int b1 = (b*10)%a;
			int c = Integer.valueOf(s.substring(i, i+1));
			b = (b1 + c%a)%a;
			++i;
		}
		return b;
	}

}
