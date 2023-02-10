package labs.lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class for simulating trading a single stock at varying prices.
 */
public class StockSimulator {

	private Queue<Block> blocks;

	/**
	 * Constructor
	 */
	public StockSimulator() {
		blocks=new LinkedList<Block>();
	}


	/**
	 * Handle a user buying a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to buy.
	 * @param price    the price to buy at.
	 * 
	 * @throws IllegalArgumentException if the requested quantity/price cannot be
	 *                                  sold i.e., quantity <= 0 or price < 0
	 */
	public void buy(int quantity, int price) throws IllegalArgumentException {
		if (quantity<=0 || price<0) {
			throw new IllegalArgumentException("Unable to complete purchase");
		}
		blocks.add(new Block(quantity, price));
	}
	
	
	public int allQ() {
		int res = 0;
		for (Block b: blocks) {
			res=res+b.getQuantity();
		}
		return res;
	}


	/**
	 * Handle a user selling a given quantity of stock at a given price.
	 * 
	 * @param quantity how many to sell.
	 * @param price    the price to sell.
	 * 
	 * @return the gain (can be positive or negative)
	 * 
	 * @throws IllegalArgumentException if the requested quantity cannot be sold
	 *                                  e.g., quantity exceeds quantity owned,
	 *                                  quantity < 1, price < 0
	 */
	public int sell(int quantity, int price) throws IllegalArgumentException {
		if (quantity<1 || price<0 || quantity>allQ()) {
			throw new IllegalArgumentException("Unable to complete sale");
		}
		Block b = blocks.poll();
		if (b.getQuantity()==quantity) {
			return (price-b.getPrice())*quantity;
		}else if (b.getQuantity()>quantity) {
			blocks.add(new Block(b.getQuantity()-quantity,b.getPrice()));
			return (price-b.getPrice())*quantity;
		}else {
			quantity=quantity-b.getQuantity();
			return (price-b.getPrice())*(b.getQuantity())+sell(quantity, price);
				
			}
		}
	


	/**
	 * This is a method for us to test your class
	 * 
	 * @return a List of Blocks owned
	 */
	public List<Block> getBlocks() {
		List<Block> res= new ArrayList<Block>(blocks);
		return res; // FIX ME
	}
	
	

}
