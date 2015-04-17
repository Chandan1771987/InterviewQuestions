import org.junit.Test;
import static org.junit.Assert.*;

public class CheatingQuizTest {
	
	@Test
	public void test0() {
		String answers = "AAAAA";
		assertArrayEquals(new int[] {1, 1, 1, 1, 1 }, new CheatingQuiz().howMany(answers));
	}
	
	@Test
	public void test1() {
		String answers = "AAABBB";
		assertArrayEquals(new int[] {2, 2, 2, 1, 1, 1 }, new CheatingQuiz().howMany(answers));
	}
	
	@Test
	public void test2() {
		String answers = "CAAAAAC";
		assertArrayEquals(new int[] {2, 2, 2, 2, 2, 2, 1 }, new CheatingQuiz().howMany(answers));
	}
	
	@Test
	public void test3() {
		String answers = "BBCA";
		assertArrayEquals(new int[] {3, 3, 2, 1 }, new CheatingQuiz().howMany(answers));
	}
	
	@Test
	public void test4() {
		String answers = "BACACABCBBBBCAAAAACCCABBCAA";
		assertArrayEquals(new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 1 }, new CheatingQuiz().howMany(answers));
	}

    @Test
	public void test5() {
		String answers = "";
		assertArrayEquals(new int[] {}, new CheatingQuiz().howMany(answers));
	}

    @Test
	public void test6() {
		String answers = "A";
		assertArrayEquals(new int[] {1}, new CheatingQuiz().howMany(answers));
	}
        @Test
	public void test7() {
		String answers = "BBBBBBBBBBBBBBBBBBBB";
		assertArrayEquals(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new CheatingQuiz().howMany(answers));
	}
}
