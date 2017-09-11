package beaufort.retailordering;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class OrderTests {
	Order order;
	String sku = "12345678";
	String paymentType = "cash";
	MockPriceList mockPriceList = new MockPriceList();
	@Before
	public void setUp() throws Exception {
		order = new Order();
		order.setReceipt(new MockReceipt());
		mockPriceList = new MockPriceList();
		mockPriceList.getPriceReturn = "$12.00";
		order.setPriceList(mockPriceList);
	}

	@Test
	public void purchaseTest() {
		assertNotNull(order.purchase("12345678", paymentType));
	}

	@Test
	public void purchase_receiptIncludesSkuTest() {
		Receipt actualReceipt = order.purchase(sku, paymentType);
		assertEquals(sku, ((MockReceipt)actualReceipt).addSkuString);
	}

	@Test
	public void purchase_receiptIncludesPriceTest() {
		Receipt actualReceipt = order.purchase(sku, paymentType);
		
		assertEquals("$12.00", ((MockReceipt)actualReceipt).addPriceString);
	}

	@Test
	public void purchase_getsPriceForSkuTest() {
		order.purchase(sku, paymentType);
		assertTrue(((MockPriceList)order.getPriceList()).getPriceGetsCalled);
	}

	@Test
	public void purchase_receiptIncludesPaymentTypeTest() {
		Receipt actualReceipt = order.purchase(sku, paymentType);
		assertEquals("cash", ((MockReceipt)actualReceipt).addPaymentTypeString);
	}

}
