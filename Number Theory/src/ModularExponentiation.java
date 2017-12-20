import java.util.Scanner;

public class ModularExponentiation {
	final static long modulo = (long) (Math.pow(10, 9) + 7);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int a = sc.nextInt();
		System.out.println("Enter it's power");
		int b = sc.nextInt();
		long ans = recursively(a, b);
		System.out.println("Modular Exponentiation is: "+ ans);
		System.out.println("Enter your modulo number:");
		int c = sc.nextInt();
		ans = modRecursive(a, b, c);

	}

	private static long modRecursive(int a, int b, int c) {
		if(b == 0) {
			return 1;
		}
		if(b%2 == 0) {
			return (modRecursive((a*a)%c, b/2, c))%c;
		}
		else {
			return ((a%c)*modRecursive((a*a)%c, b/2, c))%c;
		}
	}
//	Both the functions are equivalent

	private static long recursively(int a, int b) {
		if(b == 0) {
			return 1;
		}
		long smallAns = recursively(a, b/2);
		if(b%2 == 0) {
			return (long) Math.pow(smallAns%modulo, 2)%modulo;
		}
		else {
			return (a%modulo * (long) Math.pow(smallAns%modulo, 2))%modulo;
		}
	}

}
