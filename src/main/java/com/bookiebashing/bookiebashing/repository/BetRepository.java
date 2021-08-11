package com.bookiebashing.bookiebashing.repository;

import com.bookiebashing.bookiebashing.models.Bet;
import com.bookiebashing.bookiebashing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findBetById(long id);
    List<Bet> findBetByWeek(String week);
}
