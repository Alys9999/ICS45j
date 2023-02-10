package labs.lab2;

/**
 * A rectangle defined by its x- and y-coordinates of its upper-left and lower-right corners
 */
public class Rectangle {
	// ADD YOUR INSTANCE VARIABLES HERE
	private double x1;
	private double y1;
	private double x2;
	private double y2;

	/**
	 * Constructor
	 * 
	 * @param x1	upper-left corner x value
	 * @param y1	upper-left corner y value
	 * @param x2	lower-right corner x value
	 * @param y2	lower-right corner y value
	 */
	public Rectangle(double x1, double y1, double x2, double y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		
	}
	
	
	/**
	 * Gets the orientation of this rectangle
	 * 
	 * @return "square", "portrait", or "landscape"
	 */
	public String getOrientation() {
		double s1 = Math.abs(x1-x2);
		double s2 = Math.abs(y1-y2);
		if (s1==s2) {
			return "square";
		}else if (s1<s2) {
			return"portrait";
		}else if(s2<s1) {
			return "landscape";
		}
		return "";
	} 
}
