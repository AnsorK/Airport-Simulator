package sim;
import java.util.Random;

/**
* Create new Airlines
* @author Ansor Kasimov
* @version 1.0.0
*/

public class Airline {

	// Plane's ID
	private String flightID;
	// Plane's ID number
	private int num;
	// Time a plane entered a queue
	private long entered;
	
	// Constructor requires the id & time entered
	public Airline(String ID, long entered) {
		flightID = ID;
		num = new Random().nextInt(20) + 10;
		this.entered = entered;
	}
	
	/** @return ID string */
	public String getID() {
		return flightID;
	}
	
	/** @return time entered */
	public long getEntered() {
		return entered;
	}
	
	/** @return string representation of the Airline */
	public String toString() {
		return flightID + num;
	}
	
}
