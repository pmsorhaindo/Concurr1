
public class Main {
	public static void main(String[] args){
		
		OrderList kitchenYo = new OrderList();
		
		Thread cook1 = new Thread(new Cook("Fred",kitchenYo), "cook1");
		Thread cashier1 = new Thread(new Cashier("Bob",kitchenYo), "cashier1");

		Thread cook2 = new Thread(new Cook("Bill",kitchenYo), "cook1");
		Thread cashier2 = new Thread(new Cashier("Ed",kitchenYo), "cashier1");
		
		cook1.start();
		cashier1.start();
		cook2.start();
		cashier2.start();
		
		
	}
}
