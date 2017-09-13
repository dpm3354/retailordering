package beaufort.retailordering.handcrafted;

import beaufort.retailordering.DeliveryService;
import beaufort.retailordering.Order;

public class MockDeliveryService implements DeliveryService {

	public boolean deliverGetsCalled;

	public void deliverOrder(Order order) {
		deliverGetsCalled = true;
	}

}
