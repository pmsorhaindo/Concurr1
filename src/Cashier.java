import java.util.*;

public class Cashier implements Runnable {
	
	private OrderList kitchen;
	private String cashierName;
	
	
	public Cashier(String nameText, OrderList kitchenName){
		cashierName = nameText;
		kitchen = kitchenName;
	}
	
	public void run(){
		int i = 0;
		while(i < 30)
		{
			Random r = new Random();
			try {
				Thread.sleep(r.nextInt(4999));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Order tempOrder = kitchen.addOrder(cashierName);
			System.out.println("Cashier: " + cashierName + "  " + tempOrder.getOrderID() + "  Placed at: "
			+ tempOrder.getTimePlaced());
			i=i+1;
		}
	}
	
}
