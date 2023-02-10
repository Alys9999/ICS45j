package labs.lab5;

public class Drink extends GameElement implements Ingestible {
		
	/**
	 * 
	 * @param name
	 * @param healthScore	
	 */
	public Drink(String name, double healthScore) {
		super(name, healthScore);
	}
	
	
	/**
	 * For every this.healthScore point above 5, adds 0.05 to the player's health.
	 * For every this.healthScore point below 5, subtracts 0.05 from the player's health.
	 * If this.healthScore == 5, makes no change to the player's health
	 */
	@Override
	public String ingest(Player player) {
		player.setHealth(player.getHealth()+(this.getHealthScore()-5.0)*0.05);
		return player.getName()+" is drinking "+this.getName(); // FIX ME
	}
}