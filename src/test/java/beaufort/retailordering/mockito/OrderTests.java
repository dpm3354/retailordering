/**
 * Copyright Beaufort Fairmont, LLC 2017. 
 * 
 * If you want to use this code, you can, simply by referencing 
 * Beaufort Fairmont and D Paul Merrill, http://beaufortfairmont.com
 */
package beaufort.retailordering.mockito;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import beaufort.retailordering.DeliveryService;
import beaufort.retailordering.InventoryService;
import beaufort.retailordering.Order;
import beaufort.retailordering.PaymentInfo;
import beaufort.retailordering.PaymentService;
import beaufort.retailordering.PriceList;
import beaufort.retailordering.Receipt;

import static org.mockito.Mockito.*;

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

		mockReceipt = mock(Receipt.class);
		order.setReceipt(mockReceipt);

		mockPaymentService = mock(PaymentService.class);
		when(mockPaymentService.authorize(any(PaymentInfo.class))).thenReturn("Confirmed.");
		order.setPaymentService(mockPaymentService);

		mockPriceList = mock(PriceList.class);
		when(mockPriceList.getPrice(anyString())).thenReturn("$12.00");
		order.setPriceList(mockPriceList);

		mockInventoryService = mock(InventoryService.class);
		when(mockInventoryService.isInStock(sku)).thenReturn(true);
		order.setInventoryService(mockInventoryService);

		mockDeliveryService = mock(DeliveryService.class);
		order.setDeliveryService(mockDeliveryService);		
	}

	@Test
	public void purchaseTest() {
		assertNotNull(order.purchase(sku, paymentType));
	}
	
	@Test
	public void purchase_receiptIncludesSkuTest() {
		Receipt actualReceipt = order.purchase(sku, paymentType);
		verify(actualReceipt, times(1)).addSku(sku);
	}

	@Test
	public void purchase_receiptIncludesPriceTest() {
		Receipt actualReceipt = order.purchase(sku, paymentType);
		verify(actualReceipt, times(1)).addPrice("$12.00");
	}
	
	@Test
	public void purchase_getsPriceForSkuTest() {
		order.purchase(sku, paymentType);
		verify(mockPriceList, times(1)).getPrice(sku);
	}
	
	@Test
	public void purchase_receiptIncludesPaymentTypeTest() {
		Receipt actualReceipt = order.purchase(sku, paymentType);
		verify(actualReceipt, times(1)).addPaymentType("cash");
	}
	
	@Test
	public void purchase_callsPaymentService() {
		order.purchase(sku, paymentType);
		verify(mockPaymentService, times(1)).authorize(any(PaymentInfo.class));
	}
	
	@Test
	public void purchase_callsInventoryService() {
		order.purchase(sku, paymentType);
		verify(mockInventoryService, times(1)).isInStock(sku);
	}
	
	@Test
	public void purchase_callsDeliveryService() {
		order.purchase(sku, paymentType);
		verify(mockDeliveryService, times(1)).deliverOrder(any(Order.class));
	}
}
