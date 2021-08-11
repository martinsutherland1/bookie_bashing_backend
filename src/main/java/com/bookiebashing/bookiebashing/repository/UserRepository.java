package com.bookiebashing.bookiebashing.repository;


import com.bookiebashing.bookiebashing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserById(long id);
}
