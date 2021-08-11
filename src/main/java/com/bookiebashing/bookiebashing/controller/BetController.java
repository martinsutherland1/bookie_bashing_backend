package com.bookiebashing.bookiebashing.controller;

import com.bookiebashing.bookiebashing.models.Bet;
import com.bookiebashing.bookiebashing.models.User;
import com.bookiebashing.bookiebashing.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BetController {

    @Autowired
    BetRepository betRepository;

    // INDEX
    @GetMapping(value = "/bets")
    public ResponseEntity<List<Bet>> getAllBets(){
        return new ResponseEntity<>(betRepository.findAll(), HttpStatus.OK);
    }

    // GET
    @GetMapping(value = "/bets/{id}")
    public ResponseEntity getBet(@PathVariable Long id){
        return new ResponseEntity<>(betRepository.findById(id), HttpStatus.OK);
    }

    // POST
    @PostMapping(value = "/bets")
    public ResponseEntity<Bet> postBet(@RequestBody Bet bet){
        betRepository.save(bet);
        return new ResponseEntity<>(bet, HttpStatus.OK);
    }

    // UPDATE
    @PatchMapping(value = "/bets/{id}")
    public ResponseEntity<Bet> updateBet(@PathVariable Long id, @RequestBody Bet bet){
        betRepository.save(bet);
        return new ResponseEntity<>(bet, HttpStatus.OK);
    }



    //DELETE
    @DeleteMapping(value = "/bets/{id}")
    public ResponseEntity<User> deleteBets(@PathVariable Long id) {
        Bet found = betRepository.getById(id);
        betRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
