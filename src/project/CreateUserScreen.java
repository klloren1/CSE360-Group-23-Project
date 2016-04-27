package project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		label.setFont(new Font("Serif", Font.PLAIN, 50));
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
	    if ("create user".equals(e.getActionCommand())) 
	    {
			User user = new User(textField.getText());
			user.saveUser();
	    }
	    if ("menu".equals(e.getActionCommand())) 
	    {
			hideGUI();
			SystemMain.menuGUI.showGUI();
	    }
	} 
}
