package heap;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> data=new ArrayList<>();
	public int size() {
		return this.data.size();
	}
	public boolean isEmpty() {
		return this.data.size()==0;
	}
	public void add(int item) {
		this.data.add(item);
		upheapify(data.size()-1);
	}
	private void upheapify(int ci) {
		int pi=(ci-1)/2;
		if(this.data.get(ci)<this.data.get(pi)) {
			swap(ci,pi);
			upheapify(pi);
		}
		
		
	}
	private void swap(int i, int j) {
		int ith=this.data.get(i);
		int jth=this.data.get(j);
		this.data.set(i,jth);
		this.data.set(j, ith);
		
		
	}
	public int remove() {
		swap(0,this.data.size()-1);
		int rm=this.data.remove(this.data.size()-1);
		downheap(0);
		return rm;
	}
	private void downheap(int pi) {
		int lci=2*pi+1;
		int rci=2*pi+2;
		int min=pi;
		if(lci<this.data.size() && this.data.get(lci)<this.data.get(min)) {
			min=lci;
			
		}
		if(rci<this.data.size() && this.data.get(rci)<this.data.get(min)) {
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
	public int getHighPriorityElement() {
		return this.data.get(0);
	}

}
