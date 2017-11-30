import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KeypadSubsequence {
	
/*	String[] combine(String a[], String[] b) {
		String []c = new String[a.length+b.length];
	      int count = 0;
	      
	      for(int i = 0; i<a.length; i++) { 
	         c[i] = a[i];
	         count++;
	      } 
	      for(int j = 0;j<b.length;j++) { 
	         c[count++] = b[j];
	      } 
	      return c;
	}
*/
	public static String[] keypad(int num, Map map){
		
		String[] output;
		if(num == 0 || num == 1) {
			output = new String[1];
			output[0] = "";
			return output;
		}
//		234/10 = 23 is passed
//		Last number 4 is taken
		int lastNumber = num%10;
//		"ghi" of key 4 is taken
		String letters = (String) map.get(lastNumber);
		int noOfLoops = letters.length();
		output = new String[letters.length()*noOfLoops];
		output = keypad(num/10, map);
		int outputLength = output.length;
//		For the length of the output add letters of "ghi" to output one by one
		for(int i=0; i<outputLength; ++i) {
			String initial = output[i];
//			Loop for noOfletters for key(4) i.e 3
			for(int j=0; j<noOfLoops; ++j) {
				output[i+ j*outputLength] = initial+ letters.substring(j, j+1);
				System.out.println(output[j]);
			}
		}
		return output;

	}
	
//	Let input be 234
	static int subsequence(int num, Map map, String output[]) {
		if(num == 0 || num == 1) {
			output[0] = "";
			return 1;
		}
//		234/10 = 23 is passed
		int length = subsequence(num/10, map, output);
//		Last number 4 is taken
		int lastNumber = num%10;
//		"ghi" of key 4 is taken
		String letters = (String) map.get(lastNumber);
		int noOfLoops = letters.length();
//		For the length of the output add letters of "ghi" to output one by one
		for(int i=0; i<length; ++i) {
			String initial = output[i];
//			Loop for noOfletters for key(4) i.e 3
			for(int j=0; j<noOfLoops; ++j) {
				output[i+ j*length] = initial+ letters.substring(j, j+1);
				System.out.println(output[j]);
			}
		}
		return length*noOfLoops;
	}

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the STRING for it's subsequence: ");
		int num = sc.nextInt();
		String output[] = new String[100];
		int length = subsequence(num, map, output);
//		output = keypad(num, map); // Not working
//		System.out.println("Subsequences for the above string are: ");
//		Arrays.sort(output);
		for(int i=0; i<length; ++i) {
			System.out.println(output[i]);
		}

	}

}
