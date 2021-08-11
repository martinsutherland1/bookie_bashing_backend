package com.bookiebashing.bookiebashing;

import com.bookiebashing.bookiebashing.models.Bet;
import com.bookiebashing.bookiebashing.models.User;
import com.bookiebashing.bookiebashing.repository.BetRepository;
import com.bookiebashing.bookiebashing.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookiebashingApplicationTests {

	@Autowired
	BetRepository betRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void userHasName(){
		User bob = new User("Bob", 0, 0, 0, 0, false, "1234");
		userRepository.save(bob);
		assertEquals("Bob", bob.getName());
	}

	@Test
	public void userHasWins(){
		User bob = new User("Bob", 0, 0, 0, 0, false, "1234");
		userRepository.save(bob);
		assertEquals(0, bob.getWins());
	}

	@Test
	public void userHasAdminRights(){
		User bob = new User("Bob", 0, 0, 0, 0, true, "1234");
		userRepository.save(bob);
		assertTrue(bob.getAdmin());
	}

	@Test
	public void betHasUser(){
		User bob = new User("Bob", 0, 0, 0, 0, false, "1234");
		userRepository.save(bob);
		Bet bet1 = new Bet("Rangers to win", "1", bob);
		betRepository.save(bet1);
		assertEquals("Bob", bet1.getUserName());
	}

	@Test
	public void betHasSelectionAndResult(){
		User bob = new User("Bob", 0, 0, 0, 0, false, "1234");
		userRepository.save(bob);
		Bet bet1 = new Bet("Rangers to win", "1", bob);
		betRepository.save(bet1);
		assertEquals("Rangers to win", bet1.getSelection());
		assertEquals(0, bet1.getResult());
	}



}
