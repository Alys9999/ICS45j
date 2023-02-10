package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * A class to improve a piece of text by replacing over-used words with better
 * word choices
 */
public class TextImprover {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String wordMapFileName;

	/**
	 * Constructor
	 * 
	 * @param wordMapFileName	name of the file containing the over-used words and their replacements
	 */
	public TextImprover(String wordMapFileName) {
		this.wordMapFileName=wordMapFileName;
	}


	/**
	 * Replaces all of the over-used words in the given file with better words, based on the word map
	 * used to create this TextImprover
	 * 
	 * @param fileName	name of the file containing the text to be improved
	 */
	public void improveText(String fileName) {
		try(Scanner map = new Scanner(new File(wordMapFileName))) {
			List<String[]> combo = new ArrayList<String[]>();
			while (map.hasNextLine()) {
				String[] aLine = map.nextLine().split("\\s+");
				combo.add(aLine);
			}
			try (Scanner file = new Scanner(new File(fileName))) {
				List<String[]> allTexts = new ArrayList();
				while(file.hasNextLine()) {
					String[] word = file.nextLine().split("\\s+");
					allTexts.add(word);
						}
				PrintWriter out = new PrintWriter(fileName);
				for (int i=0; i<allTexts.size();i++) {
					for (int n=0; n<allTexts.get(i).length;n++)
						for (int j=0; j<combo.size(); j++) {
							String fin = allTexts.get(i)[n].replaceAll("[^A-Za-z]","");							
							if (fin.toLowerCase().equals(combo.get(j)[0])) {
								if (allTexts.get(i)[n].equals(allTexts.get(i)[n].toUpperCase())) {
									allTexts.get(i)[n]=(allTexts.get(i)[n].replace(fin, combo.get(j)[1].toUpperCase()));
								}
								else if (Character.isUpperCase(fin.charAt(0))) {
									allTexts.get(i)[n]=(allTexts.get(i)[n].replace(fin, combo.get(j)[1].substring(0,1).toUpperCase()+combo.get(j)[1].substring(1)));
								}else {
								allTexts.get(i)[n]=(allTexts.get(i)[n].replace(fin, combo.get(j)[1]));
								
								}
								
							}
						}
					
				}
				for (int x =0; x<allTexts.size();x++) {
					for (int m = 0; m<allTexts.get(x).length;m++) {
						out.print(allTexts.get(x)[m]+" ");
					}
					out.println();
				}
				
				out.close();
				
				
			}catch(FileNotFoundException e){
				System.out.print("File: " + fileName + " not found");
			}
		}catch(FileNotFoundException e){
			System.out.print("File: " + wordMapFileName + " not found");
			
		}
		
	}
	
	
}