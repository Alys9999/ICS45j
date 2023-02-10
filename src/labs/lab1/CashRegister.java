package labs.lab1;

/**
 * A cash register totals up sales and computes change due.
 */
public class CashRegister {
	private double purchase;
	private double payment;
	private int it;
	private double sales;
	private int salesCount;
	private String his;

	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister() {
		purchase = 0;
		payment = 0;
		it=0;
		sales=0;
		salesCount=0;
		his="";
		
	}

	/**
	 * Records the sale of an item.
	 * 
	 * @param amount the price of the item
	 */
	public void recordPurchase(double amount) {
		String s =String.valueOf(amount);
		his=his+s+"\n";
		purchase = purchase + amount;
		it++;
	}

	/**
	 * Processes a payment received from the customer.
	 * 
	 * @param amount the amount of the payment
	 */
	public void receivePayment(double amount) {
		
		payment = payment + amount;
	}

	/**
	 * Computes the change due and resets the machine for the next customer.
	 * 
	 * @return the change due to the customer
	 */
	public double giveChange() {
		double change = payment - purchase;
		sales = sales+purchase;
		salesCount++;
		purchase = 0;
		payment = 0;
		return change;
	}
	

	/**
	 * Returns count of items purchased.
	 * 
	 * @return count of items purchased
	 */
	public int getItemCountInPurchase() {
		return it;
	}

	/**
	 * Get the total amount of all sales for the day.
	 * 
	 * @return the total amount of all sales for the day
	 */
	public double getSalesTotal() {
		return sales;
	}

	/**
	 * Get the total number of sales for the day.
	 * 
	 * @return the number of sales for the day
	 */
	public int getSalesCount() {
		return salesCount;
	}

	/**
	 * Reset counters and totals for the next day's sales.
	 */
	public void reset() {
		purchase = 0;
		payment = 0;
		it=0;
		sales=0;
		salesCount=0;
	}

	public String getReceipt() {
		// WRITE YOUR CODE HERE 
		return his+purchase; // FIX ME
	}
}
