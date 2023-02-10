package labs.lab4;

/**
 * A class to simulate a combination lock.
 */
public class ComboLock {
	private boolean state = false;
	private int num1;
	private int num2;
	private int num3;
	private int move1=0;
	private int move2=0;
	private int move3=0;
	private int count=1;
	/**
	 * Initializes the combination of the lock. Assume all inputs are valid ints
	 * between 0 and 39 inclusive
	 * 
	 * @param num1 first number to turn right to
	 * @param num2 second number to turn left to
	 * @param num3 third number to turn right to 38, 39, 37  38,2,37
	 */
	
	public ComboLock(int num1, int num2, int num3) {
		this.num1= (num1==0)? 0:-(40-num1);
		this.num2=(num2>num1)?num2-num1:40-num1+num2;
		this.num3=(num3<num2)?num3-num2:-(num2+40-num3);
	}
		
	
	/**
	 * Resets the state of the lock so that it can be opened again; resets the
	 * dial so that it points to 0
	 */
	public void reset() {
		move1=0;
		move2=0;
		move3=0;
		count=1;
		state=false;
	}

	/**
	 * Turns lock left given number of ticks.
	 * 
	 * @param ticks number of ticks to turn left; assume ticks always between 0 
	 * and 39 inclusive
	 */
	public void turnLeft(int ticks) {
		switch (count) {
		case 1:
			move1=ticks;
			break;
		case 2:
			move2=ticks;
			break;
		case 3:
			move3=ticks;
			break;
		
		}
		count++;
		
	}

	/**
	 * Turns lock right given number of ticks
	 * 
	 * @param ticks number of ticks to turn right; assume ticks always between 0
	 * and 39 inclusive
	 */
	public void turnRight(int ticks) {
		switch (count) {
		case 1:
			move1=-ticks;
			break;
		case 2:
			move2=-ticks;
			break;
		case 3:
			move3=-ticks;
			break;
		
		}
		count++;
	}

	/**
	 * Returns true if the lock can be opened now, false otherwise
	 * 
	 * @return true if lock is in open state
	 */
	public boolean open() {
		if (count==4) {
			if (move1==num1 && move2==num2 && move3==num3) {
				state = true;
			}
		}
		
		return state; // FIX ME
	}
	public static void main(String args[]) {
		ComboLock lock = new ComboLock(38, 39, 37);
		lock.turnRight(2);
		lock.turnLeft(1);
		lock.turnRight(2);
		System.out.println(lock.open());
		
	}
}
