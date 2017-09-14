/**
 * Copyright Beaufort Fairmont, LLC 2017. 
 * 
 * If you want to use this code, you can, simply by referencing 
 * Beaufort Fairmont and D Paul Merrill, http://beaufortfairmont.com
 */
package beaufort.retailordering;

public interface Receipt {

	void addSku(String sku);

	void addPrice(String string);

	void addPaymentType(String string);

}
