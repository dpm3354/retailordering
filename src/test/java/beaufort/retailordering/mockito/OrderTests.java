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

}
