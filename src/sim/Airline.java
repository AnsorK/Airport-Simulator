package sim;
import java.util.Random;

/**
* The airline class
* @author Ansor Kasimov
*/

public class Airline {

	/** ID */
	private String flightID;
	/** Random value */
	private int num;
	/** Time the plane entered a queue */
	private long entered;

	/**
	 * Airline Constructor
	 * @param ID the plane String ID
	 * @param entered the plane queue entry time
	 */
	public Airline(String ID, long entered) {
		flightID = ID;

		// Random integer between [10, 29]
		num = new Random().nextInt(20) + 10;

		this.entered = entered;
	}

	/**
	 * Return plane's ID
	 * @return flightID
	 */
	public String getID() {
		return flightID;
	}

	/**
	 * Return plane's entered time
	 * @return entered
	 */
	public long getEntered() {
		return entered;
	}

	/**
	 * Return String representation of
	 * plane
	 * @return flightID + num
	 */
	@Override
	public String toString() {
		return flightID + num;
	}
}