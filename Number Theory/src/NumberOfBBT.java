import java.util.Scanner;

public class NumberOfBBT {
	final static long modulo = (long) (Math.pow(10, 9) + 7);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the height of Balanced Binary Tree: ");
		int h = sc.nextInt();
		long combos = count(h);
		System.out.println("Total combinastions possible: "+ combos);

	}

	private static long count(int h) {
		if(h==0 || h==1) {
			return 1;
		}
		long x = count(h-1);
		long y = count(h-2);
//		Possible combinations are -
//			x*x, x*y, y*x
		long count = ((x*x)%modulo + (2*x*y)%modulo)%modulo;
		return count;
	}

}
