package project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;   

public class GameScreen implements ActionListener
{
	
	//GUI elements
	static JFrame frame;
	private JLabel remaining;
	private JLabel dice;
	private JLabel playerInfo;
	private JLabel round;
	private JPanel remainingPane;
	private JPanel playerInfoPane;
	private JPanel dicePane;
	private JPanel buttonPane;
	private JPanel roundPane;
	private JButton rollButton;
	private JButton lockButton1;
	private JButton lockButton2;
	
	private Game game;
	
	public GameScreen(Game newGame)
	{
		//setting up GUI
		frame = new JFrame("Dice Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		remainingPane = new JPanel(new GridBagLayout());
		dicePane = new JPanel(new GridBagLayout());
		buttonPane = new JPanel(new GridBagLayout());
		playerInfoPane = new JPanel(new GridBagLayout());
		roundPane = new JPanel(new GridBagLayout());
		playerInfo = new JLabel("Player: Placeholder" + "         Score: " + 0);
		playerInfo.setFont(new Font("Sans Serif", Font.ITALIC, 30));
		remaining = new JLabel("Rolls: " + 0 + "         Locks: " + 0);
		remaining.setFont(new Font("Sans Serif", Font.ITALIC, 30));
		dice = new JLabel("Die 1: " + 0 + "         Die 2: " + 0);
		dice.setFont(new Font("Sans Serif", Font.ITALIC, 30));
		round = new JLabel("Round: " + 0);
		round.setFont(new Font("Sans Serif", Font.ITALIC, 30));
		playerInfoPane.add(playerInfo);
		remainingPane.add(remaining);
		dicePane.add(dice);
		roundPane.add(round);
		rollButton = new JButton("Roll");
		lockButton1 = new JButton("Lock Die 1");
		lockButton2 = new JButton("Lock Die 2");
		rollButton.setPreferredSize(new Dimension(100,60));
		lockButton1.setPreferredSize(new Dimension(100,60));
		lockButton2.setPreferredSize(new Dimension(100,60));
		buttonPane.add(rollButton);
		buttonPane.add(lockButton1);
		buttonPane.add(lockButton2);
		
		frame.getContentPane().add(roundPane);
		frame.getContentPane().add(new JSeparator(SwingConstants.HORIZONTAL));
		frame.getContentPane().add(playerInfoPane);
		frame.getContentPane().add(new JSeparator(SwingConstants.HORIZONTAL));
		frame.getContentPane().add(remainingPane);
		frame.getContentPane().add(new JSeparator(SwingConstants.HORIZONTAL));
        frame.getContentPane().add(dicePane);
        frame.getContentPane().add(new JSeparator(SwingConstants.HORIZONTAL));
        frame.getContentPane().add(buttonPane);
        
        rollButton.setActionCommand("roll");
		rollButton.addActionListener(this);
		lockButton1.setActionCommand("lock 1");
		lockButton1.addActionListener(this);
		lockButton2.setActionCommand("lock 2");
		lockButton2.addActionListener(this);
		
		game = newGame;
	}
	
	public void showGUI()
	{
		frame.setVisible(true);
	}
	
	public void hideGUI()
	{
		frame.setVisible(false);
	}
	
	public void updatePlayerInfo(String name,int score)
	{
		playerInfo.setText("Player: " + name + "         Score: " + score);
	}
	
	public void updateRound(int round)
	{
		this.round.setText("Round: " + round);
	}
	
	public void updateDice(int die1, int die2)
	{
		dice.setText("Die 1: " + die1 + "         Die 2: " + die2);
	}
	
	public void updateRemaining(int rolls, int locks)
	{
		remaining.setText("Rolls: " + rolls + "         Locks: " + locks);
	}
	
	public void showWinner(String winnerName, int winnerScore)
	{
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		
		
		JPanel winnerTextPanel = new JPanel(new GridBagLayout());
		JPanel winnerButtonPanel = new JPanel(new GridBagLayout());
		JLabel winnerText = new JLabel();
		JButton winnerButton = new JButton("Menu");
		
		
		winnerTextPanel.add(winnerText);
		winnerButtonPanel.add(winnerButton);
		
		
		winnerText.setFont(new Font("Sans Serif", Font.PLAIN, 40));
		winnerButton.setActionCommand("menu");
		winnerButton.addActionListener(this);
		winnerButton.setPreferredSize(new Dimension(120,60));
		

		winnerText.setText("Winner: " + winnerName + "         Score: " + winnerScore);
		
		
		frame.getContentPane().add(winnerTextPanel);
		frame.getContentPane().add(winnerButtonPanel);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
	    if ("roll".equals(e.getActionCommand())) 
	    {	    	
	    	game.roll();
	    }
	    else if ("lock 1".equals(e.getActionCommand())) 
	    {
	    	game.lockDie1();
	    }
	    else if ("lock 2".equals(e.getActionCommand()))
	    {
	    	game.lockDie2();
	    }
	    else if ("menu".equals(e.getActionCommand()))
		{
			hideGUI();
			SystemMain.menuGUI.showGUI();
		}
	        
	} 
	
	
}
