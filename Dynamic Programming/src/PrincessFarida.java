import java.util.Scanner;

/*Once upon time there was a cute princess called Farida living 
in a castle with her father, mother and uncle. On the way to the 
castle there lived many monsters. Each one of them had some gold 
coins. Although they are monsters they will not hurt. Instead they 
will give you the gold coins, but if and only if you didn't take 
any coins from the monster directly before the current one. 
To marry princess Farida you have to pass all the monsters and 
collect as many coins as possible. Given the number of gold coins 
each monster has, calculate the maximum number of coins you can 
collect on your way to the castle.
*/
public class PrincessFarida {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of monsters: ");
		int n = sc.nextInt();
		System.out.println("Enter the coins for each monster: ");
		int arr[] = new int[n];
		for(int i=0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
		long max = maxCoins(arr, n);
		System.out.println("Max possible coins are: "+ max);

	}

	private static long maxCoins(int[] arr, int n) {
		if(n == 1) {
			return arr[0];
		}
		if(n == 2) {
			return max(arr[0], arr[1]);
		}
		long maxOutput[] = new long[n];
		maxOutput[0] = arr[0];
		maxOutput[1] = max(arr[0], arr[1]);
		for(int i=2; i<n; ++i) {
			maxOutput[i] = max(maxOutput[i-1], maxOutput[i-2]+arr[i]);
		}
		return maxOutput[n-1];
	}

	private static long max(long a, long b) {
		if(a > b)
			return a;
		return b;
	}

}
