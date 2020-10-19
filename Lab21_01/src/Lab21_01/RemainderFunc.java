package Lab21_01;

import java.util.Scanner;

public class RemainderFunc {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		System.out.print("Please enter the max number: ");

		int maxnum=input.nextInt();
		while(maxnum<=0) {
			System.out.print("Invalid input. Please enter a valid max number (> 0): ");
			maxnum=input.nextInt();
		}

		System.out.print("Please enter the divisor: ");

		int divisor=input.nextInt();
		while(divisor<1) {
			System.out.print("Invalid input. Please enter a valid divisor (> 0): ");
			divisor=input.nextInt();
		}

		System.out.println("Multiples of "+divisor+" between 1 and "+maxnum+" (inclusive) are: ");
		for (int i=1; i<=maxnum; i++) {
			if(i%divisor == 0) {   
				//finds out if a number from 1 to max is a multiple of the divisor.
				System.out.println(i);
			}else if(maxnum<divisor){ 
				//no multiples exist if the max number is less than the divisor
				System.out.println("No number was found.");
				break;
			}
		}
	}
}