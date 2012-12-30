import org.junit.*;

import static org.junit.Assert.*;

public class HumanTest extends CreatureTest {
	@Before
	public void setUp()
	{
		this.creature = new Human("Horst");
		this.maxHealth = 5;
	}
	
	@Test
	public void testCreation()
	{
		assertTrue(this.creature instanceof Human);
	}
	
	@Test
	public void testGetName()
	{
		String actual = this.creature.getName();
		assertSame("Horst", actual);
	}
}
