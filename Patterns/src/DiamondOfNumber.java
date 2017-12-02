import java.util.Scanner;

public class DiamondOfNumber {

	public static void print(int n) {
      for(int i=1; i<n/2+1; ++i) {
        for(int k=0; k<=n/2-i; ++k) {
          System.out.print(" ");
        }
        for(int j=1; j<=2*i-1; ++j) {
			System.out.print(j);      
        }
          System.out.println("");
      }
      for(int i=n/2+1; i>0; --i) {
        for(int k=i; k<=n/2; ++k) {
          System.out.print(" ");
        }
        for(int j=1; j<=2*i-1; ++j) {
			System.out.print(j);      
        }
          System.out.println("");
      }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number for diamond number pattern: ");
		int num = sc.nextInt();
		print(num);

	}

}
