package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProductDB {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private String productsFileName;

	/**
	 * Constructor that reads in the product data from a file
	 * 
	 * @param productsFileName name of file with product data
	 */
	public ProductDB(String productsFileName) {
		this.productsFileName=productsFileName;
		try {
			Scanner in = new Scanner(new File(productsFileName));
		} catch (FileNotFoundException e) {
			System.out.print("File: "+productsFileName+" not found");
			
		}
	}


	/**
	 * Searches for the product with the given name and returns it if found,
	 * otherwise returns null.
	 * 
	 * @param productName name of product to search for
	 * 
	 * @return product with given name, or null if not found
	 */
	public Product findProduct(String productName) {
		Product res = null;
		try {
			Scanner in = new Scanner(new File(productsFileName));
			while(in.hasNextLine()) {
				String[] aLine = in.nextLine().split(";");
				if (aLine[0].equals(productName)){
					res = new Product(aLine[0],Double.valueOf(aLine[1]),Integer.valueOf(aLine[2]));
				}
						}
		} catch (FileNotFoundException e) {
			System.out.print("File: "+productsFileName+" not found");
			
		}
		return res; // FIX ME
	}


	/**
	 * Adds a new product to the products DB if a product with the given name
	 * doesn't already exist
	 * 
	 * @param name     name of product
	 * @param price    price of product
	 * @param quantity quantity of product
	 * @throws IOException 
	 */
	public void addProduct(String name, double price, int quantity) throws IOException {
		if (findProduct(name)==null){
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(productsFileName,true));
				pw.println(name+";"+price+";"+quantity);
				pw.flush();
				
			} catch (FileNotFoundException e) {
				System.out.print("File: "+productsFileName+" not found");
			}
			
		}
	}
	public static void main (String args[]) {
		String nonExistentFileName = "src/nothing.txt";
		ProductDB db2 = new ProductDB(nonExistentFileName);
	}
}
