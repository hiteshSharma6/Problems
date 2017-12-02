
public class CheckAB {
	
	public static boolean checkAB(String input) {
		if(input.isEmpty()) {
			return true;
		} else if(input.charAt(0) == 'a') {
			return checkAB(input.substring(1));
		} else if(input.length() >= 2 && input.charAt(0) == 'b' && input.charAt(1) == 'b') {
			if(input.substring(2).isEmpty() || input.charAt(2) == 'a') {
				return checkAB(input.substring(2));
			}
			return false;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(checkAB("abb"));
		System.out.println(checkAB("aabba"));
		System.out.println(checkAB("aaabbaa"));
		System.out.println(checkAB("abbbbaa"));
		System.out.println(checkAB("abbbaaa"));
	}

}
