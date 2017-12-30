
public class SegmentTree {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int tree[] = new int[18];
		int start = 0;
		int arrSize = 8;
		
		buildTree(arr, tree, start, arrSize, 1);
		
		for(int i=1; i<18; ++i)
			System.out.println(tree[i]);
		
		int changeIndex = 2;
		int changeValue = 10;
		updateTree(arr, tree, start, arrSize, 1, changeIndex, changeValue);
		System.out.println("Updated segment tree: ");
		for(int i=1; i<18; ++i)
			System.out.println(tree[i]);
		
		int startFrom = 2;
		int endAt = 4;
		int sum = query(tree, start, arrSize, 1, startFrom, endAt);
		System.out.println("Sum(2, 4) is: "+ sum);

	}

	private static int query(int[] tree, int start, int end, int treeNode, int left, int right) {
		
//		Completely outside
		if(start > right || end < left) {
			return 0;
		}
		
//		Completely inside
		if(start >= left && end <= right) {
			return tree[treeNode];
		}
		
//		Partially inside and outside
		int mid = (start + end)/2;
		int sum = 0;
		sum += query(tree, start, mid, 2*treeNode, left, right);
		sum += query(tree, mid+1, end, 2*treeNode+1, left, right);
		return sum;			
	}

	private static void updateTree(int[] arr, int[] tree, int start, int end, int treeNode, int index, int value) {
		if(start == end) {
			arr[index] = value;
			tree[treeNode] = value;
			return;
		}
		
		int mid = (start + end)/2;
		if(index > mid)
			updateTree(arr, tree, mid+1, end, 2*treeNode+1, index, value);
		else
			updateTree(arr, tree, start, mid, 2*treeNode, index, value);
		tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
	}

//	Eg- at starting of the building of tree - node 1 is containing element from range 0-8
	private static int buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {
		if(start == end)
			return tree[treeNode] = arr[start];
		int mid = (start + end)/2;
		tree[treeNode] = buildTree(arr, tree, start, mid, 2*treeNode) + buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		return tree[treeNode];
	}

//	Second way
	private static void buildTree2(int[] arr, int[] tree, int start, int end, int treeNode) {
		if(start == end) {
			tree[treeNode] = arr[start];
			return;
		}
		int mid = (start + end)/2;
		
		buildTree2(arr, tree, start, mid, 2*treeNode);
		buildTree2(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
	}

}
