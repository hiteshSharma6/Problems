import java.util.Scanner;

/*Once detective Saikat was solving a murder case. 
While going to the crime scene he took the stairs and 
saw that a number is written on every stair. 
He found it suspicious and decides to remember all the numbers 
that he has seen till now. While remembering the numbers he found 
that he can find some pattern in those numbers. So he decides that 
for each number on the stairs he will note down the sum of all the 
numbers previously seen on the stairs which are smaller than the 
present number. Calculate the sum of all the numbers 
written on his notes diary.*/

public class Murder {
	
	public static long mergeSort(int a[],int beg, int end){
        if(beg>=end){
            return 0;
        }
        int mid = (beg + end)/2;
        long sum1 = mergeSort(a, beg, mid);
        long sum2 = mergeSort(a,mid+1, end);
        long sum3 = merge(a, beg, mid, end);
        return sum1 + sum2 + sum3;
    }

    public static long merge(int a[], int beg, int mid, int end){
        int i = beg, j = mid+1,k=0;
        long sum = 0;
        int[] b = new int[end-beg+1];
        while(i<=mid && j<=end){
            if(a[i] < a[j]){
                sum = sum + ( a[i] * ( end - j + 1) ) ;
                b[k++] = a[i++];
            }
            else{
                b[k++] = a[j++];
            }
        }
        while( i<=mid ){
            b[k++] = a[i++];
        }
        while ( j<=end ){
            b[k++] = a[j++];
        }
        for (k=beg ; k<=end;k++){
            a[k] = b[k-beg];
        }
        return sum;
    }
	
	private static int countPrevious(int[] arr, int size) {
		int sum = 0;
//		When 1 element remains return 0
		if(size == 1) {
			return 0;
		}
//		make array smaller by 1
		sum = countPrevious(arr, size-1);
//		get position where the last element fits
		int index = sortedPosition(arr, size-1);
//		sum all the elements that are smaller the last element
//		(last element is sorted at this point of time)
		for(int i = 0; i < index; ++i) {
			sum += arr[i];
		}
		return sum;
	}

	private static int sortedPosition(int[] arr, int size) {
		int compareWith = arr[size];
		int beg = 0; int end = size, mid;
//		find correct position(if find in between) or return the size(since element is 
//		at last position initially so it has to be the correct position) of array
		while(beg <= end) {
			mid = (beg+end)/2;
			if(compareWith < arr[mid]  && compareWith > arr[mid-1]) {
//				Sort array from its correct position to array size
				sort(arr, size, mid);
				return mid;
			} else if(compareWith > arr[mid]) {
				beg = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return size;
	}

//	This code sorts the array
	private static void sort(int[] arr, int size, int mid) {
		int element = arr[size];
		for(int i = size; i > mid; --i) {
			arr[i] = arr[i - 1];
		}
		arr[mid] = element;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of stairs: ");
		int n = sc.nextInt();
		System.out.println("Enter the numbers on the stairs: ");
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		int sum = countPrevious(arr, n);
		System.out.println("Sum is: "+ sum);
		
//		More correct way
        sum = (int) mergeSort(arr,0,n-1);
        System.out.println(sum);

	}

}
