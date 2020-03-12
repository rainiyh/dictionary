import java.util.*;
import java.io.*;
import java.util.Scanner;


public class Dictionary {
	public static void main(String[] args) throws Exception {
		// Instantiate our dictionary as an array list of the class Definitions
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

///////////////////////////////////////////////
		//*THIS IS THE EDIT WORD DEFINITION FUNCTION*
		//Get the word that we will change from the user
		Scanner myWord = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Which word do you want to edit the definition of?:");
		String thisWord = myWord.nextLine();  // Read user input

		//Get the new definition from the user for that word
		System.out.println("What do you want to set the new definition to:");
		String thisDef = myWord.nextLine();  // Read user input

		//Get the index of that specific word in the dictionary
		int thisIndex = 0;
		boolean notInDict = true;
		for (int i = 0; i< dictionary.size();) {
			if (dictionary.get(i).word.equals(thisWord)) {
				thisIndex =  i;
				notInDict = false;
				break;
			}
			i++;
		}
		//If that word isn't in the dictionary, then output this
		if (notInDict == true)
			System.out.println("That word is not in the dictionary!");
		//If that word is in the dictionary, then replace the definition with the new inputted one
		else
		dictionary.get(thisIndex).setDefinition(thisDef);

		////////////////////////////////////////


		// Loop through the dictionary (for each definition object in the dictionary)
		for (Definition def : dictionary) {
			System.out.println(def.word + ": " + def.definition);

			sc.close();  //closes the scanner
		}
	}
}

