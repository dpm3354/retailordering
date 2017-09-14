/**
 * Copyright Beaufort Fairmont, LLC 2017. 
 * 
 * If you want to use this code, you can, simply by referencing 
 * Beaufort Fairmont and D Paul Merrill, http://beaufortfairmont.com
 */
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
