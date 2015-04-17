import org.junit.Test;
import static org.junit.Assert.*;

public class TheQuestionsAndAnswersDivTwoTest {
	
	@Test
	public void test0() {
		String[] questions = new String[] {"How_are_you_doing?", "How_do_you_like_our_country?", "How_are_you_doing?"};
		assertEquals(4, new TheQuestionsAndAnswersDivTwo().find(questions));
	}
	
	@Test
	public void test1() {
		String[] questions = new String[] {"Whazzup?"};
		assertEquals(2, new TheQuestionsAndAnswersDivTwo().find(questions));
	}
	
	@Test
	public void test2() {
		String[] questions = new String[] {"Are_you_ready?", "Are_you_ready?", "Are_you_ready?", "Are_you_ready?"};
		assertEquals(2, new TheQuestionsAndAnswersDivTwo().find(questions));
	}
	
	@Test
	public void test3() {
		String[] questions = new String[] {"Do_you_like_my_story?", "Do_you_like_my_story", "DO_YOU_LIKE_MY_STORY?", "Do__you__like__my__story?"};
		assertEquals(16, new TheQuestionsAndAnswersDivTwo().find(questions));
	}
}
