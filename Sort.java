package Sorting;

public class Sort {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 7, 2, 11, 3, 2, 7 };
		// BubbleSort(arr);
		// SelectionSort(arr);
		// int[] one = { 10, 20,30,40,50};
		// int[] two = { 5, 12, 17, 20 ,25,60,70,80};

		// int[] ans = mergeTwoSortedArrays(one, two);
		int[] ans = mergeSort(arr, 0, arr.length-1);
		// InsertionSort(arr);
		for (int i : ans) {
			System.out.println(i);
		}
		// System.out.println(BinarySearch(arr, 7));

	}

	// bubble sort
	public static void BubbleSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int i = 0; i < arr.length - 1 - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	// selection sort
	public static void SelectionSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			int min = counter;
			for (int i = counter + 1; i < arr.length; i++) {
				if (arr[i] < arr[min]) {
					min = i;
				}
			}
			int temp = arr[min];
			arr[min] = arr[counter];
			arr[counter] = temp;
		}
	}

	public static void InsertionSort(int[] arr) {
		for (int counter = 1; counter < arr.length; counter++) {
			int val = arr[counter];
			int i = counter - 1;
			while (i >= 0 && arr[i] > val) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = val;
		}
	}

	// binary search
	public static int BinarySearch(int[] arr, int item) {
		int hi = arr.length - 1;
		int lo = 0;
		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			if (arr[mid] > item) {
				hi = mid - 1;
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else
				return mid;
		}
		return -1;

	}

	// merge sort
	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] merge = new int[one.length + two.length];
		int im = 0;
		int io = 0;
		int it = 0;
		// till same length
		while (io < one.length && it < two.length) {
			if (one[io] < two[it]) {
				merge[im] = one[io];
				io++;
			} else if (one[io] >= two[it]) {
				merge[im] = two[it];
				it++;
			}
			im++;
		}

		// if arry two is finished then for array one
		while (io < one.length) {
			merge[im] = one[io];
			io++;
			im++;
		}
		// if array one is finished then for array two
		while (it < two.length) {
			merge[im] = two[it];
			it++;
			im++;
		}

		return merge;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}
		int mid = (lo + hi) / 2;
		int[] firsthalf = mergeSort(arr, lo, mid);
		int[] secondhalf = mergeSort(arr, mid + 1, hi);
		int[] sorted = mergeTwoSortedArrays(firsthalf, secondhalf);
		return sorted;
	}
	// quick sort
}
