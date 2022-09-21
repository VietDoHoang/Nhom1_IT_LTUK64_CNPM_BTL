package struct;

/*
 * Author: Tran Duc Viet
 */
public class MainProcess {
	private Customer customer = new Customer();
	private Cart cart = customer.cart;
	
	public void pay(String fullName, String address, String phoneNumber) {
		customer.setInfo(fullName, address, phoneNumber);
		History.add(customer);
		new GUI.Bill(customer);
		customer = new Customer();
		this.cart = customer.cart;
	}
	
	public void addToCart(Device dv) {
		if (dv.amount > 0) {
			dv.amount--;
			cart.add(dv);
		}
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
