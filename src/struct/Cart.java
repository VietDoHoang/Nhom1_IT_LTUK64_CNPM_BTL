package struct;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Tran Duc Viet
 * Contains all device are being in the cart.
 * Calculate total cost, total profit after user want to pay 
 */
public class Cart {
	protected List<Device> list = new ArrayList<Device>();
	protected double totalCost, totalProfit;
	
	public void add(Device newDv) {
		Device tempDv;
		if (newDv.getType() == Device.LAPTOP_TYPE) tempDv = new Laptop(newDv);
		else tempDv = new Phone(newDv);
		tempDv.amount = 1;
		
		if (list.contains(tempDv)) {
			int i = list.indexOf(tempDv);
			list.get(i).amount += tempDv.amount;
		}
		else {
			list.add(tempDv);
		}
		totalCost += tempDv.sellPrice;
		totalProfit += tempDv.sellPrice - tempDv.costPrice;
	}
	
	public List<Device> getList() {
		return list;
	}
	
	public double getTotalCost() {
		return Math.round(totalCost*100)/100;
	}
	
}
