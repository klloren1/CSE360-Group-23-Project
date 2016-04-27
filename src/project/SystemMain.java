package project;

/**
 * Main driving class of dice game.
 */
public class SystemMain {
	
	public static Menu menuGUI;
	
    public static void main(String[] args) 
    {
    	menuGUI = new Menu();
    	menuGUI.showGUI();  
    	
    }
}