package string;

import java.util.*;
class Stringlength implements Comparator<String>{
	public int compare(String str1,String str2) {
		return str1.length()-str2.length();
	}
}

public class StringQ {

	public static void main(String[] args) {
		// System.out.println(ispalindromic("nitin"));
		// subString("nitin");
		System.out.println("--------------");

		// System.out.println(removeRecAdj("mississipie"));
		// System.out.println(isAnagram("abc", "cba"));
		//System.out.println(minInsertion("helppreanadkada"));
		System.out.println(manachers("forgeeksskeegfor"));
		String str="hello my name is khan";
		String []arr=str.split(" ");
		Arrays.sort(arr,new Stringlength());
		for(String str1:arr) {
			System.out.println(str1);
		}

	}
//1.
	public static boolean ispalindromic(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void subString(String str) {
		for (int si = 0; si < str.length(); si++) {
			for (int hi = si + 1; hi <= str.length(); hi++) {
				System.out.println(str.substring(si, hi));
			}
		}
	}

	public static void reversewordinstring(String str) {
		int n = str.length();
		String result = "";
		int i = n - 1;
		int start, end = i + 1;
		while (i >= 0) {

			if (str.charAt(i) == '.') {
				start = i + 1;
				result = result + str.substring(start, end);
				end = i;
				result += ".";
			}
			i--;
			if (i == 0) {
				start = 0;
				result += str.substring(start, end);
			}

		}
		System.out.println(result);

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

	public static void longestPalindromicalindromicSubStringBU(String str) {
		int n = str.length();
		boolean strg[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			strg[i][i] = true;
		}
		// for two length bcz default value of boolean is false and we need digonal
		// value so;
		int start = 0;
		int maxlen = 1;
		for (int i = 0; i < n - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				strg[i][i + 1] = true;
				start = i;
				maxlen = 2;
			}
		}
		for (int slide = 3; slide <= n; slide++) {
			for (int si = 0; si <= n - slide; si++) {
				int ei = si + slide - 1;
				if (strg[si + 1][ei - 1] && str.charAt(si) == str.charAt(ei)) {
					strg[si][ei] = true;
					if (maxlen < slide) {
						maxlen = slide;
						start = si;
					}
				}

			}
		}
		System.out.println("longest palindromic substring is : " + str.substring(start, start + maxlen));
		System.out.println(maxlen);
	}

	public static String removeRecAdj(String str) {
		if (str.length() == 0 || str.length() == 1) {
			return str;
		}
		String Temp = "";
		if (str.charAt(0) != str.charAt(1)) {
			Temp += str.charAt(0);
		}
		int i = 1;
		while (i < str.length() - 1) {
			if (str.charAt(i) != str.charAt(i - 1) && str.charAt(i) != str.charAt(i + 1)) {
				Temp += str.charAt(i);
			}
			i++;
		}
		if (str.charAt(str.length() - 1) != str.charAt(str.length() - 2)) {
			Temp += str.charAt(str.length() - 1);
		}

		if (Temp.length() != str.length()) {
			return removeRecAdj(Temp);
		}
		return Temp;
	}

	// if we rotate str2 two time then its became st1 or not
	public static boolean istrue(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		String clockwise = "";
		String anticlockwise = "";
		int len = str2.length();
		clockwise += str2.substring(len - 2) + str2.substring(0, len - 2);
		anticlockwise += str2.substring(2) + str2.substring(0, 2);
		return str1.equals(clockwise) || str1.equals(anticlockwise);
	}

	// convert roman number to integer
	/*
	 * I placed before V or X indicates one less, so four is IV (one less than 5)
	 * and 9 is IX (one less than 10). X placed before L or C indicates ten less, so
	 * forty is XL (10 less than 50) and 90 is XC (ten less than a hundred). C
	 * placed before D or M indicates a hundred less, so four hundred is CD (a
	 * hundred less than five hundred) and nine hundred is CM (a hundred less than a
	 * thousand).
	 * 
	 * 
	 * Algorithm to convert Roman Numerals to Integer Number :
	 * 
	 * Split the Roman Numeral string into Roman Symbols (character). Convert each
	 * symbol of Roman Numerals into the value it represents. Take symbol one by one
	 * from starting from index 0: If current value of symbol is greater than or
	 * equal to the value of next symbol, then add this value to the running total.
	 * else subtract this value by adding the value of next symbol to the running
	 * total.
	 */
	public static int romanToInt(String str) {
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			int s1 = value(str.charAt(i));
			if (i + 1 < str.length()) {
				int s2 = value(str.charAt(i + 1));

				if (s1 >= s2) {
					res += s1;
				} else {
					res += s2 - s1;
					i++;// bcz we traverse at two character of str i & i+1
				}

			} else {
				res += s1;
			}
		}
		return res;

	}

	public static int value(char ch) {
		if (ch == 'I') {
			return 1;
		}
		if (ch == 'V') {
			return 5;
		}
		if (ch == 'X') {
			return 10;
		}
		if (ch == 'L') {
			return 50;
		}
		if (ch == 'C') {
			return 100;
		}
		if (ch == 'D') {
			return 500;
		}
		if (ch == 'M') {
			return 1000;
		}
		return -1;
	}

	// anagram
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int temp[] = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			temp[(int) str1.charAt(i)] += 1;
		}
		for (int i = 0; i < str2.length(); i++) {
			temp[(int) str2.charAt(i)] -= 1;
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				return false;
			}
		}
		return true;
	}

	// remove all duplicate in string
	public static String removeduplicate(String str) {
		boolean temp[] = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			temp[(int) str.charAt(i)] = true;
		}
		String str1 = "";
		for (int i = 0; i < str.length(); i++) {
			if (temp[str.charAt(i)]) {
				str1 += str.charAt(i);
				temp[str.charAt(i)] = false;

			}
		}
		return str1;

	}

	// find length of maximum substring that not contain any duplicate
	public static int maxlen(String str) {
		if (str.length() == 0 || str.length() == 1) {
			return str.length();
		}
		// for tracking visited or not
		int temp[] = new int[256];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = -1;
		}
		temp[str.charAt(0)] = 0;
		int max_len = 1;
		int curr_len = 1;
		int prev_idx;
		for (int i = 1; i < str.length(); i++) {
			prev_idx = temp[str.charAt(i)];
			// if character is not visited
			if (prev_idx == -1) {
				curr_len++;
				if (max_len < curr_len) {
					max_len = curr_len;
				}
			} // else character is visited then two case possible
			else {
				// case 1 if prev of same duplicate character not part of substring
				if (i - curr_len > prev_idx) {
					curr_len++;
				} // case 2 if part
				else {
					curr_len = i - prev_idx;
				}

				if (max_len < curr_len) {
					max_len = curr_len;
				}
			}

			temp[str.charAt(i)] = i;

		}
		return max_len;

	}

	// given a string find the minimum number of characters to be inserted to
	// convert it to palindrome
	public static int minInsertion(String str) {
		int n = str.length();
		int strg[][] = new int[n][n];
		for (int slide = 1; slide < n; slide++) {
			for (int row = 0; row < n - slide; row++) {
				int col = row + slide;
				if (str.charAt(row) == str.charAt(col)) {
					strg[row][col] = strg[row + 1][col - 1];
				} else {
					strg[row][col] = Math.min(strg[row + 1][col], strg[row][col - 1]) + 1;
				}

			}
		}
		return strg[0][n - 1];
	}

	// convert string in integer if any character except 0 to 9 occurs then return
	// -1;
	public static int atoi(String str) {
		// Your code here

		int ans = 0;
		int sign = 1;
		int i = 0;
		if (str.charAt(0) == '-') {
			sign = -1;
			i++;
		}
		for (; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch < 48 || ch > 57) {
				return -1;
			}
			ans = ans * 10 + ch - '0';
		}
		return sign * ans;
	}
	// if string x is occurence in string s then return first index otherwise -1
	public static int strstr(String s, String x)
    {
       // Your code here
       int ans=-1;
     for(int i=0;i<=s.length()-x.length();i++){
         if(s.substring(i,i+x.length()).equals(x)){
             ans=i;
             break;
         }
     }
     return ans;
    }
	// or simple
	public static int strstr2(String s, String x)
    {
      return s.indexOf(x);
    }
	//Given a set of strings, find the longest common prefix.
	
	 public static String longestCommonPrefix(String []arr){
	     Arrays.sort(arr);
	     int n1=arr[0].length();
	     String str1=arr[0];
	     String str2=arr[arr.length-1];
	     String result="";
	     for(int i=0;i<n1;i++){
	         if(str1.charAt(i)!=str2.charAt(i)){
	             break;
	         }
	         result+=str1.charAt(i);
	     }
	     if(result.length()==0){
	         result+="-1";
	     }
	     return result;
	 }
	 // geeks for geeks Given a string of both uppercase and lowercase alphabets,
	 //the task is to print the string with alternate occurrences of any character dropped(including space 
	 //and consider upper and lowercase as same).
	 public static void strIgnorance(String str){
	     boolean temp[]=new boolean[123];
	     String s=str.toLowerCase();
	     for(int i=0;i<str.length();i++){
	        char ch=s.charAt(i);
	        if(temp[ch]){
	            temp[ch]=false;
	            
	        }else{
	            System.out.print(str.charAt(i));
	            temp[ch]=true;
	        }
	     }
	 }
	 
	 //Smallest window in a string containing all the characters of another string
	 public static String smallestWindow(String str,String ptrn){
	     if(str==null || ptrn==null || ptrn.length()>str.length()){
	         return "-1";
	     }
	     int temp[]=new int[128];
	     for(int i=0;i<ptrn.length();i++){
	         temp[ptrn.charAt(i)]++;
	     }
	     String res="";
	     int left=0,count=0,min=Integer.MAX_VALUE;
	     int flag=0;
	     for(int right=0;right<str.length();right++){
	         if(--temp[str.charAt(right)]>=0){
	             count++;
	         }
	         while(count==ptrn.length()){
	             flag=1;
	             if(min>right-left+1){
	                 min=right-left+1;
	                 res=str.substring(left,right+1);
	             }
	             if(++temp[str.charAt(left)]>0){
	                 count--;
	             }
	             left++;
	         }
	     }
	     if(flag==0){
	         return "-1";
	     }
	     return res;
	 }
	 // first non repeating character
	 public static String firstNonRepeatingChar(String str,int n){
	     HashMap<Character,Integer> hp=new HashMap<>();
	     for(int i=0;i<n;i++){
	         char key=str.charAt(i);
	         if(hp.containsKey(key)){
	             hp.put(key,hp.get(key)+1);
	         }else{
	             hp.put(key,1);
	         }
	     }
	     String ch="";
	     int flag=0;
	     for(int i=0;i<n;i++){
	         char key=str.charAt(i);
	         if(hp.get(key)==1){
	             ch+=key;
	             flag=1;
	             break;
	         }
	     }
	     if(flag==0){
	         return "-1";
	     }
	     return ch;
	     
	 }
	 //Check if strings are rotations of each other or not
	 public static boolean isTrue(String str1,String str2){
	     if(str1.length()!=str2.length()){
	         return false;
	     }
	     String clockwise="";
	     String anticlockwise="";
	     int flag=0;
	     int len=str2.length();
	     for(int i=0;i<len;i++){
	     clockwise=str2.substring(len-i)+str2.substring(0,len-i);
	     anticlockwise=str2.substring(i)+str2.substring(0,i);
	     if(str1.equals(clockwise) || str1.equals(anticlockwise)){
	         flag=1;
	         break;
	     }
	     }
	     if(flag==0){
	         return false;
	     }
	     return true;
	 }
	 // save ironman
	 public static boolean isPalindromicIronMan(String str) {
	     String str1="";
	     for(int i=0;i<str.length();i++){
	         char s=str.charAt(i);
	         if((s>=48 && s<=57) || (s>=65 && s<=90) ||(s>=97 && s<=122)){
	             str1+=s;
	         } 
	     }
	     String str2=str1.toLowerCase();
		int left = 0;
		int right = str2.length() - 1;
		while (left < right) {
			if (str2.charAt(left) != str2.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	 // repeat charcater 
	 public static String firstRepeatingChar(String str){
	     HashMap<Character,Integer> hp=new HashMap<>();
	     for(int i=0;i<str.length();i++){
	         char key=str.charAt(i);
	         if(hp.containsKey(key)){
	             hp.put(key,hp.get(key)+1);
	         }else{
	             hp.put(key,1);
	         }
	     }
	     String ch="";
	     int flag=0;
	     for(int i=0;i<str.length();i++){
	         char key=str.charAt(i);
	         if(hp.get(key)>1){
	             ch+=key;
	             flag=1;
	             break;
	         }
	     }
	     if(flag==0){
	         return "-1";
	     }
	     return ch;
	     
	 }
	 //
	 public static String removeCommonChar(String s1,String s2){
	     if(s1.length()==0){
	         return s2;
	     }
	     if(s2.length()==0){
	         return s1;
	     }
	     int temp1[]=new int[256];
	     int temp2[]=new int[256];
	     for(int i=0;i<s1.length();i++){
	         ++temp1[s1.charAt(i)];
	     }
	     for(int i=0;i<s2.length();i++){
	         ++temp2[s2.charAt(i)];
	     }
	     String res="";
	     for(int i=0;i<s1.length();i++){
	         if(temp2[s1.charAt(i)]==0){
	             res+=s1.charAt(i);
	         }
	     }
	     for(int i=0;i<s2.length();i++){
	         if(temp1[s2.charAt(i)]==0){
	             res+=s2.charAt(i);
	         }
	     }
	     if(res.length()==0){
	         return "-1";
	     }
	     return res;
	 }
	 //Geek and its Colored Strings
	 public static long geekColorString(int n,int r,int g,int b){
	     long fact[]=new long[n+1];
	     fact[0]=1;
	     for(int i=1;i<=n;i++){
	         fact[i]=fact[i-1]*i;
	     }
	     int left=n-(r+g+b);
	     long sum=0;
	     for(int i=0;i<=left;i++){
	         for(int j=0;j<=left-i;j++){
	             int k=left-(i+j);
	             sum+=fact[n]/(fact[r+i]*fact[g+j]*fact[b+k]);
	             
	         }
	     }
	     return sum;
	 }
	 public static int[] getTable(String pattern) {
		 int [] table=new int[pattern.length()];
		 int j=0;
		 for(int i=1;i<pattern.length();) {
			 if(pattern.charAt(i)==pattern.charAt(j)) {
				 table[i]=j+1;
				 i++;
				 j++;
			 }else {
				 if(j!=0) {
					 j=table[j-1];
				 }else {
					 table[i]=0;
					 i++;
				 }
				 
			 }
		 }
		 return table;
	 }
	 public static boolean KMP(String text,String pattern) {
		 int table[]=getTable(pattern);
		 int i=0;
		 int j=0;
		 while(i<text.length() && j<pattern.length()) {
			 if(text.charAt(i)==pattern.charAt(j)) {
				 i++;
				 j++;
			 }else {
				 if(j!=0) {
					 i++;
					 j=table[j-1];
				 }else {
					 i++;
				 }
			 }
		 }
		 if(j==pattern.length()) {
			 return true;
		 }
		 return false;
	 }
   // manachers algo to count all palindromic algo or longest palindroic algo
	 public static int manachers(String str) {
		 int max=1;
		 // for odd length
		 for(int axis=0;axis<str.length();axis++ ) {
			 for(int orb=0;axis-orb>=0 && orb+axis<str.length();orb++) {
				 if(str.charAt(axis-orb)==str.charAt(axis+orb)) {
					 if(max<2*orb+1) {
						 max=2*orb+1;
					 }
				 }else {
					 break;
				 }
			 }
		 }
		 
		 // for even
		 for(double axis=0.5;axis<str.length();axis++ ) {
			 for(double orb=0.5;axis-orb>=0 && orb+axis<str.length();orb++) {
				 if(str.charAt((int)(axis-orb))==str.charAt((int)(axis+orb))) {
					 int len=(int)(2*orb)+1;
					 if(max<len) {
						 max=len;
					 }
				 }else {
					 break;
				 }
			 }
		 }
		 return max;
	 }
}
