package com.bookiebashing.bookiebashing.repository;

import com.bookiebashing.bookiebashing.models.User;
import com.bookiebashing.bookiebashing.models.Winnings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WinningsRepository extends JpaRepository<Winnings, Long> {

    List<Winnings> findWinningsById(long id);

}
