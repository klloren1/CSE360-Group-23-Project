package project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class GameSetupScreen implements ActionListener
{
	
	private JFrame frame;
	private JPanel textPane;
	private JPanel textFieldPane1;
	private JPanel textFieldPane2;
	private JPanel buttonPane;
	private JButton startGameButton;
	private JButton menuButton;
	private JLabel label;
	private JTextField textField1;
	private JTextField textField2;
	boolean User1Ready;
	boolean User2Ready;
	
	public GameSetupScreen() 
	{
		frame = new JFrame("Game Setup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textPane = new JPanel(new GridBagLayout());
		textFieldPane1 = new JPanel(new GridBagLayout());
		textFieldPane2 = new JPanel(new GridBagLayout());
		buttonPane = new JPanel(new GridBagLayout());
		startGameButton = new JButton("Start Game");
		startGameButton.setPreferredSize(new Dimension(120,60));
		startGameButton.setActionCommand("start game");
		startGameButton.addActionListener(this);
		menuButton = new JButton("Menu");
		menuButton.setPreferredSize(new Dimension(120,60));
		menuButton.setActionCommand("menu");
		menuButton.addActionListener(this);
		label = new JLabel("Enter Usernames");
		label.setFont(new Font("Sans Serif", Font.ITALIC, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        frame.getContentPane().add(textPane);
        frame.getContentPane().add(textFieldPane1);
        frame.getContentPane().add(textFieldPane2);
        frame.getContentPane().add(buttonPane);
        textFieldPane1.add(textField1);
        textFieldPane2.add(textField2);
        buttonPane.add(startGameButton);
        buttonPane.add(menuButton);
        textPane.add(label);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void showGUI()
	{
		frame.setVisible(true);
		User1Ready = false;
		User2Ready = false;
	}
	
	public void hideGUI()
	{
		frame.setVisible(false);
	}
	
	public User getUser1()
	{
		User tempUser = new User("temp");
		
		//attempt to load user
		try
	      {
	         FileInputStream fileIn = new FileInputStream("users/" + textField1.getText() + ".ser");
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
		
		if(tempUser.getName().equals(textField1.getText()))
		{
			User1Ready = true;
			return tempUser;
		}
		else//if user failed to load, create a new user object to be used
		{
			int n = JOptionPane.showConfirmDialog(
					frame, 
					"We could not find " + textField1.getText() + " in our system, would you like to create a new user with this name?", 
					"Could Not Find User",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.ERROR_MESSAGE);
			if(n == JOptionPane.YES_OPTION) {
				tempUser = new User(textField1.getText());
				User1Ready = true;
				return tempUser;
			}
			else {
				return tempUser;
			}
		}
	}
	
	public User getUser2()
	{
		User tempUser = new User("temp");
		
		//attempt to load user
		try
	      {
	         FileInputStream fileIn = new FileInputStream("users/" + textField2.getText() + ".ser");
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
		
		if(tempUser.getName().equals(textField2.getText()))
		{
			User2Ready = true;
			return tempUser;
		}
		else//if user failed to load, create a new user object to be used
		{
			int n = JOptionPane.showConfirmDialog(
					frame, 
					"We could not find " + textField2.getText() + " in our system, would you like to create a new user with this name?", 
					"Could Not Find User",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.ERROR_MESSAGE);
			if(n == JOptionPane.YES_OPTION) {
				tempUser = new User(textField2.getText());
				User2Ready = true;
				return tempUser;
			}
			else {
				return tempUser;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
	    if ("start game".equals(e.getActionCommand())) 
	    {
			User user1 = getUser1();
			User user2 = getUser2();
			if(User1Ready == true && User2Ready == true) {
				Game testGame = new Game(user1, user2);
	    		testGame.startGame();
	    		hideGUI();
			}
	    }
	    if ("menu".equals(e.getActionCommand())) 
	    {
			hideGUI();
			SystemMain.menuGUI.showGUI();
	    }
	} 
}
