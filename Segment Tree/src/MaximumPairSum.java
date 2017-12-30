import java.util.Scanner;

class TreeNode {
	int fMax;
	int sMax;
}

public class MaximumPairSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = sc.nextInt();
		System.out.println("Enter the array elements: ");
		int[] arr = new int[n];
		for(int i = 0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
		
		int start = 0, end = 1;
		TreeNode[] tree = new TreeNode[2*n];
		buildTree(arr, tree, start, end, 1);
		
		System.out.println("Enter the number of operations: ");
		int q = sc.nextInt();
		while(--q > 0) {
			System.out.println("Enter the query");
			String oper = sc.next();
			char c = oper.charAt(0);
			int a = oper.charAt(2);
			int b = oper.charAt(4);
			if(c == 'u' || c == 'U') {
				updateTree(arr, tree, start, end, a, b, 1);
			}
			else if(c == 'q' || c == 'Q') {
				int query = query(tree, start, end, a, b, 1);
				System.out.println("Query: "+ query);
			}
		}

	}

	private static int query(TreeNode[] tree, int start, int end, int left, int right, int node) {
		if(end < left || start > right) {
			return 0;
		}
		
		if(start >= left && end <= right) {
			return tree[node];
		}
		
		
	}

	private static void updateTree(int[] arr, int[] tree, int start, int end, int index, int value, int node) {
		if(start == end) {
			arr[index] = value;
			tree[node] = value;
			return;
		}
		
		int mid = (start + end)/2;
		if(index <= mid) {
			updateTree(arr, tree, start, mid, index, value, 2*node);
		}
		else {
			updateTree(arr, tree, mid+1, end, index, value, 2*node+1);
		}
		tree[node] = Integer.max(tree[2*node], tree[2*node+1]);
	}

	private static TreeNode buildTree(int[] arr, TreeNode[] tree, int start, int end, int node) {
		if(start == end) {
			tree[node].fMax = arr[start];
			tree[node].sMax = Integer.MIN_VALUE;
			return null;
		}
		
		int mid = (start + end)/2;
		TreeNode left = buildTree(arr, tree, start, mid, 2*node);
		TreeNode right = buildTree(arr, tree, mid+1, end, 2*node+1);
		tree[node].fMax = Integer.max(left.fMax, right.fMax);
		tree[node].sMax = Integer.min(Integer.max(left.fMax, right.sMax), Integer.max(left.sMax, right.fMax));
		return tree[node];
	}

}
