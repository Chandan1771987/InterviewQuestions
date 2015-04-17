import org.junit.Test;
import static org.junit.Assert.*;

public class BirthdayTest {
	
	@Test
	public void test0() {
		String date = "06/17";
		String[] birthdays = new String[] {"02/17 Wernie", "10/12 Stefan"};
		assertEquals("10/12", new Birthday().getNext(date, birthdays));
	}
	
	@Test
	public void test1() {
		String date = "06/17";
		String[] birthdays = new String[] {"10/12 Stefan"};
		assertEquals("10/12", new Birthday().getNext(date, birthdays));
	}
	
	@Test
	public void test2() {
		String date = "02/17";
		String[] birthdays = new String[] {"02/17 Wernie", "10/12 Stefan"};
		assertEquals("02/17", new Birthday().getNext(date, birthdays));
	}
	
	@Test
	public void test3() {
		String date = "12/24";
		String[] birthdays = new String[] {"10/12 Stefan"};
		assertEquals("10/12", new Birthday().getNext(date, birthdays));
	}
	
	@Test
	public void test4() {
		String date = "01/02";
		String[] birthdays = new String[] {"02/17 Wernie",
 "10/12 Stefan",
 "02/17 MichaelJordan",
 "10/12 LucianoPavarotti",
 "05/18 WilhelmSteinitz"};
		assertEquals("02/17", new Birthday().getNext(date, birthdays));
	}
}
