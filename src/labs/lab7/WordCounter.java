package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A program that reads text from a file and breaks it up into individual words,
 * inserts the words into a tree set, and allows you to get stats about the
 * words.
 */
public class WordCounter {
	private TreeSet<String> uniqueWords = new TreeSet<String>();
	// FILL IN ANY OTHER PRIVATE INSTANCE VARIABLES YOU NEED HERE
	String filename;
	private List<String> allWords =  new ArrayList<String>();

	/**
	 * Constructor
	 * 
	 * @param filename file from which to read words
	 */
	public WordCounter(String filename) {
		this.filename=filename;
		try {
			Scanner in = new Scanner(new File(filename));
			while(in.hasNext()) {
				String s = in.next();
				allWords.add(s);
				uniqueWords.add(s.replaceAll("[^a-zA-Z0-9]","").toLowerCase());
			}
		}catch(FileNotFoundException e) {
			System.out.print("File: "+filename+" not found");
		}
	}


	/**
	 * Returns the number of unique words in the file
	 * 
	 * @return number of unique words
	 */
	public int getNumUniqueWords() {
		return uniqueWords.size(); // FIX ME
	}


	/**
	 * Returns the number of words in the file
	 * 
	 * @return number of words
	 */
	public int getNumWords() {
		return allWords.size(); // FIX ME
	}


	/**
	 * returns a list of the unique words with all non-letter and non-digit
	 * characters removed, all in lower case, as a List in alphabetical order
	 * 
	 * @return list of unique words
	 */
	public List<String> getUniqueWords() {
		ArrayList<String> uniqueWordsList = new ArrayList<>(uniqueWords);
		return uniqueWordsList; // FIX ME
	}
	
	
}
