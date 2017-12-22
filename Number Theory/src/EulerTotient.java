import java.util.Scanner;

public class EulerTotient {
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		arr = new int[n+1];
		for(int i=0; i<=n; ++i) {
			arr[i] = i;
		}
		int count = eulerTotient(n);
		System.out.println("Number of coprimes numbers of "+ n+ " are: "+ count);
		for(int i=0; i<=n; ++i) {
			System.out.println(arr[i]);
		}

	}

	private static int eulerTotient(int n) {
		for(int i=2; i<=n; ++i) {
			if(arr[i] == i) {
				int j = 2*i;
				while(j <= n) {
					arr[j] = (arr[j]*(i - 1))/i;
					j += i;
				}
				arr[i] = i-1;
			}
		}
		return arr[n];
	}

}
