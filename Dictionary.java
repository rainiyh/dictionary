import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Dictionary {

	public static ArrayList<Definition> dictionary;

	public static void main(String[] args) throws IOException {
		// Instantiate our dictionary as an array list of the class Definitions
		dictionary = new ArrayList<Definition>();

		// Read from CSV
		readCSV("words.txt");
		
		// Add scanner
		Scanner myWord = new Scanner(System.in);  // Create a Scanner object
		
		// Get the word to search
		System.out.println("Search any text: ");
		String asdf = myWord.nextLine();
		ArrayList<Definition> list = findList(asdf);
		for (Definition d : list) {
			System.out.println(d.word + ": " + d.definition);
		}
		
		/* Get the word to remove
		System.out.println("Which word to remove: ");
		String word = myWord.nextLine();
		removeDef(word);

		//Get the word that we will change from the user
		System.out.println("Which word do you want to edit the definition of: ");
		String thisWord = myWord.nextLine();  // Read user input

		//Get the new definition from the user for that word
		System.out.println("What do you want to set the new definition to: ");
		String newDef = myWord.nextLine();  // Read user input

		//Replace the definition
		updateDef(thisWord, newDef);

		// Loop through the dictionary and print each word and definition
		for (Definition def : dictionary) {
			System.out.println(def.word + ": " + def.definition);
		}*/

		// Close the scanner
		myWord.close();
	}

	public static int findExact(String s) {
		//Get the index of that specific word in the dictionary
		for (int i = 0; i < dictionary.size(); i++) {
			if (dictionary.get(i).word.equalsIgnoreCase(s))
				return i;
		}
		//If that word hasn't been found in the dictionary, return -1
		return -1;
	}
	
	public static ArrayList<Definition> findList(String s) {
		// Return the list of all definitions that match the search
		ArrayList<Definition> subDefinition = new ArrayList<Definition>();
		for (int i = 0; i < dictionary.size(); i++) {
			if (dictionary.get(i).word.toLowerCase().contains(s.toLowerCase())) {
				subDefinition.add(dictionary.get(i));
			}
		}
		
		return subDefinition;
	}

	// Read from CSV file
	public static void readCSV(String csv) throws FileNotFoundException {
		//parse a CSV file into Scanner class constructor
		//THE table.csv text file must be in the same directory as the project, not the actual .java file
		Scanner sc = new Scanner(new File(csv));
		sc.useDelimiter(Pattern.compile("[\n,]"));   //sets the delimiter pattern

		//Scan CSV into tokens, add everything to dictionary
		while (sc.hasNext()) {
			try {
				dictionary.add(new Definition(sc.next(), sc.next()));
			} catch (NoSuchElementException e) {}
		}

		// Close the scanner
		sc.close();
	}

	public static void updateDef(String word, String newDef) {
		// Find the index of word and replace its definition
		if (findExact(word) >= 0) {
			dictionary.get(findExact(word)).setDefinition(newDef);
			System.out.println("Definition updated.");
		} else {
			System.out.println("Word not found in dictionary!");
		}
	}
	
	// Add definition
	public static void addDef(String word, String newDef) {
		dictionary.add(new Definition(word, newDef));
	}
	
	// Remove definition
	public static void removeDef(String word) {
		dictionary.remove(findExact(word));
	}
}

