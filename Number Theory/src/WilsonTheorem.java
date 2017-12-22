import java.util.Scanner;

public class WilsonTheorem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number n: ");
		int n = sc.nextInt();
		System.out.println("Enter the modulo number p: ");
		int p = sc.nextInt();
		int factMod = wilson(n, p);		
		System.out.println("N! mod P is: "+ (p-factMod));

	}

	private static int wilson(int n, int p) {
		int fact = 1;
		for(int i=n+1; i<p; ++i) {
			fact = (fact*i)%p;
			if(fact == 0)
				break;
		}
		return modExp(fact, p-2, p);
	}

	private static int modExp(int a, int b, int m) {
		if(a == 0){
			return 1;
		}
		int ans = 1;
		while(b > 0) {
			if((b&1) == 1) {
				ans = (ans*a)%m;
			}
			a = (a*a)%m;
			b = b>>1;
		}
		return ans;
	}

}
