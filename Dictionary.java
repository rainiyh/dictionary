import java.util.*;
import java.io.*;
import java.util.Scanner;


public class Dictionary {
	public static void main(String[] args) throws Exception {
		// Instantiate our dictionary
		ArrayList<Definition> dictionary = new ArrayList<Definition>();

		// Add definitions to the dictionary
		dictionary.add(new Definition("school", "learning establishment"));
		dictionary.add(new Definition("table", "raised flat surface for working or placing objects"));

//parsing a CSV file into Scanner class constructor
		//THE table.csv text file must be in the same directory as the project, not the actual .java file
		Scanner sc = new Scanner(new File("table.csv"));
		sc.useDelimiter(",");   //sets the delimiter pattern
		int contentNum = 1;
		while (sc.hasNext())  //returns a boolean value


			dictionary.add(new Definition(sc.next(), sc.next()));
		//find and returns the next complete token from this scanner


		// Loop through the dictionary (for each definition object in the dictionary)
		for (Definition def : dictionary) {
			System.out.println(def.word + ": " + def.definition);

			sc.close();  //closes the scanner
		}
	}
}

