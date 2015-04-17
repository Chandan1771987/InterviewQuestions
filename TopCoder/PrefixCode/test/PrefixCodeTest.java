import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrefixCodeTest {
	
	@Test
	public void test0() {
		String[] words = new String[] {"trivial"};
		assertEquals("Yes", new PrefixCode().isOne(words));
	}
	
	@Test
	public void test1() {
		String[] words = new String[] {"10001", "011", "100", "001", "10"};
		assertEquals("No, 2", new PrefixCode().isOne(words));
	}
	
	@Test
	public void test2() {
		String[] words = new String[] {"no", "nosy", "neighbors", "needed"};
		assertEquals("No, 0", new PrefixCode().isOne(words));
	}
	
	@Test
	public void test3() {
		String[] words = new String[] {"1010", "11", "100", "0", "1011"};
		assertEquals("Yes", new PrefixCode().isOne(words));
	}
	
	@Test
	public void test4() {
		String[] words = new String[] {"No", "not"};
		assertEquals("Yes", new PrefixCode().isOne(words));
	}
}
