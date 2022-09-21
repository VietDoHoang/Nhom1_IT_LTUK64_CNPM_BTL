package struct;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Do Hoang Viet
 */
public class History {
	private static List<Customer> customers = new ArrayList<Customer>();
	private static double sales;
	private static double profit;
	
	public static void add(Customer customer) {
		customers.add(customer);
		profit += customer.cart.totalProfit;
		sales += customer.cart.totalCost;
	}

	public static List<Customer> getCustomers() {
		return customers;
	}
	
	public static double getProfit() {
		return Math.round(profit*100)/100;
	}
	
	public static double getSales() {
		return Math.round(sales*100)/100;
	}
	
}
