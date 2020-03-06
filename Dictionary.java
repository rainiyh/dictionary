import java.util.*;

public class Dictionary {
	public static void main(String[] args) {
		// Instantiate our dictionary
		ArrayList<Definition> dictionary = new ArrayList<Definition>();
		
		// Add definitions to the dictionary
		dictionary.add(new Definition("school", "learning establishment"));
		dictionary.add(new Definition("table", "raised flat surface for working or placing objects"));
		
		// Loop through the dictionary (for each definition object in the dictionary)
		for (Definition def : dictionary) {
			System.out.println(def.word + ": " + def.definition);
		}
	}
}