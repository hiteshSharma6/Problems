import java.util.Scanner;

public class RatInMaze {
	
	public static void ratInAMaze(int maze[][]){
		int[][] mazePath = new int[maze.length][maze[0].length];
		mazePath[0][0] = 1;
		maze(maze, mazePath, 0, 0, maze.length, maze[0].length);
		
	}

	private static void maze(int[][] maze, int[][] mazePath, int row, int col, int height, int width) {
		int up = row-1, down = row+1, left = col-1, right = col+1;
		if(row == height-1 && col == width-1) {
			for(int i=0; i<height; ++i) {
				for(int j=0; j<width; ++j) {
					System.out.print(mazePath[i][j]+ " ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		} else {
			if(up>=0 && mazePath[up][col] != 1 && maze[up][col] == 1) {
				mazePath[up][col] = 1;
				maze(maze, mazePath, up, col, height, width);
				mazePath[up][col] = 0;
			}
			if(down<height && mazePath[down][col] != 1 && maze[down][col] == 1) {
				mazePath[down][col] = 1;
				maze(maze, mazePath, down, col, height, width);
				mazePath[down][col] = 0;
			}
			if(left>=0 && mazePath[row][left] != 1 && maze[row][left] == 1) {
				mazePath[row][left] = 1;
				maze(maze, mazePath, row, left, height, width);
				mazePath[row][left] = 0;
			}
			if(right<width && mazePath[row][right] != 1 && maze[row][right] == 1) {
				mazePath[row][right] = 1;
				maze(maze, mazePath, row, right, height, width);
				mazePath[row][right] = 0;
			}
		}
		
	}

	public static void main(String[] args) {
//		Sample maze
		int maze[][] = {{1, 0, 1},
						{1, 0, 1},
						{1, 1, 1}};
		ratInAMaze(maze);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the maze size(n*n): ");
		int n = sc.nextInt();
		maze = new int[n][n];
		System.out.println("Enter the maze elements: ");
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				maze[i][j] = sc.nextInt();
			}
		}
		ratInAMaze(maze);
		
	}

}
