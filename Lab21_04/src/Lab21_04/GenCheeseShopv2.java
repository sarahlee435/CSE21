package Lab21_04;
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */

	public static void intro(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		if(names.length>0) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
		}
		if(names.length>1) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if(names.length>2) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}
		Random ranGen = new Random(100);

		if(amounts.length>2) {
			for (int i = 3; i < names.length; i++) {
				names[i] = "Cheese Type " + (char)('A' + i);
				prices[i] = ranGen.nextInt(1000)/100.0;
				amounts[i] = 0;
			}
		}
	}

	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		// Fill-in
		System.out.println();
		System.out.println("We sell " + names.length + " kinds of Cheese (in 0.5 lb packages):");
		System.out.println();
		for(int i=0;i<names.length;i++) {
			System.out.print("Enter the amount of "+names[i]+" in lb: ");
			amounts[i]=sc.nextDouble();
			while((amounts[i]%0.5!=0)||(amounts[i]<0)) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				amounts[i]=sc.nextDouble();
			}
		}



	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		// Fill-in

		int check=0;
		for(int i=0;i<names.length;i++) {
			if(amounts[i]>0) {
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amounts[i], names[i],prices[i], prices[i]*amounts[i]);
			}
		}
		for(int i=0;i<names.length;i++) {
			if(amounts[i]!=0) {
				check+=1;
			}
		}
		if(check==0) {
			System.out.println("No items were purchased.");
		}
	}




	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		// Fix
		double subTotal=0;
		for(int i=0; i<amounts.length; i++) {
			subTotal+=prices[i]*amounts[i];
		}

		return subTotal;

	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		// Fix
		double[] disSpecials = new double[amounts.length];
		double humboltFogPackages=0;
		double redHawkPackages=0;
		double humboltFogDiscount;
		double redHawkDiscount;
		if(amounts.length>0) {
			humboltFogPackages=(amounts[0]*0.5);
			humboltFogPackages=(int)(humboltFogPackages/.5)*.5;
			humboltFogDiscount=humboltFogPackages*prices[0];
			disSpecials[0]=humboltFogDiscount;
		}
		if(amounts.length>1) {
			redHawkPackages=((amounts[1])/3);
			redHawkPackages=(int)(redHawkPackages/.5)*.5;
			redHawkDiscount=redHawkPackages*prices[1];	
			disSpecials[1]=redHawkDiscount;
		}	


		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix
		double discounts=0;
		System.out.println();
		System.out.println("Original Sub Total:\t \t \t $"+ subTotal);
		System.out.println("Specials...");
		if(disSpecials.length>=1) {
			if((disSpecials[0]>0)||(disSpecials[1]>0)) {
				if(disSpecials[0]>0) {
					System.out.println("Humboldt Fog (Buy 1 Get 1 Free):\t-$" + disSpecials[0]);
					discounts=(disSpecials[0]);
				}
				if(disSpecials.length>1) {
					if(disSpecials[1]>0) {
						System.out.println("Red Hawk (Buy 2 Get 1 Free):\t \t-$" +disSpecials[1]);
						discounts=(disSpecials[0]+disSpecials[1]);
					}
				}
			}
		}
		if(discounts==0){
			System.out.println("None \t \t \t \t \t-$0.0");
		}


		double newSubTotal=subTotal-discounts;
		return newSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in

		double discount=0;
		int percentage=0;
		if((newSubTotal>150)&&(newSubTotal<=250)) {
			discount=newSubTotal*0.1;
			percentage=10;
		}else if(newSubTotal>250) {
			discount=newSubTotal*0.25;
			percentage=25;
		}
		System.out.println("New Sub Total:\t \t \t \t $"+ newSubTotal);
		if(discount==0) {
			System.out.println("Additional "+percentage+"% Discount:\t\t\t-$"+discount);
		}else{
			System.out.println("Additional "+percentage+"% Discount:\t\t-$"+discount);
		}
		double finalTotal = newSubTotal-discount;


		System.out.println("Final Total: \t \t \t \t $"+finalTotal);
	}

	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);


		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();

			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));

		printFinalTotal(newSubTotal);

		sc.close();
	}
}