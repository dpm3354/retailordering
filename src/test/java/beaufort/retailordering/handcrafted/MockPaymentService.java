/**
 * Copyright Beaufort Fairmont, LLC 2017. 
 * 
 * If you want to use this code, you can, simply by referencing 
 * Beaufort Fairmont and D Paul Merrill, http://beaufortfairmont.com
 */
package beaufort.retailordering.handcrafted;

import beaufort.retailordering.PaymentInfo;
import beaufort.retailordering.PaymentService;

public class MockPaymentService implements PaymentService{

	public boolean authorizeGetsCalled;
	public String authorizeReturn;

	public String authorize(PaymentInfo paymentInfo) {
		authorizeGetsCalled = true;
		return authorizeReturn;
	}

}
