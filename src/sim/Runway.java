package sim;

/**
* Add planes from Arrival/Departure queues to the Runway queue
* @author Ansor Kasimov
* @version 1.0.0
*/

public class Runway extends Thread {

	// Reference to the arrival thread 
	private Arrival arrival;
	// Reference to the departure thread
	private Departure departure;
	// Used by main program to stop this thread
	private boolean running = true;
	// Keep track of time spent
	private long min;
	// Keep track of time entered queue
	private long minEntered;
	// Keep track of the wait time in a queue
	private long waitTime;
	
	// Constructor - needs arrival & departure threads
	public Runway(Arrival arrival, Departure departure) {
		this.arrival = arrival;
		this.departure = departure;
	}
	
	// Started by the start method inherited from the thread class
	public void run() {
		
		// Loop until main program calls the stopRunning method
		while (running) {
			
			try {
			
				// while there are planes in the arrival queue
				while (!arrival.getQueue().isEmpty()) {
				
					// Get a plane from the queue
					Airline airline = arrival.getQueue().dequeue();
					
					// Record the time elapsed
					min = (System.currentTimeMillis() - Simulation.getStartTime()) / 1000;
					
					// Record the time the plane entered the queue
					minEntered = (airline.getEntered() - Simulation.getStartTime()) / 1000;
					
					// Record the queue wait time
					waitTime = min - minEntered;
					
					// Display information about airline
					System.out.println("Minute " + min + " - Flight " + airline + " cleared for landing - Entered queue at " + minEntered + " - waited " +  waitTime + " mins\n");
					
					// Simulate landing - sleep for secs (arrival time - 5 secs)
					sleep(Formulas.LANDING_TIME);
				
				}
					
				// while there are planes in the departure queue
				while (!departure.getQueue().isEmpty()) {
								
					// Get a plane from the queue
					Airline airline = departure.getQueue().dequeue();
							
					// Record the time elapsed
					min = (System.currentTimeMillis() - Simulation.getStartTime()) / 1000;
							
					// Record the time the plane entered the queue
					minEntered = (airline.getEntered() - Simulation.getStartTime()) / 1000;
							
					// Record the queue wait time
					waitTime = min - minEntered;
							
					// Display information about airline
					System.out.println("Minute " + min + " - Flight " + airline + " cleared for takeoff - Entered queue at " + minEntered + " - waited " +  waitTime + " mins\n");
							
					// Simulate landing - sleep for secs (departure time - 5 secs)
					sleep(Formulas.TAKEOFF_TIME);
					
				}
				
			} catch (InterruptedException e) {
				System.out.println("Runway thread terminated early\n");
			}
						
		}
		
	}
	
	// Change the running state to false
	public void stopRunning() {
		running = false;
	}
	
}
