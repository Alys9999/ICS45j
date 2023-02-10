package labs.lab7;

/**
 * Class representing a patient in a hospital emergency room
 */
public class Patient implements Comparable<Patient> {

	// ADD YOUR INSTANCE VARIABLES HERE
	Injury injury;
	String description;

	/**
	 * Creates a new Patient object with the given injury and description
	 */
	public Patient(Injury injury, String description) {
		this.injury=injury;
		this.description=description;
	}


	public int getPriority() {
		return injury.getTriageLevel(injury); // FIX ME
	}


	public Injury getInjury() {
		return injury; // FIX ME
	}


	public String getDescription() {
		return description; // FIX ME
	}


	/**
	 * Compares patients by priority
	 */
	@Override
	public int compareTo(Patient p) {
		if (this.getPriority()<p.getPriority()) {
			return -1;
		}else if (this.getPriority()>p.getPriority()) {
			return 1;
		}
		return 0; // FIX ME
	}
	
	
	/**
	 * Returns a string representation of this patient in the format:
	 * "Injury: [INJURY], Description: [DESCRIPTION]"
	 */
	@Override
	public String toString() {
		return "Injury: "+injury+", Description: "+description; // FIX ME
	}

}