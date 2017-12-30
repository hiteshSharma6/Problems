import java.util.Arrays;
import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int n = sc.nextInt();
		System.out.println("Enter the number of edges: ");
		int e = sc.nextInt();
		
		int edges[][] = new int[n][n];
		for(int i=0; i<n; ++i) {
			Arrays.fill(edges[i], 0);
		}
		
		System.out.println("Enter the connected edges: ");
		for(int i=0; i<e; ++i) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			edges[f][s] = 1;
			edges[s][f] = 1;
		}
		
		boolean visited[] = new boolean[n];
		Arrays.fill(visited, false);
		
		printBFS(edges, n, 0, visited);

	}

	private static void printBFS(int[][] edges, int n, int sv, boolean[] visited) {
		
	}

}
