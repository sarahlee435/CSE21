package oop;

public class ModNCounter2  extends Counter { 


	private int cycleLength; 

	public ModNCounter2 (int n) { 
		cycleLength = n; 
	}  


	public void increment() { 
		// fill in this method so that value() will return
		// the correct value

		if (super.value()==(cycleLength-1)) {
			super.reset();
		}else {
			super.increment();

		}

	} 
} 

