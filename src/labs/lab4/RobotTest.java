package labs.lab4;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class RobotTest {

	@Test
    public void testConstructor() {
		Robot robot = new Robot();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("N", robot.getDirection());
    }

	@Test
    public void testTurnLeft() {
		Robot robot = new Robot();
		robot.turnLeft();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("W", robot.getDirection());
    }
	
	@Test
    public void testTurnRight() {
		Robot robot = new Robot();
		robot.turnRight();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("E", robot.getDirection());
    }
	
	@Test
    public void testMove() {
		Robot robot = new Robot();
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertFalse(robot.move());
		assertFalse(robot.move());
		assertFalse(robot.move());
		assertEquals(true, robot.getLocation().equals(new Point(0, 8))); 
		assertEquals("N", robot.getDirection());
    }
}
