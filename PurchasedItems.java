package cs622met;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/** PurchasedItems:child class extends parent class:Shoppings1. **/
public class PurchasedItems<T> extends ModelShoppings {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public double computeCost() {

		ModelShoppings item = new PurchasedItems<Object>();
		item.setUnitItemPrice(5.1);
		item.setQuantity(2);
		double computeTotalCost = item.getItemUnitPrice() * item.getQuantity();
		return computeTotalCost;

	}

	public double customerBankBalance() {
		ModelShoppings item = new PurchasedItems<Object>();
		item.setBankAccount(150);

		double balance = item.getBankAccount() - computeCost();
		return balance;

	}

	public double market1() {

		ModelShoppings item = new PurchasedItems();
		item.setUnitItemPrice(5.1);
		item.setQuantity(2);
		
		double price = computeCost()/item.getQuantity();
		return price;

	}

	public void market() {
		int element = 2;
		int y = 0;

		/** array list **/
		List<ModelShoppings> list = new ArrayList<>();
		Stream<ModelShoppings> str = list.stream();
		str.forEach(s -> System.out.println(list));

		/** scanner class **/
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Welcome to our shopping site! Try to list your items you are interseted in and add to your cart please!");
		while (y == 0) {
			for (int i = 0; i < element; i++) {
				ModelShoppings item = new PurchasedItems<Object>();
				PurchasedItems<?> pItems = (PurchasedItems<?>) item;

				/** Object creation **/

				/**
				 * Take input from the user that puts the shopping item name and priority into
				 * an array.
				 **/

				System.out.println("\nPlease list items' name" + " " + i);
				try {
					String iName = scan.nextLine();

					pItems.setItemName(iName);
				} catch (InputMismatchException e) {
					// catch the exception
					System.out.printf("%nException: %s%n", e);
					System.out.println("Please try again.");
					scan.nextLine();// Discard input so the user can try again
				}

				/**
				 * Only have one entry of any type in the list: if the user tries to add the
				 * same item twice, this pseudo code tells the user that it is already on the
				 * list.
				 */

				if (list.contains(item)) {

					System.out.println("item" + " " + i + " " + "is already in the list;try to list another item.");
					String itName = scan.nextLine();
					item.setItemName(itName);
					list.add(item);

				} else {

					System.out.println("Please give priority number for item:" + " " + i);

					String priority = scan.nextLine();

					item.setItemPriority(priority);

					System.out.println("How many quantity do you want to buy?" + " " + i);

					try {
						double quantity = scan.nextDouble();
						item.setQuantity(quantity);
					} catch (InputMismatchException e) {
						// catch the exception
						System.out.printf("%nException: %s%n", e);
						System.out.println("Please try again.");
						scan.nextLine();// Discard input so the user can try again
					}
					System.out.println("Please give unit price for item  :" + " " + i);

					try {
						double uPrice = scan.nextDouble();
						double totalCost = item.getQuantity() * uPrice;
						item.setUnitItemPrice(uPrice);
						item.setTotalCost(totalCost);
					} catch (InputMismatchException e) {
						// catch the exception
						System.out.printf("%nException: %s%n", e);
						System.out.println("Please try again.");
						scan.nextLine();// Discard input so the user can try again
					}

					System.out.println("please enter your name.");
					String name = scan.next();// single word

					String customerNameNew = "";
					int count = 0;
					while (count < name.length() - 1) {
						// use regex
						if ((name.equals("a-zA-Z") == false)) {
							customerNameNew = name.replaceAll("[^a-zA-Z]", "").replaceAll("[0-9]", "");
							count++;
						} else {
							customerNameNew = name;
							count++;
						}

					}
					item.setCustomerName(customerNameNew);

					System.out.println("Enter your bank balance?");
					try {
						double banckAcaount = scan.nextDouble();

						item.setBankAccount(banckAcaount);
					} catch (InputMismatchException e) {
						// catch the exception
						System.out.printf("%nException: %s%n", e);
						System.out.println("Please try again.");
						scan.nextLine();// Discard input so the user can try again
					}

					double bal = item.getBankAccount();
					item.setBalance(bal);
					list.add(item);
					scan.nextLine();

				}
			}

			/** Output before sorting **/
			System.out.println("Shopping list at mycart befor purchased:");

			list.forEach(n -> System.out.println("Shopping list with Customer information :" + " " + n));

			// Sorting with lambda expression(Java 8)

			Collections.sort(list, (a, b) -> a.getItemPriority().compareToIgnoreCase(b.getItemPriority()));

			/** purchase as many items on the list by priority, using $59.00. **/
			ArrayList<ModelShoppings> itemsPurchasedList = new ArrayList<>();

			double priceCeilings = 59.0;
			Double totalCost = 0.0;
			for (int i = 0; i < element; i++) {
				ModelShoppings item1 = list.get(i);
				System.out.println("\nPress y to purchase :" + " " + item1.getItemName());
				String ans = scan.nextLine();
				if (ans.equalsIgnoreCase("y")) {
					totalCost += item1.getItemUnitPrice() * item1.getQuantity();
					item1.setTotalCost(totalCost);
					double balance = item1.getBankAccount() - totalCost;
					item1.setBalance(balance);
					if (totalCost > priceCeilings) {
						System.out.println(item1.getItemName() + " " + "can't be added due to cost.");

					}
					itemsPurchasedList.add(item1);
				}

			}

			Stream<ModelShoppings> strm = itemsPurchasedList.stream();
			System.out.println("stream objects");
			strm.forEach(s -> System.out.printf("\n%s", s));

			System.out.println("\npurchased shipping lists:");

			itemsPurchasedList.forEach(n -> System.out.println("Shopping :" + " " + n));

//			main.marketApp();
			System.out.println("\nThank you for your business. Come back soon.");
			System.out.println("Do you want to proceed?    Y/N");
			String answer = scan.nextLine();
			if (answer.equalsIgnoreCase("N")) {
				y = -1;
			} else {
			}

		}

		scan.close();
	}

}
