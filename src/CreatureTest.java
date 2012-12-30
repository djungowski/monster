import org.junit.*;

import static org.junit.Assert.*;

public abstract class CreatureTest {
	protected Creature creature;
	protected int maxHealth;
	
	@Test
	public void testGetHealth()
	{
		int actual = this.creature.getHealth();
		assertSame(this.maxHealth, actual);
	}
	
	@Test
	public void testIsAlive()
	{
		assertTrue(this.creature.isAlive());
		
		// Alle Lebenspunkte wegnehmen und dann schauen,
		// dass die Kreatur tot ist
		final int health = this.creature.getHealth();
		for (int i = 0; i < health; i++) {
			this.creature.damage();
		}
		assertFalse(this.creature.isAlive());
	}
	
	@Test
	public void testHeal()
	{
		// Kann nicht mehr als maxHealth haben
		this.creature.heal();
		assertSame(this.maxHealth, this.creature.getHealth());
		
		// LP wegnehmen und dann wieder heilen
		this.creature.damage();
		this.creature.damage();
		this.creature.heal();
		int expected = this.maxHealth - 1;
		assertSame(expected, this.creature.getHealth());
	}
	
	@Test
	public void testDamage()
	{
		this.creature.damage();
		int expected = this.maxHealth - 1;
		int health = this.creature.getHealth();
		assertSame(expected, health);
		// Health kann nicht unter 0 sinken
		for (int i = 0; i < health; i++) {
			this.creature.damage();
		}
		assertSame(0, this.creature.getHealth());
	}
	
	@Test
	public void testAttack()
	{
		Human human2 = new Human("Egon");
		this.creature.attack(human2);
		int expected = this.maxHealth - 1;
		assertSame(expected, human2.getHealth());
	}
	
	@Test(expected=RuntimeException.class)
	public void testAttackNull()
	{
		this.creature.attack(null);
	}
	
	@Test
	public void testAttackItself()
	{
		this.creature.attack(this.creature);
		this.creature.attack(this.creature);
		assertSame(this.maxHealth, this.creature.getHealth());
	}
}
