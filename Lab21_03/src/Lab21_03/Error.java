package Lab21_03;

import java.util.Random;

public class Error {

	public static void main(String[] args) {

		final int MAXCHEESE = 20;
		
		String[] names = new String[MAXCHEESE+3];
		double[] prices = new double[MAXCHEESE+3];
		double[] amounts = new double[MAXCHEESE+3];
		
		// Three Special Cheeses
		names[0] = "Humboldt Fog";
		prices[0] = 25.00;

		names[1] = "Red Hawk";
		prices[1] = 40.50;
		
		names[2] = "Teleme";
		prices[2] = 17.25;
		
 		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese:");
		
 
 		Random ranGen = new Random(100);

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;
		
		}
		for (int i = 0; i < MAXCHEESE; i++) {
			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}

	}

}
