package labs.lab1;

/**
 * A rechargeable battery.
 */
public class Battery {

	private double capa;
	private double maxcapa;

	/**
	 * Create a battery with specified capacity.
	 * 
	 * @param capacity maximum capacity, measured in milliampere hours
	 */
	public Battery(double capacity) {
		capa=capacity;
		maxcapa=capacity;
	}


	/**
	 * Drain capacity of the battery by given amount.
	 * 
	 * @param amount amount of battery used (assume it will not be > its current capacity
	 */
	public void drain(double amount) {
		capa=capa-amount;
	}


	/**
	 * Recharge the battery to maximum capacity.
	 */
	public void charge() {
		capa=maxcapa;
	}


	/**
	 * Retrieve the battery's current capacity.
	 * 
	 * @return remaining capacity
	 */
	public double getRemainingCapacity() {
		return capa;
	}
}
