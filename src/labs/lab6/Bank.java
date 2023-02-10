package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A bank contains account numbers and balances of each customer.
 */
public class Bank {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String fileName;

	/**
	 * Construct a Bank object with accounts read from the given file
	 * 
	 * @param filename the name of the file
	 */
	public Bank(String fileName) {
		this.fileName=fileName;
		try {
			Scanner in = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.print("File: "+fileName+" not found");
			
		}
	}


	/**
	 * Gets the account with the lowest balance.
	 * 
	 * @return the account with the lowest balance, or null if there are
	 * no accounts in this bank
	 */
	public BankAccount getLowestBalanceAccount() {
		BankAccount res = null;
		double smallestB=Double.MAX_VALUE;
		int account=0;
		try {
			Scanner in = new Scanner(new File(fileName));
			if (!in.hasNextLine()) {
				return res;
			}
			while(in.hasNextLine()) {
				String[] combo = in.nextLine().split(" ");
				int accNumber = Integer.valueOf(combo[0]);
				double balance = Double.valueOf(combo[1]);
				if (balance<smallestB) {
					smallestB=balance;
					account=accNumber;
				}
				
			}
			res= new BankAccount(account, smallestB);
		} catch (FileNotFoundException e) {
			System.out.print("File: "+fileName+" not found");
			
		}
		return res; // FIX ME
	}
}
