package com.bookiebashing.bookiebashing.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int wins;

    @Column
    private int losses;

    @Column
    private int winStreak;

    @Column
    private int bestStreak;

    @Column
    private Boolean admin;

    @Column
    private String password;

    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Bet> allBets;



    public User(String name, int wins, int losses, int winStreak, int bestStreak, Boolean admin, String password) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.winStreak = winStreak;
        this.bestStreak = bestStreak;
        this.admin = admin;
        this.password = password;
        this.allBets = new ArrayList<>();



    }

    public User() {
    }

    public List<Bet> getAllBets() {
        return allBets;
    }

    public void setAllBets(List<Bet> allBets) {
        this.allBets = allBets;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWinStreak() {
        return winStreak;
    }

    public void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    public int getBestStreak() {
        return bestStreak;
    }

    public void setBestStreak(int bestStreak) {
        this.bestStreak = bestStreak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void addBet(Bet bet){
        this.allBets.add(bet);
    }
}
