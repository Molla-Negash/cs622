package cs622met;

public class MainShopping {

	public static void main(String[] args) {

		ModelShoppings model = new PurchasedItems<Object>();
		ShoppingsView view = new ShoppingsView();
		ShoppingController controller = new ShoppingController(model, view);
		controller.updateView();
		
		
		MainShopping main = new MainShopping();
		main.marketApp();

	}

	public void marketApp() {
		ModelShoppings shp = new PurchasedItems<Object>();

		PurchasedItems<Object> pItems = new PurchasedItems<Object>();
		ModelShoppings sh = (ModelShoppings) pItems;
		((PurchasedItems<Object>) sh).market();

	}

}
