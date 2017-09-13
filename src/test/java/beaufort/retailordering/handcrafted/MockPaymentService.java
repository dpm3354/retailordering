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
