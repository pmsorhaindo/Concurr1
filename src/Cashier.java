import java.util.*;

/**
 * Class detailing the Cook's actions. The class is designed to run as a separate thread and implements Runnable.
 * @author Michael Sorhaindo
 */
public class Cashier implements Runnable {
	
	private OrderList kitchen;
	private String cashierName;
	
	/**
	 * The constructor for Cashier takes the OrderList, symbolising the kitchen that the Cashier is working in, and the Cashier's name.
	 * @param nameText the Cashier's name as a sting.
	 * @param kitchenName the kitchen the Cashier is assigned as an OrderList object.
	 */
	public Cashier(String nameText, OrderList kitchenName){
		cashierName = nameText;
		kitchen = kitchenName;
	}
	
	/**
	 * This method details the Cook's actions which consists of:
	 * Sleeping for up to 5 seconds,
	 * and then adding and Order via the OrderList's function .addOrder()
	 * The cashier also prints the order object which is returned by the OrderList.
	 */
	public void run(){
		int i = 0;
		/* limit the amount of orders produced to 30 to prevent it producing orders indefinately
		 this is for testing purposes if the cook were to continue working indefinately
		 this would be "while (true) {..."
		*/
		while(i < 30) 
		{
			Random r = new Random();
			try {
				Thread.sleep(r.nextInt(4999));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Order tempOrder = kitchen.addOrder(cashierName);
			System.out.println("Cashier: " + cashierName + "  " + tempOrder.getOrderID() + "  Placed at: "
			+ tempOrder.getTimePlaced());
			i=i+1;
		}
	}
	
}
