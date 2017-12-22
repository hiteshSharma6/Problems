import java.util.Scanner;

public class AlphabetCode {
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the code number: ");
		String s = sc.next();
		arr = new int[s.length()];
		int count = alphaCode(s);
		System.out.println("Total combinations: "+ count);

	}

	private static int alphaCode(String s) {
		int length = s.length();
		if(length == 1 || length == 0) {
			return 1;
		}
		if(arr[length-1] > 0) {
			return arr[length];
		}
		int output = alphaCode(s.substring(1));
		if(Integer.parseInt(s.substring(0, 1)) < 26) {
			output += alphaCode(s.substring(2));
		}
		arr[length-1] = output;
		return output;
	}

}
