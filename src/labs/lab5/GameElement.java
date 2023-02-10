package labs.lab5;

public abstract class GameElement {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	private String name;
	private double healthScore;
	
	/**
	 * 
	 * @param name
	 * @param healthScore	from 0 (least healthy) to 10 (most healthy)
	 * 						(If below 0, sets it to 0; if above 10, sets it to 10)
	 */						
	public GameElement(String name, double healthScore) {
		this.name=name;
		this.healthScore=healthScore;
		if (this.healthScore<0.0) {
			this.healthScore=0.0;
		}else if (this.healthScore>10.0) {
			this.healthScore=10.0;
		}
	}
	
	
	public String getName() {
		return name; // FIX ME
	}
	
	
	public double getHealthScore() {
		return healthScore; // FIX ME
	}
}