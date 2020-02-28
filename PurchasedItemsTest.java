package cs622met;



import org.junit.Test;

public class PurchasedItemsTest {

	@Test
	public void testTotalCost() {
		UnPurchasedItems pur = new UnPurchasedItems();
		assert(pur.computeCost()==10.2);
		
	}
}
