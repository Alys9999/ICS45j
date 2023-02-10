package labs.lab4;

/**
 * An abstract item that can be checked out of a library
 */
public abstract class LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String title;
	private boolean isCheckedOut;
	
	
	/**
	 * Constructor
	 * 
	 * @param title	title of the item
	 */
	public LibraryItem(String title) {
		this.title=title;
		isCheckedOut=false;
	}
	
	
	public String getTitle() {
		return title; // FIX ME
	}
	
	
	public boolean isCheckedOut() {
		return isCheckedOut; // FIX ME
	}
	
	
	public void setCheckedOut(boolean checkedOut) {
		isCheckedOut=checkedOut;
	}
	
	
	/**
	 * Causes this item to be checked out
	 * 
	 * @return	a message about the check out
	 */
	public abstract String checkOut();
	
	
	/**
	 * Causes this item to be checked in
	 */
	public void checkIn() {
		isCheckedOut=false;
	}
	
	
	public String toString() {
		return "title: "+title+"is checked out: "+isCheckedOut; // FIX ME
	}
	
	
	/**
	 * Returns true if the parameter object is a LibraryItem that has the same instance
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof LibraryItem) {
		LibraryItem other = (LibraryItem) otherObject;
		return title.equals(other.getTitle());
		}
		return false;
		
	}
}