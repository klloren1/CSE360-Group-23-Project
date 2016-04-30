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

public class CreateUserScreen implements ActionListener
{

	private JFrame frame;
	private JPanel textPane;
	private JPanel textFieldPane;
	private JPanel buttonPane;
	private JButton createUserButton;
	private JButton menuButton;
	private JLabel label;
	private JTextField textField;
	
	public CreateUserScreen() 
	{
		frame = new JFrame("User Creation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textPane = new JPanel(new GridBagLayout());
		textFieldPane = new JPanel(new GridBagLayout());
		buttonPane = new JPanel(new GridBagLayout());
		createUserButton = new JButton("Create User");
		createUserButton.setPreferredSize(new Dimension(120,60));
		createUserButton.setActionCommand("create user");
		createUserButton.addActionListener(this);
		menuButton = new JButton("Menu");
		menuButton.setPreferredSize(new Dimension(120,60));
		menuButton.setActionCommand("menu");
		menuButton.addActionListener(this);
		label = new JLabel("Enter Username");
		label.setFont(new Font("Sans Serif", Font.PLAIN, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        textField = new JTextField(20);
        frame.getContentPane().add(textPane);
        frame.getContentPane().add(textFieldPane);
        frame.getContentPane().add(buttonPane);
        textFieldPane.add(textField);
        buttonPane.add(createUserButton);
        buttonPane.add(menuButton);
        textPane.add(label);
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
	
	public void actionPerformed(ActionEvent e) 
	{
User tempUser = new User("temp");
		
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
		
	    if ("create user".equals(e.getActionCommand())) 
	    {
	    	if(tempUser.getName().equals(textField.getText()))
	    	{
	    		JOptionPane.showMessageDialog(
	    				frame,
	    				textField.getText() + " is already a user",
	    				"User Already Exists",
	    				JOptionPane.ERROR_MESSAGE
	    				);
	    		textField.setText("");
	    	}
	    	else
	    	{
	    		User user = new User(textField.getText());
	    		user.saveUser();
	    		JOptionPane.showMessageDialog(
	    				frame,
	    				textField.getText() + " has successfully been added as a user"
	    				);
	    		textField.setText("");
	    	}
	    }
	    if ("menu".equals(e.getActionCommand())) 
	    {
			hideGUI();
			SystemMain.menuGUI.showGUI();
	    }
	} 
}
