package cs622met;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseConnection {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ModelShoppings model = fetchDataFromModel();

		ShoppingsView view = new ShoppingsView();

		ShoppingController controller = new ShoppingController(model, view);
		controller.updateView();
//		 controller.setName("john");
		 //controller.updateView();

	}

	private static <T> ModelShoppings fetchDataFromModel() {
		ModelShoppings shopData = new PurchasedItems<T>();

		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:sqlite:shopping.db");

			Statement stm = con.createStatement();
			stm.setQueryTimeout(30);
			System.out.println("sqlite connected...");

			stm.executeUpdate("DROP TABLE IF EXISTS CUSTOMER");
			stm.executeUpdate("CREATE TABLE CUSTOMER (customerID INTEGER, name STRING)");

			stm.executeUpdate("DROP TABLE IF EXISTS ITEM");
			stm.executeUpdate(
					"CREATE TABLE ITEM (id int, itemName STRING, quantity INTEGER, itemUnitPrice INTEGER, itemPriority String )");

			Scanner scan = new Scanner(System.in);
			System.out.println("please enter your name.");
			String name = scan.next();
			shopData.setCustomerName(name);

			System.out.println("Please enter your ID  :");
			int ids = scan.nextInt();
			shopData.setCustomerID(ids);

			System.out.println("Please list items' name");
			String itemName = scan.next();
			shopData.setItemName(itemName);
			System.out.println("Please enter items id");
			int id = scan.nextInt();
			shopData.setItemId(id);

			System.out.println("Please give priority number for item:");
			String priority = scan.next();
			shopData.setItemPriority(priority);
			System.out.println("How many quantity do you want to buy?");
			int quantity = scan.nextInt();
			shopData.setQuantity(quantity);
			System.out.println("Please give unit price for item  :");
			int itemUnitPrice = scan.nextInt();
			shopData.setUnitItemPrice(itemUnitPrice);

			shopData.setTotalCost(itemUnitPrice * quantity);
			double totalCost = shopData.getQuantity();
			stm.executeUpdate("INSERT INTO CUSTOMER values('" + shopData.getCustomerID() + "', '"
					+ shopData.getCustomerName() + "')");

			stm.executeUpdate("INSERT INTO ITEM values('" + shopData.getItemId() + "', '" + shopData.getItemName()
					+ "', '" + shopData.getQuantity() + "', '" + shopData.getItemUnitPrice() + "', '"
					+ shopData.getItemPriority() + "')");

			ResultSet resultSet = stm.executeQuery("Select * from CUSTOMER");
			while (resultSet.next()) {
				System.out.println("\nCustomer Table\n---------------------------");
				System.out.println("CUSTOMER NAME" + "\t" + "CUSTOMER ID");
				System.out.println("---------------------------");
				System.out.println(resultSet.getString("name") + "\t" + "\t" + resultSet.getInt("customerID"));
				System.out.println("---------------------------");

			}

			ResultSet resultSetItem = stm.executeQuery("Select * from ITEM");
			while (resultSetItem.next()) {

				System.out.println("");
				System.out.println(
						"\nITEM Table\n----------------------------------------------------------------------");
				System.out.println(
						"itemNAME" + "\t" + "itemID" + "\t" + "quantity" + "\t" + "itemPrice" + "\t" + "itemPriority");
				System.out.println(resultSetItem.getString("itemName") + "\t" + "\t" + +resultSetItem.getInt("id")
						+ "\t" + resultSetItem.getInt("quantity") + "\t" + "\t" + resultSetItem.getInt("itemUnitPrice")
						+ "\t" + "\t" + resultSetItem.getInt("itemPriority"));
				System.out.println("----------------------------------------------------------------------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shopData;

	}

}
