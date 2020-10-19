package oop;

public class DecrementableCounter extends Counter {

	private int cycleLength; 

	public DecrementableCounter (int n) { 
		int i;

		for (i = 0; i < n; i++) {
			super.increment();
		}
	}  


	public int decrement() { 
		// fill in this method so that value() will return
		// the correct value



		if (super.value() == 0) {
			return 0;
			//when the value becomes 0, it doesn't decrease
		} else {
			int numValue = super.value();
			super.reset();
			for (int i = numValue - 1; i > 0 ; i--) {
				super.increment();
				//makes numValue 2 less than the max amount and increment the value by one
			}
			return super.value();
		}


	} 
}
