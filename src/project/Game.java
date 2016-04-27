package project;
import java.util.Random;

/**
 * Class for containing the information and functions of the dice game.
 */
public class Game {
	
	public Player player1;
	public Player player2;
	public int rolls;
	public int locks;
	public int die1;
	public int die2;
	public int activePlayer;
	public int round;
	
	public GameScreen gameGUI;
	
	/**
	 * Constructor for the game class.
	 * 
	 * @param user1 user to be used as the first player
	 * @param user2 user to be used as the second player
	 */
	public Game(User user1, User user2)
	{
		player1 = new Player(user1);
		player2 = new Player(user2);
		gameGUI = new GameScreen(this);
		gameGUI.showGUI();
		rolls = 0;
		locks = 0;
		die1 = 0;
		die2 = 0;
		activePlayer = 0;
		round = 0;
	}
	
	/**
	 * Method to begin the game.
	 */
	public void startGame()
	{				
		player1Turn();
	}
	
	/**
	 * Method for beginning new turn for player 1
	 */
	public void player1Turn()
	{
		round++;
		die1 = 0;
		die2 = 0;
		rolls = 5;
		locks = 5;
		activePlayer = 1;
		updateGUI();
	}
	
	/**
	 * Method for beginning new turn for player 2
	 */
	public void player2Turn()
	{
		die1 = 0;
		die2 = 0;
		rolls = 5;
		locks = 5;
		activePlayer = 2;
		updateGUI();
	}
	
	/**
	 * Method to roll dice.
	 * If rolls is zero, control switches to other player.
	 * If three rounds have passed, the game is ended.
	 */
	public void roll()
	{
		if(rolls > 0)
		{
			Random rand = new Random();
			die1 = rand.nextInt(6) + 1;
			die2 = rand.nextInt(6) + 1;
			
			if(die1 == die2)
			{
				doubleRolled();
			}
		}
		
		rolls--;
		updateGUI();
		
		if(rolls == -1)
		{
			if(activePlayer == 1)
			{
				player2Turn();				
			}
			else if(round < 3)
			{
				player1Turn();
			}
			else
			{
				endGame();
			}
		}
	}
	
	/**
	 * Method to lock die 1 to current player's score.
	 */
	public void lockDie1()
	{
		if(locks > 0 && die1 > 0)
		{
			if(activePlayer == 1)
			{
				player1.score += die1;
				die1 = 0;
			}
			else
			{
				player2.score += die1;
				die1 = 0;
			}
			
			locks--;
			updateGUI();
		}
	}
	
	/**
	 * Method to lock die 2 to current player's score.
	 */
	public void lockDie2()
	{
		if(locks > 0 && die2 > 0)
		{
			if(activePlayer == 1)
			{
				player1.score += die2;
				die2 = 0;
			}
			else
			{
				player2.score += die2;
				die2 = 0;
			}
			
			locks--;
			updateGUI();
		}
	}
	
	/**
	 * Method to add ten points to current players score if doubles are rolled.
	 */
	public void doubleRolled()
	{
		if(activePlayer == 1)
		{
			player1.score += 10;
		}
		else
		{
			player2.score += 10;
		}
		
		updateGUI();
	}
	
	/**
	 * Method to end game, showing the end of game screen and updating users.
	 */
	public void endGame()
	{
		if(player1.score > player2.score)//player 1 wins
		{
			gameGUI.showWinner(player1.getName(), player1.score);
			player1.won = true;
		}
		else if(player1.score < player2.score)//player 2 wins
		{
			gameGUI.showWinner(player2.getName(), player2.score);
			player2.won = true;
		}
		else//tie
		{
			gameGUI.showWinner("Tie Game", player1.score);
		}
		
		updateStats();
	}
	
	/**
	 * Method to update the GUI based on current game values.
	 */
	private void updateGUI()
	{
		if(activePlayer == 1)
		{
			gameGUI.updatePlayerInfo(player1.getName(), player1.score);
		}
		else 
		{
			gameGUI.updatePlayerInfo(player2.getName(), player2.score);
		}
		
		gameGUI.updateRemaining(rolls,locks);
		gameGUI.updateDice(die1, die2);
		gameGUI.updateRound(round);
	}
	
	/**
	 * Method to update the stats of the users
	 */
	public void updateStats()
	{
		if(player1.score > player1.user.getScore())
		{
			player1.user.updateScore(player1.score);
		}
		
		if(player2.score > player2.user.getScore())
		{
			player2.user.updateScore(player2.score);
		}
		
		if(player1.won)
		{
			player1.user.addWin();
		}
		else if(player2.won)
		{
			player2.user.addWin();
		}
		
		player1.user.addGame();
		player2.user.addGame();
		
		player1.user.updateRatio();
		player2.user.updateRatio();
		
		player1.user.saveUser();
		player2.user.saveUser();
		
	}
	
}
