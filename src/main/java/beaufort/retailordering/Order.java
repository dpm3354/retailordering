package beaufort.retailordering;

public class Order {
	
	private Receipt receipt;
	private PriceList priceList;
	private PaymentService paymentService;

	public Receipt purchase(String sku, String paymentType) {

		paymentService.authorize(new PaymentInfo(paymentType));
		receipt.addSku(sku);
		receipt.addPrice(priceList.getPrice(sku));
		receipt.addPaymentType(paymentType);
		return receipt;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public PriceList getPriceList() {
		return priceList;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}


}
