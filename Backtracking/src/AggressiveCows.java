import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
	static long stallNo[];
	static long maxDistance = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of stalls used: ");
		int n = sc.nextInt();
		stallNo = new long[n];
		System.out.println("Enter the stall no's in array: ");
		for ( int i = 0; i < n ; i++ ){
            stallNo[i] = sc.nextInt();
		}
		System.out.println("Enter the number of cows: ");
		int c = sc.nextInt();
		Arrays.sort(stallNo);
		minCowSpace(0, stallNo[n-1]-stallNo[0], c);
		System.out.println("Maximum distance is: "+ maxDistance);

	}

	private static void minCowSpace(long start, long end, int cows) {
		if(start > end) {
			return;
		}
		long space = (end + start)/2;
		System.out.println(space+"" + start+"" + end);
		if(possible(0, stallNo.length, cows-1, space)) {
			maxDistance = space;
			minCowSpace(space+1, end, cows);
		}
		else {
			minCowSpace(start, space-1, cows);
		}
	}

	private static boolean possible(int start, int end, int cows, long space) {
		if(cows == 0) {
			return true;
		}
		if(start >= end) {
			return false;
		}
		for(int i=start+1; i<end; ++i) {
			if(stallNo[i] - stallNo[start] >= space) {
				return possible(i, end, cows-1, space);
			}
		}
		return false;
	}

}
