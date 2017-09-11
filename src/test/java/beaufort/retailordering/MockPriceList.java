package beaufort.retailordering;

public class MockPriceList implements PriceList{

	public boolean getPriceForSkuGetsCalled = false;

	
	public String getPriceReturn;
	public boolean getPriceGetsCalled;
	public String getPrice(String sku) {
		// TODO Auto-generated method stub
		this.getPriceGetsCalled = true;
		return getPriceReturn;
	}

}
