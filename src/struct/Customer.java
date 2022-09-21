package struct;

/*
 * Author: Tran Duc Viet
 */
public class Customer {	
	protected String fullName;
	protected String address;
	protected String phoneNumber;
	protected Cart cart = new Cart();
	
	public void setInfo(String fullName, String address, String phoneNumber) {
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Cart getCart() {
		return cart;
	}
	
	public String getFullName() {
		return fullName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	
}
