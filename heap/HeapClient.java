package heap;

import java.util.ArrayList;

public class HeapClient {
	public static void main(String arg[]) {
		Heap heap=new Heap();
		for(int i=5;i>0;i--) {
			heap.add(10*i);
			heap.display();
		}
		while(!heap.isEmpty()) {
			System.out.println(heap.remove());
		}
//		HeapGeneric<Car> heapg=new HeapGeneric<>();
//		Car[] carr = new Car[5];
//		carr[0] = new Car(1000, 100, "black");
//		carr[1] = new Car(500, 10, "white");
//		carr[2] = new Car(400, 50, "green");
//		carr[3] = new Car(100, 30, "gray");
//		carr[4] = new Car(200, 70, "yellow");
//		for(int i=0;i<carr.length;i++) {
//			heapg.add(carr[i]);
//		}
//		while(!heapg.isEmpty()) {
//			System.out.println(heapg.remove());
//		}
	}
	public static class Pair implements Comparable<Pair>{
		int data;
		int listNo;
		int indexNo;
		@Override
		public int compareTo(Pair o) {
			return o.data-this.data;
		}
	}
	public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> lists){
		ArrayList<Integer> ans=new ArrayList<>();
		HeapGeneric<Pair> heap=new HeapGeneric<>();
		for(int i=0;i<lists.size();i++) {
			Pair pr=new Pair();
			pr.data=lists.get(0).get(0);
			pr.listNo=i;
			pr.indexNo=0;
		}
		while(!heap.isEmpty()) {
			
		}
		return ans;
	}
//	public static ArrayList<Integer> kLargestElement(ArrayList<Integer> list,int k){
//		ArrayList<Integer> ans=new ArrayList<>();
//		Heap hp=new Heap();
//		for(int i=0;i<k;i++) {
//			hp.add(list.get(i));
//		}
//		for(int i=k;i<list.size();i++) {
//			int min=hp.getHighPriorityElement();
//			if(min<list.get(i)) {
//				hp.remove();
//				hp.add(list.get(i));
//			}
//		}
//			while(!hp.isEmpty()) {
//				ans.add(hp.remove());
//			}
//		return ans;
//	}
//	
//
}
