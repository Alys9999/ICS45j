package labs.lab1;

/**
 * Compute international standard sizes for paper, where A0 = 841 x 1189 mm A1 =
 * 594 x 841 mm A2 = 420 x 594 mm A3 = 292 x 423 mm etc
 */
public class Sheet {

	private int width;
	private int length;
	private int size;
	
	/**
	 * create a sheet of size A0
	 */
	public Sheet() {
		width=841;
		length= 1189;
		size=0;
	}
	
	public Sheet(int width, int length, int size) {
		this.width = width;
		this.length = length;
		this.size = size;
	}

	
	/**
	 * @return the width of the paper
	 */
	public int getWidth() {
		return width; // FIX ME
	}

	
	/**
	 * @return the length of the paper
	 */
	public int getLength() {
		return length; // FIX ME
	}

	
	/**
	 * @return the ISO name for the paper
	 */
	public String getName() {
		return "A"+size; // FIX ME
	}

	
	/**
	 *
	 * @return a sheet that is cut in half along the length
	 */
	public Sheet cutInHalf() {
		int newWidth = width;
		int newLength = length;
		int newSize = size+1;
		if (width > length) {
			newWidth = newWidth / 2;
		} else if(length>width){
			newLength = newLength / 2;
		}
		return new Sheet(newLength, newWidth, newSize); // FIX ME
	}
}
