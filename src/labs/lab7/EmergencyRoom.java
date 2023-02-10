package labs.lab7;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class EmergencyRoom {

	private PriorityQueue<Patient> patients;


	public EmergencyRoom() {
		patients= new PriorityQueue<Patient>();
	}


	/**
	 * Adds a patient to the ER queue with the given injury and description
	 * 
	 * @param injury
	 * @param description
	 */
	public void addPatient(Injury injury, String description) {
		patients.add(new Patient(injury, description));
	}


	/**
	 * Gets the next highest priority patient
	 */
	public Patient nextPatient() {
		try {
			return patients.remove(); // FIX ME
		}catch (NoSuchElementException e) {
			return null;
		}
		
	}
	
	public static void main(String args[]){
		EmergencyRoom er = new EmergencyRoom();
		
		er.addPatient(Injury.ABDOMINAL_PAIN, "18 year old says stomach hurts");
		er.addPatient(Injury.BURN, "Person burned hand while cooking dinner");
		er.addPatient(Injury.CHEST_PAIN, "63 year old has chest pain");
		er.addPatient(Injury.FRACTURE, "10 year old hurt knee while playing soccer, possible fracture");
		er.addPatient(Injury.HEMORRHAGE, "23 year old complaining of paper cut");
		er.addPatient(Injury.OTHER, "UCI student with a hangnail");
		
		System.out.println(er.nextPatient().getInjury());
	}
}