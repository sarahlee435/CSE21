import java.util.Scanner;

public class RunShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ShopArr shop = new ShopArr();
		Cheese cheese=new Cheese();
		System.out.print("Enter the number of Cheeses for shop setup: ");

		int max= input.nextInt();

		if (max<0) {
			System.out.print("Enter the number of Cheeses for shop setup: ");
			max= input.nextInt();
		}
		cheese.numCheese=0;
		shop.ShopArr(max);
		shop.run();

		System.out.println("Ran with Cheese Total: " + Cheese.numCheese);
		input.close();
	}

}
