package ie.gmit.dip;

import java.util.*;

/**
 * @author Stephen Curran
 * @version 1.0
 * @since 1.8
 *
 * The ParseFiles interface is an abstraction of a file parser process used to
 * map a <b>Set</b> of String values alternative String values using a <b>Map</b>.
 * 
 */
public interface ParseFiles {
	public static final Map<String, String> map = new HashMap<String, String>();
	public static final Set<String> set = new HashSet<String>();

	/**
	 * Initialises methods required to Parse values to a Set and Map by calling 
	 * private methods. 
	 * If suitable files are available for use, assigns values from a specified file 
	 * to a set. Maps required String to String values from a different reference 
	 * file if method executes successfully.
	 */
	public void initFiles();

	/**
	 * Clears existing Set and Map values and re-initialises initFiles() method to Parse
	 * values from existing files, if suitable files are available.
	 * If successful, prints notification that files have been reset.
	 */
	public void resetFiles();
}