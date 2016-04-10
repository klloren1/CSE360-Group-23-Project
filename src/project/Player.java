package project;

/**
 * Class for containing information of player.
 */
public class Player {
	
	public User user;
	public int score;
	public boolean won;
	
	/**
	 * Constructor of player.
	 * @param user user profile to be used.
	 */
	public Player(User user)
	{
		this.user = user;
		score = 0;
		won = false;
	}
	
	/**
	 * Method to retrieve the name of the user.
	 * @return String containing name of user.
	 */
	public String getName()
	{
		return user.getName();
	}
	
}
