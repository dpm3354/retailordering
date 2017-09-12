package beaufort.retailordering;

public class MockInventoryService implements InventoryService {

	public boolean isInStockGetsCalled;
	public boolean isInStockReturn;
	
	public boolean isInStock(String sku) {
		isInStockGetsCalled = true;
		return isInStockReturn;
	}

}
