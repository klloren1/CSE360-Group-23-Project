package project;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;   

public class Menu implements ActionListener
{
	
	//GUI elements
	private JFrame frame;
	private JPanel textPane;
	private JPanel buttonPane1;
	private JPanel buttonPane2;
	private JPanel buttonPane3;
	private JButton startGameButton;
	private JButton viewStatsButton;
	private JButton createUserButton;
	private JLabel label;
	
	public Menu()
	{
		frame = new JFrame("Game Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textPane = new JPanel(new GridBagLayout());
		buttonPane1 = new JPanel(new GridBagLayout());
		buttonPane2 = new JPanel(new GridBagLayout());
		buttonPane3 = new JPanel(new GridBagLayout());
		startGameButton = new JButton("Start Game");
		viewStatsButton = new JButton("View Stats");
		createUserButton = new JButton("Create User");
		startGameButton.setPreferredSize(new Dimension(120,60));
		startGameButton.setActionCommand("start game");
		startGameButton.addActionListener(this);
		viewStatsButton.setActionCommand("view stats");
		viewStatsButton.addActionListener(this);
		createUserButton.setActionCommand("create user");
		createUserButton.addActionListener(this);
		viewStatsButton.setPreferredSize(new Dimension(120,60));
		createUserButton.setPreferredSize(new Dimension(120,60));
		label = new JLabel("Menu");
		label.setFont(new Font("Serif", Font.PLAIN, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.getContentPane().add(textPane);
        frame.getContentPane().add(buttonPane1);
        frame.getContentPane().add(buttonPane2);
        frame.getContentPane().add(buttonPane3);
        buttonPane1.add(startGameButton);
        buttonPane2.add(viewStatsButton);
        buttonPane3.add(createUserButton);
        textPane.add(label);
        frame.setSize(500, 400);
	}
	
	public void showGUI()
	{
		frame.setVisible(true);
	}
	
	public void hideGUI()
	{
		frame.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
	    if ("start game".equals(e.getActionCommand())) 
	    {
			User test1 = new User("Player 1");
			User test2 = new User("Player 2");
			Game testGame = new Game(test1, test2);
	    	testGame.startGame();
	    	hideGUI();
	    }
	    else if ("view stats".equals(e.getActionCommand())) 
	    {
			
	    }
	    else if ("create user".equals(e.getActionCommand())) 
	    {
			
	    }
	        
	} 
	
}
