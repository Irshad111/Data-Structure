package Recursion;

import java.util.ArrayList;

public class RecursionGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(getss("abc"));
		// System.out.println(kpc("123"));
		// System.out.println(permutation("abc"));
		// System.out.println(getBoardPath(0,10));
		// System.out.println(coinToss(2));
		//System.out.println(mazePath(0, 0, 1, 1));
		//System.out.println(mazePathD(0, 0, 1, 1));
		//System.out.println(mazePathML(0, 0, 1, 1));

	}

	public static ArrayList<String> getss(String str) {
		if (str.length() == 0) {
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;

		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recres = getss(ros);
		ArrayList<String> ans = new ArrayList<>();
		for (String val : recres) {
			ans.add(val);
			ans.add(ch + val);
		}
		return ans;

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> kpc(String str) {
		if (str.length() == 0) {
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;

		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		String code = getCode(ch);
		ArrayList<String> recres = kpc(ros);
		ArrayList<String> ans = new ArrayList<>();
		for (String val : recres) {
			for (int i = 0; i < code.length(); i++) {
				ans.add(code.charAt(i) + val);
			}
		}
		return ans;
	}

	public static ArrayList<String> permutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> basres = new ArrayList<>();
			basres.add("");
			return basres;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recres = permutation(ros);
		ArrayList<String> ans = new ArrayList<>();
		for (String val : recres) {
			for (int i = 0; i <= val.length(); i++) {
				ans.add(val.substring(0, i) + ch + val.substring(i));
			}

		}
		return ans;
	}

	public static ArrayList<String> getBoardPath(int curr, int end) {
		if (curr == end) {
			ArrayList<String> bres = new ArrayList<>();
			bres.add("\n");
			return bres;
		}
		if (curr > end) {
			ArrayList<String> bres = new ArrayList<>();
			return bres;
		}
		ArrayList<String> myans = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> recres = getBoardPath(curr + dice, end);
			for (String val : recres) {
				myans.add(dice + val);
			}
		}
		return myans;
	}

	public static ArrayList<String> coinToss(int n) {
		if (n == 0) {
			ArrayList<String> bares = new ArrayList<>();
			bares.add("");
			return bares;
		}
		ArrayList<String> myans = new ArrayList<>();
		ArrayList<String> recres = coinToss(n - 1);
		for (String val : recres) {
			myans.add("H" + val);
			myans.add("T" + val);
		}
		return myans;
	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> bsres = new ArrayList<>();
			bsres.add("");
			return bsres;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> bsres = new ArrayList<>();
			return bsres;
		}
		ArrayList<String> myans = new ArrayList<>();
		ArrayList<String> recresh = mazePath(cr, cc + 1, er, ec);
		for (String val : recresh) {
			myans.add("H" + val);
		}
		ArrayList<String> recresv = mazePath(cr + 1, cc, er, ec);
		for (String val : recresv) {
			myans.add("V" + val);
		}
		return myans;
	}

	public static ArrayList<String> mazePathD(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> bsres = new ArrayList<>();
			bsres.add("");
			return bsres;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> bsres = new ArrayList<>();
			return bsres;
		}
		ArrayList<String> myans = new ArrayList<>();
		ArrayList<String> recresh = mazePathD(cr, cc + 1, er, ec);
		for (String val : recresh) {
			myans.add("H" + val);
		}
		ArrayList<String> recresv = mazePathD(cr + 1, cc, er, ec);
		for (String val : recresv) {
			myans.add("V" + val);
		}
		ArrayList<String> recresd = mazePathD(cr + 1, cc + 1, er, ec);
		for (String val : recresd) {
			myans.add("D" + val);
		}
		return myans;
	}
	public static ArrayList<String> mazePathML(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> bsres = new ArrayList<>();
			bsres.add("");
			return bsres;
		}
		ArrayList<String> myans = new ArrayList<>();
		
		
		for(int move=1;move<=ec-cc;move++) 
		{
		ArrayList<String> recresh = mazePathML(cr, cc + move, er, ec);
		for (String val : recresh) {
			myans.add("H" + move+ val);
		}
		
		}
		
		for(int move=1;move<=er-cr;move++) {
		ArrayList<String> recresv = mazePathML(cr + move, cc, er, ec);
		for (String val : recresv) {
			myans.add("V" +move+val);
		}
		}
		for(int move=1;move<=(er-cr)&&move<=(ec-cc);move++) {

		ArrayList<String> recresd = mazePathML(cr + move, cc + move, er, ec);
		for (String val : recresd) {
			myans.add("D" +move+ val);
		}
	}
		return myans;
	}
}
