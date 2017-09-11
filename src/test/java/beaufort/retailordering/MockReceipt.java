package beaufort.retailordering;

public class MockReceipt implements Receipt{

	public String addSkuString;
	public void addSku(String sku) {
		addSkuString = sku;
	}

}
