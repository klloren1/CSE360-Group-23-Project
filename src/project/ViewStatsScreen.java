package project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class ViewStatsScreen implements ActionListener
{

	private JFrame frame;
	private JPanel textPane;
	private JPanel statsPane;
	private JPanel textFieldPane;
	private JPanel buttonPane;
	private JButton setUserButton;
	private JButton menuButton;
	private JLabel nameLabel;
	private JLabel scoreLabel;
	private JLabel gamesLabel;
	private JLabel winsLabel;
	private JLabel lossesLabel;
	private JLabel tiesLabel;
	private JLabel ratioLabel;
	private JTextField textField;
	
	User user;
	
	public ViewStatsScreen() 
	{
		frame = new JFrame("User Creation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textPane = new JPanel(new GridBagLayout());
		textFieldPane = new JPanel(new GridBagLayout());
		buttonPane = new JPanel(new GridBagLayout());
		statsPane = new JPanel();
		statsPane.setLayout(new BoxLayout(statsPane,BoxLayout.Y_AXIS));
		setUserButton = new JButton("Select User");
		setUserButton.setPreferredSize(new Dimension(120,60));
		setUserButton.setActionCommand("set user");
		setUserButton.addActionListener(this);
		menuButton = new JButton("Menu");
		menuButton.setPreferredSize(new Dimension(120,60));
		menuButton.setActionCommand("menu");
		menuButton.addActionListener(this);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setFont(new Font("Sans Serif", Font.ITALIC, 20));
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		
		scoreLabel = new JLabel("High Score: ");
		scoreLabel.setFont(new Font("Sans Serif", Font.ITALIC, 20));
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setVerticalAlignment(JLabel.CENTER);
		
		gamesLabel = new JLabel("Games Played: ");
		gamesLabel.setFont(new Font("Sans Serif", Font.ITALIC, 20));
		gamesLabel.setHorizontalAlignment(JLabel.CENTER);
		gamesLabel.setVerticalAlignment(JLabel.CENTER);
		
		winsLabel = new JLabel("Wins: ");		
		winsLabel.setFont(new Font("Sans Serif", Font.ITALIC, 20));
		winsLabel.setHorizontalAlignment(JLabel.CENTER);
		winsLabel.setVerticalAlignment(JLabel.CENTER);
		
		lossesLabel = new JLabel("Losses: ");		
		lossesLabel.setFont(new Font("Sans Serif", Font.ITALIC, 20));
		lossesLabel.setHorizontalAlignment(JLabel.CENTER);
		lossesLabel.setVerticalAlignment(JLabel.CENTER);
		
		tiesLabel = new JLabel("Ties: ");		
		tiesLabel.setFont(new Font("Sans Serif", Font.ITALIC, 20));
		tiesLabel.setHorizontalAlignment(JLabel.CENTER);
		tiesLabel.setVerticalAlignment(JLabel.CENTER);
		
		ratioLabel = new JLabel("Win-Loss Ratio: ");		
		ratioLabel.setFont(new Font("Sans Serif", Font.ITALIC, 20));
		ratioLabel.setHorizontalAlignment(JLabel.CENTER);
		ratioLabel.setVerticalAlignment(JLabel.CENTER);
		
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        textField = new JTextField(20);
        frame.getContentPane().add(textPane);
        frame.getContentPane().add(textFieldPane);
        frame.getContentPane().add(buttonPane);
        textPane.add(statsPane);
        statsPane.add(nameLabel);
        statsPane.add(scoreLabel);
        statsPane.add(gamesLabel);
        statsPane.add(winsLabel);
        statsPane.add(lossesLabel);
        statsPane.add(tiesLabel);
        statsPane.add(ratioLabel);
        textFieldPane.add(textField);
        buttonPane.add(setUserButton);
        buttonPane.add(menuButton);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void showGUI()
	{
		frame.setVisible(true);
	}
	
	public void hideGUI()
	{
		frame.setVisible(false);
	}
	
	public User getUser()
	{
		User tempUser = new User("Failed to Load");
		
		//attempt to load user
		try
	      {
	         FileInputStream fileIn = new FileInputStream("users/" + textField.getText() + ".ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         tempUser = (User) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	      }
		
		if(tempUser.getName().equals(textField.getText()))
		{
			return tempUser;
		}
		else//if user failed to load, create a new user object to be used
		{
			JOptionPane.showMessageDialog(
					frame,
					"We could not find " + textField.getText() + " in our system",
					"Could Not Find User",
					JOptionPane.ERROR_MESSAGE
					);
			return tempUser;
		}
	}
	
	public void updateGUI()
	{
		nameLabel.setText("Name: " + user.getName());
		scoreLabel.setText("High Score: " + user.getScore());
		gamesLabel.setText("Games Played: " + user.getGames());
		winsLabel.setText("Wins: " + user.getWins());
		lossesLabel.setText("Losses: " + user.getLosses());
		tiesLabel.setText("Ties: " + user.getTies());
		ratioLabel.setText("Win-Loss Ratio: " + user.getRatio());
	}
		
	public void actionPerformed(ActionEvent e) 
	{
	    if ("set user".equals(e.getActionCommand())) 
	    {
			user = getUser();
			updateGUI();
			textField.setText("");
	    }
	    if ("menu".equals(e.getActionCommand())) 
	    {
			hideGUI();
			SystemMain.menuGUI.showGUI();
	    }
	} 
}