package project;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RulesScreen implements ActionListener{
	
	//GUI elements
	private JPanel rulesPane;
	private JFrame frame;
	private JLabel rules1;
	private JLabel rules2;
	private JLabel rules3;
	private JLabel rules4;
	private JLabel rules5;
	private JLabel rules6;
	private JLabel rules7;
	private JButton menuButton;
	
	public RulesScreen(){
		//setting up GUI
		frame = new JFrame("Rules");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rulesPane = new JPanel();
		rulesPane.setLayout(new BoxLayout(rulesPane,BoxLayout.Y_AXIS));
		rules1 = new JLabel("Each player has 5 rolls per round consisting of 2 dice each.");
		rules2 = new JLabel("If you roll doubles, ten points are added to your score.");
		rules3 = new JLabel("You can choose to lock in any dice you roll.");
		rules4 = new JLabel("Locked dice values are added directly to your score.");
		rules5 = new JLabel("Only a maximum of 5 dice may be locked each round and once locked");
		rules6 = new JLabel("they cannot be exchanged.");
		rules7 = new JLabel("The winner is the player with the higher score after three rounds.");
		rules1.setFont(new Font("Sans Serif", Font.ITALIC, 20));
        rules1.setHorizontalAlignment(JLabel.CENTER);
        rules1.setVerticalAlignment(JLabel.CENTER);
        rules2.setFont(new Font("Sans Serif", Font.ITALIC, 20));
        rules2.setHorizontalAlignment(JLabel.CENTER);
        rules2.setVerticalAlignment(JLabel.CENTER);
        rules3.setFont(new Font("Sans Serif", Font.ITALIC, 20));
        rules3.setHorizontalAlignment(JLabel.CENTER);
        rules3.setVerticalAlignment(JLabel.CENTER);
        rules4.setFont(new Font("Sans Serif", Font.ITALIC, 20));
        rules4.setHorizontalAlignment(JLabel.CENTER);
        rules4.setVerticalAlignment(JLabel.CENTER);
        rules5.setFont(new Font("Sans Serif", Font.ITALIC, 20));
        rules5.setHorizontalAlignment(JLabel.CENTER);
        rules5.setVerticalAlignment(JLabel.CENTER);
        rules6.setFont(new Font("Sans Serif", Font.ITALIC, 20));
        rules6.setHorizontalAlignment(JLabel.CENTER);
        rules6.setVerticalAlignment(JLabel.CENTER);
        rules7.setFont(new Font("Sans Serif", Font.ITALIC, 20));
        rules7.setHorizontalAlignment(JLabel.CENTER);
        rules7.setVerticalAlignment(JLabel.CENTER);
        menuButton = new JButton("Menu");
		menuButton.setPreferredSize(new Dimension(120,60));
		menuButton.setActionCommand("menu");
		menuButton.addActionListener(this);
        frame.getContentPane().add(rulesPane);
        rulesPane.add(rules1);
        rulesPane.add(rules2);
        rulesPane.add(rules3);
        rulesPane.add(rules4);
        rulesPane.add(rules5);
        rulesPane.add(rules6);
        rulesPane.add(menuButton);
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
	    if ("menu".equals(e.getActionCommand())) 
	    {
	    	hideGUI();
	    	SystemMain.menuGUI.showGUI();
	    }   
	} 
}