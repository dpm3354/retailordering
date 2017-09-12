package beaufort.retailordering;

public class MockPaymentService implements PaymentService{

	public boolean authorizeGetsCalled;

	public String authorize(PaymentInfo paymentInfo) {
		authorizeGetsCalled = true;
		return "";
	}

}
