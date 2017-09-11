package beaufort.retailordering;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class OrderTests {
	Order order;

	@Before
	public void setUp() throws Exception {
		order = new Order();
		order.setReceipt(new MockReceipt());
	}

	@Test
	public void purchaseTest() {
		assertNotNull(order.purchase("12345678"));
	}

	@Test
	public void purchase_receiptIncludesSkuTest() {
		String sku = "12345678";
		Receipt actualReceipt = order.purchase(sku);
		assertEquals(sku, ((MockReceipt)actualReceipt).addSkuString);
	}

}
