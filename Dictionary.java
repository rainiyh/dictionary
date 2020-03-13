import java.util.*;
import java.io.*;
import java.util.Scanner;


public class Dictionary {

	public static ArrayList<Definition> dictionary;

	public static void main(String[] args) throws IOException {
		// Instantiate our dictionary as an array list of the class Definitions
		dictionary = new ArrayList<Definition>();

		// Add some definitions to the dictionary
		dictionary.add(new Definition("table", "raised flat surface for working or placing objects"));
		dictionary.add(new Definition("school", "learning establishment"));

		// Read from CSV
		readCSV("table.csv");

		//Get the word that we will change from the user
		Scanner myWord = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Which word do you want to edit the definition of?: ");
		String thisWord = myWord.nextLine();  // Read user input

		//Get the new definition from the user for that word
		System.out.println("What do you want to set the new definition to: ");
		String newDef = myWord.nextLine();  // Read user input

		//Replace the definition
		updateDef(thisWord, newDef);

		// Loop through the dictionary and print each word and definition
		for (Definition def : dictionary) {
			System.out.println(def.word + ": " + def.definition);
		}

		// Close the scanner
		myWord.close();
	}

	// Search
	public static int findWord(String s) {
		//Get the index of that specific word in the dictionary
		for (int i = 0; i < dictionary.size(); i++) {
			if (dictionary.get(i).word.equals(s))
				return i;
		}
		//If that word hasn't been found in the dictionary, return -1
		return -1;
	}

	// Read from CSV file
	public static void readCSV(String csv) throws FileNotFoundException {
		//parse a CSV file into Scanner class constructor
		//THE table.csv text file must be in the same directory as the project, not the actual .java file
		Scanner sc = new Scanner(new File(csv));
		sc.useDelimiter(",");   //sets the delimiter pattern

		//Scan CSV into tokens, add everything to dictionary
		while (sc.hasNext())
			dictionary.add(new Definition(sc.next(), sc.next()));

		// Close the scanner
		sc.close();
	}

	public static void updateDef(String word, String newDef) {
		// Find the index of word and replace its definition
		if (findWord(word) >= 0) {
			dictionary.get(findWord(word)).setDefinition(newDef);
			System.out.println("Definition updated.");
		} else {
			System.out.println("Word not found in dictionary!");
		}
	}
}

