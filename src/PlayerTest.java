package project;

import static org.junit.Assert.*;

import org.junit.Test;
//this is the JUnit test class that will test the player class
public class PlayerTest {

	//this method will test the constructor for the player class
	@Test
	public void testPlayer() {
		User testUse = new User("test1");
		Player testPlay = new Player(testUse);
		assertNotNull(testPlay);
	}
	//this method will test the getName method
	@Test
	public void testGetName() {
		User testUse = new User("test1");
		Player testPlay = new Player(testUse);
		assertEquals(testPlay.getName(),"test1");
	}

}
