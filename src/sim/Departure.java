package sim;

/**
* Add planes to Departure queue
* @author Ansor Kasimov
* @version 1.0.0
*/

public class Departure extends Thread {

	// Departure queue
	private ArrayQueue<Airline> departure;
	// Takeoff duration (sleep time) 4000 = 4 secs
	private int time;
	// Used by main program to stop this thread
	private boolean running = true;
	// Keep track of wait time
	private int random;
	// Keep track of time spent
	private long min;

	// Constructor - needs the time to simulate a takeoff (4 secs)
	public Departure(int time) {
		this.time = time;
		departure = new ArrayQueue<Airline>();
	}
		
	/** @return the departure queue */
	public ArrayQueue<Airline> getQueue() {
		return departure;
	}
	
	/** @return the takeoff duration time (sleep time) */
	public int getTime() {
		return time;
	}
	
	// Started by the start method inherited from the thread class
	public void run() {
		
		// Loop until main program calls the stopRunning method
		while (running) {
			try {
				
				// Random airline
				Airline airline = new Airline(Formulas.AIRLINES[Formulas.random()], System.currentTimeMillis());
				
				// Place a new airline into the departure queue
				departure.enqueue(airline);
				
				// Record the time elapsed
				min = (System.currentTimeMillis() - Simulation.getStartTime()) / 1000;
				
				// Calculate the time (based on time-till-next formula)
				random = Formulas.timeTillNext(time);
				
				// Display information about airline and next departure time
				System.out.println("Minute " + min + " - Added flight " + airline + " to the departure queue\nRandom wait time before next departure: " + (random / 1000) + " mins\n");
				
				// Sleep for random seconds (based on time-till-next formula)
				sleep(random);
				
			} catch (InterruptedException ie) {
				System.out.println("Departure thread terminated early\n");
			} 
		}
		
	}
	
	// Change the running state to false
	public void stopRunning() {
		running = false;
	}
	
}
