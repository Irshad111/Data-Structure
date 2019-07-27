package Recursion;

import java.util.ArrayList;

public class RecursionDemo {
	public static int glo_v = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2 ,3};
//		int[] arr1 = allIndexGlobal(arr, 2, 0);
//		for (int i : arr1) {
//			System.out.println(i);
//		}
		ArrayList<Integer> arr1 = AllIndexList(arr, 2, 0);
		for (int i : arr1) {
			System.out.println(i);
		}

	}

	public static int atLastIndex(int[] arr, int item, int vidx) {
		if (vidx == arr.length) {
			return -1;
		}

		int recans = atLastIndex(arr, item, vidx + 1);
		if (arr[vidx] == item && recans == -1)
			return vidx;
		return recans;
	}

	public static int[] allIndex(int[] arr, int item, int vidx, int count) {
		if (vidx == arr.length) {
			int[] bs = new int[count];
			return bs;
		}
		if (arr[vidx] == item) {
			int[] recans = allIndex(arr, item, vidx + 1, count + 1);
			recans[count] = vidx;
			return recans;
		} else {
			int[] recans = allIndex(arr, item, vidx + 1, count);
		return recans;
		}
	}
	public static int[] allIndexGlobal(int[] arr,int item,int vidx) {
		if (vidx == arr.length) {
			int[] bs = new int[glo_v];
			return bs;
		}
		if(arr[vidx]==item) {
			glo_v++;
		}
		int[] recres=allIndexGlobal(arr,item,vidx+1);
		if(arr[vidx]==item) {
			glo_v--;
			recres[glo_v]=vidx;
		}
		return recres;
		
	}
	public static ArrayList<Integer> AllIndexList(int[] arr,int item,int vidx){
		if(vidx==arr.length) {
			ArrayList<Integer> brs=new ArrayList<>();
			return brs;
		}
		ArrayList<Integer> recres=AllIndexList(arr,item,vidx+1);
		if(arr[vidx]==item) {
			recres.add(0,vidx);
		}
		return recres;
	}

}
