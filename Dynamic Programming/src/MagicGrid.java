import java.util.Arrays;
import java.util.Scanner;

/*You are given a magrid S ( a magic grid ) having R rows and C columns. 
Each cell in this magrid has either a Hungarian horntail dragon that 
our intrepid hero has to defeat, or a flask of magic potion that his 
teacher Snape has left for him. A dragon at a cell (i,j) takes away 
|S[i][j]| strength points from him, and a potion at a cell (i,j) 
increases Harry's strength by S[i][j]. If his strength drops to 0 
or less at any point during his journey, Harry dies, and no magical 
stone can revive him.
Harry starts from the top-left corner cell (1,1) and the Sorcerer's 
Stone is in the bottom-right corner cell (R,C). From a cell (i,j), 
Harry can only move either one cell down or right i.e., to cell 
(i+1,j) or cell (i,j+1) and he can not move outside the magrid. 
Harry has used magic before starting his journey to determine which 
cell contains what, but lacks the basic simple mathematical skill 
to determine what minimum strength he needs to start with to collect 
the Sorcerer's Stone. Please help him once again.
*/
public class MagicGrid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimensions of grid(row x col): ");
		int row = sc.nextInt();
		int col = sc.nextInt();
		System.out.println("Enter the array elements: ");
		int arr[][] = new int[row][col];
		int dp[][] = new int[row][col];
		for(int i=0; i<row; ++i) {
			for(int j=0; j< col; ++j)
				arr[i][j] = sc.nextInt();
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		int minHealth = magicGrid(arr, 0, 0, row-1, col-1, dp);
		if(minHealth < 1) {
			minHealth = 1;
		}
		for(int i=0; i<row; ++i) {
			for(int j=0; j< col; ++j)
				System.out.println(dp[i][j]);
		}
		System.out.println("Minimum Health required is: "+ minHealth);

	}

	private static int magicGrid(int[][] arr, int i, int j, int row, int col, int[][] dp) {
		if(i == row && j == col)
			return 1;
		if(dp[i][j] < Integer.MAX_VALUE)
			return dp[i][j];
		int right;
		if(j != col)
			right = magicGrid(arr, i, j+1, row, col, dp) - arr[i][j+1];
		else
			right = Integer.MAX_VALUE;
		int down;
		if(i != row)
			down = magicGrid(arr, i+1, j, row, col, dp) - arr[i+1][j];
		else
			down =Integer.MAX_VALUE;
		dp[i][j] = min(right, down);
		if(dp[i][j] < 1)
			dp[i][j] = 1;
		return dp[i][j];
	}

	private static int min(int a, int b) {
		if(a > b)
			return b;
		return a;
	}

}
