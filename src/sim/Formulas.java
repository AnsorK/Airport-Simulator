package sim;
import java.util.Random;

/**
* Formulas to use in simulation
* @author Ansor Kasimov
* @version 1.0.0
*/

public class Formulas {
	
	// To be used in the Simulation class
	public static final int TAKEOFF_TIME = 4000;
	public static final int LANDING_TIME = 5000;
	
	// Array of airline companies
	public static String[] AIRLINES = {"AA","AI","AF","AZ","KL","BA","BW","DL","FL","BA","AC","ET","GH","LH","JM","KE","TW","UA"};	
	
	/** @return random number based on airline array */
	public static int random() {
		return new Random().nextInt(18);
	}
	
	/** @return milliseconds converted to minutes */ 
	public static long timeInMinutes(long millisecs){
		return millisecs / 60000;
	}
	
	/** @return minutes converted to milliseconds */
	public static long timeInMillisecs(long timeInMinutes) {
		return timeInMinutes * 60000;
	}
	
	/**
	* Calculates time until next event (Poisson distribution)
	* @param Mean event time - in milliseconds
	* @return Time until next - time before next event occurs
	*/
	public static int timeTillNext(int meanEventTime) {
		Random random = new Random();
		double randomDouble = random.nextDouble();
		int timeTillNext = (int) Math.round(-meanEventTime * Math.log(1 - randomDouble));
		return timeTillNext;
	}
		
}
