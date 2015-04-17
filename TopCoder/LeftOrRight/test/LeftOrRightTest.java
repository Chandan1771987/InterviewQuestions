import org.junit.Test;
import static org.junit.Assert.*;

public class LeftOrRightTest {
	
	@Test
	public void test0() {
		String program = "LLLRLRRR";
		assertEquals(3, new LeftOrRight().maxDistance(program));
	}
	
	@Test
	public void test1() {
		String program = "R???L";
		assertEquals(4, new LeftOrRight().maxDistance(program));
	}
	
	@Test
	public void test2() {
		String program = "??????";
		assertEquals(6, new LeftOrRight().maxDistance(program));
	}
	
	@Test
	public void test3() {
		String program = "LL???RRRRRRR???";
		assertEquals(11, new LeftOrRight().maxDistance(program));
	}
	
	@Test
	public void test4() {
		String program = "L?L?";
		assertEquals(4, new LeftOrRight().maxDistance(program));
	}
}
