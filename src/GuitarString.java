/** 
* CS312 Assignment 12.
 * 
 * On my honor, <Rohit Shetty>, this programming assignment is my own work and I
 * have not shared my solution with any other student in the class.
 *
 * email address: rohit.shetty@utexas.edu 
 * UTEID: Unique 5 digit course ID:rrs3229 
 * Number of slip days used on this assignment: 0
 */



public class GuitarString {
	double frequency;
	RingBuffer newRingBuffer;
	double frequencyCap;
	double [] init;
	int tic;
	
	public GuitarString(double frequency) {
		this.frequency = frequency;
		double frequencyCap = 44100/frequency;
		int n = (int) Math.ceil(frequencyCap);
		newRingBuffer = new RingBuffer(n);
		
		for(int i = 0; i < frequencyCap; i++) {
			newRingBuffer.enqueue(0.0);
		}
		tic = 0;
	}
	
	public GuitarString(double[] init) {
		this.init = init;
		for(int i = 0; i < init.length; i++) {
			newRingBuffer.enqueue(init[i]);
		}
		tic= 0;
	}
	
	public void pluck() {
		
		for(int x = 0; x < newRingBuffer.size(); x++) {
			newRingBuffer.dequeue();
		}
	
		while(!newRingBuffer.isFull()) {
			newRingBuffer.enqueue(Math.random()-0.5);
		}
	}
	
	public void tic() {
		double d = newRingBuffer.dequeue();
		double p = newRingBuffer.peek();
		double avg = ((d+p)/2.0)*0.994;
		newRingBuffer.enqueue(avg);
		tic++;
	}
	public double sample() {
		return newRingBuffer.peek();
	}
	
	public int time()  {
		return tic;
	}
}
