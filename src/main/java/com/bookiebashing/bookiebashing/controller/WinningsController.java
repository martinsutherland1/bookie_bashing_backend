package com.bookiebashing.bookiebashing.controller;

import com.bookiebashing.bookiebashing.models.User;
import com.bookiebashing.bookiebashing.models.Winnings;
import com.bookiebashing.bookiebashing.repository.WinningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WinningsController {

    @Autowired
    WinningsRepository winningsRepository;

    // INDEX
    @GetMapping(value = "/winnings")
    public ResponseEntity<List<Winnings>> getAllWinnings(){
        return new ResponseEntity<>(winningsRepository.findAll(), HttpStatus.OK);
    }

    // GET
    @GetMapping(value = "/winnings/{id}")
    public ResponseEntity getWinnings(@PathVariable Long id){
        return new ResponseEntity<>(winningsRepository.findById(id), HttpStatus.OK);
    }

    // POST
    @PostMapping(value = "/winnings")
    public ResponseEntity<Winnings> postWinnings(@RequestBody Winnings winnings){
        winningsRepository.save(winnings);
        return new ResponseEntity<>(winnings, HttpStatus.OK);
    }

    // UPDATE
    @PatchMapping(value = "/winnings/{id}")
    public ResponseEntity<Winnings> updateWinnings(@PathVariable Long id, @RequestBody Winnings winnings){
        winningsRepository.save(winnings);
        return new ResponseEntity<>(winnings, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping(value = "/winnings/{id}")
    public ResponseEntity<User> deleteWinnings(@PathVariable Long id) {
        Winnings found = winningsRepository.getById(id);
        winningsRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
