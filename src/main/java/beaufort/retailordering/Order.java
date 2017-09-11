package beaufort.retailordering;

public class Order {
	
	private Receipt receipt;
	
	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Receipt purchase(String sku) {
		receipt.addSku(sku);
		return receipt;
	}

}
