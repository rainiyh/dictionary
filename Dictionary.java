import java.util.*;

public class Dictionary {
	public static void main(String[] args) {
		ArrayList<Definition> dictionary = new ArrayList<Definition>();
		dictionary.add(new Definition("school", "learning establishment"));
		dictionary.add(new Definition("table", "raised flat surface for working or placing objects"));
		
		for (Definition def : dictionary) {
			System.out.println(def.word + ": " + def.definition);
		}
	}
}
