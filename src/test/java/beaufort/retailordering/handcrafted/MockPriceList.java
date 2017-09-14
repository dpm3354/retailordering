/**
 * Copyright Beaufort Fairmont, LLC 2017. 
 * 
 * If you want to use this code, you can, simply by referencing 
 * Beaufort Fairmont and D Paul Merrill, http://beaufortfairmont.com
 */
package beaufort.retailordering.handcrafted;

import beaufort.retailordering.PriceList;

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
