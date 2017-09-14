/**
 * Copyright Beaufort Fairmont, LLC 2017. 
 * 
 * If you want to use this code, you can, simply by referencing 
 * Beaufort Fairmont and D Paul Merrill, http://beaufortfairmont.com
 */
package beaufort.retailordering.handcrafted;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import beaufort.retailordering.DeliveryService;
import beaufort.retailordering.InventoryService;
import beaufort.retailordering.Order;
import beaufort.retailordering.PaymentService;
import beaufort.retailordering.PriceList;
import beaufort.retailordering.Receipt;

public class OrderTests {
	Order order;
	String sku = "12345678";
	String paymentType = "cash";
	Receipt mockReceipt;
	PriceList mockPriceList;
	PaymentService mockPaymentService;
	InventoryService mockInventoryService;
	DeliveryService mockDeliveryService;
	
	@Before
	public void setUp() throws Exception {
		order = new Order();
		
		mockReceipt = new MockReceipt();
		order.setReceipt(mockReceipt);

		mockPaymentService = new MockPaymentService();
		((MockPaymentService)mockPaymentService).authorizeReturn = "Confirmed.";
		order.setPaymentService(mockPaymentService);

		mockPriceList = new MockPriceList();
		((MockPriceList)mockPriceList).getPriceReturn = "$12.00";
		order.setPriceList(mockPriceList);
		
		mockInventoryService = new MockInventoryService();
		((MockInventoryService)mockInventoryService).isInStockReturn = true;
		order.setInventoryService(mockInventoryService);

		mockDeliveryService = new MockDeliveryService();		
		order.setDeliveryService(mockDeliveryService);
	}

	@Test
	public void purchaseTest() {
		assertNotNull(order.purchase(sku, paymentType));
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
	
	@Test
	public void purchase_callsPaymentService() {
		order.purchase(sku, paymentType);
		assertTrue(((MockPaymentService)mockPaymentService).authorizeGetsCalled);
	}
	
	@Test
	public void purchase_callsInventoryService() {
		order.purchase(sku, paymentType);
		assertTrue(((MockInventoryService)mockInventoryService).isInStockGetsCalled);
	}
	
	@Test
	public void purchase_callsDeliveryService() {
		order.purchase(sku, paymentType);
		assertTrue(((MockDeliveryService)mockDeliveryService).deliverGetsCalled);
	}

}
