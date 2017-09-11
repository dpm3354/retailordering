package beaufort.retailordering;

public class Order {
	
	private Receipt receipt;
	private PriceList priceList;

	public Receipt purchase(String sku, String paymentType) {
		receipt.addSku(sku);
		String price = priceList.getPrice(sku);
		receipt.addPrice(price);
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
		// TODO Auto-generated method stub
		return priceList;
	}

}
