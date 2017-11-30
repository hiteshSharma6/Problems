import java.util.Arrays;
import java.util.Scanner;

public class Subsequence {
	
	static int subsequence(String input, String output[]) {
		if(input.isEmpty()) {
			output[0] = "";
			return 1;
		}
		String smallString = input.substring(1);
		int length = subsequence(smallString, output);
		for(int i=0; i<length; ++i) {
			output[i+length] = input.charAt(0)+ output[i];
		}
		return 2*length;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the STRING for it's subsequence: ");
		String s = sc.next();
		String output[] = new String[100];
		int length = subsequence(s, output);
		System.out.println("Subsequences for the above string are: ");
		Arrays.sort(output);
		for(int i=0; i<length; ++i) {
			System.out.println(output[i]);
		}
		
	}

}
