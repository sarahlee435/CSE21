package Lab21_03;

import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		int MAXCHEESE = input.nextInt();
		System.out.println();

		String[] names = new String[MAXCHEESE+3];
		double[] prices = new double[MAXCHEESE+3];
		double[] amounts = new double[MAXCHEESE+3];

		double originalSubtotal=0;
		double newSubtotal=0;
		double finalTotal=0;
		double discount=0;
		double humboltFogDiscount=0;
		double redHawkDiscount=0;


		// Three Special Cheeses
		names[0] = "Humboldt Fog";
		prices[0] = 25.00;

		names[1] = "Red Hawk";
		prices[1] = 40.50;

		names[2] = "Teleme";
		prices[2] = 17.25;

		Random ranGen = new Random(100);

		if(MAXCHEESE>2) {
			for (int i = 3; i < MAXCHEESE; i++) {
				names[i] = "Cheese Type " + (char)('A' + i);
				prices[i] = ranGen.nextInt(1000)/100.0;
				amounts[i] = 0;
			}
		}

		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages):");

		for (int i = 0; i < MAXCHEESE; i++) {
			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}
		System.out.println();

		for(int i=0;i<MAXCHEESE;i++) {
			System.out.print("Enter the amount of "+names[i]+" in lb: ");
			amounts[i]=input.nextDouble();
			while((amounts[i]%0.5!=0)||(amounts[i]<0)) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				amounts[i]=input.nextDouble();
			}
		}


		System.out.println();

		int check=0;
		if(MAXCHEESE>0) {
			System.out.print("Display the itemized list? (1 for yes) ");
			int displayList=input.nextInt();
			if(displayList==1) {
				for(int i=0;i<MAXCHEESE;i++) {
					if(amounts[i]>0) {
						System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amounts[i], names[i],prices[i], prices[i]*amounts[i]);
					}
				}
				for(int i=0;i<MAXCHEESE;i++) {
					if(amounts[i]!=0) {
						check+=1;
					}
				}
				if(check==0) {
					System.out.println("No items were purchased.");
				}
			}
			System.out.println();
		}



		double humboltFogPackages=0;
		double redHawkPackages=0;

		if(MAXCHEESE>0) {
			humboltFogPackages=(amounts[0]*0.5);
			humboltFogPackages=(int)(humboltFogPackages/.5)*.5;
			humboltFogDiscount=humboltFogPackages*prices[0];
		}
		if(MAXCHEESE>1) {
			redHawkPackages=((amounts[1])/3);
			redHawkPackages=(int)(redHawkPackages/.5)*.5;
			redHawkDiscount=redHawkPackages*prices[1];	
		}	

		for(int i=0; i<MAXCHEESE; i++) {
			originalSubtotal+=prices[i]*amounts[i];
		}

		newSubtotal=originalSubtotal-(humboltFogDiscount+redHawkDiscount);
		int percentage=0;
		if((newSubtotal>150)&&(newSubtotal<=250)) {
			discount=newSubtotal*0.1;
			percentage=10;
		}else if(newSubtotal>250) {
			discount=newSubtotal*0.15;
			percentage=15;
		}

		finalTotal=newSubtotal-discount;

		System.out.println("Original Sub Total:\t \t \t $"+ originalSubtotal);
		System.out.println("Specials...");
		if((humboltFogDiscount>0)||(redHawkDiscount>0)) {
			if(humboltFogDiscount>0) {
				System.out.println("Humboldt Fog (Buy 1 Get 1 Free):\t-$" + humboltFogDiscount);
			}
			if(redHawkDiscount>0) {
				System.out.println("Red Hawk (Buy 2 Get 1 Free):\t \t-$" +redHawkDiscount);
			}
		}else {
			System.out.println("None \t \t \t \t \t-$"+humboltFogDiscount);
		}
		System.out.println("New Sub Total:\t \t \t \t $"+ newSubtotal);
		if(discount==0) {
			System.out.println("Additional "+percentage+"% Discount:\t\t\t-$"+discount);
		}else{
			System.out.println("Additional "+percentage+"% Discount:\t\t-$"+discount);
		}
		System.out.println("Final Total: \t \t \t \t $"+finalTotal);
	}

}
