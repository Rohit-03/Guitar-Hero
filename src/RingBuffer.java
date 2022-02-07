import java.util.NoSuchElementException;


public class RingBuffer {

	private int capacity;
	private int size;
	private int firstNum;
	private int lastNum;
	private double [] ringBuffer;
	
	public RingBuffer(int capacity) {
		this.capacity = capacity;
		ringBuffer = new double[capacity];
		this.size = 0;
		firstNum = 0;
		lastNum = 0;
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isFull() {
		return (size == capacity);
	}
	
	public void enqueue(double x) {
		if(isFull()) {
			throw new IllegalStateException();
		}
		else {
			if(lastNum==capacity) {
				lastNum = 0;
			}
			ringBuffer[lastNum] = x;
			lastNum++;
			size++;
		}
	}
	
	public double dequeue()  {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			
			double delete = ringBuffer[firstNum];
			ringBuffer[firstNum] = 0.0;
			firstNum++;
			size--;
			if(firstNum==capacity) {
				firstNum = 0;
			}
			return delete;
		}
	}
	
	public double peek()  {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return ringBuffer[firstNum];
	}
	
	public String toString() {
		if(size() == 0) {
			return "[]";
		}
		
		String result = "["+ ringBuffer[firstNum] + ", ";
		int next = firstNum;
		next++;
		
		
		while(next!= lastNum - 1) {
			if(next ==capacity) {
				next = 0;
			}
			result += ringBuffer[next] +", ";
			
			next++;
		}
		
		result += ringBuffer[next] + "]";
		return result;
		 
	 }
	
	
}
