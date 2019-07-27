package Dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import stack.StackClient;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int n = 4;
		// System.out.println(fiboncciTD(n,new int[n+1]));
		// System.out.println(fiboncciBU(n));
		// System.out.println(fiboncciBUSE(n));
//		System.out.println(BoardPathTD(0, n, new int[n + 1]));
//		System.out.println(BoardPathBU(n));
//		System.out.println(BoardPathBUSE(n));
		//
		// System.out.println(mazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathBU(n, n));
		// System.out.println(mazePathBUSE(n, n));
		// System.out.println(mazePathDigBUSE(n, n));
		// System.out.println(editDistance("geek","gesek"));
		// System.out.println(editDistanceTD("geek","gesek",new int[5][6]));
		// System.out.println(editDistanceBU("geek","gesek"));
		// int n=10;
		// int arr[]=new int[n];
		// for(int i=0;i<arr.length;i++)
		// arr[i]=i+1;
		// System.out.println(MCM(arr,0,arr.length-1));
		// System.out.println(MCMTD(arr,0,arr.length-1,new
		// int[arr.length][arr.length]));
		// System.out.println(MCMBU(arr));

		//int arr[] = {-5,-1,-1,-1};
		//int price[] = { 1, 7, 10 };
		// System.out.println(wineProblem(arr, 0, 4, 1));
		// System.out.println(wineProblemTD(arr, 0, 4, new int[5][5]));
		//
		// System.out.println(wineProblemBU(arr));
		// System.out.println(knapsnak(wt,price,7,0));
		// System.out.println(knapsnakTD(wt,price,7,0,new int[wt.length][7+1]));
		// System.out.println(KnapsnakBU(wt,price,7));
		// System.out.println(rodcut(price,8));
		// System.out.println(rodcutTD(price,8,new int[price.length]));
		// System.out.println(rodcutBU(price,8));
		// System.out.println(MictureTD(arr,0,2,new int[3][3]));
		// System.out.println(MictureBU(arr));
		// String str="ababbbabbababa";
		// System.out.println(palindromicpartition(str,0,str.length()-1));
		// System.out.println(palindromicpartitionTD(str,0,str.length()-1,new
		// int[str.length()][str.length()]));
//		System.out.println(mincoin(price, 15));
//		System.out.println(mincoinTD(price, 15, new int[16]));
//
//		System.out.println(mincoinBU(price, 15));
//		System.out.println(palindromicSubSeqBU("babcbab"));
//		palindromicSubStringBU("forgekeekgfor");
//		System.out.println(subset(arr,7));
//		System.out.println(eggdrop(8,4));
//		System.out.println(kadansAlgo(arr));
//		int arr1[]=kadans(arr);
//		for(int i:arr1) {
//			System.out.println(i);
//		}
//		maxSubMatrix(new int[][] { 
//            {1, 2, -1, -4, -20}, 
//            {-8, -3, 4, 2, 1}, 
//            {3, 8, 10, 1, 3}, 
//            {-4, -1, 1, 7, -6} 
//            }); 
		//System.out.println(lcsString("geeksbdc","geekabcd"));
//		Set<String> dictionary = new HashSet<>();
//        dictionary.add("I");
//        dictionary.add("like");
//        dictionary.add("had");
//        dictionary.add("play");
//        dictionary.add("to");
//        String str = "Il";
//        System.out.println(wordbreak(str,dictionary));
//		 String words1[] = {"Irshad","kha","likes","to","code"};
//	      
//	        System.out.println(justify(words1, 10));
//
//	}
		Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
        System.out.println(weightedJob(jobs));
	}

	// using top -down
	public static int fiboncciTD(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int fn1 = fiboncciTD(n - 1, strg);
		int fn2 = fiboncciTD(n - 2, strg);
		int fn = fn1 + fn2;
		strg[n] = fn;
		return fn;
	}

	// bottum-up
	public static int fiboncciBU(int n) {
		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		return strg[n];
	}

	// bottum-up less space
	public static int fiboncciBUSE(int n) {
		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;
		}
		return strg[1];
	}

	public static int BoardPathTD(int curr, int end, int[] strg) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		if (strg[curr] != 0) {
			return strg[curr];
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += BoardPathTD(curr + dice, end, strg);
		}
		strg[curr] = count;

		return count;

	}

	public static int BoardPathBU(int n) {
		int[] strg = new int[n + 6];
		strg[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];

		}

		return strg[0];

	}

	public static int BoardPathBUSE(int n) {
		int[] strg = new int[6];
		strg[0] = 1;
		for (int slide = n - 1; slide >= 0; slide--) {
			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;

		}
		return strg[0];
	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {
		if (cc == ec && cr == er) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int h = mazePathTD(cr, cc + 1, er, ec, strg);
		int v = mazePathTD(cr + 1, cc, er, ec, strg);
		strg[cr][cc] = h + v;
		return h + v;

	}

	public static int mazePathBU(int er, int ec) {
		int strg[][] = new int[er + 1][ec + 1];
		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec || row == er) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}
		return strg[0][0];

	}

	public static int mazePathBUSE(int er, int ec) {
		int strg[] = new int[ec + 1];
		Arrays.fill(strg, 1);
		for (int slide = er - 1; slide >= 0; slide--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}
		return strg[0];

	}

	public static int mazePathDigBUSE(int er, int ec) {
		int strg[] = new int[ec + 1];
		Arrays.fill(strg, 1);
		int dig = 0;
		for (int slide = er - 1; slide >= 0; slide--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					strg[col] = 1;
					dig = 1;
				} else {
					int sum = strg[col] + strg[col + 1] + dig;
					dig = strg[col];
					strg[col] = sum;
				}
			}
		}
		return strg[0];

	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);
		char ch2 = s2.charAt(0);
		String ros2 = s2.substring(0);
		int ans = 0;
		if (ch1 == ch2) {
			ans = lcs(ros1, ros2) + 1;
		} else {
			ans = Math.max(lcs(s1, ros2), lcs(ros1, s2));
		}
		return ans;
	}
    // longest common subsequence
	
	public static int lcsBU(String s1, String s2) {
		int strg[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {
				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {
					strg[row][col] = Math.max(strg[row + 1][col], strg[row][col + 1]);
				}
			}
		}
		return strg[0][0];
	}
	
	// longest common substring
	public static int lcsString(String s1, String s2) {
		int strg[][] = new int[s1.length() + 1][s2.length() + 1];
		int max=0;
		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {
				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
					if(max<strg[row][col])
						max=strg[row][col];
				} else {
					strg[row][col] = 0;
				}
			}
		}
		return max;
	}


	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			ans = editDistance(ros1, ros2);
		} else {
			int i = editDistance(ros1, s2);
			int d = editDistance(s1, ros2);
			int r = editDistance(ros1, ros2);
			ans = Math.min(i, Math.min(d, r)) + 1;
		}
		return ans;
	}

	public static int editDistanceTD(String s1, String s2, int strg[][]) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if (strg[s1.length()][s2.length()] != 0) {
			return strg[s1.length()][s2.length()];
		}
		int ans = 0;
		if (ch1 == ch2) {
			ans = editDistanceTD(ros1, ros2, strg);
		} else {
			int i = editDistanceTD(ros1, s2, strg);
			int d = editDistanceTD(s1, ros2, strg);
			int r = editDistanceTD(ros1, ros2, strg);
			ans = Math.min(i, Math.min(d, r)) + 1;
		}
		strg[s1.length()][s2.length()] = ans;
		return ans;
	}

	public static int editDistanceBU(String s1, String s2) {
		int strg[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}
				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}
				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {
					strg[row][col] = Math.min(strg[row + 1][col + 1], Math.min(strg[row + 1][col], strg[row][col + 1]))
							+ 1;
				}
			}
		}
		return strg[0][0];
	}

	public static int MCM(int[] arr, int si, int ei) {
		if (si + 1 == ei) {

			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int fs = MCM(arr, si, k);
			int se = MCM(arr, k, ei);
			int sw = arr[si] * arr[k] * arr[ei];
			int sum = fs + se + sw;
			if (sum < min) {
				min = sum;
			}
		}
		return min;

	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int fs = MCMTD(arr, si, k, strg);
			int se = MCMTD(arr, k, ei, strg);
			int sw = arr[si] * arr[k] * arr[ei];
			int sum = fs + se + sw;
			if (sum < min) {
				min = sum;
			}
		}
		strg[si][ei] = min;
		return min;

	}

	public static int MCMBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 2; slide++) {
			for (int si = 0; si <= n - slide - 2; si++) {
				int ei = si + slide + 1;
				int min = Integer.MAX_VALUE;
				for (int k = si + 1; k <= ei - 1; k++) {
					int fs = strg[si][k];
					int se = strg[k][ei];
					int sw = arr[si] * arr[k] * arr[ei];
					int sum = fs + se + sw;
					if (sum < min) {
						min = sum;
					}
				}
				strg[si][ei] = min;
			}
		}
		return strg[0][n - 1];
	}

	public static int wineProblem(int[] price, int si, int ei, int yr) {
		if (si == ei) {
			return price[si] * yr;
		}

		int fc = wineProblem(price, si + 1, ei, yr + 1) + price[si] * yr;
		int sc = wineProblem(price, si, ei - 1, yr + 1) + price[ei] * yr;
		int res = Math.max(fc, sc);
		return res;

	}

	public static int wineProblemTD(int[] price, int si, int ei, int[][] strg) {
		int yr = price.length - (ei - si);
		if (si == ei) {
			return price[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[ei][si];
		}
		int sc = wineProblemTD(price, si + 1, ei, strg) + price[si] * yr;
		int ec = wineProblemTD(price, si, ei - 1, strg) + price[ei] * yr;
		int res = Math.max(sc, ec);
		strg[si][ei] = res;
		return res;

	}

	public static int wineProblemBU(int[] price) {

		int n = price.length;
		int strg[][] = new int[n][n];
		for (int slide = 1; slide <= n; slide++) {
			for (int si = 0; si <= n - slide; si++) {
				int ei = si + slide - 1;
				int yr = n - (ei - si);
				if (si == ei) {
					strg[si][ei] = price[si] * yr;
				} else {
					int sc = strg[si + 1][ei] + price[si] * yr;
					int ec = strg[si][ei - 1] + price[ei] * yr;
					int res = Math.max(sc, ec);
					strg[si][ei] = res;
				}

			}
		}
		return strg[0][n - 1];
	}

	public static int knapsnak(int[] wt, int[] price, int cap, int vidx) {
		if (vidx == wt.length) {
			return 0;
		}

		int include = 0;
		if (cap >= wt[vidx])
			include = knapsnak(wt, price, cap - wt[vidx], vidx + 1) + price[vidx];

		int exclude = knapsnak(wt, price, cap, vidx + 1);

		int ans = Math.max(include, exclude);
		return ans;
	}

	public static int knapsnakTD(int[] wt, int[] price, int cap, int vidx, int[][] strg) {
		if (vidx == wt.length) {
			return 0;
		}
		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}
		int include = 0;
		if (cap >= wt[vidx])
			include = knapsnakTD(wt, price, cap - wt[vidx], vidx + 1, strg) + price[vidx];

		int exclude = knapsnakTD(wt, price, cap, vidx + 1, strg);

		int ans = Math.max(include, exclude);
		strg[vidx][cap] = ans;
		return ans;
	}

	public static int KnapsnakBU(int[] wt, int[] price, int cap) {
		int tr = wt.length + 1;
		int tc = cap + 1;
		int[][] strg = new int[tr][tc];
		for (int row = 0; row < tr; row++) {

			for (int col = 0; col < tc; col++) {

				if (row == 0 || col == 0) {
					strg[row][col] = 0;
				} else {
					int include = 0;
					if (col >= wt[row - 1]) {
						include = price[row - 1] + strg[row - 1][col - wt[row - 1]];// col-wt[row-1]=remaining capcity
					}
					int exclude = strg[row - 1][col];

					int max = Math.max(include, exclude);

					strg[row][col] = max;
				}
			}
		}
		return strg[tr - 1][tc - 1];
	}

	public static int rodcut(int[] price, int n) {

		if (n == 0) {
			return 0;
		}
		int max = price[n];
		int right = n - 1;
		int left = 1;

		while (left <= right) {
			int fc = rodcut(price, left);
			int sc = rodcut(price, right);
			int sum = fc + sc;
			if (max < sum) {
				max = sum;
			}
			left++;
			right--;
		}
		return max;
	}

	public static int rodcutTD(int[] price, int n, int[] strg) {

		if (n == 0) {
			return 0;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int right = n - 1;
		int left = 1;
		int max = price[n];

		while (left <= right) {
			int fc = rodcutTD(price, left, strg);
			int sc = rodcutTD(price, right, strg);
			int sum = fc + sc;
			if (max < sum) {
				max = sum;
			}
			left++;
			right--;
		}
		strg[n] = max;

		return max;
	}

	public static int rodcutBU(int[] price, int n) {
		int[] strg = new int[price.length];

		for (int i = 1; i <= n; i++) {
			strg[i] = price[i];
			int left = 1;
			int right = i - 1;
			while (left <= right) {
				int fc = strg[left];
				int sc = strg[right];
				int sum = fc + sc;
				if (strg[i] < sum) {
					strg[i] = sum;
				}
				left++;
				right--;
			}
		}

		return strg[n];

	}

	public static int color(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}
		return sum % 100;
	}

	public static int MictureTD(int[] arr, int si, int ei, int[][] strg) {

		if (si == ei) {
			return 0;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fs = MictureTD(arr, si, k, strg);
			int se = MictureTD(arr, k + 1, ei, strg);
			int sw = color(arr, si, k) * color(arr, k + 1, ei);
			int sum = fs + se + sw;
			if (sum < min) {
				min = sum;
			}
		}
		strg[si][ei] = min;
		return min;

	}

	public static int MictureBU(int[] arr) {
		int n = arr.length;
		int strg[][] = new int[arr.length][arr.length];
		for (int slide = 1; slide < n; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				int min = Integer.MAX_VALUE;
				for (int k = si; k <= ei - 1; k++) {
					int fs = strg[si][k];
					int se = strg[k + 1][ei];
					int sw = color(arr, si, k) * color(arr, k + 1, ei);
					int sum = fs + se + sw;
					if (sum < min) {
						min = sum;
					}
				}
				strg[si][ei] = min;

			}
		}
		return strg[0][n - 1];
	}

	public static boolean isPalindromic(String str, int si, int ei) {
		int left = si;
		int right = ei;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static int palindromicpartition(String str, int si, int ei) {

		int min = Integer.MAX_VALUE;
		if (isPalindromic(str, si, ei)) {
			return 0;
		}
		for (int k = si; k <= ei - 1; k++) {
			int fc = palindromicpartition(str, si, k);

			int sc = palindromicpartition(str, k + 1, ei);
			int res = fc + sc + 1;
			if (res < min) {
				min = res;
			}

		}
		return min;
	}

	public static int palindromicpartitionTD(String str, int si, int ei, int[][] strg) {

		int min = Integer.MAX_VALUE;
		if (isPalindromic(str, si, ei)) {
			return 0;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		for (int k = si; k <= ei - 1; k++) {
			int fc = palindromicpartition(str, si, k);

			int sc = palindromicpartition(str, k + 1, ei);
			int res = fc + sc + 1;
			if (res < min) {
				min = res;
			}
			strg[si][ei] = min;

		}
		return min;
	}

	public static int mincoin(int[] coin, int amount) {
		if (amount == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coin.length; i++) {
			if (coin[i] <= amount) {
				int rec = mincoin(coin, amount - coin[i]) + 1;
				if (rec < min) {
					min = rec;
				}

			}
		}
		return min;
	}

	public static int mincoinTD(int[] coin, int amount, int[] strg) {
		if (amount == 0) {
			return 0;
		}
		if (strg[amount] != 0) {
			return strg[amount];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coin.length; i++) {
			if (coin[i] <= amount) {
				int rec = mincoin(coin, amount - coin[i]) + 1;
				if (rec < min) {
					min = rec;
				}

			}
		}
		strg[amount] = min;
		return min;
	}

	public static int mincoinBU(int[] coin, int amount) {
		int strg[] = new int[amount + 1];
		strg[0] = 0;
		for (int rupay = 1; rupay <= amount; rupay++) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < coin.length; i++) {
				if (rupay >= coin[i]) {
					int ans = strg[rupay - coin[i]] + 1;
					if (min > ans) {
						min = ans;
					}

				}
			}
			strg[rupay] = min;
		}
		return strg[amount];
	}

	public static int palindromicSubSeqBU(String str) {
		int n = str.length();
		int strg[][] = new int[n][n];
		for (int slide = 0; slide < n; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				if (ei == si) {
					strg[si][ei] = 1;
					continue;
				}
				if (str.charAt(si) == str.charAt(ei)) {
					strg[si][ei] = strg[si + 1][ei - 1] + 2;
				} else {
					strg[si][ei] = Math.max(strg[si + 1][ei], strg[si][ei - 1]);
				}
			}
		}
		return strg[0][n - 1];
	}

	public static void palindromicSubStringBU(String str) {
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
	// if sum is given
	public static boolean subset(int arr[],int sum) {
		int n=arr.length;
		boolean strg[][]=new boolean[n+1][sum+1];
		for(int row=0;row<=n;row++) {
			for(int col=0;col<=sum;col++) {
				if(col==0) {
					strg[row][col]=true;
				}else if(row==0) {
					strg[row][col]=false;
				}else {
					if(arr[row-1]>col) {
						strg[row][col]=strg[row-1][col];
					}else {
						strg[row][col]=strg[row-1][col] || strg[row-1][col-arr[row-1]];
					}
				}
			}
		}
		return strg[n][sum];
	}
	// if sum is not given
	public static boolean subsetpartision(int arr[]) {
		int sum=0;
		int n=arr.length;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		if(sum%2!=0) {
			return false;
		}
		sum=sum/2;
		boolean strg[][]=new boolean[n+1][sum+1];
		for(int row=0;row<=n;row++) {
			for(int col=0;col<=sum;col++) {
				if(col==0) {
					strg[row][col]=true;
				}else if(row==0) {
					strg[row][col]=false;
				}else {
					if(arr[row-1]>col) {
						strg[row][col]=strg[row-1][col];
					}else {
						strg[row][col]=strg[row-1][col] || strg[row-1][col-arr[row-1]];
					}
				}
			}
		}
		return strg[n][sum];
	}
	public static int eggdrop(int n,int e) {
		int strg[][]=new int[n+1][e+1];
		for(int i=1;i<=e;i++) 
			strg[1][i]=1;//if we have only one floor
		for(int i=1;i<=n;i++)	
			strg[i][1]=i;//if we have only 1 egg and i floor
		
		// row for floor col for egg
		int res;
		for(int row=2;row<=n;row++) {
			for(int col=2;col<=e;col++) {
				strg[row][col]=Integer.MAX_VALUE;
			   for(int x=1;x<row;x++) {
				   res=Math.max(strg[row-x][col], strg[x-1][col-1])+1;
				   if(res<strg[row][col]) {
					   strg[row][col]=res;
				   }
			   }
			}
		}
		return strg[n][e];
	}
	public static int kadansAlgo(int arr[]) {
		int curr_max=arr[0],global_max=arr[0];
		for(int i=1;i<arr.length;i++) {
			curr_max=Math.max(arr[i],arr[i]+curr_max);
			if(curr_max>global_max) {
				global_max=curr_max;
			}
		}
		return global_max;
	}
	public static int[] kadans(int arr[]) {
		int curr_max=arr[0];
		int []result=new int[3];
		
		 result[0]=arr[0];//for global max
		result[1]=0;//start index
		result[2]=0;//end index
		for(int i=1;i<arr.length;i++) {
			if(arr[i]+curr_max<arr[i]) {
				curr_max=arr[i];
				result[1]=i;
			}else {
				curr_max=curr_max+arr[i];
			}
			//curr_max=Math.max(arr[i],arr[i]+curr_max); bcz u want start index
			if(curr_max>=result[0]) {
				result[0]=curr_max;
				result[2]=i;
			}
		}
		
		return result;
	}
	
	public static void maxSubMatrix(int mat[][]) {
		int maxsum=Integer.MIN_VALUE;
		int maxleft=-1;
		int maxright=-1;
		int maxup=-1;
		int maxdown=-1;
		
		for(int left_col=0;left_col<mat[0].length;left_col++) {
			int strg[]=new int[mat.length];
			for(int right_col=left_col;right_col<mat[0].length;right_col++) {
				for(int row=0;row<mat.length;row++) {
					strg[row]+=mat[row][right_col];
				}
				int[] result=kadans(strg);
				if(result[0]>maxsum) {
					maxsum=result[0];
					maxleft=left_col;
					maxright=right_col;
					maxup=result[1];
					maxdown=result[2];
				}
				
			}
		}
		System.out.println("left="+maxleft+" right="+maxright);
		System.out.println("bottom="+maxdown+" up="+maxup);
		System.out.println("max sum="+maxsum);
		
		
	}
//	 Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
//	 * in this matrix.
//	 * 
//	 * Maintain a temp array of same size as number of columns. 
//	 * Copy first row to this temp array and find largest rectangular area
//	 * for histogram. Then keep adding elements of next row to this temp
//	 * array if they are not zero. If they are zero then put zero there.
//	 * Every time calculate max area in histogram.
//	 * 
//	 * Time complexity - O(rows*cols)
//	 * Space complexity - O(cols) - if number of cols is way higher than rows
//	 * then do this process for rows and not columns.
//	 * 
	public static int maximumRectangularSubMatrixOf1s(int mat[][]) throws Exception {
		int temp[]=new int[mat[0].length];
		int maxarea=0,area=0;
		for(int row=0;row<mat.length;row++) {
			for(int col=0;col<mat[0].length;col++) {
				if(mat[row][col]==0) {
					temp[col]=0;
				}
				else {
					temp[col]+=mat[row][col];
				}
			}
			area=StackClient.histogramArea(temp);
			if(area>maxarea) {
				maxarea=area;
			}
		}
		return maxarea;
	}
//	1) Construct a sum matrix S[R][C] for the given M[R][C].
//    a)    Copy first row and first columns as it is from M[][] to S[][]
//    b)    For other entries, use following expressions to construct S[][]
//        If M[i][j] is 1 then
//           S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
//        Else /*If M[i][j] is 0*/
//           S[i][j] = 0
//  2) Find the maximum entry in S[R][C]
//  3) Using the value and coordinates of maximum entry in S[i], print 
//  sub-matrix of M[][]
	
	public static int maxiSizeSqureSubMatrixOf1s(int mat[][]) {
		int max=0;
		int strg[][]=new int[mat.length][mat[0].length];
		// copy first row
		for(int col=0;col<mat[0].length;col++ ) {
			strg[0][col]=mat[0][col];
			if(strg[0][col]==1) {
				max=1;
			}
		}
		//copy first column
		for(int row=0;row<mat.length;row++ ) {
			strg[row][0]=mat[row][0];
			if(strg[row][0]==1) {
				max=1;
			}
		}
		//other
		for(int row=1;row<mat.length;row++) {
			for(int col=0;col<mat[0].length;col++ ) {
				if(mat[row][col]==0) {
				strg[row][col]=0;
				}else {
					strg[row][col]=Math.min(Math.min(strg[row][col-1],strg[row-1][col]), strg[row-1][col-1])+1;
					if(strg[row][col]>max) {
						max=strg[row][col];
					}
				}
			}
		}
		return max;
	}
	public static boolean wordbreak(String str,Set<String> set) {
		
		int n = str.length();
		boolean[][] strg = new boolean[n][n];

		for (int slide = 1; slide <= n; slide++) {
			for (int si = 0; si <= n - slide ; si++) {
				int ei = si + slide -1;
				String s=str.substring(si,ei+1);
				if(set.contains(s)) {
					strg[si][ei]=true;
					
				}else {
				for (int k = si + 1; k <= ei; k++) {
					if(strg[si][k-1] && strg[k][ei]) {
						strg[si][ei]=true;
					}
	
				}
				}
				
			}
		}
		return strg[0][n - 1];
		
	}
	/**
     * This is slow method but easier to understand.
     * Time complexity is O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
     */
	public static int stockBuySell(int []price,int k) {
		if(k==0 || price.length==0) {
			return 0;
		}
		if(k>=price.length) {
			return localMin(price,k);
		}
		int strg[][]=new int[k+1][price.length];
		for(int i=1;i<strg.length;i++) {
			for(int j=1;j<strg[0].length;j++) {
				int maxvalue=0;
				for(int m=0;m<j;m++) {
					maxvalue=Math.max(maxvalue,price[j]-price[m]+strg[i-1][m]);
				}
				strg[i][j]=Math.max(strg[i][j-1], maxvalue);
			}
		}
		return strg[k][price.length-1];
		
	}
	public static int localMin(int []price,int k) {
		int profit=0;
		int localmin=price[0];
		for(int i=1;i<price.length;i++) {
			if(price[i-1]>=price[i]) {
				localmin=price[i];
			}else {
				profit+=price[i]-localmin;
				localmin=price[i];
			}
		}
		return profit;
	}
	/**
     * This is faster method which does optimization on slower method
     * Time complexity here is O(K * number of days)
     *
     * Formula is
     * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
     * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
     */
	/*
	 	Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int k=sc.nextInt();
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    System.out.println();
		}
	 */
	public static int stockBuySellfaster(int []price,int k) {
		if(k==0 || price.length==0) {
			return 0;
		}
		if(k>=price.length) {
			return localMin(price,k);
		}
		int strg[][]=new int[k+1][price.length];
		for(int i=1;i<strg.length;i++) {
			int maxdiff=-price[0];
			for(int j=1;j<strg[0].length;j++) {
                    strg[i][j]=Math.max(strg[i][j-1], maxdiff+price[j]);
					maxdiff=Math.max(maxdiff,strg[i-1][j]-price[j]);
	
				
			}
		}
		return strg[k][price.length-1];
		
	}
	// usinng dp time=o(n2) and space o(n)
	public static int jumptoend(int arr[]) {
		int jump[]=new int[arr.length];
		jump[0]=0;
		for(int i=1;i<arr.length;i++) {
			jump[i]=Integer.MAX_VALUE;
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(i<=j+arr[j]) {
					jump[i]=Math.min(jump[i],jump[j]+1);
				}
			}
		}
		return jump[arr.length-1];
	}
	// other mathod o(n)
	public static int jumptoendlinear(int arr[]) {
	    if(arr[0]==0){
	        return-1;
	    }
		
	    int stair=arr[0];
	    int ladder=arr[0];
	    int jump=1;
		for(int level=1;level<arr.length;level++) {
		    if(level==arr.length-1){
		        return jump;
		    }
		    if(level+arr[level]>ladder){
		        ladder=level+arr[level];
		    }
			stair--;
			if(stair==0){
			    jump++;
			    if(level>=ladder){//2 1 0 3 type cases
			        return -1;
			    }
			    stair=ladder-level;
			}
		}
		
		return jump;
	}
	public static String justify(String []word,int width) {
		int cost[][]=new int[word.length][word.length];
		for(int i=0;i<word.length;i++) {
			cost[i][i]=width-word[i].length();
			for(int j=i+1;j<word.length;j++) {
				cost[i][j]=cost[i][j-1]-word[j].length()-1;
			}
		}
		// for squere of cost
		for(int i=0;i<word.length;i++) {
			for(int j=i;j<word.length;j++) {
				if(cost[i][j]<0) {
					cost[i][j]=Integer.MAX_VALUE;
				}else {
					cost[i][j]=(int)Math.pow(2, cost[i][j]);
				}
			}
		}
		//minCost from i to len is found by trying
        //j between i to len and checking which
        //one has min value
		int[] mincost=new int[word.length];
		int []result=new int[word.length];
		for(int i=word.length-1;i>=0;i--) {
			mincost[i]=cost[i][word.length-1];
			result[i]=word.length;
			for(int j=word.length-1;j>i;j--) {
				if(cost[i][j-1]==Integer.MAX_VALUE) {
					continue;
				}else if(mincost[i]>mincost[j]+cost[i][j-1]){
					mincost[i]=mincost[j]+cost[i][j-1];
					result[i]=j;
					
				}
			}
		}
		System.out.println("min cost:="+mincost[0]);
		//finally put all words with new line added in 
        //string buffer and print it.
		StringBuilder sb=new StringBuilder();
		int i=0;
		int j;
			
		while(i<word.length) {
			j=result[i];
			for(int k=i;k<j;k++) {
				sb.append(word[k]+ " ");
			}
			sb.append("\n");
			i=j;
			
		}
			
		return sb.toString();
	}
	
	//weighted job scheduling
	 public static int weightedJob(Job[] jobs) {
		 int []T=new int[jobs.length];
		 Arrays.sort(jobs,new FinishTimeComparator());
		 T[0]=jobs[0].profit;
		 for(int i=1;i<jobs.length;i++) {
			 T[i]=jobs[i].profit;
			 for(int j=0;j<i;j++) {
				 if(jobs[j].finishtime<=jobs[i].starttime) {
					 T[i]=Math.max(T[i],T[j]+jobs[i].profit);
				 }
			 }
		 }
		 int max=Integer.MIN_VALUE;
		 for(int val :T) {
			 if(max<val) {
				 max=val;
			 }
		 }
		return max;
		 
	 }
     
	
}
class Job{
	int starttime;
	int finishtime;
	int profit;
	Job(int s,int f,int p){
		this.finishtime=f;
		this.starttime=s;
		this.profit=p;
	}
}
 class FinishTimeComparator implements Comparator<Job>{

	@Override
	public int compare(Job tjob, Job ojob) {
		return tjob.finishtime-ojob.finishtime;
	}
//	public int compare(Job arg0, Job arg1) {
//        if(arg0.finishtime <= arg1.finishtime){
//            return -1;
//        }else{
//            return 1;
//        }
//    }
	//Given an array of positive number, find maximum sum subsequence such that
	//elements in this subsequence are not adjacent to each other.
	public static int maxsum(int[] arr){
	     int incl=arr[0];
	     int excl=0;
	     for(int i=1;i<arr.length;i++){
	        int temp=incl;
	        incl=Math.max(incl,excl+arr[i]);
	        excl=temp;
	        
	     }
	     return incl;
	     
	 }
	
	 
 }
