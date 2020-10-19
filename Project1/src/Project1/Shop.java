package Project1;
import java.util.Scanner;

public class Shop {
	public static void Intro() {
		System.out.println("This program supports 4 functions:");
		System.out.println("\t1. Setup Shop");
		System.out.println("\t2. Buy");
		System.out.println("\t3. List Items");
		System.out.println("\t4. Checkout");
		System.out.print("Please choose the function you want: ");
	}

	public static void SetupShop(Scanner input,String name[], double prices[], int discountPkges[],int itemNum,double packages[], double discountamount, double discountrate) {
		int [] item=new int[itemNum];
		for(int i=0;i<itemNum;i++) {
			item[i]=i+1;
			if(i==0) {
				System.out.print("Enter the name of the 1st product: ");
				name[i]=input.next();

			}else if(i==1) {
				System.out.print("Enter the name of the 2nd product: ");
				name[i]=input.next();

			}else if(i==2) {
				System.out.print("Enter the name of the 3rd product: ");
				name[i]=input.next();

			}else {
				System.out.print("Enter the name of the "+item[i]+"th product: ");
				name[i]=input.next();

			}

			System.out.print("Enter the per package price of "+name[i]+": ");
			prices[i]=input.nextDouble();
			System.out.println("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free)");
			System.out.print("for "+name[i]+", or 0 if no Special Discount offered: ");
			discountPkges[i]=input.nextInt();
		}

		System.out.println();
	}
	public static double SetupShop1(Scanner input, double discountamount) {
		System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
		discountamount=input.nextDouble();	
		return discountamount;
	}
	
	public static double SetupShop2(Scanner input, double discountamount, double discountrate) {
		if(discountamount>0) {
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			discountrate=input.nextDouble();	
			while((discountrate > 0.5)||(discountrate <= 0)) {
				System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
				discountrate=input.nextDouble();	
			}
		}
		return discountrate;

	}

	public static double [] Buy(Scanner input,String name[], double prices[], int discountPkges[],int itemNum,double []packages) {
		System.out.println();
		for(int i=0;i<itemNum;i++){
			System.out.print("Enter the number of "+name[i]+" packages to buy: ");
			packages[i]=input.nextDouble();
			while ((packages[i]<1)&&(packages[i]!=0)) {
				System.out.print("Invalid input. Please enter a value >= 0: ");
				packages[i]=input.nextDouble();

			}
		}
		return packages;
	}

	public static void ItemList(Scanner input,String name[], double prices[], int discountPkges[],int itemNum,double[]packages) {
		double pricesTotal[]=new double[itemNum];
		int packageNum=0;
		for(int i=0;i<itemNum;i++){
			if(packages[i]>0) {
				packageNum+=1;
			}
		}
		System.out.println();
		if (packageNum==0) {
			System.out.println("No items were puchased.");
		}else {
			for(int i=0;i<itemNum;i++){
				pricesTotal[i]=packages[i]*prices[i];
			}
			for(int i=0;i<itemNum;i++){ 
				if((pricesTotal[i]>0)&&(packages[i]>1)) {
					System.out.println((int)packages[i]+" packages of "+name[i]+" @ $"+prices[i]+" per pkg = $"+pricesTotal[i]);
				}else if((pricesTotal[i]>0)&&(packages[i]==1)) {
					System.out.println((int)packages[i]+" package of "+name[i]+" @ $"+prices[i]+" per pkg = $"+pricesTotal[i]);
				}
			}
		}
		System.out.println();

	}
	public static void Checkout(Scanner input,String name[], double prices[], int discountPkges[],int itemNum, double packages[], double discountamount, double discountrate) {
		double specialDiscount=0;
		double subTotal=0;
		double finalTotal=0;
		double newSubTotal=0;
		double priceDiscount=0;
		double percentage=discountrate*100;

		for(int i=0;i<itemNum;i++) {
			subTotal+=(packages[i]*prices[i]);

		}
		System.out.println();
		System.out.println("Original Sub Total:\t \t \t $"+ subTotal);
		

		
		for(int i=0;i<itemNum;i++) {
			if((prices[i]>0)&&(discountPkges[i]>0)) {
				priceDiscount+=((int)(packages[i]/(discountPkges[i]+1))*prices[i]);
			}
		}


		if(priceDiscount>0) {
			System.out.println("Special Discounts:\t \t \t-$"+ priceDiscount);
		}else {
			System.out.println("No Special Discounts applied");
			priceDiscount=0;
		}
		
		newSubTotal=subTotal-priceDiscount;

		System.out.println("New Sub Total:\t \t \t \t $"+ newSubTotal);
		
		specialDiscount=newSubTotal*discountrate;
		
		if((newSubTotal>discountamount)&&(specialDiscount!=0)) {
			System.out.println("Additional "+(int)percentage+"% Discount:\t\t-$"+specialDiscount);
		}else {
			System.out.println("You did not qualify for an Additional Discount");
		}

		finalTotal = newSubTotal-specialDiscount;
		
		System.out.println("Final Sub Total: \t \t \t $"+finalTotal);
	}


	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int itemNum=0;
		String [] name=new String[itemNum];
		double[]prices=new double[itemNum];
		int[]discountPkges=new int[itemNum];
		double [] packages=new double[itemNum];
		int rerun=1;
		while(rerun==1) {
			int func=0;
			double discountamount=0;
			double discountrate=0;
			boolean shopSetup=false;
			boolean bought=false;
			boolean finished=false;
			while(finished==false) {
				Intro();
				func=input.nextInt();
				if(func==1) {
					System.out.print("Please enter the number of items to setup shop: ");
					itemNum=input.nextInt();
					if(itemNum<=0) {
						System.out.print("Invalid Input. Enter a number > 0: ");
					}
					System.out.println();
					name=new String[itemNum];
					prices=new double[itemNum];
					discountPkges=new int[itemNum];
					packages=new double[itemNum];
					SetupShop(input, name, prices, discountPkges, itemNum, packages, discountamount, discountrate);
					discountamount=SetupShop1(input,discountamount);
					discountrate=SetupShop2(input,discountamount, discountrate);
					System.out.println();
					shopSetup=true;
				}else if(func==2) {
					if(shopSetup) {
						Buy(input, name, prices, discountPkges, itemNum,packages);
						System.out.println();
						bought=true;
					}else{
						System.out.println();
						System.out.println("Shop is not set up yet!");
						System.out.println();
					}
				}else if(func==3) {
					if(shopSetup) {
						if(bought) {
							ItemList(input, name, prices, discountPkges, itemNum, packages);

						}else {
							System.out.println();
							System.out.println("You have not bought anything!");
							System.out.println();
						}
					}else {
						System.out.println();
						System.out.println("Shop is not set up yet!");
						System.out.println();
					}
				}else if(func==4) {
					if(shopSetup) {
						if(bought) {
							Checkout(input, name, prices, discountPkges, itemNum, packages, discountamount, discountrate);
							System.out.println();
							System.out.println("Thanks for coming!");
							finished=true;
						}else {
							System.out.println();
							System.out.println("You have not bought anything!");
							System.out.println();
						}
					}else {
						System.out.println();
						System.out.println("Shop is not set up yet!");
						System.out.println();

					}
				}else {
					System.out.println("Invalid Response.");
				}

			}
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
			rerun=input.nextInt();
			System.out.println("-------------------------------------------------");
			System.out.println();
		}
	}
}

