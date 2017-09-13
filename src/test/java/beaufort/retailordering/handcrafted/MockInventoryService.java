package beaufort.retailordering.handcrafted;

import beaufort.retailordering.InventoryService;

public class MockInventoryService implements InventoryService {

	public boolean isInStockGetsCalled;
	public boolean isInStockReturn;
	
	public boolean isInStock(String sku) {
		isInStockGetsCalled = true;
		return isInStockReturn;
	}

}
