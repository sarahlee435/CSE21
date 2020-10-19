package oop;

public class SeasonCounter extends ModNCounter {


	private static String[] names =  {"spring", "summer", "fall", "winter"};


	public SeasonCounter() {
		// fill-in by creating an object with 4 as the modulus
		super(4);
	}


	@Override
	public String toString() {
		// fill-in so it returns the season name
		//returns the name corresponding to the current value
		//when the value is over 4, it starts counting at 0
		return names[super.value()];
	}


}
