package queue;

public class DynamicQueue extends Queue {
	public void enqueue(int item) throws Exception {
		if(this.isFull()) {
			int [] oarr=this.data;
			int [] narr=new int[2*oarr.length];
			for(int i=0;i<narr.length;i++) {
				narr[i]=oarr[(i+this.front)%oarr.length];
			}
			this.data=narr;
			this.front=0;
					
		}
		super.enqueue(item);
	}

}
