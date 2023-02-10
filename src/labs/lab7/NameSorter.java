package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


/**
 * Sorts a file of names alphabetically, ignoring case
 */
public class NameSorter {

	// ADD YOUR INSTANCE VARIABLES EHRE
	String inputFile;

	
	/**
	 * Constructs a name sorter with the names from the input file
	 * 
	 * @param inputFile	name of the input file
	 */
	public NameSorter(String inputFile) {
		this.inputFile=inputFile;
	}
	
	
	/**
	 * Sorts the names from the input file alphabetically, ignoring case, 
	 * then writes the sorted names back to the file, overwriting the 
	 * previous content
	 */
	public void sortNames() throws FileNotFoundException{
		Scanner in = new Scanner(new File(inputFile));
		List<String[]> all = new ArrayList<String[]>();
		while(in.hasNextLine()) {
			String[] combo = in.nextLine().split(", ");
			all.add(combo);
		}
		Collections.sort(all,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[1].toLowerCase().compareTo(otherStrings[1].toLowerCase());
            }
        });
		Collections.sort(all,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[0].toLowerCase().compareTo(otherStrings[0].toLowerCase());
            }
        });
		PrintWriter out = new PrintWriter(inputFile);
		for (String[] sa: all) {
			out.println(sa[0]+", "+sa[1]);
		}

		out.close();
		
        }
		


	
	
}