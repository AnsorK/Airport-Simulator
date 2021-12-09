package sim;

/**
* Conduct the airport simulation
* @author Ansor Kasimov
* @version 1.0.0
*/

public class Simulation {
		
		// Instance variable for the start and simulation times
		private static long startTime, simulationTime;
		
		// Instance variables for arrival, departure, and runway threads
		private static Arrival arrival;
		private static Departure departure;
		private static Runway runway;
		
		// Default constructor
		public Simulation () {
			arrival = new Arrival(20000); 
			departure = new Departure(10000); 
			runway = new Runway(arrival, departure);
		}
		
		/** @return Simulation start time */
		public static long getStartTime() {
			return startTime;
		}
		
		// Parameter - long time - represents the simulation time, convert this to milliseconds
		public void startSimulation(long time) {	
			
			// Initilize the times
			startTime = System.currentTimeMillis();
			simulationTime = time * 60000; 
			
			// Start the threads
			arrival.start();
			departure.start();
			runway.start();
			
			// Loop - run simulation for specified time
			while (System.currentTimeMillis() < startTime + simulationTime);
			
			// Stop the loop in each thread – call the stopRunning method
			arrival.stopRunning();
			departure.stopRunning();
			runway.stopRunning(); 
					
			// Interrupt each thread – method from Thread class
			arrival.interrupt();
			departure.interrupt();
			runway.interrupt(); 
			
			// Wait for each thread to die – method from Thread class and output message
			try {
				arrival.join();
				departure.join();
				runway.join();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			} 
			
			// Output final message
			System.out.println("Simulation over after " + ((System.currentTimeMillis() - startTime) / 1000) + " minutes"); 
		
		}
		
		public static void main(String[] args) {
			
			// Input the length of time to run the simulation - in minutes
			simulationTime = 1;
			
			// Ouput message
			System.out.println("Simulation time: " + simulationTime + " hour(s)\n");
			
			// Create an instance of Program3
			Simulation airportSim = new Simulation();

			// Call the startSimulation method and pass the time to it
			airportSim.startSimulation(simulationTime);
		
			// Loop while the Arrival or Departure threads are alive - wait state
			while (arrival.isAlive() || departure.isAlive());
		
			// Stop the Runway thread from running
			runway.interrupt();

		}
		
}
