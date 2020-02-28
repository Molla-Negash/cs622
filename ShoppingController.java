package cs622met;

public class ShoppingController {
	private ModelShoppings model;
	private ShoppingsView view;

	public ShoppingController(ModelShoppings model, ShoppingsView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void setName(String name) {
		model.setCustomerName(name);
	}

	public String getName() {
		return model.getCustomerName();

	}

	public void setAccount(int acc) {
		model.setBalance(acc);

	}

	public int getAccount() {
		return (int) model.getBankAccount();
	}

	public void setItem(String item) {
		model.setItemName(item);

	}

	public String setItem() {
		return model.getItemName();
	}

	public void setId(int id) {
		model.setCustomerID(id);
	}

	public int getId() {
		return model.getCustomerID();
	}

	public void setQuntity(double q) {
		model.setQuantity(q);
	}

	public double getquantity() {
		return model.getQuantity();
	}

	public void setPrice(double price) {
		model.setUnitItemPrice(price);

	}

	public double getPrice() {
		return model.getItemUnitPrice();
	}

	public void computeCost(double cost) {
		model.setTotalCost(cost);
	}

	public double getCost() {
		return model.getTotaCost();
	}

	public void computeBalance(double balance) {
		model.setBalance(balance);
	}

	public double getBalance() {
		return model.getbalance();
	}

	public void updateView() {
		
		view.viewShopping(model.getCustomerName(), model.getBankAccount(), model.getCustomerID(), model.getItemName(),
				          model.getItemId(), model.getQuantity(), model.getItemUnitPrice(), model.getTotaCost(),
				          model.getbalance());
	}
}
