package Lab21_05;

import java.util.Scanner;

public class Testing {
	public static void main(String[] args) {
		int max = 0;
		
		Scanner input = new Scanner (System.in);

		System.out.print("Enter the max number:" );
		max=input.nextInt();
		int [] arr = new int [max];
		for(int i = 0; i<max; i++) {
			System.out.print("Enter the value number"+i+":" );
			arr[i]=input.nextInt();
		}
		for(int i = 0; i<max; i++) {
			arr[i]=arr[i]*arr[i];
			System.out.println(arr[i]);
		}
		if(arr.length==0) {
			System.out.println(0);
			
		}

	}
	
}
