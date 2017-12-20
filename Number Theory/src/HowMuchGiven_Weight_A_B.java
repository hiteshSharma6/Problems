import java.util.Scanner;

/*Given two weights of a and b units, in how many different ways 
you can achieve a weight of d units using only the given weights? 
Any of the given weights can be used any number of times (including 0 number of times).
*/
class EuclidValue {
	public long x;
	public long y;
}

public class HowMuchGiven_Weight_A_B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 numbers: ");
		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println("Enter the weight: ");
		long d = sc.nextLong();
		long combinations = 0;
//		Special Case
		if(d<a) {
			if(d%b == 0)
				combinations = 1;
		}
		else if(d<b) {
			if(d%a == 0)
				combinations = 1;
		}
		else if(d != 0)
			combinations = count(a, b, d);
		System.out.println("Total number of ways to achieve weight is: "+ combinations);

	}

	private static long count(long a, long b, long d) {
		long minY = findMinY(a, b, d);
		if(d < minY*b) {
			return 0;
		}
		long count = (d/b - minY)/a;
		return count + 1;
	}

	private static long findMinY(long a, long b, long d) {
		long modInverse = modInverse(a, b);
		long minY = ((d%a)*modInverse)%a;
		return minY;
	}

	private static long modInverse(long a, long b) {
		EuclidValue euclid = extendedEuclid(a, b);
		long inverse = (euclid.x%b + b)%b; 		/*for Negative Numbers also*/
		return inverse;
	}

	private static EuclidValue extendedEuclid(long a, long b) {
		EuclidValue euclid = new EuclidValue();
		if(a < b) {
			euclid = extendedEuclid(b, a);
			return euclid;
		}
		if(b == 0) {
			euclid.x = 1;
			euclid.y = 0;
			return euclid;
		}
		EuclidValue prev = extendedEuclid(b, a%b);
		euclid.x = prev.y;
		euclid.y = prev.x - a/b*prev.y;
		return euclid;
	}

}
