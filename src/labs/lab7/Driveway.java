package labs.lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class for simulating a driveway and a street, using stacks of cars with
 * license plate numbers as representation.
 */
public class Driveway {
	private Stack<Integer> driveway = new Stack<Integer>(); // represents cars in the driveway
	private Stack<Integer> street = new Stack<Integer>(); // represents cars on the street

	/**
	 * Constructor
	 */
	public Driveway() {
		// FILL IN
	}

	
	/**
	 * Returns a String representation of the driveway. For a driveway stack
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string
	 * returned by this method would be: "Driveway: 1 2 3 4"
	 * 
	 * @return	a String representation of this driveway
	 */
	public String getDriveway() {
		String s = "Driveway: ";
		for (int i:driveway) {
			s=s+String.format("%-2s",i);
		}
		s=s.strip();
		
		return s; // FIX ME
	}

	
	/**
	 * Returns a String representation of the street. For a street stack 
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string 
	 * returned by this method would be: "Street: 1 2 3 4"
	 * 
	 * @return	a String representation of the street
	 */
	public String getStreet() {
		String s = "Street: ";
		for (int i:street) {
			s=s+String.format("%-2s",i);
		}
		if (s.length()!=8) {
			s=s.strip();
		}
		return s; // FIX ME
	}

	
	/**
	 * Adds the given license plate to the driveway if it's not already in the
	 * driveway. Returns a log of the process.
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> add(int licensePlate) {
		List<String> res = new ArrayList<String>();
		if (driveway.contains(licensePlate)) {
			res.add("That car is already in the driveway.");
		}else {
			driveway.add(licensePlate);
			res.add(getDriveway());
			res.add(getStreet());
		}
		
		return res; // FIX ME
	}

	/**
	 * Remove the given license plate from the driveway if it's in the driveway.
	 * Returns a log of the process
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> remove(int licensePlate) {
		List<String> res = new ArrayList<String>();
		if (!driveway.contains(licensePlate)) {
			res.add("That car is not in the driveway.");
		}else if(driveway.peek()==licensePlate) {
			driveway.pop();
			res.add(getDriveway());
			res.add(getStreet());
		}
		else{
			while(driveway.peek()!=licensePlate) {
				street.add(driveway.pop());
				res.add(getDriveway());
				res.add(getStreet());
			}
			driveway.pop();
			while (street.size()!=0) {
				driveway.add(street.pop());
				res.add(getDriveway());
				res.add(getStreet());
			}
		}
		if (driveway.peek()==licensePlate) {
			driveway.pop();
			res.add(getDriveway());
			res.add(getStreet());
		}
		
		return res; // FIX ME
	}
	

}
