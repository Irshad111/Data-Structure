package Tree;

public class TriesClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries tr=new Tries();
		tr.addWord("art");
		tr.addWord("arts");
		tr.addWord("bug");
		tr.addWord("boy");
		tr.addWord("amit");
		tr.addWord("see");
		tr.addWord("sea");
		tr.display();
		System.out.println(tr.search("art"));
		System.out.println(tr.search("ik"));
		tr.remove("art");
		System.out.println(tr.numWord());
		tr.remove("arts");
		System.out.println(tr.numWord());
		

	}

}
