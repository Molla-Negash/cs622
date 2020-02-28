package cs622met;

import org.junit.Test;

public class PurchasedItemsTestBankBalance {

	@Test
	public void testCustomerBankBalance() {
		UnPurchasedItems pur = new UnPurchasedItems();
		assert (pur.customerBankBalance() == 139.8);
		
	}

}




