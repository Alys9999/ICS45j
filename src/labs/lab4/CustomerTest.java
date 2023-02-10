package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	private final double EPSILON = 1e-13;
	
	@Test
	public void testPurchaseLessThan100() {
		Customer c = new Customer();
		c.makePurchase(75);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(75.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testPurchaseMoreThan100() {
		Customer c = new Customer();
		c.makePurchase(175);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(175.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testDiscountApplied() {
		Customer c = new Customer();
		c.makePurchase(175);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(175.0, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(10);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(184.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testPurchaseEarningMultipleDiscounts() {
		Customer c = new Customer();
		c.makePurchase(275);
		assertEquals(2, c.getNumDiscountsToUse());
		assertEquals(275.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testOnlyOneDiscountApplied() {
		Customer c = new Customer();
		c.makePurchase(275);
		assertEquals(2, c.getNumDiscountsToUse());
		assertEquals(275.0, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(10);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(284.0, c.getTotalAmountSpent(), EPSILON);
	}
}
