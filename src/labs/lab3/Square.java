package labs.lab3;

/**
 * A magic square is an n x n matrix which, if filled with numbers, the sum of
 * the elements in each row, each column, and the two diagonal is the same
 * value.
 */
public class Square {
	private int[][] nums;
	private int sides;
	// ADD YOUR INSTANCE VARIABLES HERE

	/**
	 * Construct a Square object.
	 * 
	 * @param nums	the square array (assume it will always be n x n)
	 */
	public Square(int[][] nums) {
		this.nums=nums;
		for (int[] element:nums) {
			sides++;
		}
	}

	/**
	 * Add the numbers in a row of the square.
	 * 
	 * @param i the row index
	 * @return the sum of the row
	 */
	public int rowSum(int i) {
		int res = 0;
		for (int element:nums[i]) {
			res+=element;
			
			
		}
		return res; // FIX ME
	}

	/**
	 * Add the numbers in a column of the square.
	 * 
	 * @param i the column index
	 * @return the sum of the column
	 */
	public int columnSum(int i) {
		int res = 0;
		for (int[] element:nums) {
			res+=element[i];
		}
		return res; // FIX ME
	}

	/**
	 * Find the sum of the diagonal.
	 * 
	 * @param mainDiagonal true if it is the main diagonal (left/top to right/bottom),
	 * false otherwise (right/top to left/bottom)
	 * 
	 * @return sum the sum of the diagonal
	 */
	public int diagonalSum(boolean mainDiagonal) {
		int res = 0;
		if (mainDiagonal) {
			for (int i = 0; i<nums.length;i++) {
				res+=nums[i][i];
			}
			
		}else {
			for (int i=0; i<nums.length; i++) {
				res+=nums[i][nums.length-1-i];
			}
		}
		return res; // FIX ME
	}

	/**
	 * Determine if the square is a magic square.
	 * 
	 * @return true if square is a magic square, false otherwise
	 */
	public boolean isMagic() {
		boolean res = true;
		for (int i=0; i<sides; i++) {
			for (int j=0; j<sides; j++) {
				if (rowSum(i)==columnSum(j)&&
					rowSum(i)==rowSum(j)&&
					columnSum(i)==columnSum(j)&&
					rowSum(i)==diagonalSum(true)&&
					rowSum(i)==diagonalSum(false)) {
					res = true;
				}else {
					return false;
					
				}
					
			}
		}
		return res;
	}
	
	
}
