package Lab21_02;

import java.util.Scanner;

public class CheeseShop {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		final double humboldtFog=25.00;
		final double redHawk=40.50;
		final double teleme=17.25;
		double subtotal=0;
		double humboldtFogTotal=0;
		double redHawkTotal=0;
		double telemeTotal=0;
		double humboldtFogDiscount=0;
		double redHawkDiscount=0;
		double total=0;

		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages): ");
		System.out.println("Humboldt Fog: $25.00 per pound");
		System.out.println("Red Hawk: $40.50 per pound");
		System.out.println("Teleme: $17.25 per pound");
		System.out.println();

		System.out.print("Enter the amount of Humboldt Fog in lbs: ");
		double humboldtFogAmount=input.nextDouble();
		while(((humboldtFogAmount%0.5)!=0)||(humboldtFogAmount<0)) {
			if((humboldtFogAmount%0.5)!=0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				humboldtFogAmount=input.nextDouble();
			}else if(humboldtFogAmount<0){
				System.out.print("Invalid input. Enter a value >= 0: ");
				humboldtFogAmount=input.nextDouble();
			}
		}

		System.out.print("Enter the amount of Red Hawk in lbs: ");
		double redHawkAmount=input.nextDouble();

		while(((redHawkAmount%0.5)!=0)||(redHawkAmount<0)) {
			if((redHawkAmount%0.5)!=0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				redHawkAmount=input.nextDouble();
			}else if(redHawkAmount<0){
				System.out.print("Invalid input. Enter a value >= 0: ");
				redHawkAmount=input.nextDouble();
			}
		}

		System.out.print("Enter the amount of Teleme in lbs: ");
		double telemeAmount=input.nextDouble();
		while(((telemeAmount%0.5)!=0)||(telemeAmount<0)) {
			if((telemeAmount%0.5)!=0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				telemeAmount=input.nextDouble();
			}else if(telemeAmount<0){
				System.out.print("Invalid input. Enter a value >= 0: ");
				telemeAmount=input.nextDouble();
			}
		}

		System.out.println();

		//calculating cheese amounts
		if(humboldtFogAmount>0) {
			humboldtFogDiscount=humboldtFog*humboldtFogAmount;
			humboldtFogTotal=(humboldtFogAmount*2)*humboldtFog;
		}
		//Buy 2 get 1 free
		if(redHawkAmount>=1) {
			redHawkDiscount=(redHawkAmount/2)*redHawk;
			redHawkTotal=(redHawkAmount+(redHawkAmount/2))*redHawk;
		}else {
			redHawkTotal=redHawkAmount*redHawk;
		}

		telemeTotal=teleme*telemeAmount;

		System.out.print("Display the itemized list? (1 for yes) ");
		int displayList=input.nextInt();
		if(displayList==1) {
			if(humboldtFogAmount>0) {
				System.out.println(humboldtFogAmount+" lb of Humboldt Fog @ $"+humboldtFog+" = $"+humboldtFogTotal);
			}
			if(redHawkAmount>0) {
				System.out.println(redHawkAmount+" lb of Red Hawk @ $"+redHawk+" = $"+redHawkTotal);
			}
			if(telemeAmount>0) {
				System.out.println(telemeAmount+" lb of Teleme @ $"+teleme+" = $"+telemeTotal);
			}
			if((humboldtFogAmount<=0)&&(redHawkAmount<=0)&&(telemeAmount<=0)) {
				System.out.println("No items were purchased.");

			}
		}

		subtotal=humboldtFogTotal+redHawkTotal+telemeTotal;

		total=subtotal-humboldtFogDiscount-redHawkDiscount;

		System.out.println();
		System.out.println("Sub total: \t \t \t $"+ subtotal);
		System.out.println("Discounts... ");
		if((humboldtFogDiscount>0)||(redHawkDiscount>0)) {
			if(humboldtFogDiscount>0) {
				System.out.println("Humboldt Fog (Buy 1 Get 1 Free):-$"+humboldtFogDiscount);
			}
			if(redHawkDiscount>0) {
				System.out.println("Red Hawk (Buy 2 Get 1 Free): \t-$"+redHawkDiscount);
			}
		}else {
			System.out.println("None \t \t \t \t-$0.0");
		}
		System.out.println("Total: \t \t \t \t $"+total);

	}

}
