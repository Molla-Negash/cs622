package cs622met;



import org.junit.Test;

public class PurchasedItemsTestMarket {

	
	@Test
	public void testMarket1() {
		PurchasedItems<?> p = new PurchasedItems();
		assert (p.market1()==5.1);
	}

}
