package oop;

public class Runner {

	public static void main(String[] args) {
		testCounter();

		testCounter7Statements();

		testModNCounter2();

		testDecrementableCounter();

		testSeasonCounter();
	}


	public static void testCounter() {
		System.out.println("-- Testing Counter");

		Counter c = new Counter();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current value: " + c.value());

	}


	public static void testCounter7Statements() {
		Counter c = new Counter();
		System.out.println("-- Testing 7 statements");
		// include exactly 7 increment() and reset() statements below
		c.increment();
		c.increment();
		c.increment();
		c.reset();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current value: " + c.value());
	}

	public static void testModNCounter2() {
		int N=4; //N value that corresponds to the number of cycles to test

		System.out.println();

		ModNCounter2 c = new ModNCounter2 (N);
		for (int i =0; i<N; i++) {
			System.out.println(c.value()); 
			c.increment();
		}
		//used to check for repeats
		for (int i =0; i<N; i++) {
			System.out.println(c.value()); 
			c.increment();
		}

	}

	public static void testDecrementableCounter() {
		int N=5; //total value number to test

		System.out.println();

		DecrementableCounter c = new DecrementableCounter(N);
		for (int i =0; i<=N; i++) {
			System.out.println(c.value()); 
			c.decrement();
		}

	}

	public static void testSeasonCounter() {

		System.out.println();

		//uses the current value associated with the code
		SeasonCounter c = new SeasonCounter();

		System.out.println(c.toString());



	}
}
