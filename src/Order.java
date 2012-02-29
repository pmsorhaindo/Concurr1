import java.util.*;

/**
 * Class holding the details contained within an order.
 * The order objects created then can be passed by the OrdeList object to
 * Cook's or Cashier's as necessary.
 * @author Michael Sorhaindo
 *
 */
public class Order {
	
	private static int nextOrderID = 0;
	private int orderID;
	private Calendar timePlaced;
	private Calendar timeCooked;
	private String cashierName;
	private String cookName;
	
	/**
	  * On instantiation of an Order a this constuctor is called.
	  * It assigns the cashier name, sets a unique orderID,
	  * and sets the current time as the time the Order was placed.
	  * @param the Cashier's name is passed as a string via this parameter.
	  */
	public Order(String name){
		Order.nextOrderID = Order.nextOrderID+1;
		orderID = nextOrderID;
		cashierName = name;
		timePlaced = Calendar.getInstance();
		timeCooked = null;
	}
	/**
	  * Returns the unique orderID of the order
	  * @return an integer with the value of the orderID
	  */
	public int getOrderID(){
		return orderID;
	}
	
	/**
	  * Returns the cashier's name in the order
	  * This should be the name of the Cashier that created the order.
	  * @return a string holding the Cook's nam
	  */
	public String getCashierName(){
		return cashierName;
	}
	
	/**
	  * Returns the cook's name in the order
	  * This should be the name of the Cook that completed the order.
	  * @return a string holding the Cook's name
	  */
	public String getCookName(){
		return cookName;
	}
	
	/**
	  * Allows the Cashier name of the order to be set.
	  * @param name Name of the cashier as a String
	  */
	public void setCashierName(String name){
		cashierName = name;
	}
	
	/**
	  * Allows the Cook name of the order to be set.
	  * @param name Name of the cook as a String
	  */
	public void setCookName(String name){
		cookName = name;
	}
	
	/**
	  * Returns a formatted string of the Calendar value timePlaced.
	  * @return Formatted String containing the information of the order.
	  */
	public String getTimePlaced(){
		String time = doubleDigit(timePlaced.get(11))+":"+doubleDigit(timePlaced.get(12))+":"
		+doubleDigit(timePlaced.get(13))+":"+tripleDigit(timePlaced.get(14));
		return time;
	}
	
	/**
	  * Returns a formatted string of the Calendar value timeCooked.
	  * @return formatted String containing the information of the order.
	  */
	public String getTimeCooked(){
		String time = doubleDigit(timeCooked.get(11))+":"+doubleDigit(timeCooked.get(12))+":"
		+doubleDigit(timeCooked.get(13))+":"+tripleDigit(timeCooked.get(14));;
		return time;
	}
	
	/**
	  * Gets the current time and saves it via the Calendar's method getInstance().
	  * This is stored within the order as the time the Order is completed.
	  */
	public void setCookedTime(){
		timeCooked=Calendar.getInstance();
	}
	
	/**
	  * Formats an hours or minutes integer value as a string so it can be displayed with
	  * leading 0's to keep it consistently 2 characters long.
	  * @param singleDigit the integer that needs to be formatted
	  * @return formatted String containing the hours/minutes.
	  */
	public String doubleDigit(int singleDigit){
		String doubleTime = Integer.toString(singleDigit);
		String zero = "0";
		if (doubleTime.length() == 1){
			zero += doubleTime;
			return zero;
		}
		return doubleTime;
	}
	
	/**
	  * Formats an milliseconds integer value as a string so it can be displayed with
	  * leading 0's to keep it consistently 3 characters long.
	  * @param digit The integer that needs to be formatted
	  * @return A formatted String containing the milliseconds
	  */
	public String tripleDigit(int digit){
		String tripleTime = Integer.toString(digit);
		String zero = "0";
		
		if (tripleTime.length() == 1){
			zero = zero + zero + tripleTime;
			return zero;
		}
		if (tripleTime.length() == 2){
			zero += tripleTime;
			return zero;
		}
		return tripleTime;
	}

}
