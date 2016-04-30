package project;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Class for containing information of individual users.
 */
public class User implements java.io.Serializable
{
	
	private static final long serialVersionUID = 1L;
	String name;
	int highScore;
	int wins;
	int losses;
	int ties;
	int games;
	double ratio;
	private static DecimalFormat df = new DecimalFormat(".###");
	
	/**
	 * Constructor for user.
	 * @param name string to be used as an identifier.
	 */
	public User(String name)
	{
		this.name = name;
		highScore = 0;
		wins = 0;
		losses = 0;
		ties = 0;
		games = 0;
		ratio = 0;
	}
	
	/**
	 * Method for retrieving the name of the user.
	 * @return String containing name of the user.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Method for retrieving the user's high score.
	 * @return Integer of users high score.
	 */
	public int getScore()
	{
		return highScore;
	}
	
	/**
	 * Method for updating the user's high score.
	 * @param score new high score.
	 */
	public void updateScore(int score)
	{
		highScore = score;
	}
	
	/**
	 * Method to add a win to the user's history.
	 */
	public void addWin()
	{
		wins++;
	}
	
	/**
	 * Method to add a loss to the user's history.
	 */
	public void addLoss()
	{
		losses++;
	}
	
	/**
	 * Method to add a tie to the user's history.
	 */
	public void addTie()
	{
		ties++;
	}
	
	/**
	 * Method to add another game played to the user's history.
	 */
	public void addGame()
	{
		games++;
	}
	
	/**
	 * Method to update the user's win to loss ratio.
	 */
	public void updateRatio()
	{
		double doubWins = wins;
		double doubGames = games;
		
		ratio = doubWins / doubGames;

	}
	
	/**
	 * Method to retrieve the user's wins.
	 * @return Integer of user's wins.
	 */
	public int getWins()
	{
		return wins;
	}
	
	/**
	 * Method to retrieve the user's losses.
	 * @return Integer of user's losses.
	 */
	public int getLosses()
	{
		return losses;
	}
	
	/**
	 * Method to retrieve the user's ties.
	 * @return Integer of user's ties.
	 */
	public int getTies()
	{
		return ties;
	}
	
	/**
	 * Method to retrieve the user's games played.
	 * @return Integer of user's games played.
	 */
	public int getGames()
	{
		return games;
	}
	
	/**
	 * Method to retrieve the user's win to loss ratio.
	 * @return double of user's win to loss ratio.
	 */
	public String getRatio()
	{
		return df.format(ratio);
	}
	
	/**
	 * Method to save the user's data.
	 */
	public void saveUser()
	{
		try
	      {
	         FileOutputStream fileOut = new FileOutputStream("users/" + name + ".ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
}
