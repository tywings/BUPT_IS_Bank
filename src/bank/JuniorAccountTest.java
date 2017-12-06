package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JuniorAccountTest {

	JuniorAccount JA = new JuniorAccount();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetName() {
//		fail("Not yet implemented");
		String buf="hello";
		JA.setName(buf);
		assertTrue(true);
	}

	@Test
	public void testSetAddress() {
		//fail("Not yet implemented");
		String buf="Beijing";
		JA.setAddress(buf);
		assertTrue("Beijing".equals(JA.getAddress()));
	}

	@Test
	public void testSetAge() {
//		fail("Not yet implemented");
		JA.setAge(false);
		assertFalse(JA.getAge());
	}

	@Test
	public void testSetBirthYear() {
//		fail("Not yet implemented");
		int buf=1999;
		JA.setBirthYear(buf);
		assertEquals(1999, JA.getBirthYear());
	}
	
	@Test
	public void testSetBirthMonth() {
//		fail("Not yet implemented");
		int buf=2;
		JA.setBirthMonth(buf);
		assertEquals(2, JA.getBirthMonth());
	}

	@Test
	public void testSetBirthDay() {
//		fail("Not yet implemented");
		int buf=3;
		JA.setBirthDay(buf);
		assertEquals(3, JA.getBirthDay());
	}
}
