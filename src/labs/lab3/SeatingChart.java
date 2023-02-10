package labs.lab3;

/**
 * A theater seating chart implemented as a 2-d array of ticket prices
 */
public class SeatingChart {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int[][] seatingchart= {
		{40, 50, 50, 50, 40},
		{30, 40, 40, 40, 30},
		{20, 30, 30, 30, 20},
		{10, 20, 20, 20, 10},
		{10, 10, 10, 10, 10}
		
	};

	/**
	 * Returns a string that represents the price of seats in a grid-like pattern.
	 */
	public String getSeatingChart() {
		String res = "";
		for (int[] i:seatingchart) {
			res=res+String.format("%2s",i[0]);
			for (int j=1;j<i.length;j++) {
				res+=String.format("%3s",i[j]);
			}
			res+="\n";
		}
		return res; // FIX ME
	}

	
	/**
	 * Goes from left to right and front to back to find a seat with the specified
	 * price, then, if found, sets its price to 0 to mark it as sold. If no seat 
	 * is found with the specified price, the seating chart remains unchanged. 
	 * Assume all inputs are valid ints.
	 * 
	 * @param price the price to mark to zero
	 */
	public String change(int price) {
		for (int i=0;i<5;i++) {
			for (int j=0; j<5;j++) {
				if (seatingchart[i][j]==price) {
					seatingchart[i][j]=0;
					return null;
				}	
			}
			
		}
		return null;
	}
	
	public void sellSeatByPrice(int price) {
		change(price);
	}

	
	/**
	 * Marks the specified seat as sold by setting its price to 0. If the seat 
	 * doesn't exist, the seating chart remains unchanged. Valid rows are A through 
	 * E, case sensitive (A is the front row, E is the back row). Valid seats are 1 
	 * through 5 (if facing the front/stage, 1 is the leftmost seat, 5 is the 
	 * rightmost seat). Assume all inputs are valid chars and ints.
	 */
	public void sellSeatByNumber(char row, int seat) {
		if (seat<=5&&seat>=0) {
			switch (row) {
			case 'A': seatingchart[0][seat-1]=0;
			break;
			case 'B': seatingchart[1][seat-1]=0;
			break;
			case 'C': seatingchart[2][seat-1]=0;
			break;
			case 'D': seatingchart[3][seat-1]=0;
			break;
			case 'E': seatingchart[4][seat-1]=0;
			break;
			}
				
				
				
		}
	}
}
