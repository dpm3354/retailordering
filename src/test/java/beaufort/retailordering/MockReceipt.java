package beaufort.retailordering;

public class MockReceipt implements Receipt{

	public String addSkuString;
	public void addSku(String sku) {
		addSkuString = sku;
	}
	
	public String addPriceString;
	public void addPrice(String price) {
		addPriceString = price;
	}
}
