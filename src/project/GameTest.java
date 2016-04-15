// This is the JUnit test class to test the Game class
// Created: 4/13/2016
// Last Updated: 4/13/2016

package project;

import static org.junit.Assert.*;

import org.junit.Test;

// This is the JUnit test class that will test the Game class
public class GameTest{

	// 	  Tests the Game constructor to see if it creates all of the correct objects
	// associated with Game
	@Test
	public void testGame() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		assertNotNull(testGame);
		assertNotNull(testGame.player1);
		assertNotNull(testGame.player2);
		assertEquals(testGame.rolls, 0);
		assertEquals(testGame.locks, 0);
		assertEquals(testGame.die1, 0);
		assertEquals(testGame.die2, 0);
		assertEquals(testGame.activePlayer, 0);
		assertEquals(testGame.round, 0);
	}
	
	//    Tests playerTurn1() to make sure that it starts player 1's turn by increasing
	// the round and initializing the dice values to 0, the number of rolls to 5, and the
	// number of locks to 5
	@Test
	public void testPlayer1Turn() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1Turn();
		
		assertEquals(testGame.round, 1);
		assertEquals(testGame.die1, 0);
		assertEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 5);
		assertEquals(testGame.locks, 5);
		assertEquals(testGame.activePlayer, 1);
	}
	
	//    Tests playerTurn2() to make sure that it starts player2's turn. It does not
	// increase the round number, but it still sets the dice values to 0, the number
	// of rolls to 5, and the number of locks to 5
	@Test
	public void testPlayer2Turn() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1Turn();
		testGame.player2Turn();
		
		assertEquals(testGame.round, 1);
		assertEquals(testGame.die1, 0);
		assertEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 5);
		assertEquals(testGame.locks, 5);
		assertEquals(testGame.activePlayer, 2);
	}
	
	//    Tests roll() for player 1. Checks to see that the player starts with 5
	// rolls, and that after each role the value of rolls decreases by 1. Once the
	// number of roles reaches 0, the next time the player rolls, it checks to see
	// that player2Turn is called and that activePlayer is set to 2
	@Test
	public void testRollPlayer1() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1Turn();
		
		assertEquals(testGame.rolls, 5);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 4);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 3);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 2);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 1);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 0);
		
		testGame.roll();
		assertEquals(testGame.activePlayer, 2);
	}
	
	//    Tests roll() for player 1. Checks to see that the player starts with 5
	// rolls, and that after each role the value of rolls decreases by 1. Once the
	// number of roles reaches 0, the next time the player rolls, it checks to see
	// that player2Turn is called and that activePlayer is set to 1
	@Test
	public void testRollPlayer2() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1Turn();
		testGame.player2Turn();
		
		assertEquals(testGame.rolls, 5);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 4);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 3);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 2);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 1);
		
		testGame.roll();
		assertNotEquals(testGame.die1, 0);
		assertNotEquals(testGame.die2, 0);
		assertEquals(testGame.rolls, 0);
		
		testGame.roll();
		assertEquals(testGame.activePlayer, 1);
	}
	
	//    Tests lockDie1() to make sure that when the player locks in their first
	// die, the value of that die is added to the player's score. After it is locked
	// in, the value of the die is set to 0. Finally, after the die is locked in, the
	// value of the player's locks is decreased by 1
	@Test
	public void testLockDie1() {
		int testDie1;
		int testDie2;
		int testScore;
		
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1Turn();
		testGame.roll();		
		testDie1 = testGame.die1;
		testDie2 = testGame.die2;
		
		testGame.lockDie1();
		testScore = testGame.player1.score;
		
		if(testDie1 == testDie2) {
			testDie1 += 10;
			assertEquals(testScore, testDie1);
		}
		else {
			assertEquals(testScore, testDie1);
		}
		
		assertEquals(testGame.locks, 4);
	}
	
	//    Tests lockDie2() to make sure that when the player locks in their second
	// die, the value of that die is added to the player's score. After it is locked
	// in, the value of the die is set to 0. Finally, after the die is locked in, the
	// value of the player's locks is decreased by 1
	@Test
	public void testLockDie2() {
		int testDie1;
		int testDie2;
		int testScore;
		
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1Turn();
		testGame.roll();		
		testDie1 = testGame.die1;
		testDie2 = testGame.die2;
		
		testGame.lockDie2();
		testScore = testGame.player1.score;
		
		if(testDie1 == testDie2) {
			testDie2 += 10;
			assertEquals(testScore, testDie2);
		}
		else {
			assertEquals(testScore, testDie2);
		}
		
		assertEquals(testGame.locks, 4);
	}
	
	//    Tests doubleRolled() to make sure that each time die1 and die2 have the
	// same values, 10 points are added to the value of the player's score
	@Test
	public void testDoubleRolled() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1Turn();
		testGame.doubleRolled();
		
		assertEquals(testGame.player1.score, 10);
		
		testGame.doubleRolled();
		
		assertEquals(testGame.player1.score, 20);
	}
	
	//    Tests endGame() to make sure that when player 1 has the higher score,
	// they are set as the winner of the game
	public void testEndGame_Player1Wins() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1.score = 20;
		testGame.player2.score = 10;
		testGame.endGame();
		
		assertTrue(testGame.player1.won);
		assertFalse(testGame.player2.won);
	}
	
	//  Tests endGame() to make sure that when player 2 has the higher score,
	// they are set as the winner of the game
	@Test
	public void testEndGame_Player2Wins() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1.score = 10;
		testGame.player2.score = 20;
		testGame.endGame();
		
		assertTrue(testGame.player2.won);
		assertFalse(testGame.player1.won);
	}
	
	//    Tests endGame() to make sure that when both players have the same score,
	// neither player is chosen as a winner
	@Test
	public void testEndGame_Tie() {
		User testUser1 = new User("Test 1");
		User testUser2 = new User("Test 2");
		
		Game testGame = new Game(testUser1, testUser2);
		
		testGame.player1.score = 10;
		testGame.player2.score = 10;
		testGame.endGame();
		
		assertFalse(testGame.player1.won);
		assertFalse(testGame.player2.won);
	}
	
	// 	There is currently no functionality to the method updateStats() in the Game
	// class as of 4/13/2016, this will be added in at a later date
	@Test
	public void testUpdateStats() {
		
	}

}
