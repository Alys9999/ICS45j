package labs.lab8;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for appending lists/arrays
 *
 */
public class Appender {

	/**
	 * Appends two lists together.
	 * 
	 * Leaves the parameter lists unchanged, and returns a new list that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the lists
	 * @param a   list 1
	 * @param b   list 2
	 * 
	 * @return a new list containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> List<T> append(List<T> list1, List<T> list2){
		List<T> listRes =  new ArrayList<T>();
		for (T ele:list1) {
			listRes.add(ele);
		}
		for (T elen: list2) {
			listRes.add(elen);
		}
		return listRes;
	}


	/**
	 * Appends two arrays together.
	 * 
	 * Leaves the parameter arrays unchanged, and returns a new arrays that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the arrays
	 * @param a   array 1
	 * @param b   array 2
	 * 
	 * @return a new array containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> T[] append(T[] array1, T[] array2){
		int size = array1.length+array2.length;
		T[] res = (T[])Array.newInstance(array1.getClass().getComponentType(), size);
		int count = 0;
		for (T ele:array1) {
			res[count]=ele;
			count++;
		}
		for (T elen: array2) {
			res[count]=elen;
			count++;
		}
		
		return res;
	}
	
	public static void main (String args[]) {
		String[] d = { "apple", "orange" };
		String[] e = { "pear", "banana" };
		String[] f = Appender.append(d, e);
	}
	
}