package project;

import static org.junit.Assert.*;

import org.junit.Test;


public class UserTest {
	String name = "Name";
	User testUser = new User(name);
	
	@Test
	public void testUser() {
		assertNotNull(testUser);
		assertNotNull(testUser.name);
		assertNotNull(testUser.highScore);
		assertNotNull(testUser.wins);
		assertNotNull(testUser.games);
		assertNotNull(testUser.ratio);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Name",testUser.getName());
	}

	@Test
	public void testGetScore() {
		testUser.updateScore(1);
		assertEquals(1,testUser.getScore());
	}
	
	@Test
	public void testGetWins() {
		testUser.addWin();
		assertEquals(1,testUser.getWins());
	}
	
	@Test
	public void testGetGames() {
		testUser.addGame();
		assertEquals(1,testUser.getGames());
	}
	
	@Test
	public void testGetRatio() {
		testUser.addGame();
		testUser.addGame();
		testUser.addWin();
		testUser.updateRatio();
		assertEquals(0.5,testUser.getRatio(),0);
	}
}
