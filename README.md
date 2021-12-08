# Airport-Simulator
Java application to simulate an airport
## How it works
###### 1
An arrival, departure, and runway thread is created at runtime to simulate an airport. 
###### 2
Planes get placed in queues at random times based on Poisson distribution, and get placed in a runway after a previous plane in the runway queue has arrived/departed. 
###### 3
Real time seconds act as minutes during the simulation.
