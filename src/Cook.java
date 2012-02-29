import java.util.*;

/**
 * Class detailing the Cook's actions. The class is designed to run as a separate thread and implements Runnable.
 * @author Michael Sorhaindo
 */
public class Cook implements Runnable {
	
	//Private Class Variables
	private String cookName; // Cook name used to identify individual cooks.
	private OrderList kitchen; // The kitchen the cook works in
	
	Cook(String textCookName, OrderList kitchenObject){
		cookName = textCookName;
		kitchen=kitchenObject;
	}
	
	public void run(){
		while (true){
		this.cookOrder();
		}
	}
	
	/**
	  * Returns the Cook's name.
	  * @return a string holding the Cook's name
	  */
	public String getCookName() {
		return cookName;
	}

	/**
	 * Allows for the changing of the cook's name
	 * @param cookNameText The new value for the cook's name.
	 */
	public void setCookName(String cookNameText) {
		cookName = cookNameText;
	}
	
	/**
	 * Details the process of cooking an order which includes.
	 * Calling OrderList's removeOrder function.
	 * Sleeping
	 * and Outputing the resulting cooked Order.
	 */
	public void cookOrder(){
		Order toCook = kitchen.removeOrder(this.cookName);
		Random r = new Random();
		try{
			Thread.sleep(r.nextInt(6999)); // random int used for its value as milliseconds between 0 and 6999.
		}
		catch (Exception e){
		}
		toCook.setCookedTime();
		System.out.println("Cook: " + toCook.getCookName() + " finished cooking Order " + toCook.getOrderID() 
			+  " at: " + toCook.getTimeCooked() + ". It was placed at: " + toCook.getTimePlaced()
			+ " by " + toCook.getCashierName());
	}
	

}
