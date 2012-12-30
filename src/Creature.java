
public abstract class Creature {
	private final String name;
	private int health = 5;
	private final int maxHealth = 5;
	
	protected Creature(final String givenName)
	{
		name = givenName;		
	}
	
	public int getHealth()
	{
		return this.health;
	}
	
	public boolean isAlive()
	{
		return this.health > 0;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void heal()
	{
		if (this.health < this.maxHealth) {
			this.health = this.health + 1;
		}
	}
	
	public void damage()
	{
		if (this.health > 0) {
			this.health = this.health - 1;
		}
	}
	
	public void attack(Creature victim)
	{
		if (victim != this) {
			victim.damage();
		}
	}
}
