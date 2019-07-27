package Recursion;

public class RecursionPrint {

	public static void main(String[] args) {
		//printSubS("abc","");
		// printSubSAscii("abc", "");
		// permutation("abc", "");
		//permutationNoDup("aab", "");
		//coinToss(2,"");
		
		//noConsicutiveHead(2,"",false);
		//boardPath(0,10,"");
		//System.out.println(boardPathCount(0,10));
		System.out.println(mazePath(0,2,0,2,""));
		//lexicoCounting(1,10);
	}
//find all sub string 
	public static void printSubS(String que, String ans) {
		if (que.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = que.charAt(0);
		String ros = que.substring(1);
		printSubS(ros, ans);//value don't include
		printSubS(ros, ans + ch);//value take
	}
//find sub string including ascii value
	public static void printSubSAscii(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = que.charAt(0);
		String ros = que.substring(1);
		printSubSAscii(ros, ans);
		printSubSAscii(ros, ans + ch);
		printSubSAscii(ros, ans + (int) ch);
	}

	public static void kpc(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = que.charAt(0);
		String ros = que.substring(1);
		String code = RecursionGet.getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			kpc(ros, ans + code.charAt(i));
		}
	}
	public static void permutation(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < que.length(); i++) {
			char ch = que.charAt(i);
			String ros = que.substring(0, i) + que.substring(i + 1);
			permutation(ros, ans + ch);
		}
	}
// no dublicate result
	public static void permutationNoDup(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}
		boolean[] track = new boolean[256];
		for (int i = 0; i < que.length(); i++) {
			char ch = que.charAt(i);
			String ros = que.substring(0, i) + que.substring(i + 1);
			if (!track[(int) ch]) {
				permutationNoDup(ros, ans + ch);
				track[(int) ch] = true;
			}
		}
	}
	public static void coinToss(int n,String ans) {
		if(n==0) {
			System.out.println(ans);
			return;
		}
		coinToss(n-1,ans+"H");
		coinToss(n-1,ans+"T");
	}
	public static void noConsicutiveHead(int n,String ans,boolean visited) {
		if(n==0) {
			System.out.println(ans);
			return;
		}
		if(!visited) {
			noConsicutiveHead(n-1,ans+"H",true);
		}
		noConsicutiveHead(n-1,ans+"T",false);
	}
	public static void boardPath(int curr,int end,String ans) {
		if(curr==end) {
			System.out.println(ans);
			return;
		}
		if(curr>end) {
			return;
		}
		for(int dice=1;dice<=6;dice++) {
			boardPath(curr+dice,end,ans+dice);
		}
		
	}
	public static int boardPathCount(int curr,int end) {
		if(curr==end) {
			return 1;
		}
		if(curr>end) {
			return 0;
		}
		int count=0;
		for(int dice=1;dice<=6;dice++) {
			count+= boardPathCount(curr+dice,end);
		}
		return count;
		
	}
	public static int mazePath(int cc,int ec,int cr,int er,String ans) {
		if(cc==ec && cr==er) {
			System.out.println(ans);
			return 1;
		}
		if(cc>ec || cr>er) {
			return 0;
		}
		int h_count=0,v_count=0;
		h_count+=mazePath(cc+1,ec,cr,er,ans+"H");
		v_count+=mazePath(cc,ec,cr+1,er,ans+"V");
		
		return h_count +v_count;
	}
	public static void lexicoCounting(int curr,int end) {
		if(curr>end) {
			return ;
		}
		System.out.println(curr);
		int i=0;
		if(curr==0) {
			i=1;
		}
		for(;i<=9;i++) {
		lexicoCounting(curr*10+i,end);
		}
	}

}
