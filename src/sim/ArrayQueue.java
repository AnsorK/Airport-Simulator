package sim;

/**
* ArrayQueue data structure
* @author Ansor Kasimov
* @version 1.0.0
*/

public class ArrayQueue<T> {

	// Holds the queue elements
	private T[] data;
	// Index to front/rear elements and queue size
	private int front, rear, size;
	// size limit
	public final int CAPACITY = 100;
	
	// New ArrayQueue with base capacity
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		data = (T[]) new Object[CAPACITY];
		front = rear = size = 0;
	}
	
	// New ArrayQueue with custom capacity
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) throws Exception {
		if (size < 1)
			throw new Exception("Invalid size for the queue");
		data = (T[]) new Object[size];
		front = rear = size = 0;
	}	
	
	/** @return front index */
	public synchronized int getFront() {
		return front;
	}
	
	/** @return rear index */
	public synchronized int getRear() {
		return ((front + size) - 1) % data.length;
	}
	
	/** @return size of queue */
	public synchronized int getSize() {
		return size;
	}

	/** @return true if queue is empty, false otherwise */
	public synchronized boolean isEmpty() {
		return size == 0;
	}
	
	/** @return true if queue is full, false otherwise */
	public synchronized boolean isFull() {
		return size == data.length;
	}
	
	/** @return the element at the front without removing it */
	public synchronized T front() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Queue empty exception...");
		return  data[front];
	}
	
	/** @return the element at the rear without removing it */
	public synchronized T rear() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Queue empty exception...");
		return  data[(front + size - 1) % data.length];
	}
	
	/** @insert an element at the rear of the queue */
	public synchronized void enqueue(T d) throws RuntimeException {
		if (isFull())
			throw new RuntimeException("Queue full exception...");
		data[rear] = d;
		rear = (rear + 1) % data.length;
		size++;
	}
	
	/** @return and remove the element at the front of the queue */
	public synchronized T dequeue() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Queue empty exception...");
		T temp = data[front];
		front = (front + 1) % data.length;
		size--;
		return temp;
	}
	
	/** @return the contents of queue in string form */
	public synchronized String toString() {
		String str = "Queue: " + size + "\n";
		int trav = front;
		for (int i = 0; i < size; i++) {
			str += data[trav] + "->";
			trav = (trav + 1) % data.length;
		}
		return str;
	}
	
}
