package Tree;

import java.util.HashMap;

public class Tries {
	private class Node {
		char data;
		HashMap<Character, Node> children;
		boolean isTerminal;

		Node(char data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();

		}
	}

	private Node root;
	private int numWords;

	public Tries() {
		this.numWords = 0;
		this.root = new Node('\0', false);
	}

	public int numWord() {
		return this.numWords;
	}

	public void addWord(String word) {
		addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal == false) {
				parent.isTerminal = true;
				this.numWords++;
			}
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);

		if (child == null) {
			child = new Node(ch, false);
			parent.children.put(ch, child);
		}
		addWord(child, ros);
	}

	public void display() {
		display(this.root, "");
	}

	private void display(Node node, String str) {
		if (node.isTerminal) {
			System.out.println(str);
		}
		for (Character key : node.children.keySet()) {
			display(node.children.get(key), str + key);
		}

	}

	public boolean search(String word) {
		return search(this.root, word);
	}

	private boolean search(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				return true;
			} else {
				return false;
			}
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);

		if (child == null) {
			return false;
		}
		return search(child, ros);

	}

	public void remove(String word) {
		remove(this.root, word);
	}

	private void remove(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				parent.isTerminal = false;
				this.numWords--;
			}
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);

		if (child == null) {
			return;
		}
		remove(child, ros);
		if (!child.isTerminal && child.children.size() == 0) {//last node not teminal and it's not have further children
			parent.children.remove(ch);
		}
	}

}
