import org.junit.Test;
import static org.junit.Assert.*;

public class RainyRoadTest {
	
	@Test
	public void test0() {
		String[] road = new String[] {".W.."
,"...."};
		assertEquals("YES", new RainyRoad().isReachable(road));
	}
	
	@Test
	public void test1() {
		String[] road = new String[] {".W.."
,"..W."};
		assertEquals("YES", new RainyRoad().isReachable(road));
	}
	
	@Test
	public void test2() {
		String[] road = new String[] {".W..W.."
,"...WWW."};
		assertEquals("NO", new RainyRoad().isReachable(road));
	}
	
	@Test
	public void test3() {
		String[] road = new String[] {".."
,"WW"};
		assertEquals("YES", new RainyRoad().isReachable(road));
	}
	
	@Test
	public void test4() {
		String[] road = new String[] {".WWWW."
,"WWWWWW"};
		assertEquals("NO", new RainyRoad().isReachable(road));
	}
	
	@Test
	public void test5() {
		String[] road = new String[] {".W.W.W."
,"W.W.W.W"};
		assertEquals("YES", new RainyRoad().isReachable(road));
	}
	
	@Test
	public void test6() {
		String[] road = new String[] {".............................................W."
,".............................................W."};
		assertEquals("NO", new RainyRoad().isReachable(road));
	}

    @Test
	public void test7() {
		String[] road = new String[] {"W............................................W."
,".............................................W."};
		assertEquals("NO", new RainyRoad().isReachable(road));
	}
}
