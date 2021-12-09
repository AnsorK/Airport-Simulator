package sim;

/**
* Add planes to Arrival queue
* @author Ansor Kasimov
* @version 1.0.0
*/

public class Arrival extends Thread {
	
	// Arrival queue
	private ArrayQueue<Airline> arrival;
	// Arrival duration (sleep time) 5000 = 5 secs
	private int time;
	// Used by main program to stop this thread
	private boolean running = true;
	// Keep track of wait time
	private int random;
	// Keep track of time spent
	private long min;
	
	// Constructor - needs the time to simulate an arrival (5 secs)
	public Arrival(int time) {
		this.time = time;
		arrival = new ArrayQueue<Airline>();
	}
	
	/** @return the arrival queue */
	public ArrayQueue<Airline> getQueue() {
		return arrival;
	}
	
	/** @return the landing duration time (sleep time) */
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
				
				// Place a new airline into the arrival queue
				arrival.enqueue(airline);
			
				// Record the time elapsed
				min = (System.currentTimeMillis() - Simulation.getStartTime()) / 1000;
				
				// Calculate the time (based on time-till-next formula)
				random = Formulas.timeTillNext(time);
				
				// Display information about airline and next arrival time
				System.out.println("Minute " + min + " - Added flight " + airline + " to the arrival queue\nRandom wait time before next arrival: " + (random / 1000) + " mins\n");
					
				// Sleep for random seconds (based on time-till-next formula)
				sleep(random);
					
			} catch (InterruptedException ie) {
				System.out.println("Arrival thread terminated early\n");
			} 
		}
		
	}
	
	// Change the running state to false
	public void stopRunning() {
		running = false;
	}
	
}
