package labs.lab4;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

/**
 * A class for simulating a robot wandering on a 10 x 10 plane.
 */
public class Robot {
	
	private String face;
	private int x;
	private int y;

	
	/**
	 * Creates a Robot at location (0, 0), which is in the center of the plane,
	 * and facing north
	 */
	public Robot() {
		face = "N";
		x=0;
		y=0;
	}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnLeft() {
		switch (face) {
		case "N":
			face = "W";
			break;
		case "W":
			face = "S";
			break;
		case "S":
			face = "E";
			break;
		case "E":
			face = "N";
			break;
			
		}
	}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnRight() {
		switch (face) {
		case "N":
			face = "E";
			break;
		case "W":
			face = "N";
			break;
		case "S":
			face = "W";
			break;
		case "E":
			face = "S";
			break;
		}
	}

	
	/**
	 * Moves the robot by one unit in the direction it is facing. Returns true if the
	 * robot is still on the plane, or false if it has fallen off.
	 * 
	 * Note 1: In coordinate terms, |x| must be <= 5 and |y| must be <= 5 for the robot
	 * to stay on the plane (see below example).
	 * 
	 * Note 2: This method can still be called on a robot that has fallen off the plane,
	 * and its location should be updated as if it was still on the plane.
	 * 
	 * @return	true if the robot is still on the plane, false otherwise
	 */
	public boolean move() {
		switch (face) {
		case "N":
			y++;
			break;
		case "S":
			y--;
			break;
		case "E":
			x++;
			break;
		case "W":
			x--;
			break;
		}
		
		if (Math.abs(x)<=5 &&Math.abs(y)<=5) {
			return true;
		}else {
		return false;
		}// FIX ME
	}

	
	/**
	 * Returns the robot's current location on the plane
	 * 
	 * @return	robot's current location
	 */
	public Point getLocation() {
		return new Point(x, y); // FIX ME
	}

	
	/**
	 * Returns "N", "E", "S", or "W" (for north, east, south, or west, respectively)
	 * 
	 * @return	the robot's direction
	 */
	public String getDirection() {
		return face; // FIX ME
		
	}
	
	
}
