package beaufort.retailordering;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class OrderTests {
	Order order;
	String sku = "12345678";
	@Before
	public void setUp() throws Exception {
		order = new Order();
		order.setReceipt(new MockReceipt());
		order.setPriceList(new MockPriceList());
	}

	@Test
	public void purchaseTest() {
		assertNotNull(order.purchase("12345678"));
	}

	@Test
	public void purchase_receiptIncludesSkuTest() {
		Receipt actualReceipt = order.purchase(sku);
		assertEquals(sku, ((MockReceipt)actualReceipt).addSkuString);
	}

	@Test
	public void purchase_receiptIncludesPriceTest() {
		Receipt actualReceipt = order.purchase(sku);
		assertEquals("price", ((MockReceipt)actualReceipt).addPriceString);
	}

	@Test
	public void purchase_getsPriceForSkuTest() {
		Receipt actualReceipt = order.purchase(sku);
		assertTrue(((MockPriceList)order.getPriceList()).getPriceGetsCalled);
	}


}
