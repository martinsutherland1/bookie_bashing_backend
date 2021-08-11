package com.bookiebashing.bookiebashing.components;


//import com.bookiebashing.bookiebashing.repository.BetRepository;
import com.bookiebashing.bookiebashing.models.Bet;
import com.bookiebashing.bookiebashing.models.User;

import com.bookiebashing.bookiebashing.models.Winnings;
import com.bookiebashing.bookiebashing.repository.BetRepository;
import com.bookiebashing.bookiebashing.repository.UserRepository;


import com.bookiebashing.bookiebashing.repository.WinningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {



    @Autowired
    UserRepository userRepository;

    @Autowired
    BetRepository betRepository;

    @Autowired
    WinningsRepository winningsRepository;


    public DataLoader(){

    }


    public void run(ApplicationArguments args){

        User martin = new User("Martin", 0, 0, 0, 0, true, "1234");
        userRepository.save(martin);
        User wullie = new User("Wullie", 0, 0, 0, 0, true, "1234");
        userRepository.save(wullie);
        User del = new User("Del", 0, 0, 0, 0, false, "1234");
        userRepository.save(del);
        User jaz = new User("Jaz", 0, 0, 0, 0, false, "1234");
        userRepository.save(jaz);
        User stu = new User("Stu", 0, 0, 0, 0, false, "1234");
        userRepository.save(stu);

        Bet bet1 = new Bet("Rangers to win", "1", martin);
        betRepository.save(bet1);

        Winnings winnings1 = new Winnings(0.00);
        winningsRepository.save(winnings1);







    }
}
