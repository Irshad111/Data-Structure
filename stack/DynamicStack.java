package stack;

public class DynamicStack extends Stack {
	public void push(int item) throws Exception {
		if (this.isFull()) {
			int[] oarr = this.data;
			int[] narr = new int[2 * oarr.length];

			for (int i = 0; i < oarr.length; i++) {
				narr[i] = oarr[i];
			}
			this.data = narr;
		}
		super.push(item);
	}

}
