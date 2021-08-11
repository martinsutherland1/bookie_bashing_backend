package com.bookiebashing.bookiebashing.models;


import javax.persistence.*;

@Entity
@Table(name = "winnings")
public class Winnings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double runningTotal;

    public Winnings(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public Winnings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void updateWinnings( double updatedTotal){
        this.runningTotal += updatedTotal;
    }
}
