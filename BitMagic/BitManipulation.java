package BitMagic;

public class BitManipulation {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//oddeven(6);
		     System.out.println(Extractbit(17,noOfBit(17)));
		     System.out.println(noOfBit2(17));
			//System.out.println(Setbit(21,4));
			//System.out.println(Resetbit(17,3));
	        // System.out.println(Posrightmostsetbit(54));
			//System.out.println(addone(9));
			//System.out.println(magicno(5));
			//System.out.println(pascalsum(2));
			//System.out.println(poweroftwo(31));
		}

		public static void oddeven(int num) {
			if ((num & 1) == 0)
				System.out.println("even");
			else
				System.out.println("odd");
		}//m1
		 public static int noOfBit(int n){
		     int count=0;
		     while(n!=0){
		         n>>=1;
		         count++;
		     }
		     return count;
		 }
		 //m2
		 public static int noOfBit2(int num) {
			 return (int)(Math.log(num)/Math.log(2)+1);// in cpp log2(num)+1;
		 }
		// ith bit is 1 or 0
		public static int Extractbit(int n,int i) {
			int mask =1 << (i-1);
			if((n & mask) == 0)
				return 0;
			else 
				return 1;
		}
		public static int Setbit(int n,int i) {
			int mask =1 << (i-1);
			n=n | mask;
				return n ;
		}
		public static int Resetbit(int n,int i) {
			int mask =~(1 << (i-1));
			n=n & mask;
				return n ;
		}
		public static int Posrightmostsetbit(int n) {
			int pos=1;
			int mask=1;
			while((n & mask)==0){
				pos++;
				mask=mask<<1;
			}
			return pos;
		}
		public static int addone(int n) {
			int mask=1;
			while((n & mask)!=0) {
				n=n ^ mask;
				mask=mask << 1;
			}
			n= n ^ mask;
			return n;
		}
		//nth magic number
		public static int magicno(int n) {
			int pow=1;
			int ans=0;
			while(n!=0) {
				pow=pow*5;
				if((n & 1)==1)
				ans=ans+pow;
				n =(n >> 1);
			}
			return ans;
		}
		//   sum of all rows  of pascal triangle
		public static int pascalsum(int n) {
			return (1 << n)-1;
		}
		public static boolean poweroftwo(int n) {
			if(n!=0) {
				if((n & (n-1))==0)
					return true;
			}
			return false;
			
		}
	}

