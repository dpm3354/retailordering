package beaufort.retailordering;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class OrderTests {
	Order order;

	@Before
	public void setUp() throws Exception {
		order = new Order();
	}

	@Test
	public void purchaseTest() {
		assertNotNull(order.purchase("12345678"));
		
	}

}
