package beaufort.retailordering;

public class MockDeliveryService implements DeliveryService {

	public boolean deliverGetsCalled;

	public void deliverOrder(Order order) {
		deliverGetsCalled = true;
	}

}
