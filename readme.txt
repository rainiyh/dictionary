DATA PROJECT - TOPIC 6 DICTIONARY

Instructions and Setup:

1. Have a Java IDE (such as IntelliJ IDEA) and JDK installed

2. Save all files (Definiton.java, Dictionary.java, and
    words.txt) in the same directory

3. Run the dictionary.java file in the Java IDE

4. Use the command console to Type/Input 'Add','Search','Edit', 
   'Delete','Display', or 'exit' in the command line interface 
    to use the corresponding function in the dictionary program. 
    
5. CLI will keep looping and asking user for an input from the user, 
   until 'exit' is inputted when asked accordingly.



Description:
The purpose of this program is to be able the read a csv file, 
and then store the wordsa and definitions of that file to a
dictionary. This dictionary is built using an arrayList, where
the objects consist of a word and definition. The program has many
functionailties, as the user is able to add, delete, edit, search,
and display the dictionary by inputtign the appropriate word in the
command line interface. 

 

Questions:

Q. How do I exit the program CLI loop?
Answer: Input 'exit' in the CLI 

Q. What if I try to delete/edit a word that doesn't exist in the dictionary?
Answer: Program will output "Word not found!", so the dictionary will remain
unchanged. The user will be asked for another input.

Q. Do I have to keeping restarting the program to test each functionality?
Answer: No, the CLI will automatically ask the user which function they want
to use after each run, unless 'exit' was inputted
