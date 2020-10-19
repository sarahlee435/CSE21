import java.util.*;

public class ShopArr {

	// Instance Variables
	private Cheese[] cheese;

	// Initialize method
	private void init(int max) {

		// Create max number of Cheese pointers
		cheese = new Cheese[max]; 

		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Humboldt Fog");
			cheese[0].setPrice(25.00);

			if (max > 1) {
				cheese[1] = new Cheese("Red Hawk");
				cheese[1].setPrice(40.50);

				if (max > 2) {
					cheese[2] = new Cheese("Teleme", 17.25);
					//cheese[2].setName("Wrong Name");
				}
			}
		}

		Random ranGen = new Random(100);

		for (int i = 3; i < max; i++) {
			cheese[i] = new Cheese("Cheese Type " + (char)('A' + i));
			cheese[i].setPrice(ranGen.nextInt(1000)/100.0);

		}

	}
	public ShopArr() {
		init(10);
	}

	public void ShopArr(int max) {
		// Fill-in Code
		init(max);
	}

	/*
	 * Displays the intro message informing the user of various cheeses sold and
	 * Gets the amount of each cheese the user would like to purchase. 
	 */
	private void intro(Scanner input) {


		System.out.println("We sell " + cheese.length + " kinds of Cheese (in 0.5 lb packages)");


		// Fill-in Code
		for (int i = 0; i < cheese.length; i++) {
			System.out.println(cheese[i].getName() + ": $" + cheese[i].getPrice() + " per pound");
		}

		System.out.println();
		for(int i=0;i<cheese.length;i++) {
			System.out.print("Enter the amount of "+cheese[i].getName()+" in lb: ");
			cheese[i].setAmount(input);
			while((cheese[i].getAmount()%0.5!=0)||(cheese[i].getAmount()<0)) {
				if(cheese[i].getAmount()%0.5!=0) {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					cheese[i].setAmount(input);
				}else if(cheese[i].getAmount()<0) {
					System.out.print("Invalid input. Enter a value >= 0: ");
					cheese[i].setAmount(input);
				}
			}
		}
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	private void itemizedList(){
		double amt = 0, price = 0;
		// Fill-in Code
		int check=0;
		for(int i=0;i<cheese.length;i++) {
			if(cheese[i].getAmount()>0) {
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", cheese[i].getAmount(), cheese[i].getName(),cheese[i].getPrice(), cheese[i].getAmount()*cheese[i].getPrice());
			}
		}
		for(int i=0;i<cheese.length;i++) {
			if(cheese[i].getAmount()!=0) {
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
	private double calcSubTotal() {
		double subTotal = 0;
		// Fill-in Code
		for(int i=0;i<cheese.length;i++) {
			subTotal += cheese[i].getPrice()*cheese[i].getAmount();
		}
		return subTotal;
	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 * stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 * Minor changes from Lab 07 (identical logic). 
	 */
	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};
		if(cheese.length>0) {
			double hfAmt = cheese[0].getAmount();

			if (hfAmt > 0) {
				// Fill-in Code
				hfAmt=(hfAmt*0.5);
				hfAmt=(int)(hfAmt/.5)*.5;
				disSpecials[0]=hfAmt*cheese[0].getPrice();
			}
		}
		if(cheese.length>1) {
			double rhAmt = cheese[1].getAmount();
			if(rhAmt > 0) {
				// Fill-in Code	
				rhAmt=((rhAmt)/3);
				rhAmt=(int)(rhAmt/.5)*.5;
				disSpecials[1]=rhAmt*cheese[1].getPrice();	
			}
		}


		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total. Identical to Lab 07.
	 */
	private double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix code
		double discounts=0;
		System.out.println();
		if (subTotal<=0) {
			subTotal=0.00;
		}
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
	 * the Final Total. Identical to Lab 07.
	 */
	private void printFinalTotal(double newSubTotal) {
		// Fill-in code
		double discount=0;
		int percentage=0;
		if((newSubTotal>150)&&(newSubTotal<=250)) {
			discount=newSubTotal*0.1;
			percentage=10;
		}else if(newSubTotal>250) {
			discount=newSubTotal*0.25;
			percentage=15;
		}
		if (newSubTotal<=0) {
			newSubTotal=0.00;
		}
		System.out.println("New Sub Total:\t \t \t \t $"+ newSubTotal);
		if(discount==0) {
			System.out.println("Additional "+percentage+"% Discount:\t\t\t-$"+discount);
		}else{
			System.out.println("Additional "+percentage+"% Discount:\t\t-$"+discount);
		}
		double finalTotal = newSubTotal-discount;
		if (finalTotal<=0) {
			finalTotal=0.00;
		}
		System.out.println("Final Total: \t \t \t \t $"+finalTotal);

	}

	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) 		
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lb of " + cheese[i].getName() + " @ $0 = $" + 0);
		System.out.println("Total Price: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);		
		intro(input);

		double subTotal = calcSubTotal();
		if(cheese.length!=0) {
			System.out.println();
		}
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}

		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1) {
			run();
		}else {
			System.out.println("Thanks for coming!");
		}
	}
}
