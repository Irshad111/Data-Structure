package heap;

import java.util.ArrayList;

public class HeapGeneric <T extends Comparable<T>>{
	ArrayList<T> data=new ArrayList<>();
	public int size() {
		return this.data.size();
	}
	public boolean isEmpty() {
		return this.data.size()==0;
	}
	public void add(T item) {
		this.data.add(item);
		upheapify(data.size()-1);
	}
	private void upheapify(int ci) {
		int pi=(ci-1)/2;
		if(larger(this.data.get(ci),this.data.get(pi))>0) {
			swap(ci,pi);
			upheapify(pi);
		}
		
		
	}
	private void swap(int i, int j) {
		T ith=this.data.get(i);
		T jth=this.data.get(j);
		this.data.set(i,jth);
		this.data.set(j, ith);
		
		
	}
	public T remove() {
		swap(0,this.data.size()-1);
		T rm=this.data.remove(this.data.size()-1);
		downheap(0);
		return rm;
	}
	private void downheap(int pi) {
		int lci=2*pi+1;
		int rci=2*pi+2;
		int min=pi;
		if(lci<this.data.size() && larger(this.data.get(lci),this.data.get(min))>0) {
			min=lci;
			
		}
		if(rci<this.data.size() && larger(this.data.get(rci),this.data.get(min))>0) {
			min=rci;
			
		}
		if(min!=pi) {
			swap(min,pi);
			downheap(min);
		}
		
		
		
	}
	public void display() {
		System.out.println(this.data);
	}
	public T getHighPriorityElement() {
		return this.data.get(0);
	}
	// if t having high priority than return +ve value
	 public int larger(T t,T o) {
		 return t.compareTo(o);
	 }

}
