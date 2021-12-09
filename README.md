# Airport-Simulator  :airplane:
Java application to simulate an airport
## How it works

An arrival, departure, and runway thread is created at runtime to simulate an airport. 

A custom ArrayQueue data structure is used to keep track of planes. 

Planes get placed in arrival/departure queues at random times based on Poisson distribution, and get placed in a runway after a previous plane in the runway queue has arrived/departed. 

Real time seconds act as minutes during the simulation.


Everything is outputted to the console.
