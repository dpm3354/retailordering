/**
 * Copyright Beaufort Fairmont, LLC 2017. 
 * 
 * If you want to use this code, you can, simply by referencing 
 * Beaufort Fairmont and D Paul Merrill, http://beaufortfairmont.com
 */
package beaufort.retailordering.handcrafted;

import beaufort.retailordering.DeliveryService;
import beaufort.retailordering.Order;

public class MockDeliveryService implements DeliveryService {

	public boolean deliverGetsCalled;

	public void deliverOrder(Order order) {
		deliverGetsCalled = true;
	}

}
