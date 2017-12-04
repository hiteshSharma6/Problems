import java.util.Arrays;

public class NQueen {
	
	public static void placeNQueens1(int n){
	  	int[] a = new int[n*n];
		nqueen(a,n,0);
	}
	
	public static void nqueen(int a[], int n, int i){
        int k;
        if ( i == n){
            for (int j=0; j<n*n; j++){
                System.out.print(a[j]+" ");
            }
            System.out.println();
            return ;
        }
        for (int j=n*i;j<n*i+n;j++){
            boolean status = true;
            
/*            Below in every for loop we are checking if there are 
 * 				queens present on sides and digonals of current element
*/            for(k=1;k<=i;k++){
                if(a[j - n*k] == 1){
                    status = false;
                    break;
                }
            }
            if(status != false){
            	for(k=j-n+1;k%n!=0 && k>=0;k=k-n+1){
            		if(a[k]==1){
            			status = false;
            			break;
            		}
            	}
            }
            if(status != false) {
            	for(k = j-n-1;(k+1)%n!=0 && k>=0; k=k-n-1){
            		if(a[k]==1){
            			status = false;
            			break;
            		}
            	}
            }
            if(status == true){
                a[j]=1;
                nqueen(a,n,i+1);
                a[j]=0;
            }
        }
        return ;
    }
	
//	Second method

	public static void placeNQueens2(int n){
//		This one will be printed
		int[][] board = new int[n][n];
/*		This one is for reference and will have value 2 for position 
 * 		to refer that they are not available
*/		int[][] boardTrack = new int[n][n];
		for (int k = 0; k < n; k++) {
			Arrays.fill(board[k], 0);
			Arrays.fill(boardTrack[k], 0);			
		}
		traverse(board, boardTrack, n, 0);
//		traverse(board, n, 0);
	}

	private static void traverse(int[][] board, int[][] boardTrack, int n, int i) {
		if(i == n) {
			for(int j=0; j<n ; ++j)
				for(int k=0; k<n; ++k)
					System.out.print(board[j][k]+ " ");
			System.out.println("");
			return;
		}
		for(int j=0; j<n ;++j) {
/*			This array is to store initial state of boardTrack 
 * 			so that if n-queen fails the boardTrack can be initialised 
 * 			to it's original state at that point
*/			int[][] currentTrack = new int[n][n];
			for (int k = 0; k < n; k++) {
		        System.arraycopy(boardTrack[k], 0, currentTrack[k], 0, n);
		    }
			if(boardTrack[i][j] != 2) {
				board[i][j] = 1;				
				for(int k=0; k<n; ++k) {
					boardTrack[i][k] = 2;
					boardTrack[k][j] = 2;
					int diagonalLR = j-i+k;
					int diagonalRL = j+i-k;
					if(diagonalLR >= 0 && diagonalLR < n)
						boardTrack[k][diagonalLR] = 2;
					if(diagonalRL >=0 && diagonalRL < n)
						boardTrack[k][diagonalRL] = 2;
				}
				traverse(board, boardTrack, n, i+1);
			}
			for (int k = 0; k < n; k++) {
		        System.arraycopy(currentTrack[k], 0, boardTrack[k], 0, n);
		    }
			board[i][j] = 0;
		}
		return;
	}

	public static void main(String[] args) {
		
		placeNQueens2(4);
		placeNQueens1(4);

	}

}
