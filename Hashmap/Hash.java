package Hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Hash {
	public static void main(String[] arg) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		System.out.println(map);
		map.put("e", 2);
		System.out.println(map);
		System.out.println(map.get("e"));
		System.out.println(map.containsKey("e"));
		System.out.println(map.containsValue(2));
		ArrayList<Integer> list = new ArrayList<>(map.values());
		System.out.println(list);
		//Set<String> set = map.keySet();
		System.out.println("---------------------");
		for (String key : map.keySet()) {
			System.out.println(key + ">" + map.get(key));
		}
		System.out.println(maxFreqChar("bababa"));
		int arr1[] = { 10, 10,10, 60, 70 };
		int arr2[] = { 10,70,10 };
		ArrayList<Integer> ans = intersection(arr1, arr2);
		for (int i : ans)
			System.out.println(i);
		System.out.println(map.get("b"));
	}

	public static char maxFreqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else
				map.put(ch, 1);
		}
		int max = Integer.MIN_VALUE;
		char ch = ' ';
		// Set<Character> set=map.keySet();
		for (char key : map.keySet()) {
			if (max < map.get(key)) {
				max = map.get(key);
				ch = key;
			}
		}
		return ch;
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			int val = one[i];
			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			}
			else
			map.put(val, 1);
		}
		for (int i = 0; i < two.length; i++) {
			int val = two[i];
			if (map.containsKey(val) && map.get(val) > 0) {
				ans.add(val);
				map.put(val, map.get(val) - 1);
			}
		}

		return ans;
	}
}
