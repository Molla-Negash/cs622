package cs622met;

import java.io.Serializable;

/** Abstract class **/
abstract class ModelShoppings implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Instant fields or data members.
	private String customerName;
	private double bankAccount;
	private int customerID;
	private String itemName;
	private int id;
	private double quantity;
	private double itemUnitPrice;
	private String itemPriority;
	private double totaCost;
	private double balance;

	/** non parameterized Constructor **/
	public ModelShoppings() {

	}

	public ModelShoppings(String customerName, int customerID) {
		super();
		this.customerName = customerName;
		this.customerID = customerID;
	}

	public ModelShoppings(String customerName, double bankAccount, int customerID, String itemName, int id,
			double quantity, double itemUnitPrice, String itemPriority, double totaCost, double balance) {

		super();
		this.customerName = customerName;
		this.bankAccount = bankAccount;
		this.customerID = customerID;
		this.itemName = itemName;
		this.quantity = quantity;
		this.itemUnitPrice = itemUnitPrice;
		this.itemPriority = itemPriority;
		this.totaCost = totaCost;
		this.balance = balance;
		//market();
	}

	/** getter and setters. **/

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String name) {
		customerName = name;

	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int id) {
		// TODO Auto-generated method stub
		customerID = id;

	}

	public void setBankAccount(double ba) {

		bankAccount = ba;
	}

	public double getBankAccount() {
		return bankAccount;

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemId() {
		return id;

	}

	public void setItemId(int id) {
		this.id = id;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setBalance(double balance) {

		this.balance = balance;
	}

	public double getbalance() {
		return balance;

	}

	public double getTotaCost() {
		return totaCost;
	}

	public void setTotalCost(double totaCost) {

		this.totaCost = totaCost;

	}

	public double getItemUnitPrice() {
		return itemUnitPrice;
	}

	public void setUnitItemPrice(double price) {
		itemUnitPrice = price;

	}

	public String getItemPriority() {
		return itemPriority;
	}

	public void setItemPriority(String itemPriority) {
		this.itemPriority = itemPriority;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof ModelShoppings))
			return false;
		/** type casting of the argument. **/
		ModelShoppings x = (ModelShoppings) obj;
		/** comparing the state of argument with the state of 'this' Object. **/
		if (this.itemName.equalsIgnoreCase(x.getItemName()))
			return true;

		return false;
	}

	/**
	 * Abstract method to identify items to be purchased and unpurchased in both
	 * classes. Because the two classes have different algorithm for calculating
	 * total cost and prioritizing it.
	 * @return 
	 * 
	 ***/
 abstract void market();

	@Override
	public String toString() {
		return "Shoppings [customerName=" + customerName + ", banckAcount=" + bankAccount + ", customerID=" + customerID
				+ ", itemName=" + itemName + ", id=" + id + ", quantity=" + quantity + ", itemUnitPrice="
				+ itemUnitPrice + ", itemPriority=" + itemPriority + ", totaCost=" + totaCost + ", balance=" + balance
				+ "]";
	}

}
