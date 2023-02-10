package labs.lab4;

/**
 * A magazine item in a library
 */
public class Magazine extends LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int issueNumber;
	private String publicationDate;

	
	/**
	 * Constructor
	 * 
	 * @param title				magazine title
	 * @param issueNumber		magazine issue number
	 * @param publicationDate	magazine publication date
	 */
	public Magazine(String title, int issueNumber, String publicationDate) {
		super(title);
		this.issueNumber=issueNumber;
		this.publicationDate=publicationDate;
	}
	
	
	public int getIssueNumber() {
		return issueNumber; // FIX ME
	}
	
	
	public void setIssueNumber(int issueNumber) {
		this.issueNumber=issueNumber;
	}

	
	public String getPublicationDate() {
		return publicationDate; // FIX ME
	}

	
	public void setPublicationDate(String publicationDate) {
		this.publicationDate=publicationDate;
	}
	
	
	/**
	 * If this item is not already checked out, this method checks this item out and 
	 * returns the loan period; if it is already checked out, returns the String 
	 * "NOT ALLOWED"; overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (super.isCheckedOut()) {
			return "NOT ALLOWED";
		}else {
			super.setCheckedOut(true);
			return "7 days";
		}
	}
	
	
	/**
	 * Returns true if the parameter object is a Magazine that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		if (otherObject instanceof Magazine) {
			Magazine other = (Magazine)otherObject;
			return issueNumber==other.getIssueNumber()&&publicationDate.equals(other.getPublicationDate());
		}
		return false;
	}
}